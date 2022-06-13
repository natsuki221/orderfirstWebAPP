package orderfirst.orderpos.checkorder;


public class CheckOrder {
    
    private String product_id;
    private String order_num;
    private int quantity;
    private int product_price;
    private String product_name;
    private String order_date;
    private String finished;

    public CheckOrder() {
    }

    public CheckOrder(String product_id, String order_num, int quantity, int product_price, String product_name, String order_date, String finished) {
        this.product_id = product_id;
        this.order_num = order_num;
        this.quantity = quantity;
        this.product_price = product_price;
        this.product_name = product_name;
        this.order_date = order_date;
        this.finished = finished;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProduct_price() {
        return product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getFinished() {
        return finished;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    
    
    @Override
    public String toString() {
        return "Order{" + "product_id=" + product_id + ", order_num=" + order_num + ", quantity=" + quantity + ", product_price=" + product_price + ", product_name=" + product_name + ", order_date=" + order_date + ", finished=" + finished + '}';
    }
}
