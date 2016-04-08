package ntu.cs.kwangbeng.ccsg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);
        setTitle("View My Groups");

        final ListView viewGroupList = (ListView)findViewById(R.id.viewGroupList);

        if (Homepage.currentUser.getGroups().size() < 1){
            Toast.makeText(this, "You have no Groups! Please return to the previous page.", Toast.LENGTH_SHORT).show();
        }

        viewGroupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                final Group group = Homepage.currentUser.getGroups().get(position);
                final Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.viewgrouppopup);
                dialog.setTitle(group.getTitle());

                TextView type = (TextView) dialog.findViewById(R.id.viewMyType);
                TextView location = (TextView) dialog.findViewById(R.id.viewMyLocation);
                TextView date = (TextView) dialog.findViewById(R.id.viewMyDate);
                TextView leader = (TextView) dialog.findViewById(R.id.viewMyLeader);
                TextView desc = (TextView) dialog.findViewById(R.id.viewMyDesc);
                TextView size = (TextView) dialog.findViewById(R.id.viewMySize);
                TextView time = (TextView) dialog.findViewById(R.id.viewMyTime);
                ListView members = (ListView) dialog.findViewById(R.id.viewMyMembers);

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

                Button leaveGroupBtn = (Button) dialog.findViewById(R.id.leaveBtn);

                leaveGroupBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        new AlertDialog.Builder(ViewGroup.this)
                                .setTitle("Leave Group")
                                .setMessage("Do you really want to leave group?")
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog1, int whichButton) {
                                        group.getMembers().remove(Homepage.currentUser);
                                        Homepage.currentUser.removeGroup(group);
                                        Toast.makeText(ViewGroup.this, "Left Group successfully", Toast.LENGTH_SHORT).show();
                                        ViewGroupAdapter adapter = new ViewGroupAdapter(ViewGroup.this, R.layout.searchgrouplist, Homepage.currentUser.getGroups());
                                        viewGroupList.setAdapter(adapter);
                                    }})
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog1, int whichButton) {
                                        dialog.show();
                                    }}).show();

                    }
                });

                ArrayList<String> nameList = new ArrayList<String>();
                for (int i = 0; i < group.getMembers().size(); i++) {
                    nameList.add(group.getMembers().get(i).getName());
                }

                ArrayAdapter adapter = new ArrayAdapter(ViewGroup.this, android.R.layout.simple_list_item_1, nameList);
                members.setAdapter(adapter);

                dialog.show();
            }
        });

        ViewGroupAdapter adapter = new ViewGroupAdapter(this, R.layout.searchgrouplist, Homepage.currentUser.getGroups());
        viewGroupList.setAdapter(adapter);
    }

    public class ViewGroupAdapter extends ArrayAdapter {

        public ViewGroupAdapter(Context context, int viewResourceId, ArrayList<Group> values) {
            super(context, viewResourceId, values);
        }
        @Override
        public View getView(int position, View convertView, android.view.ViewGroup parent) {
            Group group = (Group)getItem(position);
            View rowView = LayoutInflater.from(getContext()).inflate(R.layout.viewgrouplist, parent, false);

            TextView title = (TextView)rowView.findViewById(R.id.viewGroupTitle);
            TextView type = (TextView)rowView.findViewById(R.id.viewGroupType);
            TextView location = (TextView)rowView.findViewById(R.id.viewGroupLocation);
            TextView date = (TextView)rowView.findViewById(R.id.viewGroupDate);
            TextView leader = (TextView)rowView.findViewById(R.id.viewGroupLeader);
            TextView size = (TextView)rowView.findViewById(R.id.viewGroupSize);
            ImageView isLeader = (ImageView)rowView.findViewById((R.id.viewGroupIsLeader));

            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat t = new SimpleDateFormat("HH:mm");

            if (group.getLeader().getName().compareTo(Homepage.currentUser.getName()) != 0){
                isLeader.setVisibility(View.INVISIBLE);
            }

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
}
