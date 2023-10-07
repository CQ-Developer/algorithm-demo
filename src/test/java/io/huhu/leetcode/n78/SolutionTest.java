package io.huhu.leetcode.n78;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void subsets_1() {
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 3),
                List.of(1, 2),
                List.of(2, 3),
                List.of(1, 2, 3));
        expected = expected.stream()
                .map(ArrayList::new)
                .sorted(CommonUtils::deepSort)
                .collect(Collectors.toList());
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution.subsets(nums);
        actual = actual.stream()
                .sorted(CommonUtils::deepSort)
                .collect(Collectors.toList());
        assertIterableEquals(expected, actual);
    }

    @Test
    void subsets_2() {
        List<List<Integer>> expected = List.of(List.of(), List.of(0));
        int[] nums = {0};
        List<List<Integer>> actual = solution.subsets(nums);
        assertIterableEquals(expected, actual);
    }

}
