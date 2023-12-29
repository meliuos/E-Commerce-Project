import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person {
    //Attributes
    public Cart cart;
    private List<Order> orderHistory=new ArrayList<Order>(10);

    //Constructor
    public Customer(String user,String password){
        super(user,password);
        this.isAdmin=false;
        this.cart=new Cart();
    }

    // Method to add an order to the customer's order history
    public void addOrder(Order order) {
        orderHistory.add(order);
    }
    // Methode for viewing the products
    public void viewProducts(Map<String,Product> inventory){
        for(Map.Entry<String, Product> entry : inventory.entrySet()){
            System.out.println(entry.getValue().toString());
        }
    }

    public static void CustomerMenu() {
        System.out.println("0:view all of our products");
        System.out.println("1:View Products by keyword");
        System.out.println("2:view Products by Category");
        System.out.println("3:view Products by price Range");
        System.out.println("4:Add a product to ur cart");
        System.out.println("5:Remove a Product from ur cart");
        System.out.println("6:Change the quantity of a certain item");
        System.out.println("7:Get your total ");
        System.out.println("8:Complete your order and Payment !");
        System.out.println("9:Leave");
    }

}
