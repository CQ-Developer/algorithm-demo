package io.huhu.leetcode.back.trace.n1239;

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
    void maxLength1() {
        List<String> arr = List.of("un", "iq", "ue");
        Assertions.assertEquals(4, solution.maxLength(arr));
    }

    @Test
    void maxLength2() {
        List<String> arr = List.of("cha", "r", "act", "ers");
        Assertions.assertEquals(6, solution.maxLength(arr));
    }

    @Test
    void maxLength3() {
        List<String> arr = List.of("abcdefghijklmnopqrstuvwxyz");
        Assertions.assertEquals(26, solution.maxLength(arr));
    }

    @Test
    void maxLength4() {
        List<String> arr = List.of("aa", "bb");
        Assertions.assertEquals(0, solution.maxLength(arr));
    }

}
