package transactionDemo;

import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    @Test
    public void testUpdate(){
        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        update(sql1,"AA");
        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update(sql2,"BB");
    }
    //通用的增删改操作
    public void update(String sql,Object ...args)  {
        //获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //预编译sql语句返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i] );
            }
            //执行
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps);
        }
        //关闭资源
    }
    @Test
    public void testUpdate2(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //取消数据的自动提交
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update2(conn,sql1,"AA");
            System.out.println(100 / 0);
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update2(conn,sql2,"BB");
            //提交数据
            conn.commit();
        } catch (Exception e){
            e.printStackTrace();
            //回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }

    }
    //考虑数据库事务
    public void update2(Connection conn,String sql,Object ...args)  {
        //获取数据库连接
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //预编译sql语句返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i] );
            }
            //执行
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps);
        }
        //关闭资源
    }
}
