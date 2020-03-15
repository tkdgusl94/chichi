package com.example.chichi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_message, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        MessageAdapter adapter = new MessageAdapter();

        adapter.addItem(new Message("사람1", "010-5188-2978"));
        adapter.addItem(new Message("사람1", "010-5188-2978"));
        adapter.addItem(new Message("사람1", "010-5188-2978"));
        adapter.addItem(new Message("사람1", "010-5188-2978"));

        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
