package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class TwoSumTest {

    int[] arr;
    static int[] ARRAY;
    static int EXPECTED;

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        ARRAY = CommonUtils.generateArray(100_0000);
        EXPECTED = TwoSum.count(ARRAY);
    }

    @BeforeEach
    void beforeEach() {
        arr = ARRAY.clone();
    }

    @Test
    void count() {
        long start = System.currentTimeMillis();
        int actual = TwoSum.count(arr);
        System.out.printf("cost %d%n", System.currentTimeMillis() - start);
        Assertions.assertEquals(EXPECTED, actual);
    }

    @Test
    void countFast() {
        long start = System.currentTimeMillis();
        int actual = TwoSum.countFast(arr);
        System.out.printf("cost %d%n", System.currentTimeMillis() - start);
        Assertions.assertEquals(EXPECTED, actual);
    }

}
