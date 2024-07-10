package io.huhu.newcoder.ZJ24;

import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/7037a3d57bbd4336856b8e16a9cafd71">
 * 机器人跳跃问题
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int ans = robotJump(arr);
        System.out.println(ans);
    }

    public static int robotJump(int[] arr) {
        int l = 1, r = 0;
        for (int i : arr) {
            r = Math.max(r, i);
        }
        int ans = 0, max = r;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (f(arr, m, max)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private static boolean f(int[] arr, int m, int max) {
        for (int i : arr) {
            m += m - i;
            if (m >= max) {
                return true;
            }
            if (m < 0) {
                return false;
            }
        }
        return true;
    }

}
