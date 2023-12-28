package io.huhu.leetcode.back.trace.n282;

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
    void addOperators_1() {
        List<String> actual = solution.addOperators("123", 6);
        List<String> expected = List.of("1+2+3", "1*2*3");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void addOperators_2() {
        List<String> actual = solution.addOperators("232", 8);
        List<String> expected = List.of("2+3*2", "2*3+2");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void addOperators_3() {
        List<String> actual = solution.addOperators("3456237490", 9191);
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void addOperators_4() {
        List<String> actual = solution.addOperators("2147483648", -2147483648);
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void addOperators_5() {
        List<String> actual = solution.addOperators("105", 5);
        List<String> expected = List.of("1*0+5", "10-5");
        Assertions.assertIterableEquals(expected, actual);
    }

}
