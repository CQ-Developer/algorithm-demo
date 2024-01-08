package io.huhu.leetcode.back.trace.n996;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/number-of-squareful-arrays/description/">正方形数组的数目</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= A.length <= 12</li>
     * <li>1 <= A[i] <= 1e9</li>
     * </ul>
     */
    public int numSquarefulPerms(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        return dfs(nums, new boolean[nums.length], new int[nums.length], 0);
    }

    private int dfs(int[] nums, boolean[] used, int[] path, int j) {
        if (j > 1 && !check(path[j - 1], path[j - 2])) {
            return 0;
        }
        if (j == path.length) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path[j] = nums[i];
            res += dfs(nums, used, path, j + 1);
            used[i] = false;
        }
        return res;
    }

    private boolean check(int a, int b) {
        double sqrt = Math.sqrt(a + b);
        return sqrt == (int) sqrt;
    }

}
