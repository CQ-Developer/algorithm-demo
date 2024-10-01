package io.huhu.leetcode.n139;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        List<String> wordDict = List.of("leet", "code");
        Assertions.assertTrue(code.wordBreak("leetcode", wordDict));
    }

    @Test
    void test_2() {
        List<String> wordDict = List.of("apple", "pen");
        Assertions.assertTrue(code.wordBreak("applepenapple", wordDict));
    }

    @Test
    void test_3() {
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        Assertions.assertFalse(code.wordBreak("catsandog", wordDict));
    }

}
