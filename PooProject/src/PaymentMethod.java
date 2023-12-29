import java.time.YearMonth;
import java.util.Date;

// PaymentMethod interface representing a payment method
interface PaymentMethod {
    void processPayment(double amount);
}

// CreditCardPayment class implementing PaymentMethod for credit card payments
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;
    private YearMonth expirationDate;

    // Constructor
    public CreditCardPayment(String cardNumber, String cardHolder, YearMonth expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Credit card details: " +
                "Card Number: " + cardNumber +
                ", Card Holder: " + cardHolder +
                ", Expiration Date: " + expirationDate);
        System.out.println("Payment processed successfully.\n");
    }
}

// PayPalPayment class implementing PaymentMethod for PayPal payments
class PayPalPayment implements PaymentMethod {
    private String email;
    // Constructor
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal account details: " +
                "Email: " + email);
        System.out.println("Payment processed successfully.\n");
    }
}