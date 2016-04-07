package ntu.cs.kwangbeng.ccsg;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JoinGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        setTitle("Join Group");

        ListView searchView = (ListView) findViewById(R.id.searchResultGroup);

        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Group group = Homepage.allGroups.get(position);
                final Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.joingrouppopup);
                dialog.setTitle(group.getTitle());

                TextView type = (TextView)dialog.findViewById(R.id.joinType);
                TextView location = (TextView)dialog.findViewById(R.id.joinLocation);
                TextView date = (TextView)dialog.findViewById(R.id.joinDate);
                TextView leader = (TextView)dialog.findViewById(R.id.joinLeader);
                TextView desc = (TextView)dialog.findViewById(R.id.joinDesc);
                TextView size = (TextView)dialog.findViewById(R.id.joinSize);
                TextView time = (TextView)dialog.findViewById(R.id.joinTime);

                SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat t = new SimpleDateFormat("HH:mm");

                type.setText("Activity Type: " + group.getType());
                location.setText("Venue: " + group.getBooking().getCC());

                desc.setText(group.getDescription());

                String dateString = "Date: " + d.format(group.getBooking().getStartDate());
                String timeString = "Time: " + t.format(group.getBooking().getStartDate()) + " - " + t.format(group.getBooking().getEndDate());

                date.setText(dateString);
                time.setText(timeString);
                leader.setText("Leader: " + group.getLeader().getName());

                int currentSize = group.getMembers().size() + 1;

                size.setText("Group Size: " + currentSize + "/" + group.getSize());

                dialog.show();
            }
        });

        SearchGroupAdapter adapter = new SearchGroupAdapter(this, R.layout.searchgrouplist, Homepage.allGroups);
        searchView.setAdapter(adapter);

    }

    public class SearchGroupAdapter extends ArrayAdapter {

        public SearchGroupAdapter(Context context, int viewResourceId, ArrayList<Group> values) {
            super(context, viewResourceId, values);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Group group = (Group)getItem(position);
            View rowView = LayoutInflater.from(getContext()).inflate(R.layout.searchgrouplist, parent, false);

            TextView title = (TextView)rowView.findViewById(R.id.searchGroupTitle);
            TextView type = (TextView)rowView.findViewById(R.id.searchGroupType);
            TextView location = (TextView)rowView.findViewById(R.id.searchGroupLocation);
            TextView date = (TextView)rowView.findViewById(R.id.searchGroupDate);
            TextView leader = (TextView)rowView.findViewById(R.id.searchGroupLeader);
            TextView size = (TextView)rowView.findViewById(R.id.searchGroupSize);

            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat t = new SimpleDateFormat("HH:mm");

            title.setText(group.getTitle());
            type.setText(group.getType());
            location.setText(group.getBooking().getCC());

            String dateString = d.format(group.getBooking().getStartDate()) + " " + t.format(group.getBooking().getStartDate()) + " - " + t.format(group.getBooking().getEndDate());

            date.setText(dateString);
            leader.setText(group.getLeader().getName());

            int currentSize = group.getMembers().size() + 1;

            size.setText(currentSize + "/" + group.getSize());

            return rowView;
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            TextView date = (TextView) getActivity().findViewById(R.id.searchSelectedDate);
            String dateToBeDisplayed = year+"/"+month+"/"+day;
            date.setText(dateToBeDisplayed);
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}

