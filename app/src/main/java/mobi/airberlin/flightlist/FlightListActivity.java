package mobi.airberlin.flightlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mobi.airberlin.FlightActivity;
import mobi.airberlin.FlightModel;
import mobi.airberlin.R;

public class FlightListActivity extends AppCompatActivity {
    ArrayList<FlightModel> myFLightData;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //basic android stuff***********************
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        //create fake 3 flights
        context=this;

        mRecyclerView = (RecyclerView)findViewById(R.id.flightList);

        //recycler view stuff************************
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        /*
            add check, if this is our first time in the activity (intent is null) then
            we don't try to fetch data from it
         */

        Intent intent = getIntent();
        // I don't think intent is null, so check if flight data is null

        myFLightData = initData();
        if(myFLightData !=null) {
            // if flight activity is not null then that means you already were in this activity
            Log.d("testing",((FlightModel)intent.getSerializableExtra("flightmodel")).getDestinationA());
            myFLightData.add(0,(FlightModel)intent.getSerializableExtra("flightmodel"));
        }else{
            // if flight data is null that means you are in this activity for the first time
        }
        Log.d("myflightdata", myFLightData.size() + "");
        mAdapter = new FlightListAdapter(myFLightData);
        mRecyclerView.setAdapter(mAdapter);


        //Floating Action buttons**********************
        FloatingActionButton addFlightFab = (FloatingActionButton) findViewById(R.id.floatingActionAddFlight);
        addFlightFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FlightActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton lighteningFab = (FloatingActionButton) findViewById(R.id.floatingActionLightening);
        lighteningFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "oh no! flight delayed!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ArrayList<FlightModel> initData()  {

        ArrayList<FlightModel> fmList = new ArrayList<>();
        try {
            //the departure time
            Calendar cal = Calendar.getInstance();
            //the arrival time
            Calendar cal2 = Calendar.getInstance();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tempDate = "2016-12-20";
            date = sdf.parse(tempDate);
            cal.setTime(date);
            //11:30 flight
            cal.set(Calendar.HOUR_OF_DAY,11);
            cal.set(Calendar.MINUTE,30);

            cal2.setTime(date);
            cal2.set(Calendar.HOUR_OF_DAY,23);
            cal2.set(Calendar.MINUTE,30);
            //CALENDAR IS FREAKING MUTABLE. WHYYYYY
            fmList.add(new FlightModel("ADODD", 246.11, 2104.50, 34.11, "DFW", "PMI", "ECOFLEX", "BOEING 747", cal, cal2, "abcd"));

            tempDate = "2016-12-30";
            date = sdf.parse(tempDate);
            cal = Calendar.getInstance();
            cal2 = Calendar.getInstance();
            cal.setTime(date);
            // 8:45am flight
            cal.set(Calendar.HOUR_OF_DAY,8);
            cal.set(Calendar.MINUTE,45);


            cal2.setTime(date);
            cal2.set(Calendar.HOUR_OF_DAY,20);
            cal2.set(Calendar.MINUTE,30);
            fmList.add(new FlightModel("CFDAD", 346.11, 2904.80, 34.11, "PMI", "DFW", "FIRSTCLASS", "BOEING 747", cal, cal2, "abcd"));

            tempDate = "2017-01-30";
            date = sdf.parse(tempDate);
            cal = Calendar.getInstance();
            cal2 = Calendar.getInstance();
            cal.setTime(date);
            //6 am flight
            cal.set(Calendar.HOUR_OF_DAY,6);

            cal2.setTime(date);
            cal2.set(Calendar.HOUR_OF_DAY,18);
            cal2.set(Calendar.MINUTE,30);
            fmList.add(new FlightModel("ZDFFA", 246.11, 2104.50, 34.11, "DFW", "PMI", "ECOFLEX", "BOEING 747", cal, cal2, "abcd"));

            return fmList;
        }catch(Exception e){
            Log.d("error in init","error in inti");

        }
        return null;
    }
}
