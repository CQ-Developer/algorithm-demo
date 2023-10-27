package io.huhu.leetcode.back.trace.n1863;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>
 * 1863.找出所有子集的异或总和再求和
 * </h1>
 *
 * <p>
 * 一个数组的异或总和定义为数组中所有元素按位XOR的结果；如果数组位空，则异或总和为0
 * </p>
 *
 * <p>
 * 例如，数组[2,5,6]的异或总和为 2 XOR 5 XOR 6 = 1
 * </p>
 *
 * <p>
 * 给你一个数组nums，请你请求nums中每个子集的异或总和，计算并返回这些值相加之和
 * </p>
 *
 * <p>
 * 注意：在本题中，元素相同的不同子集应多次计数
 * 数组a是数组b的一个子集的前提条件是：从b删除几个(也可能不删除)元素能够得到a
 * </p>
 */
class Solution {

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            subsetXORSum(nums, 0, i + 1, new ArrayList<>(), subset);
        }
        int sum = 0;
        for (var list : subset) {
            int t = 0;
            for (int i : list) {
                t ^= i;
            }
            sum += t;
        }
        return sum;
    }

    private void subsetXORSum(int[] nums, int i, int size, List<Integer> list, List<List<Integer>> subset) {
        if (size == list.size()) {
            subset.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            subsetXORSum(nums, j + 1, size, list, subset);
            list.remove(list.size() - 1);
        }
    }

}
