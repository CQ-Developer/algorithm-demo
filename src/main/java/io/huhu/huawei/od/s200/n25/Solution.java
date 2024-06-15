package io.huhu.huawei.od.s200.n25;

import java.util.Scanner;

/**
 * 员工派遣
 */
class Solution {

    private static int x;
    private static int y;
    private static int cntX;
    private static int cntY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        cntX = scanner.nextInt();
        cntY = scanner.nextInt();

        int min = cntX + cntY, max = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (check(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    private static boolean check(int k) {
        int a = k / x;
        int b = k / y;
        int c = k / (x * y);
        return k - (a + b - c) >= Math.max(0, cntX - (b - c)) + Math.max(0, cntY - (a - c));
    }

}
