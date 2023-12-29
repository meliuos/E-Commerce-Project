public class CartItem {
    protected Product product;
    private int quantity;
    //Constructors
    CartItem(Product p,int quantity){
        this.product=p;
        this.quantity=quantity;
    }
    //GETTERS AND SETTERS
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
