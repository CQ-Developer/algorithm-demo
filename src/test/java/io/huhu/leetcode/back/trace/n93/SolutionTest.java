package io.huhu.leetcode.back.trace.n93;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void restoreIpAddresses_1() {
        var expected = List.of(
                "255.255.11.135",
                "255.255.111.35");
        Assertions.assertIterableEquals(expected, solution.restoreIpAddresses("25525511135"));
    }

    @Test
    void restoreIpAddresses_2() {
        var expected = List.of(
                "0.0.0.0");
        Assertions.assertIterableEquals(expected, solution.restoreIpAddresses("0000"));
    }

    @Test
    void restoreIpAddresses_3() {
        var expected = List.of(
                "1.0.10.23",
                "1.0.102.3",
                "10.1.0.23",
                "10.10.2.3",
                "101.0.2.3");
        Assertions.assertIterableEquals(expected, solution.restoreIpAddresses("101023"));
    }

}
