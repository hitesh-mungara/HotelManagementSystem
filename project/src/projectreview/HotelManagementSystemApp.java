package projectreview;

import com.sun.tools.jdeprscan.scan.Scan;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

interface Reservation {
    public int getRoomNumber();
    public String getGuestName();
    public int getNumberOfNights();
}
abstract class HotelRoom implements Reservation {
    protected int roomNumber;
    protected String guestName;
    protected int numberOfNights;

    public HotelRoom(int roomNumber, String guestName, int numberOfNights) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String getGuestName() {
        return guestName;
    }

    @Override
    public int getNumberOfNights() {
        return numberOfNights;
    }

    public abstract double getPrice();
}
class StandardRoom extends HotelRoom {
    public StandardRoom(int roomNumber, String guestName, int numberOfNights) {
        super(roomNumber, guestName, numberOfNights);
    }

    @Override
    public double getPrice() {
        return 750.0;
    }
}

class DeluxeRoom extends HotelRoom {
    public DeluxeRoom(int roomNumber, String guestName, int numberOfNights) {
        super(roomNumber, guestName, numberOfNights);
    }

    @Override
    public double getPrice() {
        return 1250.0;
    }
}

class HotelManagementSystem {
    private List<Reservation> reservations;

    public HotelManagementSystem() {

        reservations = new ArrayList<>();
    }

    public void checkIn(Reservation reservation) {
        reservations.add(reservation);
    }

    public void checkOut(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber) {
                System.out.println(reservation.getGuestName()+"'s has left the room");
                reservations.remove(reservation);

                break;
            }
        }
    }

    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (Reservation reservation : reservations) {
            HotelRoom room = (HotelRoom) reservation;
            totalRevenue += room.getPrice();
        }
        return totalRevenue;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }

    public int displayMenu(ArrayList a) {
        Scanner in=new Scanner(System.in);

        int op=0;
        try {
            System.out.println( "\nHOTEL MANAGEMENT\n\n1. Check in\n2. Check out\n3. View total revenue\n4. View list of reservations\n5. Check details\n" +
                    "6. Exit\n\n");
            int option=in.nextInt();

            if (option==null){
                System.out.println("Thank you for using our services\nBe sure to get back");

            }else {
                op = Integer.valueOf(option);
                if(op < 0 || op >6 ){

                    System.out.println("Choose correct option");
                }
            }


        }catch (NumberFormatException e){
            String error = "Please enter only integers(from above option)";
            System.out.println();("Choose correct option");


        }

        return op;
    }

    public void handleInput(int option,ArrayList a,ArrayList t) {
        Scanner in=new Scanner(System.in);

        switch (option) {
            case 1 -> {
//                JTextField field1 = new JTextField();
//                JTextField field2 = new JTextField();
//                JTextField field3 = new JTextField();
//                JTextField field4 = new JTextField();
//                JTextField field5 = new JTextField();


                System.out.println("Enter type of room\n1.standard (₹ 750)\n2.deluxe (₹ 1250)");
                String field1=in.next();
                System.out.println("Enter room number from " + a);
                String field2=in.next();
                System.out.println("Enter name ");
                String field3=in.next();
                System.out.println("Date(YYYY-MM-DD)");
                String field4=in.next();
                System.out.println("Number of nights");
                String field5=in.next();



                int action = JOptionPane.showConfirmDialog(null, fields, "Customer details", JOptionPane.OK_CANCEL_OPTION);
                if (action != 0) {
                    JOptionPane.showMessageDialog(null, "Thank you for using our services\nBe sure to get back");
                    System.exit(0);

                }
                // Check in a guest

                int roomType1 = 1;
                try {
                    String roomtype = field1.getText();

                    if (roomtype == null) {
                        JOptionPane.showMessageDialog(null, "Thank you for using our services\nBe sure to get back");
                        System.exit(0);

                    }
                    roomType1 = Integer.valueOf(roomtype);

                    if (roomType1 > 2 || roomType1 <= 0) {
                        JOptionPane.showMessageDialog(null, "please choose from above");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please choose valid integer for Roomtype");
                    return;
                }

                int roomNumber = 0;

                try {
                    roomNumber = Integer.valueOf(field2.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong datatype of room number entered");
                    return;
                }
                if (!a.contains(String.valueOf(roomNumber))) {
                    System.out.println( "Please refer to available rooms list");
                    return;
                } else if (t.contains(String.valueOf(roomNumber))) {
                    System.out.println( "Sorry,Room is already occupied");
                    return;
                } else {

                    a.remove(String.valueOf(roomNumber));
                    t.add(String.valueOf(roomNumber));
                }
                String guestName;
                guestName = field3.getText();
                String dateofarrival;
                try {
                    dateofarrival = String.valueOf(field4.getText());

                } catch (InputMismatchException ex) {
                    System.out.println( "Please enter the correct format");
                    return;
                }

//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Calendar cal = Calendar.getInstance();
//                try {
//                    cal.setTime(sdf.parse(dateofarrival));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }


                int numberOfNights = Integer.parseInt(field5.getText());
                try {
                    numberOfNights = Integer.parseInt(field5.getText());

                } catch (NumberFormatException ex) {
                    System.out.println( "Wrong datatype of number of nights entered");
                    return;
                }
                cal.add(Calendar.DAY_OF_MONTH, numberOfNights);

                String dateAfter = sdf.format(cal.getTime());
                JOptionPane.showMessageDialog(null, guestName + "\nChecked in Date: " + dateofarrival + "\nCheck out date: " + dateAfter);
                JOptionPane.showMessageDialog(null, guestName + "'s Entry has been added.\nThank You");
                if (roomType1 == 1) {
                    StandardRoom room = new StandardRoom(roomNumber, guestName, numberOfNights);
                    checkIn(room);
                } else if (roomType1 == 2) {
                    DeluxeRoom room = new DeluxeRoom(roomNumber, guestName, numberOfNights);
                    checkIn(room);
                }
                break;
            }
            case 2 -> {
                int roomNumber;// Check out a guest

                roomNumber = 0;
                try {
                    System.out.println("Please enter the room number\nBooked rooms: \n" + t);
                    roomNumber=in.nextInt();

                } catch (NumberFormatException e) {
                    System.out.println( "Wrong format");
                }
                checkOut(roomNumber);
//                if (a.contains(String.valueOf(roomNumber))) {
//                    String error = "The Room is still empty";
//                    System.out.println(null, error, "Empty error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }


                a.add(String.valueOf(roomNumber));
                t.remove(String.valueOf(roomNumber));
                break;
            }
            case 3 -> { // View total revenue
                double totalRevenue = getTotalRevenue();
                System.out.println( "The total revenue generated is : ₹ " + totalRevenue);
            }
            case 4 -> {// View list of reservations
                List<Reservation> reservations = getReservations();
                String alldetails = "\n------------------------------------------------------\n";
                for (Reservation reservation : reservations) {

                    String details = "Room number: " + reservation.getRoomNumber() +
                            "\nGuest name: " + reservation.getGuestName() +
                            "\nNumber of nights: " + reservation.getNumberOfNights() +
                            "\n------------------------------------------------------\n";
                    alldetails = alldetails + details;

                }
                System.out.println( alldetails);
                break;
            }
            case 5 -> {
                List<Reservation> reservations;// Exit


                reservations = getReservations();
                System.out.println("Please enter the room number you want to search details of\n");
                int inp=in.nextInt();
                String details = null;
                for (Reservation reservation : reservations) {

                    if (reservation.getRoomNumber() == inp) {
                        details = "Room number: " + reservation.getRoomNumber() +
                                "\nGuest name: " + reservation.getGuestName() +
                                "\nNumber of nights: " + reservation.getNumberOfNights() +
                                "\n------------------------------------------------------\n";
                        System.out.println(details);

                    }

                }
                if (details == null) {
                    System.out.println( "No entry found`");
                }
                break;
            }
            case 6 -> {
                System.out.println("Thank you for using our services\nBe sure to get back");
                break;
            }
        }
    }
}



public class HotelManagementSystemApp {
    public static void main(String[] args){
        System.out.println("       WELCOME TO\n" +
                "HOTEL MANAGEMENT");
        HotelManagementSystem hms = new HotelManagementSystem();
        Scanner scanner = new Scanner(System.in);

        ArrayList a=new ArrayList();
        ArrayList t=new ArrayList();
        a.add("101");
        a.add("102");
        a.add("103");
        a.add("104");
        a.add("105");
        a.add("201");
        a.add("202");
        a.add("203");
        a.add("204");
        a.add("205");
        while (true) {
            int option=hms.displayMenu(a);
            hms.handleInput(option,a,t);
        }

    }
}