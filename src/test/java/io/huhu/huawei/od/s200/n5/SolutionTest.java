package io.huhu.huawei.od.s200.n5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        Assertions.assertEquals(3, Solution.doSolution("ABC", "ABC"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(9, Solution.doSolution("ABCABBA", "CBABAC"));
    }

}
