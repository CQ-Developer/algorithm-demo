package io.huhu.leetcode.back.trace.n967;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void numsSameConsecDiff1() {
        int[] expected = {181, 292, 707, 818, 929};
        int[] actual = solution.numsSameConsecDiff(3, 7);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void numsSameConsecDiff2() {
        int[] expected = {10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98};
        int[] actual = solution.numsSameConsecDiff(2, 1);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void numsSameConsecDiff3() {
        int[] expected = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] actual = solution.numsSameConsecDiff(2, 0);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void numsSameConsecDiff4() {
        int[] expected = {13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97};
        int[] actual = solution.numsSameConsecDiff(2, 2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void numsSameConsecDiff5() {
        int[] expected = {
                10101, 10121, 10123, 12101, 12121, 12123, 12321, 12323, 12343,
                12345, 21010, 21012, 21210, 21212, 21232, 21234, 23210, 23212,
                23232, 23234, 23432, 23434, 23454, 23456, 32101, 32121, 32123,
                32321, 32323, 32343, 32345, 34321, 34323, 34343, 34345, 34543,
                34545, 34565, 34567, 43210, 43212, 43232, 43234, 43432, 43434,
                43454, 43456, 45432, 45434, 45454, 45456, 45654, 45656, 45676,
                45678, 54321, 54323, 54343, 54345, 54543, 54545, 54565, 54567,
                56543, 56545, 56565, 56567, 56765, 56767, 56787, 56789, 65432,
                65434, 65454, 65456, 65654, 65656, 65676, 65678, 67654, 67656,
                67676, 67678, 67876, 67878, 67898, 76543, 76545, 76565, 76567,
                76765, 76767, 76787, 76789, 78765, 78767, 78787, 78789, 78987,
                78989, 87654, 87656, 87676, 87678, 87876, 87878, 87898, 89876,
                89878, 89898, 98765, 98767, 98787, 98789, 98987, 98989};
        int[] actual = solution.numsSameConsecDiff(5, 1);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void numsSameConsecDiff6() {
        int[] expected = {19, 80, 91};
        int[] actual = solution.numsSameConsecDiff(2, 8);
        Assertions.assertArrayEquals(expected, actual);
    }

}
