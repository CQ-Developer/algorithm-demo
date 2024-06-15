package io.huhu.huawei.od.s200.n16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 项目排期
 */
class Solution {

    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int total = 0;
        int[] works = new int[s.length];
        for (int i = 0; i < works.length; i++) {
            total += works[i] = Integer.parseInt(s[i]);
        }
        // 将数组从大到小排列
        Arrays.sort(works);
        int l = 0, r = works.length - 1;
        while (l < r) {
            int t = works[l];
            works[l++] = works[r];
            works[r--] = t;
        }
        int n = Integer.parseInt(scanner.nextLine());
        // 最好的分配方式是尽量均分(向上取整)
        // 最差的分配方式是将所有任务分给一个人
        int best = (total + n - 1) / n;
        while (best <= total) {
            if (dfs(total, works, new boolean[works.length], new int[n], best)) {
                break;
            }
            best++;
        }
        // 输出
        System.out.println(best);
    }

    private static boolean dfs(int total, int[] works, boolean[] used, int[] n, int best) {
        if (total == 0) {
            return true;
        }
        for (int i = 0, j = 0; i < works.length; i++) {
            if (used[i]) {
                continue;
            }
            // 是否能将工作分配给j员工
            boolean can = false;
            while (j < n.length && !can) {
                if (n[j++] + works[i] <= best) {
                    can = true;
                }
            }
            // backtrace
            if (can) {
                used[i] = true;
                n[j] += works[i];
                if (dfs(total - works[i], works, used, n, best)) {
                    return true;
                }
                used[i] = false;
                n[j] -= works[i];
            }
        }
        return false;
    }

}
