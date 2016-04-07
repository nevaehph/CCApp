package ntu.cs.kwangbeng.ccsg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Group {
    private Booking booking;
    private String title;
    private String description;
    private String type;
    private int size;
    private ArrayList<User> members;
    private User leader;

    public Group(String title, String type, String desc, int size, Booking booking, User u){
        this.title = title;
        this.type = type;
        this.description = desc;
        this.size = size;
        this.booking = booking;
        this.leader = u;
        this.members = new ArrayList<User>();
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getSize(){
        return size;
    }

    public String getType(){return type;}

    public Booking getBooking(){
        return booking;
    }

    public User getLeader() {
        return leader;
    }

    public ArrayList<User> getMembers(){
        return members;
    }

}
