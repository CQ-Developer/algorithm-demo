package io.huhu.leetcode.bit.manipulation.easy.n1684;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void countConsistentStrings_1() {
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        Assertions.assertEquals(2, solution.countConsistentStrings("ab", words));
    }

    @Test
    void countConsistentStrings_2() {
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        Assertions.assertEquals(7, solution.countConsistentStrings("abc", words));
    }

    @Test
    void countConsistentStrings_3() {
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        Assertions.assertEquals(4, solution.countConsistentStrings("cad", words));
    }

}
