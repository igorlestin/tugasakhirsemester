package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.MainActivity;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.R;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private MainActivity mainActivity;
    public List<User> users = new ArrayList<>();
    public final LayoutInflater mInflater;
    private UserAdapter.OnItemClickListener listener;

    public UserAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.profile_layout, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.textViewName.setText(currentUser.getName());
//        holder.textViewAge.setText(currentUser.getAge());
//        holder.textViewWeight.setText(String.valueOf(currentUser.getWeight()));
//        holder.textViewHeight.setText(String.valueOf(currentUser.getWeight()));
    }

    public void setUsers(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    public User getUserAt(int position) {
        return users.get(position);
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        else return 0;
    }


    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private EditText textViewAge;
        private EditText textViewWeight;
        private EditText textViewHeight;

        public UserViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.profile_name);
            textViewAge = itemView.findViewById(R.id.age);
            textViewWeight = itemView.findViewById(R.id.weight);
            textViewHeight = itemView.findViewById(R.id.height);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(users.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
    }
    public void setOnItemClickListener(UserAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
}
