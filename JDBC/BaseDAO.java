package dao;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
封装了针对数据表的通用操作
 */
public abstract class BaseDAO {
    //考虑数据库事务
    public void update2(Connection conn, String sql, Object ...args)  {
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
    //通用的查询操作，用于返回数据表中的一条记录
    public <T>T getInstance(Connection conn,Class<T> clazz,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一个列
                for(int i = 0; i < columnCount; i++){
                    //获取列值
                    Object value = rs.getObject(i + 1);
                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i+1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    //给cust对象指定columnName属性赋值给columnValue通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }
    public <T> List<T> getForList(Connection conn,Class<T> clazz, String sql, Object...args){

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()){
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一个列
                for(int i = 0; i < columnCount; i++){
                    //获取列值
                    Object value = rs.getObject(i + 1);
                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i+1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    //给cust对象指定columnName属性赋值给columnValue通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);

                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }
    public <E>E getValue(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
       try {
           ps = conn.prepareStatement(sql);
           for(int i = 0; i < args.length; i++){
               ps.setObject(i+1,args[i]);
           }
           rs = ps.executeQuery();
           if(rs.next()){
               return (E) rs.getObject(1);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtils.closeResource(null,ps,rs);
       }
    return null;
    }
}
