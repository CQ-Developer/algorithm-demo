package io.huhu.leetcode.n90;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void subsetsWithDup1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expect = List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2));
        List<List<Integer>> actual = solution.subsetsWithDup(nums);
        CommonUtils.deepSortLists(actual);
        assertIterableEquals(expect, actual);
    }

    @Test
    void subsetsWithDup2() {
        int[] nums = {0};
        List<List<Integer>> expect = List.of(
                List.of(),
                List.of(0));
        List<List<Integer>> actual = solution.subsetsWithDup(nums);
        CommonUtils.deepSortLists(actual);
        assertIterableEquals(actual, expect);
    }

}
