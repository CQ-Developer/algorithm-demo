package io.huhu.leetcode.n788;

import java.util.Arrays;
import java.util.Map;

class Exhaustion implements Code {

    private static final Map<Character, Character> MAP = Map.ofEntries(
            Map.entry('0', '0'), Map.entry('1', '1'), Map.entry('8', '8'),
            Map.entry('2', '5'), Map.entry('5', '2'),
            Map.entry('6', '9'), Map.entry('9', '6'));

    @Override
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(String.valueOf(i).toCharArray())) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(char[] num) {
        int n = num.length;
        char[] rotate = Arrays.copyOf(num, n);
        for (int i = 0; i < n; i++) {
            if (!MAP.containsKey(num[i])) {
                return false;
            }
            rotate[i] = MAP.get(num[i]);
        }
        return !Arrays.equals(rotate, num);
    }

}
