package io.huhu.leetcode.n1227;

class Mathematics implements Code {

    @Override
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }

}
