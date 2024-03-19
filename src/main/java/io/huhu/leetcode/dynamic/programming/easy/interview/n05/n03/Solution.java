package io.huhu.leetcode.dynamic.programming.easy.interview.n05.n03;

/**
 * <a href="https://leetcode.cn/problems/reverse-bits-lcci/description/">翻转数位</a>
 */
class Solution {

    public int reverseBit(int num) {
        int res = 0, max = 0, cur = 0;
        for (int i = 0; i < 32; i++) {
            max = (num & 1 << i) == 0 ? cur + 1 : max + 1;
            cur = (num & 1 << i) == 0 ? 0 : cur + 1;
            res = Math.max(max, res);
        }
        return res;
    }

}
