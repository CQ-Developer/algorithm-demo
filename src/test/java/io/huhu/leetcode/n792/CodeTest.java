package io.huhu.leetcode.n792;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
    }

    @Test
    void test_1() {
        String[] words = {"a", "bb", "acd", "ace"};
        Assertions.assertEquals(3, code.numMatchingSubseq("abcde", words));
    }

    @Test
    void test_2() {
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        Assertions.assertEquals(2, code.numMatchingSubseq("dsahjpjauf", words));
    }

}