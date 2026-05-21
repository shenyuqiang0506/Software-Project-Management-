package com.shen.chapter01;

public class FizzBuzz {

    private final int number;

    public FizzBuzz(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String play() {
        String result = "";

        if (isFizz()) {
            result += "Fizz";
        }
        if (isBuzz()) {
            result += "Buzz";
        }
        if (isWhizz()) {
            result += "Whizz";
        }

        return result.isEmpty() ? String.valueOf(number) : result;
    }

    private boolean isFizz() {
        return number % 3 == 0 || String.valueOf(number).contains("3");
    }

    private boolean isBuzz() {
        return number % 5 == 0 || String.valueOf(number).contains("5");
    }

    private boolean isWhizz() {
        return number % 7 == 0 || String.valueOf(number).contains("7");
    }
}
