package io.huhu.leetcode.back.trace.n691;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void minStickers1() {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        Assertions.assertEquals(3, solution.minStickers(stickers, target));
    }

    @Test
    void minStickers2() {
        String[] stickers = {"notice", "possible"};
        String target = "basicbasic";
        Assertions.assertEquals(-1, solution.minStickers(stickers, target));
    }

}
