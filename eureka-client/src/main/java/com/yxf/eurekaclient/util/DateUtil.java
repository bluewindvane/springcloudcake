package com.yxf.eurekaclient.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 时间戳相减转秒
     *
     * @param max
     * @param min
     * @return
     */
    public static String getDifferenceTimeStamp(Long max, Long min) {
        String result = null;
        Long difference = max - min;
        result = String.valueOf(difference / 1000);
        return result;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return df.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime());
    }
}
