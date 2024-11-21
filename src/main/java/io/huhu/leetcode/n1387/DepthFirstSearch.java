package io.huhu.leetcode.n1387;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DepthFirstSearch implements Code {

    private static final Map<Integer, Integer> MEM = new HashMap<>();

    @Override
    public int getKth(int lo, int hi, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            nums.add(i);
        }
        nums.sort(this::compare);
        return nums.get(k - 1);
    }

    private int compare(int a, int b) {
        int _a = f(a), _b = f(b);
        return _a == _b ? a - b : _a - _b;
    }

    private int f(int num) {
        if (num == 1) {
            return 0;
        }
        if (MEM.containsKey(num)) {
            return MEM.get(num);
        }
        int ans = num % 2 == 0 ? f(num / 2) + 1 : f(num * 3 + 1) + 1;
        MEM.put(num, ans);
        return ans;
    }

}
