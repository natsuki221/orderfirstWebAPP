package orderfirst.orderpos.checkorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import orderfirst.orderpos.DBConnection;

public class CheckDB {

    private Connection conn;

    public boolean CheckDB() throws InterruptedException {

        conn = DBConnection.getConnection();

        String query = "SELECT COUNT(*) FROM sale_order";
        boolean changed = false;
        int raw_count = 0;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rset = ps.executeQuery();
            while (rset.next()) {
                raw_count = rset.getInt("COUNT(*)");
            }

        } catch (SQLException e) {
            System.out.println("SQL錯誤：" + e);

        }

        for (int i = 0; i < 100; i++) {

            Thread.sleep(5000);
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rset = ps.executeQuery();
                while (rset.next()) {
                    count = rset.getInt("COUNT(*)");
                }

                if (raw_count < count) {
                    changed = true;
                    break;
                } else if(raw_count == count){
                    System.out.println("Unchange");
                } else{
                    System.out.println("delete order");
                }
            } catch (SQLException e) {
                System.out.println("SQL錯誤：" + e);
                break;

            }
        }
        System.out.println("Jump out of for");
        
        return changed;
    }
}
