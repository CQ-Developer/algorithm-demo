package io.huhu.huawei.od.s100.n7;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = 0, x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('X' == s.charAt(i)) {
                x++;
            }
            if ('Y' == s.charAt(i)) {
                y++;
            }
            if (x == y) {
                ans++;
                x = y = 0;
            }
        }
        System.out.println(ans);
    }

}
