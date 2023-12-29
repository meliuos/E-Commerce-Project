import java.util.ArrayList;
import java.util.List;
import java.util.Date;
// Discount interface representing a discount strategy
interface Discount {
    void applyDiscount(double originalAmount);
}

// PercentageDiscount class implementing Discount for percentage-based discounts
class PercentageDiscount implements Discount {
    private double percentage;
    protected Product product;

    // Constructor
    public PercentageDiscount(double percentage,Product product) {
        this.percentage = percentage;
        this.product=product;
    }

    @Override
    public void applyDiscount(double originalAmount) {
         product.setPrice(originalAmount - (originalAmount * (percentage / 100.0)));
    }
}

// FixedAmountDiscount class implementing Discount for fixed amount discounts
class FixedAmountDiscount implements Discount {
    private double amount;
    protected Product product;


    // Constructor
    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public void applyDiscount(double originalAmount) {
        product.setPrice(Math.max(0, originalAmount - amount));
    }
}

// Promotion class managing available discounts
class Promotion {
    private static List<Discount> discounts;

    // Constructor
    public Promotion() {
        this.discounts = new ArrayList<>();
    }

    // Add a discount to the promotion
    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    // Apply discounts to the original amount
    public void applyDiscounts(double originalAmount) {
        for (Discount discount : discounts) {
            discount.applyDiscount(originalAmount);
        }
    }
}

// Updated Payment class with promotion support
class Payment {
    private double amount;
    private Date paymentDate;
    private PaymentMethod paymentMethod;
    private Promotion promotion;

    // Constructor
    public Payment(double amount, PaymentMethod paymentMethod, Promotion promotion) {
        this.amount = amount;
        this.paymentDate = new Date();
        this.paymentMethod = paymentMethod;
        this.promotion = promotion;
    }

    // Getter methods
    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    // Apply discounts before processing payment ;
    public void applyDiscounts(double amount){
        promotion.applyDiscounts(amount);
    }
}