package com.example.chichi;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Builder;
import lombok.Getter;

public class Message {
    private String content;
    private String phone;
    private LocalDateTime time;

    public Message(String content, String phone, LocalDateTime time) {
        this.content = content;
        this.phone = phone;
        this.time = time;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDateTime() {
        return time.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTime() {
        if (LocalDate.now().isEqual(time.toLocalDate())) {
            return time.format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        return time.format(DateTimeFormatter.ofPattern("MM월 dd일"));
    }

    public String getContent(){
        return content;
    }

    public String getPhone(){
        return phone;
    }
}
