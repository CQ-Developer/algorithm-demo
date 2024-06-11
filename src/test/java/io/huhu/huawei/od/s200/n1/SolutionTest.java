package io.huhu.huawei.od.s200.n1;

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
    void test1() {
        int n = 3, m = 3;
        int[][] graph = {
                {1, 2, 3, 0},
                {1, 3, 1, 0},
                {2, 3, 5, 0}};
        Assertions.assertEquals(4, solution.build5GNetwork(n, m, graph));
    }

    @Test
    void test2() {
        int n = 3, m = 1;
        int[][] graph = {
                {1, 2, 5, 0}};
        Assertions.assertEquals(-1, solution.build5GNetwork(n, m, graph));
    }

    @Test
    void test3() {
        int n= 3, m = 3;
        int[][] graph = {
                {1, 2, 3, 0},
                {1, 3, 1, 0},
                {2, 3, 5, 1}};
        Assertions.assertEquals(1, solution.build5GNetwork(n, m, graph));
    }

}
