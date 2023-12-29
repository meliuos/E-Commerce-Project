public class Admin extends Person {
    //Admin class for Admins that have privilege from 0-4 where:
    // 0 is the CEO
    // 1 Being in the Top of management team(all of them but cant change anything about the CEO details)
    //2 Mid-Manager(can Add or remove products and below and set Privilege)
    //3 Supervisors(Below and Add or remove admin)
    //4 Line workers(Can only refill stock or add new stock)
     int privilege ;
    //Dashboard Attribute for Entering and exiting the Admin dashboard
    public boolean dashboard ;
    Customer adminCustomer;
    //Constructor
    Admin(String user,String password,boolean b){
        super(user,password);
        adminCustomer=new Customer(user,password);
        this.isAdmin=true;
        this.dashboard=b;
    }
    //Getters and setters
    protected void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    protected void setDashboard(boolean dashboard) {
        this.dashboard = dashboard;
    }
    protected int getPrivilege(){
        return this.privilege;
    }
    protected boolean getDashboard(){
        return this.dashboard;
    }

    // Admin Dashboard Menu
    protected void adminDashboardMenu(){
        if(this.dashboard){
        System.out.printf("1:Show stock \n" +
                " 2:Add a product \n" +
                " 3:Remove a product \n" +
                " 4:search for a product \n" +
                " 5:Modify Admin privilege \n" +
                "6:Add an Admin\n " +
                "7:Remove an admin \n" +
                " 9:Refill Stock \n" +
                " 10:Modify Password \n " +
                "11:Add a fixed discount"+
                "12:Add a percentage discount"+
                "13:Go to Customer Menu \n" +
                " 14:Quit ");
        }
        else{
            Customer.CustomerMenu();
        }
    }
}