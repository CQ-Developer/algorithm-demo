package io.huhu.leetcode.n823;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DepthFirstSearch implements Code {

    private static final int M = 1000000007;

    @Override
    public int numFactoredBinaryTrees(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        long ans = 0;
        for (int a : arr) {
            ans += f(set, a, new HashMap<>());
        }
        return (int) (ans % M);
    }

    private long f(Set<Integer> arr, int root, Map<Integer, Long> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        long ans = 1;
        for (int a : arr) {
            if (root % a == 0 && arr.contains(root / a)) {
                ans += f(arr, a, map) * f(arr, root / a, map);
            }
        }
        map.put(root, ans);
        return ans;
    }

}
