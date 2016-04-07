package ntu.cs.kwangbeng.ccsg;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private String email;
    private String homeAddress;
    private String NRIC;
    private ArrayList<Booking> bookings;
    private ArrayList<Group> groups;

    public User(String name, String password, String email, String homeAddress, String nric){
        this.name = name;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
        this.NRIC = nric;
        bookings = new ArrayList<Booking>();
        groups = new ArrayList<Group>();
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getHomeAddress(){
        return homeAddress;
    }

    public String getNRIC(){
        return NRIC;
    }

    public void addBooking(Booking b){
        bookings.add(b);
    }

    public void addGroup(Group g){
        groups.add(g);
    }

    public ArrayList<Booking> getBookings(){
        return bookings;
    }

    public ArrayList<Group> getGroups(){
        return groups;
    }

}
