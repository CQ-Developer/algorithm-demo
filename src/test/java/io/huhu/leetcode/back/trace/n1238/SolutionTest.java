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
        List<Integer> expected = List.of(3, 2, 0, 1);
        List<Integer> actual = solution.circularPermutation(2, 3);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation2() {
        List<Integer> expected = List.of(2, 3, 1, 0, 4, 5, 7, 6);
        List<Integer> actual = solution.circularPermutation(3, 2);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation3() {
        List<Integer> expected = List.of(
                12, 13, 15, 14, 10, 11, 9, 8, 0, 1,
                3, 2, 6, 7, 5, 4, 20, 21, 23, 22, 18,
                19, 17, 16, 24, 25, 27, 26, 30, 31, 29,
                28, 60, 61, 63, 62, 58, 59, 57, 56, 48,
                49, 51, 50, 54, 55, 53, 52, 36, 37, 39,
                38, 34, 35, 33, 32, 40, 41, 43, 42, 46,
                47, 45, 44, 108, 109, 111, 110, 106, 107,
                105, 104, 96, 97, 99, 98, 102, 103, 101,
                100, 116, 117, 119, 118, 114, 115, 113,
                112, 120, 121, 123, 122, 126, 127, 125,
                124, 92, 93, 95, 94, 90, 91, 89, 88, 80,
                81, 83, 82, 86, 87, 85, 84, 68, 69, 71,
                70, 66, 67, 65, 64, 72, 73, 75, 74, 78,
                79, 77, 76);
        List<Integer> actual = solution.circularPermutation(7, 12);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation4() {
        List<Integer> expected = List.of(
                112, 113, 115, 114, 118, 119, 117, 116, 124,
                125, 127, 126, 122, 123, 121, 120, 104, 105,
                107, 106, 110, 111, 109, 108, 100, 101, 103,
                102, 98, 99, 97, 96, 64, 65, 67, 66, 70, 71,
                69, 68, 76, 77, 79, 78, 74, 75, 73, 72, 88,
                89, 91, 90, 94, 95, 93, 92, 84, 85, 87, 86,
                82, 83, 81, 80, 16, 17, 19, 18, 22, 23, 21,
                20, 28, 29, 31, 30, 26, 27, 25, 24, 8, 9, 11,
                10, 14, 15, 13, 12, 4, 5, 7, 6, 2, 3, 1, 0,
                32, 33, 35, 34, 38, 39, 37, 36, 44, 45, 47,
                46, 42, 43, 41, 40, 56, 57, 59, 58, 62, 63,
                61, 60, 52, 53, 55, 54, 50, 51, 49, 48);
        List<Integer> actual = solution.circularPermutation(7, 112);
        Assertions.assertIterableEquals(expected, actual);
    }

}
