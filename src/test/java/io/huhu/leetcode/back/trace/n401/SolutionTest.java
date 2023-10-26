package io.huhu.leetcode.back.trace.n401;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void readBinaryWatch1() {
        var expect = List.of("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32");
        Assertions.assertIterableEquals(expect, solution.readBinaryWatch(1));
    }

    @Test
    void readBinaryWatch2() {
        var expect = List.of();
        Assertions.assertIterableEquals(expect, solution.readBinaryWatch(9));
    }

}
