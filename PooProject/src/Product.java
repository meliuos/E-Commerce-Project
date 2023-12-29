public abstract class Product {
    public String productName;
    public String productId;
    public double price;
    private int stockQuantity;
    public Category category;

    // Constructor
    public Product(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getProductType();

    // Getter and Setter methods
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public String toString() {
        return "---Product Name :'" + productName + "\n" +
                ", price :" + price +"DT \n"+
                 category +"---\n";
    }
}
