package io.huhu.huawei.od.s100.n5;

import java.util.Scanner;

/**
 * 停车场车辆统计
 */
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] cars = str.split(",");
        int ans = 0, count = 0;
        for (String car : cars) {
            if ("1".equals(car)) {
                count++;
                continue;
            }
            if (count > 0) {
                ans += sum(count);
            }
            count = 0;
        }
        if (count > 0) {
            ans += sum(count);
        }
        System.out.println(ans);
    }

    private static int sum(int count) {
        if (count > 3) {
            return count / 3 + 1;
        }
        return 1;
    }

}
