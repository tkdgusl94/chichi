package com.example.chichi;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDateTime;
import java.util.Date;

public class MessageFragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_message, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        MessageAdapter adapter = new MessageAdapter();

        adapter.addItem(new Message("hello", "010-5188-2978", LocalDateTime.now()));
        adapter.addItem(new Message("hello", "010-5188-2978", LocalDateTime.of(2020, 02, 22, 03, 20, 10)));
        adapter.addItem(new Message("hi", "010-5188-2978", LocalDateTime.of(2020, 02, 22, 03, 20, 10)));
        adapter.addItem(new Message("nicddsdfjkajsdlfjalkdsjflkajdlf jsdlf jalkdsjkfl ajsdlf kalsde to meet you", "010-5188-2978", LocalDateTime.of(2020, 02, 22, 03, 20, 10)));

        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
