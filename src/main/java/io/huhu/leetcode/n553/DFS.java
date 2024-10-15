package io.huhu.leetcode.n553;

class DFS implements Code {

    private record Info(double minVal, double maxVal, String minExpr, String maxExpr) {}

    @Override
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        return f(nums, 0, n - 1, new Info[n][n]).maxExpr;
    }

    private Info f(int[] nums, int l, int r, Info[][] dp) {
        if (l == r) {
            return new Info(nums[l], nums[l], String.valueOf(nums[l]), String.valueOf(nums[l]));
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        double minVal = Double.MAX_VALUE, maxVal = Double.MIN_VALUE;
        String minExpr = "", maxExpr = "";
        for (int i = l; i < r; i++) {
            Info left = f(nums, l, i, dp), right = f(nums, i + 1, r, dp);
            // min value
            double min = left.minVal / right.maxVal;
            if (min < minVal) {
                minVal = min;
                if (i + 1 == r) {
                    minExpr = left.minExpr + "/" + right.maxExpr;
                } else {
                    minExpr = left.minExpr + "/(" + right.maxExpr + ")";
                }
            }
            // max value
            double max = left.maxVal / right.minVal;
            if (max > maxVal) {
                maxVal = max;
                if (i + 1 == r) {
                    maxExpr = left.maxExpr + "/" + right.minExpr;
                } else {
                    maxExpr = left.maxExpr + "/(" + right.minExpr + ")";
                }
            }
        }
        return dp[l][r] = new Info(minVal, maxVal, minExpr, maxExpr);
    }

}
