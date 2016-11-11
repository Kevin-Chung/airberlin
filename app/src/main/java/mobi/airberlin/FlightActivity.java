package mobi.airberlin;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class FlightActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        XapixService service = new XapixService(this);
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
}
