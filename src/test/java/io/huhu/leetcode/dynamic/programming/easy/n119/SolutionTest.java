package io.huhu.leetcode.dynamic.programming.easy.n119;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void getRow_1() {
        Assertions.assertIterableEquals(List.of(1, 3, 3, 1), solution.getRow(3));
    }

    @Test
    void getRow_2() {
        Assertions.assertIterableEquals(List.of(1), solution.getRow(0));
    }

    @Test
    void getRow_3() {
        Assertions.assertIterableEquals(List.of(1, 1), solution.getRow(1));
    }

    @Test
    void getRow_4() {
        List<Integer> expected = List.of(1, 33, 528, 5456, 40920, 237336, 1107568,
                4272048, 13884156, 38567100, 92561040, 193536720, 354817320, 573166440,
                818809200, 1037158320, 1166803110, 1166803110, 1037158320, 818809200,
                573166440, 354817320, 193536720, 92561040, 38567100, 13884156, 4272048,
                1107568, 237336, 40920, 5456, 528, 33, 1);
        Assertions.assertIterableEquals(expected, solution.getRow(33));
    }

}
