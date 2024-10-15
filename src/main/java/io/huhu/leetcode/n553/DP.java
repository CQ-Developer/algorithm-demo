package io.huhu.leetcode.n553;

class DP implements Code {

    private record Info(double minVal, double maxVal, String minExpr, String maxExpr) {}

    @Override
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        Info[][] dp = new Info[n][n];
        for (int l = n - 1; l >= 0; l--) {
            dp[l][l] = new Info(nums[l], nums[l], String.valueOf(nums[l]), String.valueOf(nums[l]));
            for (int r = l + 1; r < n; r++) {
                double minVal = Double.MAX_VALUE, maxVal = Double.MIN_VALUE;
                String minExpr = "", maxExpr = "";
                for (int i = l; i < r; i++) {
                    Info left = dp[l][i], right = dp[i + 1][r];
                    double min = left.minVal / right.maxVal;
                    if (min < minVal) {
                        minVal = min;
                        if (i + 1 == r) {
                            minExpr = left.minExpr + "/" + right.maxExpr;
                        } else {
                            minExpr = left.minExpr + "/(" + right.maxExpr + ")";
                        }
                    }
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
                dp[l][r] = new Info(minVal, maxVal, minExpr, maxExpr);
            }
        }
        return dp[0][n - 1].maxExpr;
    }

}
