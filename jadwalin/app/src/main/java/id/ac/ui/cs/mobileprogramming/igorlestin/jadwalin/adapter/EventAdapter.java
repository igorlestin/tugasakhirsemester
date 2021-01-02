package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.R;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    Context context;
    public List<Event> allReminders;
    private EventAdapter.OnItemClickListener listener;

    public EventAdapter(Context context, List<Event> allReminders) {
        this.context = context;
        this.allReminders = allReminders;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.message.setText(allReminders.get(position).getMessage());
        holder.time.setText(allReminders.get(position).getRemindDate() + " " + allReminders.get(position).getRemindTime());
    }

    @Override
    public int getItemCount() {
        return allReminders.size();
    }

    public Event getEventAt(int position) {
        return allReminders.get(position);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        private TextView message, time;
        private LinearLayout toplayout;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.messageTextView);
            time = (TextView) itemView.findViewById(R.id.reminderTextView);
            toplayout = (LinearLayout) itemView.findViewById(R.id.toplayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(allReminders.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Event waterConsumption);
    }
    public void setOnItemClickListener(EventAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
}
