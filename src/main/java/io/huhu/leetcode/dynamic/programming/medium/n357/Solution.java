package io.huhu.leetcode.dynamic.programming.medium.n357;

/**
 * <a href="https://leetcode.cn/problems/count-numbers-with-unique-digits/description/">Count Number with Unique Digits</a>
 */
class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        // 边界情况
        if (n == 0) {
            return 1;
        }
        // 1位数情况
        int result = 10;
        /*
         * 核心思想: 计算每一位上不重复的可能性, 将他们全部组合既所有位不重复的可能性
         *
         * 1位数
         * 可选数字为0-9, 共10种可能性, 直接用c表示
         *
         * 2位数
         * 第1位(最高位)不能是0, 所以可选数字1-9, 存在9种可能性
         * 第2位可选数字0-9, 共10个可选数字, 但第1位已经选了1个数字, 所以存在9种可能
         * 2位数所有的可能性为9*9=81
         * 2位数[总]的可能性 = 2位数的可能 + 1位数的[总]可能性
         * 81 + 10 = 91
         *
         * 3位数
         * 第3位可选数字0-9, 共10个可选数字, 但之前2位已经选了2个数字, 所以存在8种可能
         * 3位数所有的可能性为81*8=648
         * 3位数[总]的可能性 = 3位数的可能性 + 2位数的[总]可能性
         * 648 + 91 = 739
         *
         * 后面的位数可以依此类推
         *
         * 这里使用pre表示上一位的可能性, 由于最高位不能是0所以存在9种可能性, 这里直接初始化为9
         * i表示当前计算的是几位数
         */
        for (int i = 2, pre = 9; i <= n; i++) {
            // i位数的可能性
            pre = pre * (10 - i + 1);
            // i位数总的可能性
            result += pre;
        }
        return result;
    }

}
