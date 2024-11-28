package io.huhu.leetcode.n1654;

import io.huhu.AC;

@AC
class DepthFirstSearch implements Code {

    private int ans = -1;

    @Override
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[] _forbidden = new int[6001];
        for (int i : forbidden) {
            _forbidden[i] = 1;
        }
        f(_forbidden, a, b, x, 0, true, 0);
        return ans;
    }

    private void f(int[] forbidden, int a, int b, int x, int i, boolean d, int _ans) {
        if (i == x) {
            ans = _ans;
        } else {
            if (i + a <= 6000 && forbidden[i + a] == 0) {
                forbidden[i + a] = 1;
                f(forbidden, a, b, x, i + a, true, _ans + 1);
            }
            if (d && i - b >= 0 && forbidden[i - b] == 0) {
                f(forbidden, a, b, x, i - b, false, _ans + 1);
            }
        }
    }

}
