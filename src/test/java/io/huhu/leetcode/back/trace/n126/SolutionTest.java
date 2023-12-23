package io.huhu.leetcode.back.trace.n126;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(List.of("hit", "hot", "lot", "log", "cog"), List.of("hit", "hot", "dot", "dog", "cog"));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = List.of("hot", "dog", "dot");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(List.of("hot", "dot", "dog"));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        String beginWord = "qa", endWord = "sq";
        List<String> wordList = List.of(
                "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb",
                "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br",
                "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
                "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh",
                "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb",
                "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
                "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an",
                "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
                "pa", "he", "lr", "sq", "ye");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(List.of("hot", "dot", "dog"));
        Assertions.assertIterableEquals(expected, actual);
    }

}