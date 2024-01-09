package io.huhu.leetcode.bit.manipulation.easy.n1486;

/**
 * <a href="https://leetcode.cn/problems/xor-operation-in-an-array/description/">数组异或操作</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= n <= 1000</li>
     * <li>0 <= start <= 1000</li>
     * <li>n == nums.length</li>
     * </ul>
     */
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + (i << 1);
        }
        return res;
    }

}
