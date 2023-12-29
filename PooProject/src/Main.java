import java.time.YearMonth;
import java.util.Date;
import java.util.Scanner;

class Electronics extends Product{
    Electronics(String productId,String productname,double price,int quantity){
        super(productId,productname,price,quantity);
    }
    public String getProductType(){
        return this.category.getCategoryName();
    }
}
class Khodhra extends Product {
    //Price per Kilo also quantity per kilo
    Khodhra(String productId, String productname, double price, int quantity) {
        super(productId, productname, price, quantity);
    }
    public String getProductType(){
        return this.category.getCategoryName();
    }
}
public class Main {
    static PersonManagement personManagement=new PersonManagement();
    static InventoryManager inv=new InventoryManager();
    static boolean ok;
    static Customer SignInUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1:Sign In");
        System.out.println("2:Sign Up");
        int n;
        do {
            System.out.println("Enter ur choice ");
            n = scanner.nextInt();
        }
        while ((n < 0) || (n > 2));
        if (n == 1) {
            ok = false;
            String user = "";
            String pass = "";
            System.out.println("Enter ur User Name :");
            user=scanner.next();
            System.out.println("Enter ur password : ");
            pass=scanner.next();
            Person loginPerson=new Customer(user,pass);
            ok = PersonManagement.signIn(loginPerson);
            return PersonManagement.customerList.get(user);
        }
        else {
            ok = false;
            String user = "";
            String pass = "";
            System.out.println("*** Signing Up ***");
            System.out.println("Enter ur User Name :");
            user=scanner.next();
            System.out.println("Enter ur password : ");
            pass=scanner.next();
            PersonManagement.signUp(user, pass, false);
            Customer loginPerson=new Customer(user, pass);
            return loginPerson;
        }
            }
    public static void main(String[] args) throws InvalidAmountException{
            Scanner scan=new Scanner(System.in);
            Category elect=new Category("Electronics","This is a category for electronics like pcs smartphones TVs and etc...");
            Category khodhra=new Category("Khodhra","this is a category for khodhra");
            Product dola3=new Khodhra("d1","Dola3",0.500,500);
            Electronics tv = new Electronics("Tv1", "Samsung TV smart 40'", 500, 50);
            Product phone=new Electronics("phone1","Iphone 14 PRO MAX",4000,100);
            Admin ceo=new Admin("admin1","admin1",true);
            PersonManagement.addAdmin(ceo);
            Customer customer=new Customer("mootez","mootez");
            PersonManagement.addCustomer(customer);
            tv.setCategory(elect);
            phone.setCategory(elect);
            dola3.setCategory(khodhra);
            inv.addProduct(tv);
            inv.addProduct(phone);
            inv.addProduct(dola3);
            PercentageDiscount percentageDiscount=new PercentageDiscount(10,phone);
            Promotion promotion=new Promotion();
            promotion.addDiscount(percentageDiscount);
            System.out.println("WE HAVE GOOD NEWS FOR YOU " +
                "There is a discount of 10% on Iphone 14 PRO MAX");
            Customer login=new Customer("","");
            while(ok==false) {
                login = SignInUp();
            }
            int n;
            int choice;
            while(ok){
                do {
                    Customer.CustomerMenu();
                    choice = scan.nextInt();
                }
                while ((choice < 0) || choice > 9);
                String keyword = "";
                String name = "";
                double pmin;
                double pmax;
                int x;
                int x2;
                YearMonth date;
                PaymentMethod paymentMethod;
                switch (choice) {
                    case 0:
                        System.out.println(inv.searchByKeyword(""));
                        break;
                    case 1:
                        System.out.println("Enter the keyword :");
                        keyword = scan.next();
                        System.out.println(inv.searchByKeyword(keyword));
                        break;
                    case 2:
                        System.out.println("Enter the Category name :");
                        keyword = scan.next();
                        System.out.println(inv.filterByCategory(keyword));
                        break;
                    case 3:
                        System.out.println("Enter the minimum price :");
                        pmin = scan.nextDouble();
                        System.out.println("Enter the maximum price :");
                        pmax = scan.nextDouble();
                        System.out.println(inv.searchByPriceRange(pmin, pmax));
                        break;
                    case 4:
                        System.out.println("Enter the product id :");
                        keyword = scan.next();
                        if (!InventoryManager.productInventory.containsKey(keyword)) {
                            System.out.println("There is no product with this ID ");
                        } else {
                            System.out.println("Enter the quantity u want to purchase :");
                            x = scan.nextInt();
                            CartItem item = new CartItem(InventoryManager.productInventory.get(keyword), x);
                            login.cart.addItem(item);
                            System.out.println(login.cart.getItems());
                        }
                        break;
                    case 5:
                        System.out.println("Enter the product id :");
                        keyword = scan.next();
                        if (!InventoryManager.productInventory.containsKey(keyword)) {
                            System.out.println("There is no product with this ID");
                        } else {
                            login.cart.remItem(login.cart.Items.get(keyword));
                            System.out.println(login.cart.getItems());
                        }
                        break;
                    case 6:
                        System.out.println("Enter the product id :");
                        keyword = scan.next();
                        if (!InventoryManager.productInventory.containsKey(keyword)) {
                            System.out.println("There is no product with this ID");
                        } else {
                            n = scan.nextInt();
                            login.cart.updateQuantity(InventoryManager.productInventory.get(keyword), n);
                        }
                        break;
                    case 7:
                        System.out.println(login.cart.getTotal());
                        break;
                    case 8:
                        Order order = new Order(login, login.cart.getItems());
                        System.out.println("1:To pay with paypal");
                        System.out.println("2:To pay with Credit Card");
                        do {
                            x = scan.nextInt();
                        }
                        while (x != 1 && x != 2);
                        if (x == 1) {
                            System.out.println("Enter your Email: ");
                            keyword = scan.next();
                            paymentMethod = new PayPalPayment(keyword);
                        } else {
                            System.out.println("Enter your credit card Number");
                            keyword = scan.next();
                            System.out.println("Enter the name of the card holder :");
                            name = scan.next();
                            System.out.println("Enter the month of the expiration date :");
                            x = scan.nextInt();
                            System.out.println("Enter the year of the expiration date :");
                            x2 = scan.nextInt();
                            date = YearMonth.of(x, x2);
                            paymentMethod = new CreditCardPayment(keyword, name, date);
                        }
                        Payment payment = new Payment(order.getTotalAmount(), paymentMethod, promotion);
                        payment.applyDiscounts(login.cart.getTotal());
                        paymentMethod.processPayment(login.cart.getTotal());

                        break;
                    case 9:
                        System.exit(1);
                        break;
                }
            }
    }
}