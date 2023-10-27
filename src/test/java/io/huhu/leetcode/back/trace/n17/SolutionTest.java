package io.huhu.leetcode.back.trace.n17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void letterCombinations1() {
        var actual = solution.letterCombinations("23");
        Collections.sort(actual);
        var expect = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void letterCombinations2() {
        var actual = solution.letterCombinations("");
        var expect = List.of();
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void letterCombinations3() {
        var actual = solution.letterCombinations("2");
        var expect = List.of("a", "b", "c");
        Assertions.assertIterableEquals(expect, actual);
    }

}
