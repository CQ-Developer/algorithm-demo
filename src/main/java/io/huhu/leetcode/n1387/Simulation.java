package io.huhu.leetcode.n1387;

import java.util.Arrays;

class Simulation implements Code {

    @Override
    public int getKth(int lo, int hi, int k) {
        int offset = 0;
        int[][] arr = new int[hi - lo + 1][];
        for (int i = 0; i < arr.length; i++) {
            int num = lo + offset++, _num = num, step = 0;
            while (_num > 1) {
                _num = _num % 2 == 0 ? _num / 2 : _num * 3 + 1;
                step++;
            }
            arr[i] = new int[]{num, step};
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        return arr[k - 1][0];
    }

}
