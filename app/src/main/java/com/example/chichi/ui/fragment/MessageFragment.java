package com.example.chichi.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chichi.R;
import com.example.chichi.data.Message;
import com.example.chichi.other.JsonParser;
import com.example.chichi.ui.activity.MessageDetailActivity;
import com.example.chichi.ui.adapter.MessageAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

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

        String jsonString = JsonParser.getJsonString(getContext(), "Message.json");
        ArrayList<Message> messages = jsonParsing(jsonString);

        for (Message message : messages) adapter.addItem(message);

        adapter.setOnItemClickListener(new OnMessageClickListener() {
            @Override
            public void onItemClick(MessageAdapter.ViewHolder holder, View view, int position) {
                Message item = adapter.getItem(position);
                Intent intent = new Intent(getContext(), MessageDetailActivity.class);

                intent.putExtra("phone", item.getPhone());
                intent.putExtra("content", item.getContent());
                intent.putExtra("time", item.getDateTime());

                startActivity(intent);
            }
        });
        return adapter;
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

                Message message = new Message(content, phone, LocalDateTime.parse(time));
                messages.add(message);
            }
            return messages;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
