package io.huhu.leetcode.n1654;

import io.huhu.AC;

import java.util.ArrayDeque;

@AC
class BreadthFirstSearch implements Code {

    private static final int N = 6000;

    @Override
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        var visited = new boolean[N][2];
        visited[0][0] = true;
        for (int i : forbidden) {
            visited[i][0] = visited[i][1] = true;
        }
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{0, 0});
        for (int step = 0; !queue.isEmpty(); step++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int p = cur[0];
                if (p == x) {
                    return step;
                }
                int _p = p + a;
                if (_p < N && !visited[_p][0]) {
                    visited[_p][0] = true;
                    queue.add(new int[]{_p, 0});
                }
                _p = p - b;
                if (_p >= 0 && cur[1] == 0 && !visited[_p][1]) {
                    visited[_p][1] = true;
                    queue.add(new int[]{_p, 1});
                }
            }
        }
        return -1;
    }

}
