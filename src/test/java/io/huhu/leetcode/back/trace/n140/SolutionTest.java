package io.huhu.leetcode.back.trace.n140;

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
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> actual = solution.wordBreak(s, wordDict);
        List<String> expected = List.of("cat sand dog", "cats and dog");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        List<String> actual = solution.wordBreak(s, wordDict);
        List<String> expected = List.of("pine apple pen apple", "pine applepen apple", "pineapple pen apple");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        List<String> actual = solution.wordBreak(s, wordDict);
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

}
