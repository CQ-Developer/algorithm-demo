package io.huhu.leetcode.n978;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1, down = 1, up = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                down = up + 1;
                up = 1;
            } else if (arr[i - 1] < arr[i]) {
                up = down + 1;
                down = 1;
            } else {
                down = up = 1;
            }
            ans = Math.max(ans, Math.max(down, up));
        }
        return ans;
    }

}
