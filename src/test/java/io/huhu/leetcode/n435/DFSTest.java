package io.huhu.leetcode.n435;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DFSTest extends CodeTest {

    @Override
    Code getCode() {
        return new DFS();
    }

    @Test
    void test_N() {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        Assertions.assertEquals(2, code.eraseOverlapIntervals(intervals));
    }

}
