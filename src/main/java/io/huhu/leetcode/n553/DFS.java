package io.huhu.leetcode.n553;

class DFS implements Code {

    @Override
    public String optimalDivision(int[] nums) {
        return f(nums, 0, nums.length - 1).maxExpr;
    }

    private Info f(int[] nums, int l, int r) {
        if (l == r) {
            return new Info(nums[l], nums[l], String.valueOf(nums[l]), String.valueOf(nums[l]));
        }
        double minVal = Double.MAX_VALUE, maxVal = Double.MIN_VALUE;
        String minExpr = "", maxExpr = "";
        for (int i = l; i < r; i++) {
            Info left = f(nums, l, i);
            Info right = f(nums, i + 1, r);
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
        return new Info(minVal, maxVal, minExpr, maxExpr);
    }

    private record Info(double minVal, double maxVal, String minExpr, String maxExpr) {}

}
