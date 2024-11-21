package io.huhu.leetcode.n1387;

import io.huhu.AC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AC
class DepthFirstSearch implements Code {

    private static final Map<Integer, Integer> MEM = new HashMap<>();

    private record Info(int num, int wei) implements Comparable<Info> {

        @Override
        public int compareTo(Info other) {
            return this.wei == other.wei ? this.num - other.num : this.wei - other.wei;
        }

    }

    @Override
    public int getKth(int lo, int hi, int k) {
        Info[] arr = new Info[hi - lo + 1];
        for (int i = 0, j = lo; j <= hi; i++, j++) {
            arr[i] = new Info(j, f(j));
        }
        Arrays.sort(arr);
        return arr[k - 1].num();
    }

    private int f(int num) {
        if (num == 1) {
            return 0;
        }
        if (MEM.containsKey(num)) {
            return MEM.get(num);
        }
        int ans = (num & 1) == 0 ? f(num >> 1) + 1 : f(num * 3 + 1) + 1;
        MEM.put(num, ans);
        return ans;
    }

}
