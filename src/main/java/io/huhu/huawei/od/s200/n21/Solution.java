package io.huhu.huawei.od.s200.n21;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                if (levels[j] < levels[i]) {
                    left++;
                }
            }
            int right = 0;
            for (int j = i + 1; j < n; j++) {
                if (levels[j] > levels[i]) {
                    right++;
                }
            }
            ans += left * right;
        }
        System.out.println(ans);
    }

}
