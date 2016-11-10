package mobi.airberlin.flightlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mobi.airberlin.FlightModel;
import mobi.airberlin.R;

public class FlightListActivity extends AppCompatActivity {
    FlightModel[] myFLightData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //basic android stuff***********************
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);


        //recycler view stuff************************
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        //TODO::Need some sort of class that holds flight data problably.

        myFLightData = (FlightModel[])savedInstanceState.getSerializable("flightData");
        mAdapter = new FlightListAdapter(myFLightData);
        mRecyclerView.setAdapter(mAdapter);






        //Floating Action buttons**********************
        FloatingActionButton addFlightFab = (FloatingActionButton) findViewById(R.id.floatingActionAddFlight);
        addFlightFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This button should add a flight", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

}
