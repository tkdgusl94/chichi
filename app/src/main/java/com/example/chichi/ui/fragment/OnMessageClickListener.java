package com.example.chichi.ui.fragment;

import android.view.View;

import com.example.chichi.ui.adapter.MessageAdapter;

public interface OnMessageClickListener {
    public void onItemClick(MessageAdapter.ViewHolder holder, View view, int position);
}
