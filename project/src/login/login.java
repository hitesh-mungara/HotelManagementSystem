package login;
import com.sun.tools.jdeprscan.scan.Scan;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

import java.util.*;

class containsadmin {
    private String name1="Hitesh";
    private String name2="Veda";
    private String name3="Siddharth";
    private String name4="Srinivas";
    private String name5="Nithish";
    public boolean checkadmin(String username) {
        if(username.equals(name1) || username.equals(name2)|| username.equals(name3)|| username.equals(name4) ||username.equals(name5)) {
            return true;
        }
        else {
            return false;
        }


    }
    public boolean passwordauthentication(){
        JPasswordField pwd = new JPasswordField();

        int action;
        System.out.println( "Enter Password");
        String password;
        boolean flag = false;
        if (action == 0) {
            password = String.valueOf(pwd.getPassword());

            if (password.equals("admin1234")) {
                System.out.println( "your login is successful");


                flag = true;
            } else {
                String message = "invalid password";
                System.out.println( message
                        );
            }
        } else{
            System.out.println("Thank you for using our services\nBe sure to get back");
            break;
        }
        return flag;
    }
}
public class login {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        // TODO Auto-generated method stub
        containsadmin ca= new containsadmin();
        System.out.println("Please enter Username");
        String username=in.next();
        boolean flag = false;
        if(ca.checkadmin(username)){
            System.out.println("Hello admin : "+username);
            while (flag == false) {

                flag=ca.passwordauthentication();
            }
            projectreview.HotelManagementSystemApp hmsa = new projectreview.HotelManagementSystemApp();
            hmsa.main(null);
        }else{
            System.out.println("Hello user : "+username);

            System.out.println( "Enter Password");
            String pas=in.next();
            int action=0;
            if (action == 0){
                System.out.println( "your login is successful");
                user.userside us = new user.userside();
                us.main(null);


            }else{

                System.exit(0);
            }

        }








    }

}