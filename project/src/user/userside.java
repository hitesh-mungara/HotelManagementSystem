package user;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class foodorder  {

    int order;
    ArrayList<Integer>od;





    void ch(){
        Scanner in=new Scanner(System.in);
        od=new ArrayList<>(10);
        System.out.println("--------------------------MENU------------------------");

        System.out.println("1.Pizza   ₹ 200");

        System.out.println("2.Burger ₹ 100");

        System.out.println("3.Tea    ₹ 20");
        System.out.println("4.Coffee ₹ 30");

        System.out.println("5.Pani puri ₹ 40");
        System.out.println("6.Chaat ₹ 15");
        while(true) {
            System.out.println("Enter 'O and the food numbers' to add to the basket");
            System.out.println("Enter 'E' if your order is completed");
            char ch=in.next().charAt(0);
            if(ch=='O'||ch=='o'){
                od.add(in.nextInt());
            }
            else{
                break;
            }

        }









    }






    public void actionPerformed()

    {
        od.sort();
        int amount=0;
        int count[10]=new int[];
        count[0]=0;
        System.out.println("Your bill is ");
        for (int i = 1; i <=6; i++) {

            if(od.contains(i)){
                count[i]=od.lastIndexOf(i)-od.lastIndexOf(i);
            }
            else{
                count[i]=0;
            }

        }
        for (int i = 1; i <=6; i++) {
            if(od.contains(i)){
                if(i==1){
                    System.out.println("Pizza : "+(200*(count[i]+1));
                    amount+=(200*(count[i]+1);

                }
                else if(i==2){
                    System.out.println("Burger : "+(100*(count[2]+1));
                    amount+=(100*(count[2]+1);

                }
                else if(i==3){
                    System.out.println("Tea : "+(20*(count[3]+1));
                    amount+=(20*(count[3]+1));


                }
                else if(i==4){
                    System.out.println("coffee : "+(30*(count[4]+1));
                    amount+=(30*(count[4]+1);

                }
                else if(i==5){
                    System.out.println("Pani puri : "+(40*(count[5]+1));
                    amount+=(40*(count[5]+1);

                }
                else if(i==6){
                    System.out.println("Chat : "+(15*(count[6]+1));
                    amount+=(15*(count[6]+1);

                }
                else{
                    System.out.println("Enter the food number properly");
                }
            }




        }



        float tax=(5*amount)/100;
        float totalamount=amount+tax;

        System.out.println( msg + "Total    : ₹ " + amount+ "\nGST(5%): ₹ "+tax+ "\n------------------------------------------\n"+ "Total(including GST of 5%): ₹ " + totalamount);




    }

}
class cleaning{

    public void room()  {




        System.out.println("Your request has been recieved");
        Thread.sleep(3000);
        System.out.println("Our staff is Ready for Visting you");
        System.out.println("He is near your door.Please open your door ");
        System.out.println("Your room has been cleaned.....");

    }}

class customer{


    String name;
    String dateofarrival;
    int numberOfNights;
    int order;

    public void details()   {
        Scanner in=new Scanner(System.in);
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        Object [] fields = {

                "Enter name ",field3,
                "\nDate(YYYY-MM-DD)",field4,
                "\nNumber of nights",field5

        };
//        int action=JOptionPane.showConfirmDialog(null,fields,"Customer details",JOptionPane.OK_CANCEL_OPTION);
//        if(action !=0){
//            JOptionPane.showMessageDialog(null,"Thank you for using our services\nBe sure to get back");
//            System.exit(0);
//
//        }
        System.out.println("Please enter your name");
        String guestName ;
        guestName =in.next() ;
//        dateofarrival = null;
//        try {
//            dateofarrival = String.valueOf(field4.getText());
//
//        }
//        catch (InputMismatchException ex) {
//            JOptionPane.showMessageDialog(null,"Please enter the correct format");
//
//        }
        System.out.println("Enter date of arrival");
        String dateOfarrival=in.next();
        System.out.println("Enter number of nights you wanna stay");
        int numberOfNights=in.nextInt();
        
        

       


//        int numberOfNights = Integer.parseInt(field5.getText());
//        try {
//            numberOfNights = Integer.parseInt(field5.getText());
//
//        }
//        catch (NumberFormatException ex){
//            JOptionPane.showMessageDialog(null,"Wrong datatype of number of nights entered");
//
//        }
//        cal.add(Calendar.DAY_OF_MONTH, numberOfNights);

//        String dateAfter = sdf.format(cal.getTime());
        System.out.println(guestName+":\nChecked in Date: "+dateofarrival);

    }
    public void choice() {
        Scanner in=new Scanner(System.in);
        System.out.println("Please feel free to use our services\n1.Cleaning\n2.Order food\n3.exit\n");
        int opinion=in.nextInt();
        if(opinion == 1){
            cleaning clean = new cleaning();
            clean.room();
        }
        else if(opinion == 2){
            foodorder f = new foodorder();
            f.ch();

        }else if (opinion == 3){
            System.out.println("Thank you for using our services\nBe sure to get back");
            break;
                    
        }

    }
}



public class userside {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub


        System.out.println("Welcome,How can we help You");
        customer cs= new customer ();
        cs.details();
        while (true){
            cs.choice();
        }
    }
}