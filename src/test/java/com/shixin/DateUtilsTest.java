package com.shixin;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtilsTest {
    @Test
    public void test_addDays() {
        System.out.println(DateUtils.addDays(new Date(), 1));
        System.out.println(DateUtils.addDays(new Date(), -1));
    }

    @Test
    public void test_addMonths() {
        Date date = DateUtils.addMonths(new Date(), 1);
        System.out.println(date);
    }

    @Test
    public void test_addYears() {
        Date date = DateUtils.addYears(new Date(), 1);
        System.out.println(date);
    }

    @Test
    public void test_isSameDay() throws InterruptedException {
        Date date1 = new Date();
        TimeUnit.SECONDS.sleep(1);
        Date date2 = new Date();
        Assertions.assertTrue(DateUtils.isSameDay(date1, date2));
    }

    @Test
    public void test_truncate() {
        // 向过去的时间点舍入
        System.out.println(DateUtils.truncate(new Date(), Calendar.MINUTE));
        System.out.println(DateUtils.truncate(new Date(), Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test_celling() {
        // 向未来的时间点舍入
        Date date = new Date();
        System.out.println(DateUtils.ceiling(date, Calendar.DAY_OF_MONTH));
        System.out.println(DateUtils.ceiling(date, Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.ceiling(date, Calendar.MINUTE));
    }

    @Test
    public void test_round() {
        Date date = new Date();
        System.out.println(DateUtils.round(date, Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.round(date, Calendar.MINUTE));
        System.out.println(DateUtils.round(date, Calendar.SECOND));
    }

    @Test
    public void test_parseDate() throws ParseException {
        String[] patterns = new String[] {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd"};
        System.out.println(DateUtils.parseDate("2025-06-01 12:01:01", patterns));
        System.out.println(DateUtils.parseDate("2025-06-01", patterns));
        System.out.println(DateUtils.parseDate("2025/06/01", patterns));
    }
}
