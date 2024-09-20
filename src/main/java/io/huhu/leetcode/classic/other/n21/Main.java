package io.huhu.leetcode.classic.other.n21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.luogu.com.cn/problem/T386911">
 * 最长上升子序列输出解
 * </a>
 */
class Main {

    private static final int N = 100001;

    private static int[] nums = new int[N];
    private static int[] ans = new int[N];

    private static int[] end = new int[N];
    private static int[] dp = new int[N];

    public static void main(String[] args) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(System.in)); var writer = new PrintWriter(System.out)) {
            var tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            for (int i = 0; i < n; i++) {
                nums[i] = readInt(tokenizer);
            }
            int k = f(n);
            // 推导最长递增子序列
            Arrays.fill(ans, 0, k, Integer.MAX_VALUE);
            for (int i= 0; i < n; i++) {
                if (dp[i] == k) {
                    ans[0] = nums[i];
                } else {
                    if (ans[k - dp[i] - 1] < nums[i]) {
                        ans[k - dp[i]] = nums[i];
                    }
                }
            }
            // 输出
            for (int i = 0; i < k - 1; i++) {
                writer.print(ans[i] + " ");
            }
            writer.println(ans[k - 1]);
        }
    }

    /**
     * 动态规划求最长递增子序列的长度
     */
    private static int f(int n) {
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            int j = find(i, k);
            if (j == -1) {
                end[k++] = nums[i];
                dp[i] = k;
            } else {
                end[j] = nums[i];
                dp[i] = j + 1;
            }
        }
        return k;
    }

    /**
     * 二分查找
     */
    private static int find(int i, int n) {
        int l = 0, r = n - 1, j = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (end[m] <= nums[i]) {
                j = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return j;
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
