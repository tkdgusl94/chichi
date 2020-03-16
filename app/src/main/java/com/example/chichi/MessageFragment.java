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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
            String jsonString = getJsonString();
            ArrayList<Message> messages = jsonParsing(jsonString);

            for (Message message : messages) {
                adapter.addItem(message);
            }
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

    private String getJsonString() {
        String json = "";
        try {
            InputStream is = getResources().getAssets().open("Message.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return json;
    }

    private ArrayList<Message> jsonParsing(String json) {
        try {
            ArrayList<Message> messages = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(json);

            JSONArray messageArray = jsonObject.getJSONArray("messages");

            for (int i = 0; i < messageArray.length(); i++) {
                JSONObject messageObject = messageArray.getJSONObject(i);

                String phone = messageObject.getString("phone");
                String content = messageObject.getString("content");
                String time = messageObject.getString("time");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    Message message = new Message(content, phone, LocalDateTime.parse(time));
                    messages.add(message);
                }
            }
            return messages;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
