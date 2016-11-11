package mobi.airberlin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mobi.airberlin.flightlist.FlightListActivity;

public class FlightInformation extends AppCompatActivity {

    Context context;
    FlightModel fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_information);

            context=this;

        Intent intent = getIntent();
        fm = (FlightModel)intent.getSerializableExtra("flightmodel");

        TextView tv = (TextView)findViewById(R.id.flight_list_from);
        tv.setText(fm.getDestinationA());

        tv = (TextView)findViewById(R.id.flight_list_to);
        tv.setText(fm.getDestingationB());

        tv = (TextView)findViewById(R.id.flight_date);
        tv.setText(fm.getFlightDate().getTime().toString());

        tv = (TextView)findViewById(R.id.flight_price);
        tv.setText(fm.getTotalFlightPrice()+"");

        tv = (TextView)findViewById(R.id.flight_seat);
        tv.setText(fm.getSeatClass());

        tv = (TextView)findViewById(R.id.flight_plane);
        tv.setText(fm.getTypeOfPlane());

        Button button = (Button)findViewById(R.id.book_flight);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlightListActivity.class);
                intent.putExtra("flightmodel",fm);
                startActivity(intent);
            }
        });
    }
}
