package com.example.chichi;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private ArrayList<Message> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 인플레이션을 통해 뷰 객체 만들기
        View itemView = inflater.inflate(R.layout.message_item, parent, false);

        return new ViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Message item) {
        items.add(item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView contentText;
        TextView phoneText;
        TextView timeText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contentText = itemView.findViewById(R.id.contentText);
            phoneText = itemView.findViewById(R.id.phoneText);
            timeText = itemView.findViewById(R.id.timeText);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void setItem(Message item) {
            contentText.setText(item.getContent());
            phoneText.setText(item.getPhone());
            timeText.setText(item.getTime());
        }
    }
}
