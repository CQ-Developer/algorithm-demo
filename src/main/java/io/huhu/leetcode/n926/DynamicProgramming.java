package io.huhu.leetcode.n926;

class DynamicProgramming implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        int p0 = 0, p1 = 0;
        for (char c : s.toCharArray()) {
            int _p0 = p0 + (c == '0' ? 0 : 1);
            p1 = Math.min(p0, p1 + (c == '0' ? 1 : 0));
            p0 = _p0;
        }
        return Math.min(p0, p1);
    }

}
