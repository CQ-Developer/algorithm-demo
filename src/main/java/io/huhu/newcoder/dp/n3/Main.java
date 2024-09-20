package io.huhu.newcoder.dp.n3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/30fb9b3cab9742ecae9acda1c75bf927">
 * 最长递增子序列
 * </a>
 */
class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter writer = new PrintWriter(System.out)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            int n = readInt(tokenizer);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = readInt(tokenizer);
            }
            int[] dp = new int[n];
            int k = f(nums, n, dp);
            int[] ans = new int[k];
            Arrays.fill(ans, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                if (dp[i] == k) {
                    ans[0] = nums[i];
                } else {
                    if (ans[k - dp[i] - 1] < nums[i]) {
                        ans[k - dp[i]] = nums[i];
                    }
                }
            }
            for (int i = 0; i < k - 1; i++) {
                writer.print(ans[i] + " ");
            }
            writer.println(ans[k - 1]);
        }
    }

    private static int f(int[] nums, int n, int[] dp) {
        int k = 0;
        int[] end = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = find(nums[i], k, end);
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

    private static int find(int num, int n, int[] end) {
        int l = 0, r = n - 1, i = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (end[m] <= num) {
                i = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return i;
    }

    private static int readInt(StreamTokenizer tokenizer) throws Exception {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

}
