package orderfirst.orderpos.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import orderfirst.orderpos.DBConnection;

public class UsersDAO {

    private Connection conn;

    public boolean checkPassword(Users user) {

        boolean access = false;

        System.out.println(user.toStringWithoutID());

        conn = DBConnection.getConnection();
        String query = "select * from user where username like ? and password like ?";

        try {
            PreparedStatement ps
                    = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword());
            ResultSet rset = ps.executeQuery();
            System.out.println("success");

            rset.last();
            if (rset.getRow() == 1) {
                access = true;
                System.out.println("登入成功！ 使用者：" + user.getUser_name());
                rset.close();

            } else {
                System.out.println(rset.getRow());
                rset.close();
            }

        } catch (SQLException ex) {
            System.out.println("SQL錯誤：" + ex);
        }

        return access;
    }

    public int returnId(Users user) {

        System.out.println("returnID: name = " + user.getUser_name() + " password = " + user.getPassword());

        conn = DBConnection.getConnection();
        String query = "select * from user where username like ? and password like ?";

        try {
            PreparedStatement ps
                    = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword());
            ResultSet rset = ps.executeQuery();
            System.out.println("Login success");

            rset.last();
            System.out.println(rset.getRow());
            user.setUser_id(rset.getInt("user_id"));
            int usr = user.getUser_id();
            System.out.println(usr);

            return usr;

        } catch (SQLException ex) {

            System.out.println("SQL錯誤：" + ex);

            return 0;
        }

    }
}
