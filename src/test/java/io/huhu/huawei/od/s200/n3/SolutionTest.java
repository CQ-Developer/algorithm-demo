package io.huhu.huawei.od.s200.n3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class SolutionTest {

    @Test
    void test1() {
        int len = 7;
        int[] numbers = {1, 2, 2, 7, 3, 6, 1};
        int n = 3;
        Assertions.assertEquals(10, Solution.dfs(numbers, n, 0, len - 1, 0, new HashMap<>()));
    }

    @Test
    void test2() {
        int len = 3;
        int[] numbers = {1, 2, 3};
        int n = 3;
        Assertions.assertEquals(6, Solution.dfs(numbers, n, 0, len - 1, 0, new HashMap<>()));
    }

    @Test
    void test3() {
        int len = 4;
        int[] numbers = {4, 2, 2, 3};
        int n = 2;
        Assertions.assertEquals(7, Solution.dfs(numbers, n, 0, len - 1, 0, new HashMap<>()));
    }

    @Test
    void test4() {
        Random random = new Random(System.currentTimeMillis());
        int[] numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, 1000);
        }
        System.out.println(Arrays.toString(numbers));
        int n = 300;
        Solution.dfs(numbers, n, 0, numbers.length - 1, 0, new HashMap<>());
    }

}
