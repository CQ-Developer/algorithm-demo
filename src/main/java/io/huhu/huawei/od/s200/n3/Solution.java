package io.huhu.huawei.od.s200.n3;

import java.util.Scanner;

/**
 * 贪吃的猴子
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int N = scanner.nextInt();
        int ans = dfs(numbers, N, 0, numbers.length - 1, 0);
        System.out.println(ans);
    }

    public static int dfs(int[] numbers, int n, int l, int r, int ans) {
        if (n == 0) {
            return ans;
        }
        if (numbers[l] > numbers[r]) {
            return dfs(numbers, n - 1, l + 1, r, ans + numbers[l]);
        }
        if (numbers[l] < numbers[r]) {
            return dfs(numbers, n - 1, l, r - 1, ans + numbers[r]);
        }
        return Math.max(dfs(numbers, n - 1, l + 1, r, ans + numbers[l]), dfs(numbers, n - 1, l, r - 1, ans + numbers[r]));
    }

}
