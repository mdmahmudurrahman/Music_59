package com.example.dung.music_59.utils;

import java.text.SimpleDateFormat;

public class TimeUtils {
    public static String timeFormat(int time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        return dateFormat.format(time);
    }
}
