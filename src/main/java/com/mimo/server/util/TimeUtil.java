package com.mimo.server.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    private static final int MINUTE_STANDARD = 60;
    private static final int HOUR_STANDARD = 60;
    private static final int DAY_STANDARD = 24;
    private static final int MONTH_STANDARD = 30;

    public static String calculateTimeDifference(String uploadTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime uploadTime = LocalDateTime.parse(uploadTimeStr, formatter);
        ZonedDateTime uploadZonedDateTime = ZonedDateTime.of(uploadTime, ZoneId.of("Asia/Seoul"));
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        Duration duration = Duration.between(uploadZonedDateTime, currentZonedDateTime);
        return printTimeDiff(duration.getSeconds());
    }

    private static String printTimeDiff(Long diff) {
        if (diff < MINUTE_STANDARD) {
            return diff + "초 전";
        } else if (diff < MINUTE_STANDARD * HOUR_STANDARD) {
            long minutes = diff / MINUTE_STANDARD;
            return minutes + "분 전";
        } else if (diff < MINUTE_STANDARD * HOUR_STANDARD * DAY_STANDARD) {
            long hours = diff / (MINUTE_STANDARD * HOUR_STANDARD);
            return hours + "시간 전";
        } else if (diff < MINUTE_STANDARD * HOUR_STANDARD * DAY_STANDARD * MONTH_STANDARD) {
            long days = diff / (MINUTE_STANDARD * HOUR_STANDARD * DAY_STANDARD);
            return days + "일 전";
        } else {
            long months = diff / (MINUTE_STANDARD * HOUR_STANDARD * DAY_STANDARD * MONTH_STANDARD);
            return months + "개월 전";
        }
    }
}
