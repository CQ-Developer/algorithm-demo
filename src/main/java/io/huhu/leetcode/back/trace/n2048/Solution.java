package io.huhu.leetcode.back.trace.n2048;

/**
 * <a href="https://leetcode.cn/problems/next-greater-numerically-balanced-number/description/">下一个更大的数值平衡数</a>
 * <p>如果整数x满足: 对于每个数位d, 这个数位恰好在x种出现d次. 那么整数x就是一个数值平衡数.
 * <p>给你一个整数n, 请你返回严格大于n的最小数值平衡数.
 */
class Solution {

    /**
     * 0 <= n <= 10<sup>6</sup>
     */
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (!check(("" + num).toCharArray())) {
            num++;
        }
        return num;
    }

    private boolean check(char[] nums) {
        int[] arr = new int[10];
        for (char num : nums) {
            int i = num - '0';
            if (i > nums.length) {
                return false;
            }
            arr[i]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (i != arr[i]) {
                return false;
            }
        }
        return true;
    }

}
