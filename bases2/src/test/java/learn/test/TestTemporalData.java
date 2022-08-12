package learn.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Time;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TestTemporalData {

    @Test
    void testDate() {
        // Java 1.0 : java.util.Date
        Date d = new Date();
        System.out.println(d); // Fri Aug 12 15:40:16 CEST 2022
        // drawback: type à tout faire
    }

    @Test
    void testCalendar() {
        // Java 1.1 : Calendar/GregorianCalendar
        Calendar d = Calendar.getInstance();
        System.out.println(d);
        // ava.util.GregorianCalendar[
        // time=1660311868464,
        // areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Europe/Paris",offset=3600000,dstSavings=3600000,useDaylight=true,transitions=184,lastRule=java.util.SimpleTimeZone[id=Europe/Paris,offset=3600000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=2,startMonth=2,startDay=-1,startDayOfWeek=1,startTime=3600000,startTimeMode=2,endMode=2,endMonth=9,endDay=-1,endDayOfWeek=1,endTime=3600000,endTimeMode=2]],firstDayOfWeek=2,minimalDaysInFirstWeek=4,
        // ERA=1,YEAR=2022,MONTH=7,
        // WEEK_OF_YEAR=32,WEEK_OF_MONTH=2,
        // DAY_OF_MONTH=12,
        // DAY_OF_YEAR=224,
        // DAY_OF_WEEK=6,
        // DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=44,SECOND=28,MILLISECOND=464,ZONE_OFFSET=3600000,DST_OFFSET=3600000]

        // drawback: type à tout faire
    }

    @Test
    void testModernTypesIntro() {
        // Java 8 (2014): package java.time
        LocalDate d; // Year, Month, Day
        LocalDateTime dt; // Year, Month, Day, Hour, Minute, Second, ...
        Time t; // Hour, Minute, Second, ...
        Duration duration; // ecart
    }

    @Test
    void testLocalDate() {
        LocalDate d = LocalDate.now();
        System.out.println("Now: " + d); // 2022-08-12
        d = LocalDate.of(2020, 2, 29);
        System.out.println("2020 année bissextile : " + d);
        System.out.println("year: " + d.getYear());
        System.out.println("month: " + d.getMonth());
        System.out.println("day month: " + d.getDayOfMonth());
        System.out.println("day week: " + d.getDayOfWeek());
        System.out.println("day year: " + d.getDayOfYear());
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 2020, 2024, 2400})
    void testLocalDateFebruary29OK(int year) {
        var d = LocalDate.of(year, 2, 29);
        System.out.println(d);
    }

    @ParameterizedTest
    @ValueSource(ints = {2022, 2100})
    void testLocalDateFebruary29Nok(int year) {
        assertThrows(DateTimeException.class,
                () -> LocalDate.of(year, 2, 29));
    }

    @Test
    void testLocalDateTime() {
        var d1 = LocalDateTime.now(); // Locale du user
        System.out.println(d1); // 2022-08-12T16:07:45.490867500
        var d2 = LocalDateTime.of(2022, 8, 13, 1, 24);
        System.out.println(d2);
    }

    @Test
    void testZonedDateTime() {
        var d2 = LocalDateTime.of(2022, 8, 13, 1, 24)
            .atZone(ZoneId.of("Asia/Manila"));
        System.out.println(d2); // 2022-08-13T01:24+08:00[Asia/Manila]
        var d3 = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(d3); // 2022-08-12T07:20:06.717113400
    }



}