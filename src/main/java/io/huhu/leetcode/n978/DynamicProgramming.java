package io.huhu.leetcode.n978;

class DynamicProgramming implements Code {

    @Override
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, ans = 1;
        // f[i][0]表示以arr[i]结尾时arr[i-1]>arr[i]时的湍流子数组的长度
        // f[i][1]表示以arr[i]结尾时arr[i-1]<arr[i]时的湍流子数组的长度
        int[][] f = new int[n][2];
        f[0][0] = f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i][1] = 1;
            /*
             * arr[i-1] > arr[i] 能够形成的湍流子数组表示为 f[i][0]
             * 则必然 arr[i-2] < arr[i-1] > arr[i]
             * arr[i-2] < arr[i-1] 能够形成的湍流子数组表示为 f[i-1][1]
             * 则 f[i][0] = f[i-1][0] + 1
             */
            if (arr[i - 1] > arr[i]) {
                f[i][0] = f[i - 1][1] + 1;
            }
            /*
             * arr[i-1] < arr[i] 能够形成的湍流子数组表示为 f[i][1]
             * 则必然 arr[i-2] > arr[i-1] < arr[i]
             * arr[i-2] > arr[i-1] 能够形成的湍流子数组表示为 f[i-1][0]
             * 则 f[i][1] = f[i-1][0] + 1
             */
            else {
                f[i][1] = f[i - 1][0] + 1;
            }
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }

}
