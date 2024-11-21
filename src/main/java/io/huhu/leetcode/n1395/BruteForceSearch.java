package io.huhu.leetcode.n1395;

class BruteForceSearch implements Code {

    @Override
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int less = 0, more = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    less++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) {
                    more++;
                }
            }
            ans += less * more;
            less = more = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] > rating[i]) {
                    more++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    less++;
                }
            }
            ans += less * more;
        }
        return ans;
    }

}
