package io.huhu.leetcode.back.trace.n638;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void shoppingOffers_1() {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(List.of(3, 0, 5), List.of(1, 2, 10));
        List<Integer> needs = List.of(3, 2);
        Assertions.assertEquals(14, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_2() {
        List<Integer> price = List.of(2, 3, 4);
        List<List<Integer>> special = List.of(List.of(1, 1, 0, 4), List.of(2, 2, 1, 9));
        List<Integer> needs = List.of(1, 2, 1);
        Assertions.assertEquals(11, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_3() {
        List<Integer> price = List.of(4, 3, 2, 9, 8, 8);
        List<List<Integer>> special = List.of(List.of(1, 5, 5, 1, 4, 0, 18), List.of(3, 3, 6, 6, 4, 2, 32));
        List<Integer> needs = List.of(6, 5, 5, 6, 4, 1);
        Assertions.assertEquals(11, solution.shoppingOffers(price, special, needs));
    }

}
