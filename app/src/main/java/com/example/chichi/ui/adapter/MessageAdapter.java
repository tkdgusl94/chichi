package com.example.chichi.ui.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chichi.data.Message;
import com.example.chichi.ui.fragment.OnMessageClickListener;
import com.example.chichi.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> implements OnMessageClickListener {

    private ArrayList<Message> items = new ArrayList<>();
    private OnMessageClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 인플레이션을 통해 뷰 객체 만들기
        View itemView = inflater.inflate(R.layout.message_item, parent, false);

        return new ViewHolder(itemView, this);
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

    public Message getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnMessageClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contentText;
        private TextView phoneText;
        private TextView timeText;

        public ViewHolder(@NonNull View itemView, final OnMessageClickListener listener) {
            super(itemView);

            contentText = itemView.findViewById(R.id.contentText);
            phoneText = itemView.findViewById(R.id.phoneText);
            timeText = itemView.findViewById(R.id.timeText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        @RequiresApi(api = Build.VERSION_CODES.O)//
        public void setItem(Message item) {
            contentText.setText(item.getContent());
            phoneText.setText(item.getPhone());
            timeText.setText(item.getTime());
        }
    }

}