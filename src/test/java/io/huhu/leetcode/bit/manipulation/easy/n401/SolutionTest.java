package io.huhu.leetcode.bit.manipulation.easy.n401;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void readBinaryWatch1() {
        List<String> expected = Stream.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00").sorted().toList();
        List<String> actual = solution.readBinaryWatch(1).stream().sorted().toList();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void readBinaryWatch2() {
        List<String> expected = List.of();
        List<String> actual = solution.readBinaryWatch(9);
        Assertions.assertIterableEquals(expected, actual);
    }

}
