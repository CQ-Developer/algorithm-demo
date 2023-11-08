package io.huhu.leetcode.back.trace.n89;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void grayCode_1() {
        var expected = List.of(0, 1);
        Assertions.assertIterableEquals(expected, solution.grayCode(1));
    }

    @Test
    void grayCode_2() {
        var expected = List.of(0, 1, 3, 2);
        Assertions.assertIterableEquals(expected, solution.grayCode(2));
    }

    @Test
    void grayCode_3() {
        var expected = List.of(0, 1, 3, 2, 6, 7, 5, 4);
        Assertions.assertIterableEquals(expected, solution.grayCode(3));
    }

    @Test
    void test() {
        System.out.println(solution.grayCode(3));
    }

}
