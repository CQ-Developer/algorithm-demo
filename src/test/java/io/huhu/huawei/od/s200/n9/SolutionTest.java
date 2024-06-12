package io.huhu.huawei.od.s200.n9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 1, 2, 2};
        Assertions.assertEquals(2, Solution.resolve(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1, 1, 1, 9, 8, 3, 7, 10};
        Assertions.assertEquals(3, Solution.resolve(nums));
    }

    @Test
    void test3() {
        int[] nums = {5, 30, 2, 2, 16, 10, 13, 7, 12, 28, 25, 2, 12, 7, 14, 27, 27, 30, 8,
                29, 29, 2, 28, 1, 19, 20, 21, 8, 5, 24, 2, 8, 9, 5, 18, 8, 20, 9, 9, 2, 17,
                18, 11, 12, 15, 25, 16, 20, 10, 10, 16, 1, 8, 16, 11, 17, 1, 20, 19, 19, 9,
                11, 7, 23, 11, 27, 10, 25, 19, 3, 5, 28, 18, 1, 12, 18, 16, 29, 25, 9, 16,
                5, 27, 22, 18, 13, 1, 22, 3, 2, 9, 2, 30, 13, 24, 20, 25, 22, 4, 13, 13, 18,
                15, 26, 3, 16, 3, 23, 24, 23, 26, 23, 19, 22, 8, 20, 25, 12, 8, 13, 7, 25,
                6, 15, 26, 17, 2, 19, 26, 16, 1, 22, 30, 3, 23, 20, 14, 29, 8, 19, 6, 2, 17,
                20, 13, 11, 24, 7, 11, 23, 14, 13, 13, 24, 1, 30, 26, 17, 19, 26, 7, 4, 24,
                24, 17, 3, 21, 1, 4, 23, 9, 7, 10, 9, 9, 5, 16, 9, 4, 9, 29, 6, 9, 10, 3, 9,
                5, 4, 15, 29, 2, 20, 8, 10, 22, 8, 18, 22, 1, 14, 26, 27, 25, 25, 23, 17, 10,
                17, 22, 2, 2, 19, 4, 24, 1, 17, 7, 21, 20, 21, 10, 24, 3, 24, 9, 6, 30, 10, 7,
                4, 17, 25, 18, 15, 12, 27, 29, 18, 17, 16, 6, 25, 21, 9, 30, 13, 15, 25, 27,
                27, 12, 15, 14, 30, 3, 27, 21, 28, 19, 20, 23, 1, 17, 28, 16, 20, 24, 3, 30, 6,
                30, 16, 24, 27, 3, 21, 23, 10, 8, 9, 24, 30, 18, 19, 27, 25, 4, 10, 1, 24, 10,
                12, 9, 30, 2, 2, 1, 5, 24, 12, 29, 21, 26, 12, 5, 23, 17, 27, 22, 29, 28, 16,
                28, 16, 2, 25, 25, 22, 10, 24, 21, 8, 10, 18, 25, 13, 28, 27, 20, 21, 17, 22,
                1, 4, 27, 22, 2, 6, 15, 23, 19, 22, 24, 27, 6, 13, 23, 11, 13, 15, 18, 30, 30,
                12, 28, 21, 27, 26, 22, 26, 10, 8, 13, 18, 16, 26, 3, 23, 3, 6, 18, 28, 14, 10,
                4, 1, 19, 15, 22, 1, 23, 12, 10, 20, 25, 12, 17, 1, 20, 8, 17, 6, 19, 16, 22,
                19, 16, 28, 30, 14, 3, 10, 8, 24, 27, 19, 10, 24, 13, 27, 9, 7, 29, 28, 21, 9,
                12, 1, 16, 26, 25, 25, 5, 11, 17, 29, 5, 14, 16, 22, 6, 11, 25, 14, 26, 9, 4,
                3, 3, 17, 23, 25, 15, 5, 18, 27, 27, 10, 29, 29, 28, 16, 14, 5, 19, 10, 29, 24,
                2, 4, 26, 14, 27, 11, 3, 11, 24, 3, 12, 6, 3, 21, 14, 9, 10, 3, 14, 9, 18, 8, 1,
                14, 4, 9, 23, 16, 18, 29, 18, 5, 9, 27, 22, 20, 15, 17, 27, 20, 19, 23};
        Assertions.assertEquals(152, Solution.resolve(nums));
    }

}
