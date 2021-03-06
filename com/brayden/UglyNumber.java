package com.brayden;

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1)
            return false;
        for (; num % 2 == 0; num /= 2);
        for (; num % 3 == 0; num /= 3);
        for (; num % 5 == 0; num /= 5);
        return num == 1;
    }
}
