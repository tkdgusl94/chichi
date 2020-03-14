package com.example.chichi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    ArrayList<Message> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 인플레이션을 통해 뷰 객체 만들기
        View itemView = inflater.inflate(R.layout.message_item, parent, false);

        return new ViewHolder(itemView);
    }

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

    public void setItems(ArrayList<Message> items) {
        this.items = items;
    }

    public Message getItem(int position) {
        return items.get(position);
    }

    public Message setItem(int position, Message item){
        return items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        TextView phoneText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.nameText);
            phoneText = itemView.findViewById(R.id.phoneText);
        }

        public void setItem(Message item) {
            nameText.setText(item.getName());
            phoneText.setText(item.getPhone());
        }
    }
}
