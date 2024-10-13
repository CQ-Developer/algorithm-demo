package io.huhu.leetcode.greedy.n1029;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        Assertions.assertEquals(110, code.twoCitySchedCost(costs));
    }

    @Test
    void test_2() {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        Assertions.assertEquals(1859, code.twoCitySchedCost(costs));
    }

    @Test
    void test_3() {
        int[][] costs = {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}};
        Assertions.assertEquals(3086, code.twoCitySchedCost(costs));
    }

}
