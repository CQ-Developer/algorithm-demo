package io.huhu.leetcode.n1578;

class DynamicProgramming implements Code {

    @Override
    public int minCost(String colors, int[] neededTime) {
        char[] _colors = colors.toCharArray();
        int f = 0;
        for (int i = 1; i < _colors.length; i++) {
            if (_colors[i] == _colors[i - 1]) {
                if (neededTime[i] >= neededTime[i - 1]) {
                    f += neededTime[i - 1];
                } else {
                    f += neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                }
            }
        }
        return f;
    }

}
