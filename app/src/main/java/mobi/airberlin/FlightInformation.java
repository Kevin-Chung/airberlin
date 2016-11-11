package mobi.airberlin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_information);

        Intent intent = getIntent();
        FlightModel fm = (FlightModel)intent.getSerializableExtra("flightmodel");

        TextView tv = (TextView)findViewById(R.id.flight_list_from);
        tv.setText(fm.getDestinationA());

        tv = (TextView)findViewById(R.id.flight_list_to);
        tv.setText(fm.getDestingationB());

        tv = (TextView)findViewById(R.id.flight_date);
        tv.setText(fm.getFlightDate().toString());

        tv = (TextView)findViewById(R.id.flight_price);
        tv.setText(fm.getTotalFlightPrice()+"");

        tv = (TextView)findViewById(R.id.flight_seat);
        tv.setText(fm.getSeatClass());

        tv = (TextView)findViewById(R.id.flight_plane);
        tv.setText(fm.getTypeOfPlane());
    }
}
