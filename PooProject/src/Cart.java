import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final long ID;
    static private Long lastID= 0L;
    protected Map<String,CartItem> Items=new HashMap<>();
    private double total;
    //Constructors
    Cart(){
        this.ID= lastID;
        lastID++;
        total=0;
    }
    Cart(CartItem item,int quantity){
        this();
        total+=item.product.price;
        this.Items.put(item.product.productId,item);
    }
    //getters and setters
    //Returns the total amount the cart ;
    public double getTotal() {
        double t=0;
        for(Map.Entry<String, CartItem> item:Items.entrySet()) {
            t+=item.getValue().product.getPrice()*item.getValue().getQuantity();
        }
        return t;
    }

    public long getID() {
        return ID;
    }

    public Map<String,CartItem> getItems() {
        return Items;
    }

    public static Long getLastID() {
        return lastID;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    //ADDING ITEM TO THE CART
    void addItem(CartItem i){
        Items.put(i.product.productId,i);
    }
    // removing item from the cart
    void remItem(CartItem item){
        Items.remove(item.product.productId);
    }
    //updating quantity of a certain product
    void updateQuantity(Product product,int quantity)throws InvalidAmountException{
            if(quantity > InventoryManager.productInventory.get(product.productId).getStockQuantity() || quantity<=0){
                throw new InvalidAmountException("Quantity invalid !");
            }
            if(Items.containsKey(product.productId)){
                Items.get(product.productId).setQuantity(quantity);
            }
            else {
                System.out.println("There is no product like this ");
            }
        }
    }

