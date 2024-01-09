package io.huhu.leetcode.bit.manipulation.easy.n1763;

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
    void longestNiceSubstring_1() {
        Assertions.assertEquals("aAa", solution.longestNiceSubstring("YazaAay"));
    }

    @Test
    void longestNiceSubstring_2() {
        Assertions.assertEquals("Bb", solution.longestNiceSubstring("Bb"));
    }

    @Test
    void longestNiceSubstring_3() {
        Assertions.assertEquals("", solution.longestNiceSubstring("C"));
    }

    @Test
    void longestNiceSubstring_4() {
        Assertions.assertEquals("dD", solution.longestNiceSubstring("dDzeE"));
    }

}
