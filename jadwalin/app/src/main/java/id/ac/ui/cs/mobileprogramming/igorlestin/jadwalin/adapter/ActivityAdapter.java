package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.R;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Activity;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityEnergyViewHolder> {

    public final LayoutInflater mInflater;
    public List<Activity> mLog = new ArrayList<>(); // Cached copy of Log
    private OnItemClickListener listener;

    public ActivityAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public ActivityEnergyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.log_item, parent, false);
        return new ActivityEnergyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityEnergyViewHolder holder, int position) {
            Activity current = mLog.get(position);
            holder.textViewAmount.setText(String.valueOf(current.getAct()));
            holder.textViewDate.setText(current.getDate());
            holder.textViewTime.setText(current.getTime());
    }

    public void setLogs(List<Activity> logs){
        this.mLog = logs;
        notifyDataSetChanged();
    }

    public Activity getLogAt(int position) {
        return mLog.get(position);
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mLog != null)
            return mLog.size();
        else return 0;
    }

    class ActivityEnergyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewAmount;
        private TextView textViewDate;
        private TextView textViewTime;
        private TextView textViewProgress;

        public ActivityEnergyViewHolder(View itemView) {
            super(itemView);
            textViewAmount = itemView.findViewById(R.id.water_drunk);
            textViewDate = itemView.findViewById(R.id.date);
            textViewTime = itemView.findViewById(R.id.time);
            textViewProgress = itemView.findViewById(R.id.progress_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(mLog.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Activity activity);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}