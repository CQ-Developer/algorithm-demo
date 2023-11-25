package io.huhu.leetcode.back.trace.n698;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

@Timeout(value = 2, threadMode = SEPARATE_THREAD)
class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void canPartitionKSubsets_1() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        Assertions.assertTrue(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_2() {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_3() {
        int[] nums = {3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};
        int k = 6;
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_4() {
        int[] nums = {2, 9, 4, 7, 3, 2, 10, 5, 3, 6, 6, 2, 7, 5, 2, 4};
        int k = 7;
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_5() {
        int[] nums = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;
        Assertions.assertTrue(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_6() {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2};
        int k = 2;
        Assertions.assertTrue(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_7() {
        int[] nums = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
        int k = 5;
        Assertions.assertTrue(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_8() {
        int[] nums = {85, 35, 40, 64, 86, 45, 63, 16, 5364, 110, 5653, 97, 95};
        int k = 7;
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, k));
    }

    @Test
    void canPartitionKSubsets_9() {
        int[] nums = {5309, 7138, 779, 8949, 8568, 2250, 1794, 6539, 4948, 7189, 4270, 9866, 5867, 2112, 9176, 3162};
        int k = 2;
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, k));
    }

}
