package com.example.chichi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = "SMS Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if (messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();
            String contents = messages[0].getMessageBody();
            Date receiveDate = new Date(messages[0].getTimestampMillis());

            Log.i(TAG, sender);
            Log.i(TAG, contents);
            Log.i(TAG, receiveDate.toString());

            //sendToActivity(context, sender, contents, receiveDate);
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        int smsCount = objs.length;

        SmsMessage[] messages = new SmsMessage[smsCount];

        String format = bundle.getString("format");
        messages[0] = SmsMessage.createFromPdu((byte[]) objs[0], format);

        return messages;
    }

//    // 메시지 받으면 MainActivity로 전달
//    private void sendToActivity(Context context, String sender, String contents, Date receiveDate) {
//        Intent intent = new Intent(context, MainActivity.class);
//
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
//                | Intent.FLAG_ACTIVITY_SINGLE_TOP
//                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        intent.putExtra("sender", sender);
//        intent.putExtra("contents", contents);
//        intent.putExtra("receiveDate", receiveDate);
//
//        context.startActivity(intent);
//    }
}
