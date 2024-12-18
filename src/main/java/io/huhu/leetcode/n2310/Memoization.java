package io.huhu.leetcode.n2310;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Solution {

    @Override
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if (k == 0) {
            return num % 10 == 0 ? 1 : -1;
        }
        int[] mem = new int[num + 1];
        Arrays.fill(mem, -1);
        int res = f(num, k, mem);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int f(int num, int k, int[] mem) {
        if (num == 0) {
            return 0;
        }
        if (mem[num] != -1) {
            return mem[num];
        }
        int res = Integer.MAX_VALUE;
        for (int i = k; i <= num; i += 10) {
            if (num - i >= 0) {
                int _res = f(num - i, k, mem);
                if (_res != Integer.MAX_VALUE) {
                    res = Math.min(res, _res + 1);
                }
            }
        }
        return mem[num] = res;
    }

}
