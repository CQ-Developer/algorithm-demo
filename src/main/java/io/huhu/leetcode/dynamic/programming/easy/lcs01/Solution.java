package io.huhu.leetcode.dynamic.programming.easy.lcs01;

/**
 * <a href="https://leetcode.cn/problems/Ju9Xwi/description/">下载插件</a>
 */
class Solution {

    public int leastMinutes(int n) {
        int res = 1, dp = 1;
        while (dp < n) {
            dp *= 2;
            res++;
        }
        return res;
    }

}
