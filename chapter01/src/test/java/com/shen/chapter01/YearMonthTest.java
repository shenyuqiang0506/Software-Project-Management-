package com.shen.chapter01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class YearMonthTest {

    @ParameterizedTest
    @CsvSource({
        "2000, true",
        "2004, true",
        "1900, false",
        "2023, false"
    })
    public void testIsLeapYear(int year, boolean expected) {
        assertTrue(YearMonth.isLeapYear(year) == expected);
    }

    @ParameterizedTest
    @CsvSource({
        "2023, 1, 31",
        "2023, 2, 28",
        "2024, 2, 29",
        "2023, 4, 30",
        "2023, 12, 31"
    })
    public void testGetDaysInMonth(int year, int month, int expected) {
        assertEquals(expected, YearMonth.getDaysInMonth(year, month));
    }
}
