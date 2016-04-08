package ntu.cs.kwangbeng.ccsg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        setTitle("Create Group");

        //setup Spinner
        Spinner bookings = (Spinner)findViewById(R.id.BookingSpinner);
        bookings.setAdapter(new BookingsAdapter(this, R.layout.bookingsdialog, Homepage.currentUser.getBookings()));

        //Set SubmitBtn
        Button submitBtn = (Button)findViewById(R.id.GroupSubmitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText titleUI = (EditText)findViewById(R.id.groupTitle);
                String title = titleUI.getText().toString();
                EditText typeUI = (EditText)findViewById(R.id.groupType);
                String type = typeUI.getText().toString();
                EditText sizeUI = (EditText)findViewById(R.id.groupSize);
                String size = sizeUI.getText().toString();
                EditText descUI = (EditText)findViewById(R.id.groupDesc);
                String desc = descUI.getText().toString();

                if (title.compareTo("") == 0 || type.compareTo("") == 0 || size.compareTo("") == 0 || desc.compareTo("") == 0){
                    Toast.makeText(CreateGroup.this, "You did not enter all the values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Spinner bookings = (Spinner)findViewById(R.id.BookingSpinner);
                    int index = bookings.getSelectedItemPosition();
                    Booking b = Homepage.currentUser.getBookings().get(index);

                    Group g = new Group(title, desc, type, Integer.parseInt(size), b, Homepage.currentUser);
                    Homepage.currentUser.addGroup(g);
                    Homepage.allGroups.add(g);

                    Toast.makeText(CreateGroup.this, "Group Created Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    public class BookingsAdapter extends ArrayAdapter {

        public BookingsAdapter(Context context, int textViewResourceId, ArrayList <Booking> bookingsList){
            super(context, textViewResourceId, bookingsList);

        }

        public View getCustomView(int position, View convertView, ViewGroup parent){

            Booking booking = (Booking)getItem(position);

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bookingsdialog, parent, false);

            TextView BookingCCName = (TextView) convertView.findViewById(R.id.BookingCCName);
            TextView BookingCCType = (TextView) convertView.findViewById(R.id.BookingCCType);
            TextView BookingDate = (TextView) convertView.findViewById(R.id.BookingDate);
            TextView BookingTime = (TextView) convertView.findViewById(R.id.BookingTime);

            BookingCCName.setText(booking.getCC());
            BookingCCType.setText(booking.getType());

            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat t = new SimpleDateFormat("HH:mm");

            BookingDate.setText(d.format(booking.getStartDate()));
            BookingTime.setText(t.format(booking.getStartDate()) + " - " + t.format(booking.getEndDate()));

            return convertView;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }
    }

}


