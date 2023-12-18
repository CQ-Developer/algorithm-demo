package io.huhu.leetcode.back.trace.n2698;

/**
 * <a href="https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/">求一个整数的惩罚数</a>
 * <p>n的惩罚数定义为所有满足以下条件i的数的平方和:
 * <ul>
 * <li>1 <= i <= n
 * <li>i * i 的十进制表示的字符串可以分割成若干连续子字符串, 且这些子字符串对应的整数值之和等于i
 * </ul>
 */
class Solution {

    /**
     * 提示:
     * <ul>
     * <li>1 <= n <= 1000
     * </ul>
     */
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if (dfs(num + "", 0, i, 0)) {
                res += num;
            }
        }
        return res;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private boolean dfs(String s, int j, int target, int sum) {
        if (j == s.length()) {
            return target == sum;
        }
        int num = 0;
        for (int i = j; i < s.length(); i++) {
            num = 10 * num + (s.charAt(i) - '0');
            if (sum + num > target) {
                break;
            }
            if (dfs(s, i + 1, target, sum + num)) {
                return true;
            }
        }
        return false;
    }

}
