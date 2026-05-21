package com.shen.chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("YearMonth")
class YearMonthTest {

    @Nested
    @DisplayName("构造方法")
    class ConstructorTest {

        @Test
        @DisplayName("Given 有效的年月 When 创建YearMonth Then 年月属性正确")
        void shouldCreateYearMonthWithValidValues() {
            // given
            int year = 2024;
            int month = 6;

            // when
            YearMonth ym = new YearMonth(year, month);

            // then
            assertEquals(2024, ym.getYear());
            assertEquals(6, ym.getMonth());
        }

        @Test
        @DisplayName("Given 无效月份0 When 创建YearMonth Then 抛出异常")
        void shouldThrowExceptionWhenMonthIsZero() {
            // given
            int year = 2024;
            int month = 0;

            // when & then
            assertThrows(IllegalArgumentException.class, () -> new YearMonth(year, month));
        }

        @Test
        @DisplayName("Given 无效月份13 When 创建YearMonth Then 抛出异常")
        void shouldThrowExceptionWhenMonthIsThirteen() {
            // given
            int year = 2024;
            int month = 13;

            // when & then
            assertThrows(IllegalArgumentException.class, () -> new YearMonth(year, month));
        }
    }

    @Nested
    @DisplayName("闰年判断")
    class IsLeapYearTest {

        @ParameterizedTest
        @CsvSource({
            "2000, true",
            "2004, true",
            "1900, false",
            "2023, false"
        })
        @DisplayName("Given 年份 When 判断闰年 Then 返回正确结果")
        void shouldDetermineLeapYear(int year, boolean expected) {
            // given
            YearMonth ym = new YearMonth(year, 1);

            // when
            boolean result = ym.isLeapYear();

            // then
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("获取每月天数")
    class GetDaysInMonthTest {

        @ParameterizedTest
        @CsvSource({
            "2023, 1, 31",
            "2023, 2, 28",
            "2024, 2, 29",
            "2023, 4, 30",
            "2023, 12, 31"
        })
        @DisplayName("Given 年月 When 获取天数 Then 返回正确天数")
        void shouldReturnCorrectDaysInMonth(int year, int month, int expected) {
            // given
            YearMonth ym = new YearMonth(year, month);

            // when
            int days = ym.getDaysInMonth();

            // then
            assertEquals(expected, days);
        }
    }
}
