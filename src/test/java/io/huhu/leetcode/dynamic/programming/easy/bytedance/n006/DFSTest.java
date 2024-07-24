package io.huhu.leetcode.dynamic.programming.easy.bytedance.n006;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DFSTest {

    @Test
    void test_1() {
        int n = 4, x = 100;
        int[] price = {100, 100, 30, 10};
        int[] discount = {73, 89, 21, 8};
        int[] happy = {60, 35, 30, 10};
        Assertions.assertEquals(100, DFS.buy(n, x, price, discount, happy));
    }

    @Test
    void test_2() {
        int n = 3, x = 100;
        int[] price = {100, 80, 21};
        int[] discount = {100, 80, 21};
        int[] happy = {60, 35, 30};
        Assertions.assertEquals(60, DFS.buy(n, x, price, discount, happy));
    }

    @Test
    void test_3() {
        int n = 2, x = 100;
        int[] price = {100, 140};
        int[] discount = {30, 140};
        int[] happy = {35, 100};
        Assertions.assertEquals(135, DFS.buy(n, x, price, discount, happy));
    }

}
