package com.example.chichi.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class Message {
    private String content;
    private String phone;
    private LocalDateTime time;

    public Message(String content, String phone, LocalDateTime time) {
        this.content = content;
        this.phone = phone;
        this.time = time;
    }

    public String getDateTime() {
        return time.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    /**
     * DateTimeFormatter.ofPattern 함수를 쓰려면 최소 API 레벨이 26이다.
     * 만약 minSdkVersion을 낮게 유지하려면 다른 방법을 찾아야 한다.
     * 참고 : https://stackoverflow.com/questions/53781154/kotlin-android-java-string-datetime-format-api21
     */
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
