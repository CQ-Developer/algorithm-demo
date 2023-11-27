package io.huhu.leetcode.back.trace.n816;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        this.solution = new Solution();
    }

    @Test
    void ambiguousCoordinates1() {
        List<String> expected = List.of("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)");
        List<String> actual = this.solution.ambiguousCoordinates("(123)");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void ambiguousCoordinates2() {
        List<String> expected = List.of("(0.001, 1)", "(0, 0.011)");
        List<String> actual = this.solution.ambiguousCoordinates("(00011)");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void ambiguousCoordinates3() {
        List<String> expected = List.of("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)");
        List<String> actual = this.solution.ambiguousCoordinates("(0123)");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void ambiguousCoordinates4() {
        List<String> expected = List.of("(10, 0)");
        List<String> actual = this.solution.ambiguousCoordinates("(100)");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

}
