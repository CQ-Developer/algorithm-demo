package io.huhu.leetcode.back.trace.n1863;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>
 * <a href ="https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/">1863.找出所有子集的异或总和再求和</a>
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

    /**
     * 1 <= nums.length <= 12
     * <br/>
     * 1 <= nums[i] <= 20
     */
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subLists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            backTrace(nums, 0, i + 1, new ArrayDeque<>(), subLists);
        }
        int sum = 0;
        for (List<Integer> subList : subLists) {
            int xor = 0;
            for (int i : subList) {
                xor ^= i;
            }
            sum += xor;
        }
        return sum;
    }

    /**
     * 回溯算法
     */
    private void backTrace(int[] nums, int i, int len, Deque<Integer> path, List<List<Integer>> subLists) {
        if (path.size() == len) {
            subLists.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length - len + path.size() + 1; j++) {
            path.addLast(nums[j]);
            backTrace(nums, j + 1, len, path, subLists);
            path.removeLast();
        }
    }

}
