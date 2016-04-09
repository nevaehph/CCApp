package ntu.cs.kwangbeng.ccsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Homepage extends AppCompatActivity {

    public static ArrayList<Booking> allBookings;
    public static ArrayList<Group> allGroups;
    public static User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        allBookings = new ArrayList<Booking>();
        allGroups = new ArrayList<Group>();

        //For Presentation Purposes
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        Date d4 = new Date();

        Date all1 = new Date();
        Date all2 = new Date();
        Date all3 = new Date();
        Date all4 = new Date();

        try{
            d1 = ft.parse("2016-04-10 13:30");
            d2 = ft.parse("2016-04-10 16:30");
            d3 = ft.parse("2016-04-20 16:30");
            d4 = ft.parse("2016-04-20 18:30");

            all1 = ft.parse("2016-04-16 12:30");
            all2 = ft.parse("2016-04-16 13:30");
            all3 = ft.parse("2016-04-19 17:30");
            all4 = ft.parse("2016-04-19 18:30");
        } catch(ParseException e){
            System.out.println("Unparseable using " + ft);
        }

        Booking b3 = new Booking("Boon Lay Community Centre", "Badminton Court 1", all1, all2);
        Booking b4 = new Booking("Boon Lay Community Centre", "Badminton Court 2", all3, all4);

        User user1 = new User("Tommy Lee", "tom123", "tommylee@hotmail.com", "Simulation Address", "S9781289A");
        User user2 = new User("Alex Tan", "alex123", "alextan@hotmail.com", "Simulation Address", "S9784102A");

        user1.getBookings().add(b3);
        user2.getBookings().add(b4);

<<<<<<< HEAD
        Group g1 = new Group("Title 1", "Badminton", "Come and join in the fun!!", 5, b3, user1);
=======
        Group g1 = new Group("Title 1", "Badminton", "Come and join in the fun!! ASDASFASDASFASDASFASDASFASDASFD:D\nFriendly Matches abound!", 5, b3, user1);
>>>>>>> refs/remotes/origin/master
        Group g2 = new Group("Title 2", "Badminton", "Join us for a game of badminton!! :D", 4, b4, user2);

        allGroups.add(g1);
        allGroups.add(g2);

        currentUser = new User("John Lee", "john123", "johnlee@hotmail.com", "Simulation Address", "S9456789G");

        Booking b1 = new Booking("Boon Lay Community Centre", "Badminton Court 1", d1, d2);
        Booking b2 = new Booking("Boon Lay Community Centre", "Badminton Court 2", d3, d4);

        currentUser.getBookings().add(b1);
        currentUser.getBookings().add(b2);

        //end Presentation Purposes

        ImageButton group = (ImageButton)this.findViewById(R.id.GroupBtn);
<<<<<<< HEAD
        group.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
=======
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
>>>>>>> refs/remotes/origin/master
                Intent i = new Intent(Homepage.this, GroupMenu.class);
                startActivity(i);
            }
        });
<<<<<<< HEAD
=======

          ImageButton viewAllCCs = (ImageButton)this.findViewById(R.id.viewCCbtn);
          viewAllCCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, ViewAllCCs.class);
                startActivity(i);
            }
        });


>>>>>>> refs/remotes/origin/master
    }
}
