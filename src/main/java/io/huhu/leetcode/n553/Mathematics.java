package io.huhu.leetcode.n553;

class Mathematics implements Code {

    /**
     * 答案只有一种: a/(b/c/d/...)
     */
    @Override
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(nums[i]);
            if (i != n - 1) {
                sb.append("/");
            }
        }
        if (n > 2) {
            sb.append(")").insert(0, "/(").insert(0, nums[0]);
        } else {
            sb.insert(0, "/").insert(0, nums[0]);
        }
        return sb.toString();
    }

}
