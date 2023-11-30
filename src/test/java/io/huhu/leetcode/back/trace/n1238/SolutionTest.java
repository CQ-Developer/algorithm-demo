package io.huhu.leetcode.back.trace.n1238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

@Timeout(value = 3, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void circularPermutation1() {
        List<Integer> expected = List.of(3, 1, 0, 2);
        List<Integer> actual = solution.circularPermutation(2, 3);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation2() {
        List<Integer> expected = List.of(2, 0, 1, 3, 7, 5, 4, 6);
        List<Integer> actual = solution.circularPermutation(3, 2);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation3() {
        // todo 超时
        List<Integer> expected = List.of(12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26,
                                         30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16,
                                         48, 49, 51, 50, 54, 55, 53, 52, 60, 61, 63, 62,
                                         58, 59, 57, 56, 40, 41, 43, 42, 46, 47, 45, 44,
                                         36, 37, 39, 38, 34, 35, 33, 32, 96, 97, 99, 98,
                                         102, 103, 101, 100, 108, 109, 111, 110, 106, 107, 105, 104,
                                         120, 121, 123, 122, 126, 127, 125, 124, 116, 117, 119, 118,
                                         114, 115, 113, 112, 80, 81, 83, 82, 86, 87, 85, 84,
                                         92, 93, 95, 94, 90, 91, 89, 88, 72, 73, 75, 74,
                                         78, 79, 77, 76, 68, 69, 71, 70, 66, 67, 65, 64,
                                         0, 1, 3, 2, 6, 7, 5, 4);
        List<Integer> actual = solution.circularPermutation(7, 12);
        Assertions.assertIterableEquals(expected, actual);
    }

}
