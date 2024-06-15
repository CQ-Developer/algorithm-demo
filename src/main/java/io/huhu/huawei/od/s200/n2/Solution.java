package io.huhu.huawei.od.s200.n2;

import java.util.Scanner;

/**
 * 部门人力建设
 */
class Solution {

    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        String[] s = scanner.nextLine().split(" ");
        int l = 0, r = 0;
        int[] requirements = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            requirements[i] = Integer.parseInt(s[i]);
            l = Math.max(l, requirements[i]);
            r += requirements[i];
        }
        // 算法
        while (l < r) {
            int m = (l + r) >> 1;
            if (check(requirements, m) <= M) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // 输出
        System.out.println(l);
    }

    public static int check(int[] requirements, int m) {
        int l = 0, r = requirements.length - 1, ans = 0;
        while (l <= r) {
            if (requirements[l] + requirements[r] <= m) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }

}
