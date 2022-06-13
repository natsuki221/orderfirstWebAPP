package orderfirst.orderpos.checkorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import orderfirst.orderpos.DBConnection;


public class CheckOrderDAO {
    
    private Connection conn;
    
    public List<CheckOrder> getAllOrders() {

        conn = DBConnection.getConnection();
        String query = "select * from order_detail where finished like 'unfinish'";
        CheckOrder corder = new CheckOrder();

        List<CheckOrder> order_list = new ArrayList();

        try {
            PreparedStatement ps
                    = conn.prepareStatement(query);
            System.out.println(query);
            ResultSet rset = ps.executeQuery();

            while (rset.next()) {
                CheckOrder checkorder = new CheckOrder();
                checkorder.setProduct_id(rset.getString("product_id"));
                System.out.println(rset.getString("product_id"));
                checkorder.setOrder_num(rset.getString("order_num"));
                System.out.println(rset.getString("order_num"));
                checkorder.setQuantity(rset.getInt("quantity"));
                System.out.println(rset.getInt("quantity"));
                checkorder.setProduct_price(rset.getInt("product_price"));
                System.out.println(rset.getInt("product_price"));
                checkorder.setProduct_name(rset.getString("product_name"));
                System.out.println(rset.getString("product_name"));
                checkorder.setOrder_date(rset.getString("order_date"));
                System.out.println(rset.getString("order_date"));
                checkorder.setFinished(rset.getString("finished"));
                System.out.println(rset.getString("finished"));
                order_list.add(checkorder);
                System.out.println("載入成功");

                //不要斷線，一直會用到，使用持續連線的方式
                //conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("getAllproducts異常:" + ex.toString());
        }

        return order_list;
    }
    
    public void update(String order_num) {
        conn = DBConnection.getConnection();
        
        System.out.println(order_num);
        String query = String.format("update order_detail set finished='finished' where order_num = '%s'", order_num);
        try {
            PreparedStatement state = conn.prepareStatement(query);
            state.executeUpdate();
            System.out.println("update success!");
        } catch (SQLException ex) {
            System.out.println("update異常:" + ex.toString());
        }
    }
    
    public String last(){
        
        conn = DBConnection.getConnection();
        String query = "select * from order_detail where finished like 'unfinish' order by order_date desc limit 1";
        String order_num = "";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rset = ps.executeQuery();
            order_num = rset.getString("order_num");
            System.out.println(order_num);
        } catch(SQLException e){
            System.out.println("SQL Error: " + e);
        }
        
        return order_num;
    }
}
