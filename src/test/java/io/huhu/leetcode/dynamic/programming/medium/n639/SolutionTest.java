package io.huhu.leetcode.dynamic.programming.medium.n639;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract sealed class SolutionTest permits DFSSolutionTest, DPSolutionTest {

    protected Solution solution;

    abstract void setup();

    @Test
    void case1() {
        Assertions.assertEquals(9, solution.numDecodings("*"));
    }

    @Test
    void case2() {
        Assertions.assertEquals(18, solution.numDecodings("1*"));
    }

    @Test
    void case3() {
        Assertions.assertEquals(15, solution.numDecodings("2*"));
    }

    @Test
    void case4() {
        Assertions.assertEquals(291868912, solution.numDecodings("*********"));
    }

    @Test
    void case5() {
        Assertions.assertEquals(196465252, solution.numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
    }

}
