package mobi.airberlin.flightlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobi.airberlin.FlightModel;
import mobi.airberlin.R;

/**
 * Created by HeyImRige on 11/10/2016.
 */

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightListHolder> {
    private FlightModel[] myFlightData;

    public static class FlightListHolder extends RecyclerView.ViewHolder {
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
        }

        //TODO:potentially add setter function here
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FlightListAdapter(FlightModel[] myFlightData)
    {
        this.myFlightData = myFlightData;
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

        //TODO:potentially add setters to the holder class
        //TODO:actually set data based on the class given to me
        holder.pointATextView.setText(myFlightData[position].getDestinationA());
        holder.pointBTextView.setText(myFlightData[position].getDestingationB());
        holder.flightDepartureTimeView.setText(myFlightData[position].getFlightTime().toString());
        holder.flightDepartureDateView.setText(myFlightData[position].getFlightDate().toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myFlightData.length;
    }

}
