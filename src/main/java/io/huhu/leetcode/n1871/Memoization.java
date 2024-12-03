package io.huhu.leetcode.n1871;

import io.huhu.TLE;

@TLE
class Memoization implements Code {

    @Override
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c = s.toCharArray();
        int n = c.length;
        if (c[n - 1] == '1') {
            return false;
        }
        return f(c, minJump, maxJump, new int[n], 0);
    }

    private boolean f(char[] s, int min, int max, int[] mem, int i) {
        if (i == s.length - 1) {
            return true;
        }
        if (mem[i] != 0) {
            return mem[i] == 1;
        }
        int f = i + min, t = Math.min(i + max, s.length - 1);
        for (int j = t; j >= f; j--) {
            if (s[j] == '0' && f(s, min, max, mem, j)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = -1;
        return false;
    }

}
