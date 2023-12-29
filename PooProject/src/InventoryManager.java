import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


public class InventoryManager{
        public static final Map<String, Product> productInventory=  new HashMap<>();

        // Method to add a product to the inventory
        public void addProduct(Product product) throws InvalidAmountException{
            if(productInventory.containsKey(product.getProductId())){
                throw new InvalidAmountException("There is already a product with this ID");
            }
            else {
            productInventory.put(product.getProductId(), product);
            }
        }
        public void remProduct(Product product)throws InvalidAmountException{
            if(productInventory.containsValue(product)){
                productInventory.remove(product.getProductId());
            }
            else {
                throw new InvalidAmountException("There is no product with this ID");
            }
        }

        // Method to purchase a product and update the inventory
        public void purchaseProduct(String productId, int quantity) {
            Product product = productInventory.get(productId);
            if (product != null) {
                int currentStock = product.getStockQuantity();
                product.setStockQuantity(currentStock + quantity);
                System.out.println("Purchase successful. Updated stock quantity: " + product.getStockQuantity());
            } else {
                System.out.println("Product not found in inventory.");
            }
        }

        // Method to check and alert if a product is low or out of stock
        public void checkStockStatus(String productId) {
            Product product = productInventory.get(productId);
            if (product != null) {
                if (product.getStockQuantity() == 0) {
                    System.out.println("Alert: Product " + product.getProductName() + " is out of stock!");
                } else if (product.getStockQuantity() < 5) {
                    System.out.println("Alert: Low stock for product " + product.getProductName() +
                            ". Current stock quantity: " + product.getStockQuantity());
                }
            } else {
                System.out.println("Product not found in inventory.");
            }
        }
        //quick note I used Lambda function inside of the filter function
        // Method to filter products by category
        public Map<String, Product> filterByCategory(String category) {
            return productInventory.entrySet().stream()
                    .filter(entry -> entry.getValue().getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

    // Method to search products by keyword
    public Map<String, Product> searchByKeyword(String keyword) {
        return productInventory.entrySet().stream()
                .filter(entry ->
                        entry.getValue().getProductName().toLowerCase().contains(keyword.toLowerCase()) ||
                                entry.getValue().category.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // Method to search products by price range
    public Map<String, Product> searchByPriceRange(double minPrice, double maxPrice) {
        return productInventory.entrySet().stream()
                .filter(entry -> entry.getValue().getPrice() >= minPrice && entry.getValue().getPrice() <= maxPrice)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
