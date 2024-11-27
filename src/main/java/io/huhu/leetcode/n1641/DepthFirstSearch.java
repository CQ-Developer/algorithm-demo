package io.huhu.leetcode.n1641;

import io.huhu.AC;

@AC
class DepthFirstSearch implements Code {

    @Override
    public int countVowelStrings(int n) {
        return f(n, 0, 0);
    }

    private int f(int n, int i, int j) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int k = j; k < 5; k++) {
            ans += f(n, i + 1, k);
        }
        return ans;
    }

}
