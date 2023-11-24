package io.huhu.leetcode.back.trace.n638;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// @Timeout(value = 3, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void shoppingOffers_1() {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(
                List.of(3, 0, 5),
                List.of(1, 2, 10));
        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);
        Assertions.assertEquals(14, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_2() {
        List<Integer> price = List.of(2, 3, 4);
        List<List<Integer>> special = List.of(
                List.of(1, 1, 0, 4),
                List.of(2, 2, 1, 9));
        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);
        Assertions.assertEquals(11, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_3() {
        List<Integer> price = List.of(4, 3, 2, 9, 8, 8);
        List<List<Integer>> special = List.of(
                List.of(1, 5, 5, 1, 4, 0, 18),
                List.of(3, 3, 6, 6, 4, 2, 32));
        List<Integer> needs = new ArrayList<>();
        needs.add(6);
        needs.add(5);
        needs.add(5);
        needs.add(6);
        needs.add(4);
        needs.add(1);
        Assertions.assertEquals(91, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_4() {
        List<Integer> price = List.of(2, 2);
        List<List<Integer>> special = List.of(
                List.of(1, 1, 1),
                List.of(1, 1, 2),
                List.of(1, 1, 3),
                List.of(1, 1, 4),
                List.of(1, 1, 5),
                List.of(1, 1, 6),
                List.of(1, 1, 7),
                List.of(1, 1, 8),
                List.of(1, 1, 9),
                List.of(1, 1, 10),
                List.of(1, 1, 11),
                List.of(1, 1, 12),
                List.of(1, 1, 13),
                List.of(1, 1, 14),
                List.of(1, 1, 15));
        List<Integer> needs = new ArrayList<>();
        needs.add(10);
        needs.add(10);
        Assertions.assertEquals(10, solution.shoppingOffers(price, special, needs));
    }

}
