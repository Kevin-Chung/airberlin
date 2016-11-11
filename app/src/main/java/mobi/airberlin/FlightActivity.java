package mobi.airberlin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FlightActivity extends AppCompatActivity {

    Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        context = this;
        Button button = (Button)findViewById(R.id.search_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XapixService service = new XapixService(context);
                ArrayList<FlightModel> fmList = service.getFlights();
                Log.d("inside oncreate","yo");
                if(fmList!=null){
                    for(FlightModel fm : fmList){
                        Log.d("fmlist:",fmList.toString());
                    }

                }else{
                    Log.d("ERROr","ERROR");
                }
            }
        });
    }
}
