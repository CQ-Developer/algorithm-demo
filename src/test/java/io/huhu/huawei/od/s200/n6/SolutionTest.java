package io.huhu.huawei.od.s200.n6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int n = 4;
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        Assertions.assertEquals("0 3", Solution.doSolution(n, graph));
    }

    @Test
    void test2() {
        int n = 2;
        int[][] graph = {{0, 1}, {0, 2}};
        Assertions.assertEquals("0 1 2", Solution.doSolution(n, graph));
    }

    @Test
    void test3() {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        Assertions.assertEquals("-1", Solution.doSolution(n, edges));
    }

}
