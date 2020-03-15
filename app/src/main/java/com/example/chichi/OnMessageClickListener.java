package com.example.chichi;

import android.view.View;

public interface OnMessageClickListener {
    public void onItemClick(MessageAdapter.ViewHolder holder, View view, int position);
}
