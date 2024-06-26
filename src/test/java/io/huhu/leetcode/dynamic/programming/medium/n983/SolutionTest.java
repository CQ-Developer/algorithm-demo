package io.huhu.leetcode.dynamic.programming.medium.n983;

import org.junit.jupiter.api.Assertions;

class SolutionTest {

    final void case_1(Solution solution) {
        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        Assertions.assertEquals(11, solution.mincostTickets(days, costs));
    }

    final void case_2(Solution solution) {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, costs = {2, 7, 15};
        Assertions.assertEquals(17, solution.mincostTickets(days, costs));
    }

}
