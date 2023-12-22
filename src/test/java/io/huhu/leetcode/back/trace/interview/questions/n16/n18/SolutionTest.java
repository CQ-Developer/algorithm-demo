package io.huhu.leetcode.back.trace.interview.questions.n16.n18;

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
    void case_1() {
        boolean actual = solution.patternMatching("abba", "dogcatcatdog");
        Assertions.assertTrue(actual);
    }

    @Test
    void case_2() {
        boolean actual = solution.patternMatching("abba", "dogcatcatfish");
        Assertions.assertFalse(actual);
    }

    @Test
    void case_3() {
        boolean actual = solution.patternMatching("aaaa", "dogcatcatdog");
        Assertions.assertFalse(actual);
    }

    @Test
    void case_4() {
        boolean actual = solution.patternMatching("abba", "dogdogdogdog");
        Assertions.assertTrue(actual);
    }

    @Test
    void case_5() {
        boolean actual = solution.patternMatching("a", "");
        Assertions.assertTrue(actual);
    }

    @Test
    void case_6() {
        boolean actual = solution.patternMatching("abbaa", "dogdogdogdogdog");
        Assertions.assertFalse(actual);
    }

}
