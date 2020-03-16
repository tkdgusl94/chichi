package com.example.chichi.support;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonParser {

    public static String getJsonString(Context context, String fileName) {
        String json = "";
        try {
            InputStream is = context.getResources().getAssets().open(fileName);
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
}
