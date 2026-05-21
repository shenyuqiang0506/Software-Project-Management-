package com.shen.chapter01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("FizzBuzzWhizz")
class FizzBuzzTest {

    @Test
    @DisplayName("构造方法属性正确")
    void shouldCreateFizzBuzzWithNumber() {
        assertEquals(1, new FizzBuzz(1).getNumber());
    }

    static Stream<Arguments> allCases() {
        return Stream.of(
            // 数字本身
            arguments(1, "1"),
            arguments(2, "2"),
            arguments(4, "4"),
            arguments(8, "8"),
            arguments(11, "11"),
            arguments(16, "16"),
            arguments(22, "22"),
            // Fizz: 3的倍数或包含3
            arguments(3, "Fizz"),
            arguments(6, "Fizz"),
            arguments(9, "Fizz"),
            arguments(12, "Fizz"),
            arguments(13, "Fizz"),
            arguments(23, "Fizz"),
            arguments(31, "Fizz"),
            arguments(32, "Fizz"),
            arguments(43, "Fizz"),
            // Buzz: 5的倍数或包含5
            arguments(5, "Buzz"),
            arguments(10, "Buzz"),
            arguments(20, "Buzz"),
            arguments(25, "Buzz"),
            arguments(52, "Buzz"),
            arguments(56, "BuzzWhizz"),
            arguments(65, "Buzz"),
            arguments(85, "Buzz"),
            // Whizz: 7的倍数或包含7
            arguments(7, "Whizz"),
            arguments(14, "Whizz"),
            arguments(28, "Whizz"),
            arguments(49, "Whizz"),
            arguments(71, "Whizz"),
            arguments(72, "FizzWhizz"),
            arguments(77, "Whizz"),
            arguments(98, "Whizz"),
            // FizzBuzz: 3和5
            arguments(15, "FizzBuzz"),
            arguments(30, "FizzBuzz"),
            arguments(45, "FizzBuzz"),
            arguments(53, "FizzBuzz"),
            arguments(60, "FizzBuzz"),
            arguments(90, "FizzBuzz"),
            // FizzWhizz: 3和7
            arguments(21, "FizzWhizz"),
            arguments(37, "FizzWhizz"),
            arguments(42, "FizzWhizz"),
            arguments(63, "FizzWhizz"),
            arguments(73, "FizzWhizz"),
            arguments(84, "FizzWhizz"),
            // BuzzWhizz: 5和7
            arguments(70, "BuzzWhizz"),
            arguments(175, "BuzzWhizz"),
            arguments(350, "FizzBuzzWhizz"),
            // FizzBuzzWhizz: 3、5和7
            arguments(35, "FizzBuzzWhizz"),
            arguments(75, "FizzBuzzWhizz"),
            arguments(105, "FizzBuzzWhizz"),
            arguments(210, "FizzBuzzWhizz"),
            arguments(57, "FizzBuzzWhizz"),
            arguments(375, "FizzBuzzWhizz"),
            arguments(537, "FizzBuzzWhizz"),
            arguments(735, "FizzBuzzWhizz"),
            // 超出1-100范围
            arguments(0, "FizzBuzzWhizz"),
            arguments(-3, "Fizz"),
            arguments(-5, "Buzz"),
            arguments(-7, "Whizz"),
            arguments(-15, "FizzBuzz"),
            arguments(-21, "FizzWhizz"),
            arguments(-35, "FizzBuzzWhizz"),
            arguments(-105, "FizzBuzzWhizz"),
            arguments(101, "101"),
            arguments(102, "Fizz"),
            arguments(110, "Buzz"),
            arguments(120, "FizzBuzz"),
            arguments(200, "Buzz"),
            arguments(300, "FizzBuzz"),
            arguments(333, "Fizz"),
            arguments(555, "FizzBuzz"),
            arguments(777, "FizzWhizz"),
            arguments(1001, "Whizz")
        );
    }

    @ParameterizedTest(name = "play({0}) = {1}")
    @MethodSource("allCases")
    @DisplayName("完整规则验证")
    void shouldReturnExpectedResult(int number, String expected) {
        String actual = new FizzBuzz(number).play();
        assertEquals(expected, actual,
            "number=" + number + " expected=" + expected + " actual=" + actual);
    }
}
