package io.huhu.huawei.od.s200.n19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139483">数据最节约的备份方法</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(",");
        int total = 0;
        int[] file = new int[arr.length];
        for (int i = 0; i < file.length; i++) {
            total += file[i] = Integer.parseInt(arr[i]);
        }
        if (total <= 500) {
            System.out.println(1);
            return;
        }
        Arrays.sort(file);
        int l = (total + 500 - 1) / 500, r = file.length, ans = r;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (dfs(new int[m], Arrays.copyOf(file, file.length), total)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int[] disk, int[] file, int total) {
        if (total == 0) {
            return true;
        }
        for (int i = 0, j = 0; i < file.length; i++) {
            if (file[i] == 0) {
                continue;
            }
            boolean can = false;
            while (j < disk.length && !can) {
                if (disk[j++] + file[i] <= 500) {
                    can = true;
                }
            }
            if (!can) {
                continue;
            }
            int f = file[i];
            disk[j - 1] += f;
            file[i] = 0;
            if (dfs(disk, file, total - f)) {
                return true;
            }
            file[i] = f;
            disk[j - 1] -= f;
        }
        return false;
    }

}
