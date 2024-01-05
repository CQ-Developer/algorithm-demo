package io.huhu.leetcode.bit.manipulation.easy.n645;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/description/">错误的集合</a>
 */
class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] dict = new int[nums.length + 1];
        for (int i : nums) {
            dict[i]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < dict.length; i++) {
            if (dict[i] == 2) {
                res[0] = i;
            }
            if (dict[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

}
