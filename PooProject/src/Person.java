import java.util.*;
//Person class that will be got inheritance from under-classes for simple login we only need a username and a password ;

public class Person {
    String user,password;
    boolean isAdmin=false;
    //Constructors
    Person(){
        user="";
        password="";
    }
    Person(String user,String pass){
        this.user=user;
        this.password=pass;
    }
    //getters and setters
    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setUser(String user) {
        this.user = user;
    }

    protected String getPassword() {
        return password;
    }

    protected String getUser() {
        return user;
    }


}