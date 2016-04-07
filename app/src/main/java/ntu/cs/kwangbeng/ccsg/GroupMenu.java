package ntu.cs.kwangbeng.ccsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GroupMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_menu);

        //Create Group Btn
        ImageButton createGroup = (ImageButton)this.findViewById(R.id.CreateGroupBtn);
        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroupMenu.this, CreateGroup.class);
                startActivity(i);
            }
        });

        //View Group Btn
        ImageButton viewGroup = (ImageButton)this.findViewById(R.id.ViewGroupBtn);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroupMenu.this, ViewGroup.class);
                startActivity(i);
            }
        });

        //Join Group Btn
        ImageButton joinGroup = (ImageButton)this.findViewById(R.id.JoinGroupBtn);
        joinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroupMenu.this, JoinGroup.class);
                startActivity(i);
            }
        });

    }
}
