package io.huhu.huawei.od.s200.n3;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int N = scanner.nextInt();
        int ans = dfs(numbers, N, 0, numbers.length - 1, 0, new HashMap<>());
        System.out.println(ans);
    }

    public static int dfs(int[] numbers, int n, int l, int r, int ans, Map<Integer, Integer> cache) {
        if (n == 0) {
            return ans;
        }
        if (cache.containsKey(n)) {
            System.out.println("hit");
            return cache.get(n);
        }
        int i = dfs(numbers, n - 1, l + 1, r, ans + numbers[l], cache);
        int j = dfs(numbers, n - 1, l, r - 1, ans + numbers[r], cache);
        int max = Math.max(i, j);
        if (cache.containsKey(n)) {
            cache.put(n, Math.max(cache.get(n), max));
        }
        return max;
    }

}
