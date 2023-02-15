package com.sincred.assembly.utils;

import com.google.common.base.Strings;
import com.sincred.assembly.exceptions.ErrorOnProcessingRequestException;
import com.sincred.assembly.response.common.StatusCodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    private static final Logger LOGGER = LogManager.getLogger(DateUtil.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static LocalDateTime stringForLocalDateTime(String date) {
        if (Strings.isNullOrEmpty(date)) {
            return formatDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        }
        try {
            return formatDate(date);
        } catch (DateTimeParseException e) {
            LOGGER.error(e);
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Util.InvalidDate);
        }
    }

    public static boolean compareDateAndHourBigger(LocalDateTime date) {
        long minutes = date.until(LocalDateTime.now(), ChronoUnit.MINUTES);
        return minutes > 0;
    }

    public static boolean compareDateAndHourSmallerEquals(LocalDateTime date) {
        long minutes = date.until(LocalDateTime.now(), ChronoUnit.MINUTES);
        return minutes >= 0;
    }

    private static LocalDateTime formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDateTime.parse(date, formatter);
    }
}
