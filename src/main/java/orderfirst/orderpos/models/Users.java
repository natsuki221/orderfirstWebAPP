package orderfirst.orderpos.models;

/**
 *
 * @author lintzujeng
 */
public class Users {
    
    private int user_id;
    private String user_name;
    private String password;

    public Users() {
    }

    public Users(int user_id, String user_name, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Users{" + "user_id=" + user_id + "user_name=" + user_name + ", password=" + password + '}';
    }
    
    public String toStringWithoutID() {
        return "Users{" + "user_name=" + user_name + ", password=" + password + '}';
    }

    public Users(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
}
