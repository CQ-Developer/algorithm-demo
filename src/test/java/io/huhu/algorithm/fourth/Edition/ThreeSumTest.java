package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.function.Function;

class ThreeSumTest {

    int[] arr;
    static int[] ARR;
    static int EXPECTED;

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        ARR = CommonUtils.generateArray(5000);
        EXPECTED = ThreeSum.count(ARR);
    }

    @BeforeEach
    void beforeEach() {
        arr = ARR.clone();
    }

    @Test
    void countFast() {
        int actual = count(ThreeSum::countFast, "countFast");
        Assertions.assertEquals(EXPECTED, actual);
    }

    @Test
    void countFaster() {
        int actual = count(ThreeSum::countFaster, "countFaster");
        Assertions.assertEquals(EXPECTED, actual);
    }

    private int count(Function<int[], Integer> threeSum, String name) {
        long start = System.currentTimeMillis();
        int count = threeSum.apply(arr);
        System.out.printf("%s cost: %d%n", name, System.currentTimeMillis() - start);
        return count;
    }

}
