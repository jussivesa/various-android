package co.vesa.materialdesignappwithimplicitintends;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jussivesa on 18/10/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private JSONArray mCourses;
    private Context mContext;

    public MainAdapter(JSONArray courses, Context context) {
        this.mCourses = courses;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mCourses.length();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        try {
            JSONObject jsonObject = mCourses.getJSONObject(position);
            // images are in ptm.fi web server
            Glide.with(mContext).load("http://ptm.fi/jamk/android/golfcourses/"+jsonObject.getString("image")).into(viewHolder.cardImageView);
            viewHolder.cardNameTextView.setText(jsonObject.getString("course"));
            viewHolder.cardAddressTextView.setText(jsonObject.getString("address"));
            viewHolder.cardPhoneTextView.setText(jsonObject.getString("phone"));
            viewHolder.cardEmailTextView.setText(jsonObject.getString("email"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImageView;
        public TextView cardNameTextView;
        public TextView cardAddressTextView;
        public TextView cardPhoneTextView;
        public TextView cardEmailTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardImageView = (ImageView) itemView.findViewById(R.id.cardImageView);
            cardNameTextView = (TextView) itemView.findViewById(R.id.cardNameTextView);
            cardAddressTextView = (TextView) itemView.findViewById(R.id.cardAddressTextView);
            cardPhoneTextView = (TextView) itemView.findViewById(R.id.cardPhoneTextView);
            cardEmailTextView = (TextView) itemView.findViewById(R.id.cardEmailTextView);
            // item click handler
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    try {
                        JSONObject jsonObject = mCourses.getJSONObject(position);
                        // open DetailActivity
                        Intent intent = new Intent(mContext,DetailActivity.class);
                        intent.putExtra("course", jsonObject.toString());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}