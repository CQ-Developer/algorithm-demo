package io.huhu.huawei.od.s200.n8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int min = 1;
        int[] nums = {0, 1, 2, 3, 4};
        Assertions.assertEquals("0-2", Solution.findMaxRange(nums, min));
    }

    @Test
    void test2() {
        int min = 2;
        int[] nums = {0, 0, 100, 2, 2, 99, 0, 2};
        Assertions.assertEquals("0-1 3-4 6-7", Solution.findMaxRange(nums, min));
    }

    @Test
    void test3() {
        int min = 10;
        int[] nums = {12, 16, 42, 95, 41, 92, 60, 23, 52, 65, 16, 32, 24, 84, 8, 75, 47, 57, 25, 12, 35, 41, 71, 96, 75, 80, 48, 65, 27, 3, 92, 90, 10, 75, 32, 46, 23, 52, 71, 5, 63, 38, 0, 7, 57, 79, 16, 68, 100, 31, 85, 41, 62, 5, 40, 98, 96, 37, 46, 95, 37, 86, 69, 31, 64, 20, 75, 30, 3, 78, 48, 86, 44, 10, 85, 80, 33, 27, 9, 95, 74, 93, 12, 75, 29, 3, 54, 5, 90, 5, 2, 54, 34, 44, 8, 10, 17, 3, 99, 40};
        Assertions.assertEquals("42-43 89-90 94-95 96-97", Solution.findMaxRange(nums, min));
    }

}
