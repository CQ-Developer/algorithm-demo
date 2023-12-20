package io.huhu.leetcode.back.trace.lcr.n087;

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
        List<String> actual = solution.restoreIpAddresses("25525511135");
        List<String> expected = List.of("255.255.11.135", "255.255.111.35");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        List<String> actual = solution.restoreIpAddresses("0000");
        List<String> expected = List.of("0.0.0.0");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        List<String> actual = solution.restoreIpAddresses("1111");
        List<String> expected = List.of("1.1.1.1");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        List<String> actual = solution.restoreIpAddresses("010010");
        List<String> expected = List.of("0.10.0.10", "0.100.1.0");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_5() {
        List<String> actual = solution.restoreIpAddresses("10203040");
        List<String> expected = List.of("10.20.30.40", "102.0.30.40", "10.203.0.40");
        Assertions.assertIterableEquals(expected, actual);
    }

}
