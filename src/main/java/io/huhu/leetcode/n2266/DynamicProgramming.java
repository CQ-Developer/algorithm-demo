package io.huhu.leetcode.n2266;

import java.util.ArrayList;
import java.util.List;

class DynamicProgramming implements Solution {

    private static final int M = 1_000_000_007;

    @Override
    public int countTexts(String pressedKeys) {
        char[] chars = pressedKeys.toCharArray();
        int len = chars.length;

        int max3 = 0, max4 = 0;
        List<Integer> list3 = new ArrayList<>(), list4 = new ArrayList<>();
        for (int i = 0, cnt = 0; i < len; i++) {
            cnt++;
            if (i == len - 1 || chars[i] != chars[i + 1]) {
                if (chars[i] == '7' || chars[i] == '9') {
                    list4.add(cnt);
                    max4 = Math.max(max4, cnt);
                } else {
                    list3.add(cnt);
                    max3 = Math.max(max3, cnt);
                }
                cnt = 0;
            }
        }

        long[] f3 = new long[max3 + 4], f4 = new long[max4 + 4];
        f3[0] = f4[0] = 1;
        f3[1] = f4[1] = 1;
        f3[2] = f4[2] = 2;
        f3[3] = f4[3] = 4;
        for (int i = 4; i <= max3; i++) {
            f3[i] = (f3[i - 1] + f3[i - 2] + f3[i - 3]) % M;
        }
        for (int i = 4; i <= max4; i++) {
            f4[i] = (f4[i - 1] + f4[i - 2] + f4[i - 3] + f4[i - 4]) % M;
        }

        long res = 1;
        for (int i : list3) {
            res = (res * f3[i]) % M;
        }
        for (int i : list4) {
            res = (res * f4[i]) % M;
        }
        return (int) res;
    }

}
