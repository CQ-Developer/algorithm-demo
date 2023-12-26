package io.huhu.leetcode.back.trace.n212;

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
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> actual = solution.findWords(board, words);
        List<String> expected = List.of("oath", "eat");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}};
        String[] words = {"abcd"};
        List<String> actual = solution.findWords(board, words);
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        char[][] board = {
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}};
        String[] words = {"oa", "oaa"};
        List<String> actual = solution.findWords(board, words);
        List<String> expected = List.of("oa", "oaa");
        Assertions.assertIterableEquals(expected, actual);
    }

}
