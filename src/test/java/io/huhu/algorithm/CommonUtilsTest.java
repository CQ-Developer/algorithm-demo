package io.huhu.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonUtilsTest {

    @Test
    void sequence_az() {
        char[] az = CommonUtils.sequence_az();
        for (char c = 'a', i = 0; c <= 'z'; c++) {
            assertEquals(c, az[i++]);
        }
    }

    @Test
    void sequenceAZ() {
        char[] az = CommonUtils.sequenceAZ();
        for (char c = 'A', i = 0; c <= 'Z'; c++) {
            assertEquals(c, az[i++]);
        }
    }

    @Test
    void sequence09() {
        int[] ints = CommonUtils.sequence09();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, ints[i]);
        }
    }

    @Test
    void recursionFactorial() {
        int expect = 1;
        for (int i = 2; i <= 10; i++) {
            expect *= i;
        }
        assertEquals(expect, CommonUtils.recursionFactorial(10));
    }

    @Test
    void recursionSum() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(15, CommonUtils.recursionSum(arr));
    }

    @Test
    void recursionCount() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(5, CommonUtils.recursionCount(arr));
    }

    @Test
    void recursionFindMax() {
        int[] arr = {32, 10, 44, 21, 5};
        assertEquals(2, CommonUtils.recursionFindMax(arr));
    }

}
