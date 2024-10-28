package io.huhu.leetcode.n873;

class DynamicProgramming implements Code {

    @Override
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            // k < j < i
            int k = 0, j = i - 1;
            while (k < j) {
                if (arr[k] + arr[j] == arr[i]) {
                    f[j][i] = Math.max(3, f[k][j] + 1);
                    ans = Math.max(ans, f[j][i]);
                    k++;
                    j--;
                }
                // 将k指针右移获取更大的和
                else if (arr[k] + arr[j] < arr[i]) {
                    k++;
                }
                // 将j指针左移获取更小的值
                else {
                    j--;
                }
            }
        }
        return ans;
    }

}
