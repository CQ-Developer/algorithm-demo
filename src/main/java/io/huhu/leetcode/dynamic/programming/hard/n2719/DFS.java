package io.huhu.leetcode.dynamic.programming.hard.n2719;

class DFS implements Solution {

    private static final int M = (int) 1E9 + 7;

    @Override
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int large = count(num2.toCharArray(), min_sum, max_sum);
        char[] chars = num1.toCharArray();
        int small = count(chars, min_sum, max_sum);
        int ans = (large - small + M) % M;
        if (check(chars, min_sum, max_sum)) {
            ans = (ans + 1) % M;
        }
        return ans;
    }

    private int count(char[] num, int min, int max) {
        return dfs(num, min, max, 0, 0, 0);
    }

    private int dfs(char[] num, int min, int max, int i, int free, int sum) {
        if (sum > max || sum + (num.length - i) * 9 < min) {
            return 0;
        }
        if (i == num.length) {
            return 1;
        }
        int ans = 0, cur = num[i] - '0';
        if (free == 0) {
            for (int p = 0; p < cur; p++) {
                ans = (ans + dfs(num, min, max, i + 1, 1, sum + p)) % M;
            }
            ans = (ans + dfs(num, min, max, i + 1, 0, sum + cur)) % M;
        } else {
            for (int p = 0; p <= 9; p++) {
                ans = (ans + dfs(num, min, max, i + 1, 1, sum + p)) % M;
            }
        }
        return ans;
    }

    private boolean check(char[] num, int min, int max) {
        int sum = 0;
        for (char c : num) {
            sum += c - '0';
        }
        return min <= sum && sum <= max;
    }

}
