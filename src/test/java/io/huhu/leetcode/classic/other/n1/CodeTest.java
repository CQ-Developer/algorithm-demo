package io.huhu.leetcode.classic.other.n1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CodeTest {

    static Code expect;
    static Code actual;

    @BeforeAll
    static void setupAll() {
        expect = new DFS();
        actual = new DP();
    }

    @Test
    void test() {
        Random rnd = new Random(System.currentTimeMillis());
        int len = 15, rd = 30;
        for (int i = 0; i < rd; i++) {
            int[] nums = new int[rnd.nextInt(1, len)];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = rnd.nextInt(0, 100);
            }
            int a = expect.maxSum(nums);
            int b = actual.maxSum(nums);
            Assertions.assertEquals(a, b, Arrays.toString(nums));
        }
    }

}