package io.huhu.leetcode.n838;

import java.util.ArrayList;
import java.util.List;

class BreadthFirstSearch implements Code {

    record Info(int position, int turn, int direction) {}

    @Override
    public String pushDominoes(String dominoes) {
        char[] status = dominoes.toCharArray();
        int n = status.length;
        int[] turns = new int[n];
        List<Info> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (status[i] != '.') {
                int d = status[i] == 'L' ? -1 : 1;
                queue.addLast(new Info(i, 1, d));
                turns[i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            var info = queue.removeFirst();
            int position = info.position;
            if (status[position] == '.') {
                continue;
            }
            int direction = info.direction;
            int neighbor = position + direction;
            if (neighbor < 0 || neighbor >= n) {
                continue;
            }
            int turn = info.turn;
            if (turns[neighbor] == 0) {
                queue.addLast(new Info(neighbor, turn + 1, direction));
                turns[neighbor] = turn + 1;
                status[neighbor] = direction == -1 ? 'L' : 'R';
            } else if (turns[neighbor] == turn + 1) {
                status[neighbor] = '.';
            }
        }
        return String.valueOf(status);
    }

}
