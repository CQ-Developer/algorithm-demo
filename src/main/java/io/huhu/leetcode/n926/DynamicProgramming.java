package io.huhu.leetcode.n926;

class DynamicProgramming implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        int p0 = 0, p1 = 0;
        for (char c : s.toCharArray()) {
            p1 = Math.min(p0, p1) + ('1' - c);
            p0 += c - '0';
        }
        return Math.min(p0, p1);
    }

}
