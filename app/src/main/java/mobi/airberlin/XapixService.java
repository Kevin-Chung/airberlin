package mobi.airberlin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mobi.airberlin.flightlist.FlightListActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Kevin on 11/9/2016.
 * service for interacting with XapixService API
 *
 */

public class XapixService {
    public static final String url = "https://xap.ix-io.net/api/v1/airberlin_lab_2016/";
    public static final String auth = "ab16_mobi:8zk3jJZRodc2VSrK0qxg6awF6fXl4IeM";

   private String reqUrlDFWtoPMI = "https://xap.ix-io.net/api/v1/airberlin_lab_2016/availabilities?filter%5Bdeparture%5D=dfw&filter%5Bdestination%5D=pmi&fields%5Bavailabilities%5D=next_outbound_flight_date%2Cprevious_outbound_flight_date%2Crandom_id%2Cdeparture%2Cdestination&include=combinations&sort=random_id&page%5Bnumber%5D=1&page%5Bsize%5D=100";

    ArrayList<FlightModel> fmList = new ArrayList<>();

    // comibnation numbera9a2f126-881c-4cd0-b5e0-7aa874976f15

    Context context;
    OkHttpClient client;

    public XapixService(Context context) {
        client = new OkHttpClient();
        this.context = context;
    }

    public ArrayList<FlightModel> getFlights(){

        Request request = new Request.Builder()
                .url(reqUrlDFWtoPMI)
                .addHeader("Accept","application/json")
                .addHeader("Authorization","ab16_mobi:8zk3jJZRodc2VSrK0qxg6awF6fXl4IeM")
                .build();

        Log.d("logigng req",request.header("Accept"));
        Log.d("logigng req",request.header("Authorization"));

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    ArrayList<FlightModel> fList = cleanFlightInfo(response.body());
                    for(FlightModel fm:fmList){
                        Log.d("Printing flight data",fm.toString());
                    }
                    Intent intent = new Intent(context,FlightListActivity.class);
                    intent.putExtra("flightData",fList);
                    context.startActivity(intent);

                }
                response.close();
            }
        });



        return null;
    }

    public ArrayList<FlightModel> cleanFlightInfo(ResponseBody resp){
        try{
            //Log.d("response",resp.string());
            JSONObject obj = new JSONObject(resp.string());
            JSONArray combinations = obj.getJSONArray("combinations");

            // loop through first 3 combinations
            for(int i = 0; i < 3 ; i++) {
                JSONObject arOne = combinations.getJSONObject(i);
                String internalFlightNum = arOne.getString("combinations_sub_structure_id");
                JSONObject onwardFlightInfor = arOne.getJSONObject("onward_flight_info");
                JSONObject passengerPricing = onwardFlightInfor.getJSONObject("passenger_pricing");
                JSONObject pricing = passengerPricing.getJSONObject("pricing");
                JSONArray fareDetail = pricing.getJSONArray("fare_detail");

                JSONObject fareDetailOne = fareDetail.getJSONObject(0);
                double fuelPrice = fareDetailOne.getDouble("@amount");

                JSONObject fareDetailTwo = fareDetail.getJSONObject(1);
                double netPrice = fareDetailTwo.getDouble("@amount");

                JSONObject fareDetailThree = fareDetail.getJSONObject(2);
                double taxPrice = fareDetailThree.getDouble("@amount");

                JSONArray segment_info = passengerPricing.getJSONArray("segment_infos");
                JSONObject temp = segment_info.getJSONObject(0);
                String flightNumber = temp.getString("@fare_base_code");
                String seatType = temp.getString("@fare_family");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String stringDate = temp.getString("@flight_date");
                Date tempDate = sdf.parse(stringDate);
                Calendar date = Calendar.getInstance();
                date.setTime(tempDate);

                FlightModel fm = new FlightModel(flightNumber,
                        fuelPrice,
                        netPrice,
                        taxPrice,
                        "DFW",
                        "PMI",
                        seatType,
                        "BOEING 747",
                        date,
                        date,
                        internalFlightNum);
                fmList.add(fm);
            }
        }catch(Exception e){
            e.printStackTrace();
            Log.d("error clean",e.getMessage());
        }

        return fmList;
    }



}
