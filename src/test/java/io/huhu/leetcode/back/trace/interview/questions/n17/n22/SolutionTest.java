package io.huhu.leetcode.back.trace.interview.questions.n17.n22;

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
        List<String> actual = solution.findLadders("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log", "cog"));
        List<String> expected = List.of("hit", "hot", "dot", "lot", "log", "cog");
        Assertions.assertEquals(expected.get(0), actual.get(0));
        Assertions.assertEquals(expected.get(expected.size() - 1), actual.get(actual.size() - 1));
    }

    @Test
    void case_2() {
        List<String> actual = solution.findLadders("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log"));
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        List<String> actual = solution.findLadders("hot", "dog",
                List.of("hot", "dog"));
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        List<String> actual = solution.findLadders("qa", "sq",
                List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr",
                        "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba",
                        "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho",
                        "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo",
                        "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh",
                        "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
                        "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc",
                        "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
                        "ni", "mr", "pa", "he", "lr", "sq", "ye"));
        List<String> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

}
