package io.huhu.leetcode.back.trace.n1079;

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
    void numTilePossibilities1() {
        Assertions.assertEquals(8, solution.numTilePossibilities("AAB"));
    }

    @Test
    void numTilePossibilities2() {
        Assertions.assertEquals(13, solution.numTilePossibilities("AAAB"));
    }

    @Test
    void numTilePossibilities3() {
        Assertions.assertEquals(33, solution.numTilePossibilities("AABAB"));
    }

    @Test
    void numTilePossibilities4() {
        Assertions.assertEquals(188, solution.numTilePossibilities("AAABBC"));
    }

    @Test
    void numTilePossibilities5() {
        Assertions.assertEquals(1, solution.numTilePossibilities("V"));
    }

    @Test
    void numTilePossibilities6() {
        Assertions.assertEquals(8, solution.numTilePossibilities("CDC"));
    }

}
