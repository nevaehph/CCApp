package ntu.cs.kwangbeng.ccsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Event_details extends AppCompatActivity {
    private TextView eventName;
    private TextView eventDate;
    private TextView eventTime;
    private TextView eventLocation;
    private TextView eventPrice;
    private ImageView money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent i = getIntent();
        eventName =(TextView) findViewById(R.id.heading);
        eventDate =(TextView) findViewById(R.id.date);
        eventTime =(TextView) findViewById(R.id.time);
        eventLocation =(TextView) findViewById(R.id.location);
        eventPrice =(TextView) findViewById(R.id.price);
        money = (ImageView) findViewById(R.id.price_icon);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Event Details");
//        setSupportActionBar(toolbar);

        eventName.setText(i.getStringExtra("Name"));
        Calendar startTime = (Calendar) i.getSerializableExtra("StartTime");
        Calendar endTime = (Calendar) i.getSerializableExtra("EndTime");
        eventDate.setText(startTime.get(Calendar.DAY_OF_MONTH)+"-"+(startTime.get(Calendar.MONTH)+1)+"-"+startTime.get(Calendar.YEAR));
        eventTime.setText(startTime.get(Calendar.HOUR_OF_DAY)+":"+startTime.get(Calendar.MINUTE)+" to "+endTime.get(Calendar.HOUR_OF_DAY)+":"+endTime.get(Calendar.MINUTE));
        eventLocation.setText(i.getStringExtra("Location"));
        eventPrice.setText("SGD "+String.valueOf(i.getFloatExtra("Price", 0)));
        Log.d("DAY",i.getStringExtra("Name"));
        if(i.getStringExtra("Name").equals("Racial Harmony Day")){
            money.setImageResource(R.drawable.ic_info_black_24px);
            eventPrice.setText("Racial Harmony Day has been marked in Singapore since 1964, to commemorate the 1964 Race Riots. It provides an opportunity\n" +
                    "to our society to reflect upon our multicultural fabric and appreciate our diversity.\n" +
                    "We at Raffles Community Centre organize intercultural events every year to mark this day. This year important members of \n" +
                    "the different races will be invited to give inspirational talks. Raffles JC kids are organizing a play on the theme of multiculturalism.");
            eventPrice.setTextSize(18);
        }
        else if(i.getStringExtra("Name").equals("Mother's Day")){
            money.setImageResource(R.drawable.ic_info_black_24px);
            eventPrice.setText("The hand that rocks the cradle is the hand that rules the world. Singaporean society has never forgotten the truth of these \n" +
                    "lines. We recognize the debt we owe to our mothers, and while we can never repay that, we can try once in a while to \n" +
                    "express our affection. \n" +
                    "Jurong Community Centre celebrates this day as a tribute to all mothers. The 4 hour long event will include fun games\n" +
                    "with mother-child teams, and the event will conclude with the screening with a movie on motherhoo by Natasha Brooks.");
            eventPrice.setTextSize(18);

        }


    }


}

