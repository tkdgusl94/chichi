package com.example.chichi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.LocalDateTime;

public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_message, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MessageAdapter adapter = initAdapter();
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private MessageAdapter initAdapter() {
        final MessageAdapter adapter = new MessageAdapter();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            adapter.addItem(new Message("hello", "010-5188-2978", LocalDateTime.now()));
            adapter.addItem(new Message("hello", "010-5188-2978", LocalDateTime.of(2020, 2, 22, 3, 20, 10)));
            adapter.addItem(new Message("hi", "010-5188-2978", LocalDateTime.of(2020, 2, 22, 3, 20, 10)));
            adapter.addItem(new Message("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세", "010-5188-2978", LocalDateTime.of(2020, 2, 22, 3, 20, 10)));
        }

        adapter.setOnItemClickListener(new OnMessageClickListener() {
            @Override
            public void onItemClick(MessageAdapter.ViewHolder holder, View view, int position) {
                Message item = adapter.getItem(position);
                Intent intent = new Intent(getContext(), MessageDetailActivity.class);

                intent.putExtra("phone", item.getPhone());
                intent.putExtra("content", item.getContent());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    intent.putExtra("time", item.getDateTime());
                }
                startActivity(intent);
            }
        });
        return adapter;
    }
}
