package ntu.cs.kwangbeng.ccsg;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;



/**
 * Created by Linus on 9/4/2016.
 */


public class ViewAllCCs extends AppCompatActivity  {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_ccs);


        expListView = (ExpandableListView) findViewById(R.id.CClistView);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Aljunied Community Centre");
        listDataHeader.add("Ang Mo Kio Comunnity Centre");
        listDataHeader.add("Bishan Comunnity Centre");
        listDataHeader.add("Cairnhill Centre");
        listDataHeader.add("Dover Comunnity Centre");
        listDataHeader.add("Hougang Community Centre");
        listDataHeader.add("Jalan Besar Community Centre");
        listDataHeader.add("Marine Parade Community Centre");
        listDataHeader.add("Nanyang Community Centre");
        listDataHeader.add("Sengkang Community Centre");


        List<String> Aljunied = new ArrayList<String>();
        Aljunied.add("Address : 110 Hougang Ave 1, HDB Hougang, 530110");
        Aljunied.add("Phone Number : 6288 4320");
        Aljunied.add("Operating Hours : 0900 - 2200");
        Aljunied.add("Available Facilities : Tennis, Soccer, Sauna, Badminton");


        List<String> AMK = new ArrayList<String>();
        AMK.add("Address : 795 Ang Mo Kio Avenue 1, 569976");
        AMK.add("Phone Number : 6452 9644");
        AMK.add("Operating Hours : 0100 - 2200");
        AMK.add("Available Facilities : Laser Tag, Basketball, Archery, Dance Studio, Netball");

        List<String> Bishan = new ArrayList<String>();
        Bishan.add("Address : 51 Bishan Street 13, Singapore 579799");
        Bishan.add("Phone Number : 6259 4720");
        Bishan.add("Operating Hours : 0900 - 2000");
        Bishan.add("Available Facilities : Squash, Volleyball, Laser Tag, Basketball");


        List<String> Cairnhill = new ArrayList<String>();
        Cairnhill.add("Address : 1 Anthony Rd, 229944");
        Cairnhill.add("Phone Number : 6737 9537");
        Cairnhill.add("Operating Hours : 0900 - 2200");
        Cairnhill.add("Available Facilities : Rugby, Soccer, Sepak Takraw, Cricket, Swimming");

        List<String> Dover = new ArrayList<String>();
        Dover.add("Address : 1 Dover Rd, Singapore 130001");
        Dover.add("Phone Number : 6777 0976");
        Dover.add("Operating Hours : 0800 - 2300");
        Dover.add("Available Facilities : Table Tennis, Basketball, Swimming Pool");

        List<String> Hougang = new ArrayList<String>();
        Hougang.add("Address : 35 Hougang Avenue 3, 538840");
        Hougang.add("Phone Number : 6282 8887");
        Hougang.add("Operating Hours : 0900 - 2000");
        Hougang.add("Available Facilities : Soccer, Sepak Takraw, Cricket, Swimming");

        List<String> JalanBesar = new ArrayList<String>();
        JalanBesar.add("Address : 69 Jellicoe Rd, Singapore 208737");
        JalanBesar.add("Phone Number : 6298 6110");
        JalanBesar.add("Operating Hours : 1200 - 2200");
        JalanBesar.add("Available Facilities : Laser Tag . Rugby");

        List<String> MarineParade  = new ArrayList<String>();
        MarineParade.add("Address : 278 Marine Parade Road 449282");
        MarineParade.add("Phone Number : 6346 7703");
        MarineParade.add("Operating Hours : 0800 - 2000");
        MarineParade.add("Available Facilities : Bowling, Volleyball, Squash, Tennis, Archery");

        List<String> Nanyang = new ArrayList<String>();
        Nanyang.add("Address : 60 Jurong West Street 91, Singapore 649040");
        Nanyang.add("Phone Number : 6791 0395");
        Nanyang.add("Operating Hours : 1000 - 2000");
        Nanyang.add("Available Facilities : Dance Studio, Laser Tag, Basketball, Soccer");

        List<String> Sengkang = new ArrayList<String>();
        Sengkang.add("Address : 2 Sengkang Square, 545025");
        Sengkang.add("Phone Number : 6312 5400");
        Sengkang.add("Operating Hours : 1100 - 2100");
        Sengkang.add("Available Facilities : Street Soccer, Sepak Takraw, Cricket, Table Tennis");



        listDataChild.put(listDataHeader.get(0), Aljunied);
        listDataChild.put(listDataHeader.get(1), AMK);
        listDataChild.put(listDataHeader.get(2), Bishan);
        listDataChild.put(listDataHeader.get(3), Cairnhill);
        listDataChild.put(listDataHeader.get(4), Dover);
        listDataChild.put(listDataHeader.get(5), Hougang);
        listDataChild.put(listDataHeader.get(6), JalanBesar);
        listDataChild.put(listDataHeader.get(7), MarineParade);
        listDataChild.put(listDataHeader.get(8), Nanyang);
        listDataChild.put(listDataHeader.get(9), Sengkang);

    }
}