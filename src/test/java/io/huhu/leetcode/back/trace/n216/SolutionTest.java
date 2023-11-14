package io.huhu.leetcode.back.trace.n216;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void combinationSum3_1() {
        var expected = List.of(List.of(1, 2, 4));
        Assertions.assertIterableEquals(expected, solution.combinationSum3(3, 7));
    }

    @Test
    void combinationSum3_2() {
        var expected = List.of(
                List.of(1, 2, 6),
                List.of(1, 3, 5),
                List.of(2, 3, 4));
        Assertions.assertIterableEquals(expected, solution.combinationSum3(3, 9));
    }

    @Test
    void combinationSum3_3() {
        var expected = List.of();
        Assertions.assertIterableEquals(expected, solution.combinationSum3(4, 1));
    }

    @Test
    void combinationSum3_4() {
        var expected = List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assertions.assertIterableEquals(expected, solution.combinationSum3(9, 45));
    }

}
