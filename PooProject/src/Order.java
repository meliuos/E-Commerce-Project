import java.util.*;

public class Order {
    private int orderId;
    static private int lastId=0;
    private Customer customer;
    private Map<String,CartItem> products;
    private Date orderDate;
    private double totalAmount;
    // Constructors
    public Order(Customer customer, Map<String,CartItem> products) {
        this.orderId = lastId;
        lastId++;
        this.customer = customer;
        this.products = new HashMap<String ,CartItem>(products);
        this.orderDate = new Date(); // This constructor initializes the object with the current date and time.
        // Assuming that the constructor will be called the moment the order is completed
        customer.addOrder(this); // Assuming a method to add this order to the customer's order history
    }
    // Getter methods
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<String,CartItem> getProducts() {
        return new HashMap<>(products); // Return a copy to prevent external modification
    }

    public Date getOrderDate() {
        return new Date(orderDate.getTime()); // Return a copy to prevent external modification
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
