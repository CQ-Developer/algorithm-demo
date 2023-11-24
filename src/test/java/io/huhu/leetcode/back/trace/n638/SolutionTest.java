package io.huhu.leetcode.back.trace.n638;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;

@Timeout(value = 3, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void shoppingOffers_1() {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<Integer> s1 = new ArrayList<>();
        s1.add(3);
        s1.add(0);
        s1.add(5);
        List<Integer> s2 = new ArrayList<>();
        s2.add(1);
        s2.add(2);
        s2.add(10);
        List<List<Integer>> special = new ArrayList<>();
        special.add(s1);
        special.add(s2);
        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);
        Assertions.assertEquals(14, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_2() {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<Integer> s1 = new ArrayList<>();
        s1.add(1);
        s1.add(1);
        s1.add(0);
        s1.add(4);
        List<Integer> s2 = new ArrayList<>();
        s2.add(2);
        s2.add(2);
        s2.add(1);
        s2.add(9);
        List<List<Integer>> special = new ArrayList<>();
        special.add(s1);
        special.add(s2);
        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);
        Assertions.assertEquals(11, solution.shoppingOffers(price, special, needs));
    }

    @Test
    void shoppingOffers_3() {
        List<Integer> price = new ArrayList<>();
        price.add(4);
        price.add(3);
        price.add(2);
        price.add(9);
        price.add(8);
        price.add(8);
        List<Integer> s1 = new ArrayList<>();
        s1.add(1);
        s1.add(5);
        s1.add(5);
        s1.add(1);
        s1.add(4);
        s1.add(0);
        s1.add(18);
        List<Integer> s2 = new ArrayList<>();
        s2.add(3);
        s2.add(3);
        s2.add(6);
        s2.add(6);
        s2.add(4);
        s2.add(2);
        s2.add(32);
        List<List<Integer>> special = new ArrayList<>();
        special.add(s1);
        special.add(s2);
        List<Integer> needs = new ArrayList<>();
        needs.add(6);
        needs.add(5);
        needs.add(5);
        needs.add(6);
        needs.add(4);
        needs.add(1);
        Assertions.assertEquals(11, solution.shoppingOffers(price, special, needs));
    }

}
