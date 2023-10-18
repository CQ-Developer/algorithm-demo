package io.huhu.leetcode.n2530;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void maxKelements_1() {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        assertEquals(50, solution.maxKelements(nums, k));
    }

    @Test
    void maxKelements_2() {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        assertEquals(17, solution.maxKelements(nums, k));
    }

    @Test
    void maxKelements_3() {
        int[] nums = {
                881784984, 829998714, 730002802,
                56524562, 120336848, 548306998,
                801116106, 828640251, 519131180,
                819176153, 476262254, 15904939,
                540793851, 53572296, 259044378,
                491129827, 561147559, 205793082,
                967833729};
        int k = 16;
        assertEquals(9888530217L, solution.maxKelements(nums, k));
    }

}
