package com.platform.papafood.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateTimeUtils {
    private DateTimeUtils() {
    }

    public static Date fromLocalDateTime(LocalDateTime source) {
        return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date fromLocalDate(LocalDate source) {
        return fromLocalDateTime(source.atStartOfDay());
    }

    public static Date nowInUTC() {
        return fromLocalDateTime(LocalDateTime.now(ZoneOffset.UTC));
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static LocalDateTime fromDate(Date utcDate) {
        return utcDate.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public static LocalDate fromDateWithoutTime(Date utcDate) {
        return utcDate.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
    }

    public static LocalDateTime startDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.of(0, 0, 0));
    }

    public static LocalDateTime startDate(LocalDateTime date) {
        return LocalDateTime.of(date.toLocalDate(), LocalTime.of(0, 0, 0));
    }

    public static LocalDateTime endDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.of(23, 59, 59));
    }

    public static LocalDateTime endDate(LocalDateTime date) {
        return LocalDateTime.of(date.toLocalDate(), LocalTime.of(23, 59, 59));
    }

    private static final DateTimeFormatter EXPORT_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter EXPORT_FORMAT_TIME = DateTimeFormatter.ofPattern("dd/MM/yyyyHHmmss");

    public static String formatDate(LocalDateTime utcDateTime) {
        LocalDateTime localDate = utcDateTime.atZone(ZoneOffset.UTC).withZoneSameInstant(ZoneId.of("Asia/Jakarta"))
                .toLocalDateTime();
        return EXPORT_FORMAT.format(localDate);
    }

    public static String formatDateTime(LocalDateTime utcDateTime) {
        LocalDateTime localDate = utcDateTime.atZone(ZoneOffset.UTC).withZoneSameInstant(ZoneId.of("Asia/Jakarta"))
                .toLocalDateTime();
        return EXPORT_FORMAT_TIME.format(localDate);
    }
}
