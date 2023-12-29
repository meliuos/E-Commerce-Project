import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonManagement {
    //List of the admins and customers and Keeping Track of the Number of admin and customers
    protected static int NbAdmins=0;
    protected static int NbCustomers=0;
    protected static Map<String,Admin> adminList = new HashMap<String,Admin>();
    protected static Map<String ,Customer> customerList = new HashMap<String,Customer>();
    //Verification of the existence of a person in the admin list and customer list for non redoubtably users
    protected static boolean verifyAdmin(Person a){
        System.out.println(a.password);
        System.out.println(Objects.equals(a.password,adminList.get(a.user)));
        if(adminList.containsKey(a.user)){
            Admin b=adminList.get(a.user);
            return Objects.equals(a.password, b.password);
        }
        return false;
    }
    protected static boolean verifyCustomer(Person a){
        if(customerList.containsKey(a.user)){
            return Objects.equals(a.password, customerList.get(a.user).password);
        }
        return false;
    }
    //Adding a Person to its Map ;
    protected static void addAdmin(Admin a){
        if(verifyAdmin(a)){
            System.out.println("Admin already Exist with same username");
        }
        else {
        adminList.put(a.user,a);
        System.out.println("SUCCESSFULLY ADDED AN ADMIN");
        NbAdmins++;
        }
    }

    public static void addCustomer(Customer c){
        if (verifyCustomer(c)){
            System.out.println("Customer already exists with the same Username");
        }
        else {
        customerList.put(c.user,c);
        System.out.println("SUCCESSFULLY ADDED A CUSTOMER");
        NbCustomers++;
        }
    }
    // Removing a perosn form its Map
    void RemAdmin(Person a){
        if(verifyCustomer(a)){
            adminList.remove(a.user,a);
            System.out.println("SUCCESFULLY REMOVED THE ADMIN ");
            NbAdmins--;
        }
        else {
            System.out.println("Couldn't Find the admin");
        }
    }
    //Removing Customer from its HashMap
    void RemCustomer(Person a){
        if(verifyCustomer(a)){
            customerList.remove(a.user,a);
            System.out.println("SUCCESFULLY REMOVED THE Customer ");
            NbCustomers--;
        }
        else {
            System.out.println("Couldn't Find the Customer");
        }
    }
    //Changing the password of a Person
    void changePass(Admin a,String pass){
        if(verifyAdmin(a)){
            a.setPassword(pass);
            adminList.replace(a.user,a);
            System.out.println("SUCCESFULLY CHANGED PASSSWORD");
        }
        else {
            System.out.println("Couldn't find this Username or password ");
        }
    }
    //Change the password of a customer
    void changePass(Customer a,String pass){
        if(verifyCustomer(a)){
            a.setPassword(pass);
            customerList.replace(a.user,a);
            System.out.println("SUCCESFULLY CHANGED PASSSWORD");
        }
        else {
            System.out.println("Couldn't find this Username or password ");
        }
    }
    public static void signUp(String user, String password, boolean isAdmin) {
        Person newPerson;
        if (isAdmin) {
            if(!PersonManagement.adminList.containsKey(user)){
            newPerson = new Admin(user, password,isAdmin);
            addAdmin((Admin) newPerson);}
            else {
                System.out.println("There is an admin with same User Name !");
            }
        } else {
            if(!PersonManagement.customerList.containsKey(user)){
            newPerson = new Customer(user, password);
            addCustomer((Customer) newPerson);}
            else {
                System.out.println("There is a customer with same user name !");
            }
        }
    }

    // Sign-in method for both admins and customers
    public static boolean signIn(Person loginPerson) {

        if (loginPerson.isAdmin) {
            loginPerson = new Admin(loginPerson.user, loginPerson.password,loginPerson.isAdmin);
        } else {
            loginPerson = new Customer(loginPerson.user, loginPerson.password);
        }

        if (loginPerson.isAdmin && verifyAdmin(loginPerson)) {
            System.out.println("Admin sign-in successful.");
            return true;
        } else if (!loginPerson.isAdmin && verifyCustomer(loginPerson)) {
            System.out.println("Customer sign-in successful.");
            return true;
        } else {
            System.out.println("Sign-in failed. Invalid username or password.");
            return false;
        }
    }

}
