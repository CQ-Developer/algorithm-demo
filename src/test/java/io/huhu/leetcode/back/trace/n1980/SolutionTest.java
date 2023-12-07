package io.huhu.leetcode.back.trace.n1980;

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
    void case_1() {
        List<String> expected = List.of("00", "11");
        String[] nums = {"01", "10"};
        String actual = solution.findDifferentBinaryString(nums);
        Assertions.assertTrue(expected.contains(actual));
    }

    @Test
    void case_2() {
        List<String> expected = List.of("10", "11");
        String[] nums = {"00", "01"};
        String actual = solution.findDifferentBinaryString(nums);
        Assertions.assertTrue(expected.contains(actual));
    }

    @Test
    void case_3() {
        List<String> expected = List.of("000", "010", "100", "110");
        String[] nums = {"111", "011", "001"};
        String actual = solution.findDifferentBinaryString(nums);
        Assertions.assertTrue(expected.contains(actual));
    }

}
