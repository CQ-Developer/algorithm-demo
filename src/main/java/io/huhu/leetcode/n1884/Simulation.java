package io.huhu.leetcode.n1884;

import io.huhu.AC;

@AC
class Simulation implements Code {

    @Override
    public int twoEggDrop(int n) {
        int ans = 0;
        for (int i = 1; n > 0; i++, ans++) {
            n -= i;
        }
        return ans;
    }

}
