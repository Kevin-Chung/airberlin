package mobi.airberlin.flightlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobi.airberlin.R;

/**
 * Created by HeyImRige on 11/10/2016.
 */

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightListHolder> {
    private String[] mDataset;

    public static class FlightListHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public FlightListHolder(View v) {
            super(v);
            mTextView =(TextView) v.findViewById(R.id.flight_list_from);
        }

        //TODO:potentially add setter function here
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FlightListAdapter(String[] myDataset) {
        mDataset = myDataset;
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
        holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
