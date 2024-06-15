package io.huhu.huawei.od.s200.n23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135441082">快递员的烦恼</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        Map<Integer, Integer> s2c = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s2c.put(scanner.nextInt(), scanner.nextInt());
        }

        Map<Integer, List<int[]>> c2c = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), dis = scanner.nextInt();
            List<int[]> l1 = c2c.getOrDefault(x, new ArrayList<>());
            l1.add(new int[]{y, dis});
            c2c.put(x, l1);
            List<int[]> l2 = c2c.getOrDefault(y, new ArrayList<>());
            l2.add(new int[]{x, dis});
            c2c.put(y, l2);
        }

        int ans = dfs(s2c, -1, new HashSet<>(), c2c, 0);

        System.out.println(ans);
    }

    private static int dfs(Map<Integer, Integer> s2c, int from, Set<Integer> sent, Map<Integer, List<int[]>> c2c, int path) {
        if (sent.size() == s2c.size()) {
            // check if possible back to station
            int back = s2c.getOrDefault(from, -1);
            if (back == -1) {
                return -1;
            }
            return path + back;
        }

        int ans = Integer.MAX_VALUE;

        // from station
        if (from == -1) {
            for (Map.Entry<Integer, Integer> client : s2c.entrySet()) {
                int id = client.getKey();
                if (sent.contains(id)) {
                    continue;
                }
                sent.add(id);
                int x = dfs(s2c, id, sent, c2c, path + client.getValue());
                sent.remove(id);
                ans = Math.min(ans, x);
            }
        }

        // from client
        else {
            for (int[] client : c2c.getOrDefault(from, new ArrayList<>())) {
                int id = client[0];
                if (sent.contains(id)) {
                    continue;
                }
                int distance = client[1];
                // check if back to station is better
                if (distance > s2c.get(from) + s2c.get(id)) {
                    continue;
                }
                sent.add(id);
                return dfs(s2c, id, sent, c2c, path + distance);
            }
            // back to station only
            return dfs(s2c, -1, sent, c2c, path + s2c.get(from));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
