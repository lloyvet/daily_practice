package preparedStatement;

import bean.Order;

import org.junit.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

public class OrderForQuery {
    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql,1);
        System.out.println(order.toString());
    }

    public  Order orderForQuery(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            //执行获取结果集
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order order = new Order();
                for(int i = 0; i < columnCount; i++){
                    //获取每个列的列值通过ResultSet
                    Object columnValue = rs.getObject(i+1);
                    //获取每个列名
                    //获取列的列名getColumnName
                    //获取列的别名getColumnLabel()
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    //通过反射将对象指定名的属性赋值为指定的值

                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }

        return null;
    }
    @Test
    public void testQuery1()  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       try {
           String sql = "select order_id,order_name,order_date from `order` where order_id = ?";

           conn = JDBCUtils.getConnection();
           ps = conn.prepareStatement(sql);
           ps.setObject(1,1);
           rs = ps.executeQuery();
           if(rs.next()){
               int id = (int) rs.getObject(1);
               String name = (String) rs.getObject(2);
               Date date  = (Date) rs.getObject(3);

               Order order = new Order(id,name,date);
               System.out.println(order.toString());
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtils.closeResource(conn,ps,rs);
       }

    }
}
