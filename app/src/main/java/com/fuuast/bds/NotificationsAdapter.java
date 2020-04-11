package com.fuuast.bds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fuuast.bds.Models.NotificationModel;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {
    List<NotificationModel> notifications;
    Context context;
    OnNotificationListener onNotificationListener;
    public NotificationsAdapter(Context c, List<NotificationModel> n,OnNotificationListener onNotificationListener) {
        notifications = n;
        context = c;
        this.onNotificationListener=onNotificationListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_notification, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view,onNotificationListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.notificationBody.setText(notifications.get(position).getBody());
        holder.notificationTitle.setText(notifications.get(position).getTitle());
        holder.notificationTime.setText(notifications.get(position).getTime());
        //holder.notificationThumb.setImageDrawable(R.drawable.ic_home);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView notificationCard;
        ImageView notificationThumb;
        TextView notificationTitle;
        TextView notificationBody;
        TextView notificationTime;
        OnNotificationListener onNotificationListener;
        public MyViewHolder(@NonNull View itemView,OnNotificationListener onNotificationListener) {
            super(itemView);
            notificationCard = itemView.findViewById(R.id.notification_card);
            notificationThumb = itemView.findViewById(R.id.notification_thumb);
            notificationTitle = itemView.findViewById(R.id.notification_title);
            notificationBody = itemView.findViewById(R.id.notification_body);
            notificationTime = itemView.findViewById(R.id.notification_time);

            itemView.setOnClickListener(this);
            this.onNotificationListener=onNotificationListener;
        }

        @Override
        public void onClick(View v) {
            this.onNotificationListener.onHistoryClick(getAdapterPosition());
        }
    }
    public interface OnNotificationListener{
        void onHistoryClick(int position);
    }
}
