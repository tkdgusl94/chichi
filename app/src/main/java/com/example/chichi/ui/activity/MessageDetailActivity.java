package com.example.chichi.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chichi.R;

public class MessageDetailActivity extends AppCompatActivity {

    TextView phoneText;
    TextView timeText;
    TextView contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

        phoneText = findViewById(R.id.phoneText);
        timeText = findViewById(R.id.timeText);
        contentText = findViewById(R.id.contentText);

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String phone = intent.getExtras().get("phone").toString();
            String time = intent.getExtras().get("time").toString();
            String content = intent.getExtras().get("content").toString();

            phoneText.setText(phone);
            timeText.setText(time);
            contentText.setText(content);

        }
    }
}
