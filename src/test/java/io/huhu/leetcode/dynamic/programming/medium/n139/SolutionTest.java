package io.huhu.leetcode.dynamic.programming.medium.n139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        Assertions.assertTrue(solution.wordBreak(s, wordDict));
    }

    @Test
    void test_2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        Assertions.assertTrue(solution.wordBreak(s, wordDict));
    }

    @Test
    void test_3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        Assertions.assertFalse(solution.wordBreak(s, wordDict));
    }

    @Test
    void test_4() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        Assertions.assertFalse(solution.wordBreak(s, wordDict));
    }

    @Test
    void test_5() {
        String s = "catskicatcats";
        List<String> wordDict = List.of("cats","cat","dog","ski");
        Assertions.assertTrue(solution.wordBreak(s, wordDict));
    }

}
