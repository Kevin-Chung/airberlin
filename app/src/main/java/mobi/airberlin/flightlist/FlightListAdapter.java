package mobi.airberlin.flightlist;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mobi.airberlin.FlightInformation;
import mobi.airberlin.FlightModel;
import mobi.airberlin.R;

/**
 * Created by HeyImRige on 11/10/2016.
 */

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightListHolder> {
    private ArrayList<FlightModel> myFlightData;

    public class FlightListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView pointATextView;
        public TextView pointBTextView;
        public TextView flightDepartureTimeView;
        public TextView flightDepartureDateView;
        public FlightListHolder(View v) {
            super(v);
            pointATextView =(TextView) v.findViewById(R.id.flight_list_from);
            pointBTextView=(TextView) v.findViewById(R.id.flight_list_to);
            flightDepartureDateView = (TextView) v.findViewById(R.id.flight_list_date);
            flightDepartureTimeView = (TextView) v.findViewById(R.id.flight_list_time);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v,"yo",Snackbar.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), FlightInformation.class);
            intent.putExtra("flightmodel",myFlightData.get(getLayoutPosition()));
            v.getContext().startActivity(intent);
        }

        //TODO:potentially add setter function here
    }

    // Create new views (invoked by the layout manager)
    @Override
    public  FlightListHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new FlightListHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FlightListAdapter.FlightListHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.pointATextView.setText(myFlightData.get(position).getDestinationA());
        holder.pointBTextView.setText(myFlightData.get(position).getDestingationB());
        //TODO: get date and time a better way
        Calendar cal = myFlightData.get(position).getFlightDate();
        Date date = cal.getTime();
        String hour = date.getHours()+"";
        String minute = date.getMinutes()+"";
        String day = date.getDay()+"";
        Log.d("day",day);
        holder.flightDepartureTimeView.setText(myFlightData.get(position).getFlightTime().getTime().toString());
        holder.flightDepartureDateView.setText(myFlightData.get(position).getFlightDate().getTime().toString());




    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myFlightData.size();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FlightListAdapter(ArrayList<FlightModel> myFlightData)
    {
        this.myFlightData = myFlightData;
    }

}
