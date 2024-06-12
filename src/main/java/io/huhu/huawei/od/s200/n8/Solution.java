package io.huhu.huawei.od.s200.n8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135119132">查找接口成功率最优时间段</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        String res = findMaxRange(nums, minAverageLost);
        System.out.println(res);
    }

    public static String findMaxRange(int[] nums, int minAverageLost) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i], len = 1;
            for (int j = i + 1; j < nums.length; j++) {
                int a = sum + nums[j], b = len + 1;
                if ((a + b - 1) / b > minAverageLost) {
                    break;
                }
                sum = a;
                len = b;
            }
            int[] cur = {i, i + len - 1};
            if (res.isEmpty()) {
                res.add(cur);
            } else {
                int[] pre = res.getLast();
                if (pre[1] - pre[0] < cur[1] - cur[0]) {
                    res.clear();
                    res.add(cur);
                } else if (pre[1] - pre[0] == cur[1] - cur[0]) {
                    res.add(cur);
                }
            }
        }
        if (res.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            int[] cur = res.get(i);
            sb.append(cur[0]).append("-").append(cur[1]);
            if (i != res.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
