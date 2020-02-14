package com.fuuast.bds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fuuast.bds.Models.HistoryModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    List<HistoryModel> history;
    Context context;

    public HistoryAdapter(Context c, List<HistoryModel> n) {
        history = n;
        context = c;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_history, parent, false);
        HistoryAdapter.MyViewHolder viewHolder = new HistoryAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {

        holder.historyTitle.setText(history.get(position).getTitle());
        holder.historyDescription.setText(history.get(position).getDescription());
        holder.historyTime.setText(history.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView historyTitle;
        TextView historyDescription;
        TextView historyTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            historyTitle = itemView.findViewById(R.id.history_title);
            historyDescription = itemView.findViewById(R.id.history_description);
            historyTime = itemView.findViewById(R.id.history_time);
        }
    }
}
