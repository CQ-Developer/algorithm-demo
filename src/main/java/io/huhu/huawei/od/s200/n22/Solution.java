package io.huhu.huawei.od.s200.n22;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wa = scanner.nextInt(),
            wb = scanner.nextInt(),
            wt = scanner.nextInt(),
            pa = scanner.nextInt(),
            pb = scanner.nextInt();

        // must have product a & product b
        wt -= wa + wb;
        int profit = pa + pb;

        // search all solution
        int ans = dfs(wt, wa, pa, wb, pb, profit);

        System.out.println(ans);
    }

    private static int dfs(int wt, int wa, int pa, int wb, int pb, int profit) {
        if (wt == 0) {
            return profit;
        }
        if (wt < 0) {
            return 0;
        }
        int a = dfs(wt - wa, wa, pa, wb, pb, profit + pa);
        int b = dfs(wt - wb, wa, pa, wb, pb, profit + pb);
        return Math.max(a, b);
    }

}
