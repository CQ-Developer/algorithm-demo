package io.huhu.huawei.od.s200.n17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 分月饼
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // m个员工, n个月饼
        int m = scanner.nextInt(), n = scanner.nextInt();
        // 每个员工最少分1块月饼
        n -= m;
        int[] employees = new int[m];
        Arrays.fill(employees, 1);
        int ans = dfs(n, employees, new HashSet<>());
        System.out.println(ans);
    }

    private static int dfs(int n, int[] employees, Set<Integer> set) {
        if (n == 0) {
            int pro = 1;
            for (int e : employees) {
                pro *= e;
            }
            return set.add(pro) ? 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < employees.length; i++) {
            if (i == 0 && !canAssign(employees[i], employees[i + 1])) {
                continue;
            }
            if (i == employees.length - 1 && !canAssign(employees[i], employees[i - 1])) {
                continue;
            }
            if (i > 0 && i < employees.length - 1 && !canAssign(employees[i], employees[i - 1], employees[i + 1])) {
                continue;
            }
            employees[i]++;
            ans += dfs(n - 1, employees, set);
            employees[i]--;
        }
        return ans;
    }

    private static boolean canAssign(int a, int b) {
        return Math.abs(a - b) < 3;
    }

    private static boolean canAssign(int a, int b, int c) {
        return canAssign(a, b) && canAssign(a, c);
    }

}
