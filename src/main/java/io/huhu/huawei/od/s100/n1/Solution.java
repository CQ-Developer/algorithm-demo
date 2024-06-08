package io.huhu.huawei.od.s100.n1;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] urls = new String[n];
        for (int i = 0; i < n; i++) {
            urls[i] = sc.next();
        }
        int L = sc.nextInt() - 1;
        String keyword = sc.next();
        // do
        int ans = 0;
        for (String url : urls) {
            String[] levels = url.substring(1).split("/");
            if (L < levels.length && keyword.equals(levels[L])) {
                ans++;
            }
        }
        // output
        System.out.println(ans);
    }

}
