package io.huhu.huawei.od.s200.n2;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int N = split.length;
        int[] requirements = new int[N];
        for (int i = 0; i < N; i++) {
            requirements[i] = Integer.parseInt(split[i]);
        }
        int min = new Solution().doSolution(M, requirements);
        System.out.println(min);
    }

    public int doSolution(int m, int[] requirements) {
        Arrays.sort(requirements);
        return test(m, requirements, requirements[requirements.length - 1]);
    }

    private int test(int m, int[] requirements, int hr) {
        int l = 0, r = requirements.length - 1, cnt = 0;
        while (l < r) {
            if (requirements[l] + requirements[r] <= hr) {
                l++;
            }
            r--;
            cnt++;
        }
        // 相等表示需要单独加一天完成当前的任务
        if (l == r) {
            cnt++;
        }
        if (cnt <= m) {
            return hr;
        }
        return test(m, requirements, hr + 1);
    }

}
