package mobi.airberlin;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kevin on 11/9/2016.
 * service for interacting with XapixService API
 *
 */

public class XapixService {
    public static final String url = "https://xap.ix-io.net/api/v1/airberlin_lab_2016/";
    public static final String auth = "ab16_mobi:8zk3jJZRodc2VSrK0qxg6awF6fXl4IeM";

   private String reqUrlDFWtoPMI = "https://xap.ix-io.net/api/v1/airberlin_lab_2016/availabilities?filter%5Bdeparture%5D=dfw&filter%5Bdestination%5D=pmi&fields%5Bavailabilities%5D=next_outbound_flight_date%2Cprevious_outbound_flight_date%2Crandom_id%2Cdeparture%2Cdestination&include=combinations&sort=random_id&page%5Bnumber%5D=1&page%5Bsize%5D=100";


    // comibnation numbera9a2f126-881c-4cd0-b5e0-7aa874976f15


    OkHttpClient client;

    public XapixService() {
        client = new OkHttpClient();
    }

    public String getFlights(){
        Request request = new Request.Builder()
                .url(reqUrlDFWtoPMI)
                .build();
        try{
            Response response = client.newCall(request).execute();

            cleanFlightInfo(response.toString());

            return response.toString();
        }catch(Exception e){
            Log.d("ERROR","ERROr in getflights");
        }


        return "it didn't work";
    }

    public String cleanFlightInfo(String resp){

        try{
            JSONObject obj = new JSONObject(resp);
            JSONArray = obj.getJSONArray("combinations");

        }catch(Exception e){

        }

        return "";
    }



}
