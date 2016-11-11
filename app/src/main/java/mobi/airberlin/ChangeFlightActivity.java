package mobi.airberlin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChangeFlightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_flight);

        Intent intent = getIntent();
        FlightModel fm = (FlightModel)intent.getSerializableExtra("flight");

        TextView tv = (TextView)findViewById(R.id.delayed_header);
        tv.setText("Unfortunately your flight "+fm.getFlightNumber()+" has been canceled. Here are some alternatives we've selected for you");

        // this one is going to suck. Might need to recreate an entire recycler view here and adapter and everything
        // can copy pasta some code over but it'll be a doozy. Skipping for now

        // Potentially just port the entire xapix servie here and remake the request inside of this class. This will allow
        // updating the arraylist that is fed into the adapter easier.

        //skip for now. Fire intent to go to a new class immediately

        intent = new Intent(this,GoogleActivity.class);
        startActivity(intent);


    }
}
