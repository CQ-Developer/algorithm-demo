package io.huhu.leetcode.n1035;

public class DepthFirstSearch implements Code {

    @Override
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return f(nums1, nums2, nums1.length - 1, nums2.length - 1);
    }

    private int f(int[] a, int[] b, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        int ans;
        if (a[i] == b[j]) {
            ans = f(a, b, i - 1, j - 1) + 1;
        } else {
            ans = Math.max(f(a, b, i - 1, j), f(a, b, i, j - 1));
        }
        return ans;
    }

}
