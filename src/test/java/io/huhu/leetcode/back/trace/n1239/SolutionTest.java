package io.huhu.leetcode.back.trace.n1239;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
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

    @Test
    void maxLength5() {
        List<String> arr = List.of("ab", "ba", "cb");
        Assertions.assertEquals(2, solution.maxLength(arr));
    }

    @Test
    void maxLength6() {
        List<String> arr = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p");
        Assertions.assertEquals(16, solution.maxLength(arr));
    }

}
