package io.huhu.leetcode.n1884;

import io.huhu.AC;

@AC
class Simulation implements Code {

    @Override
    public int twoEggDrop(int n) {
        int i = 1;
        for (; n > 0; i++) {
            n -= i;
        }
        return i - 1;
    }

}
