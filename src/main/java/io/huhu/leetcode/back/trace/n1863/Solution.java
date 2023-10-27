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
        int sum = 0;
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());
        for (int num : nums) {
            int size = subset.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(subset.get(i));
                list.add(num);
                subset.add(list);
                int tmp = 0;
                for (int j : list) {
                    tmp ^= j;
                }
                sum += tmp;
            }
        }
        return sum;
    }

}
