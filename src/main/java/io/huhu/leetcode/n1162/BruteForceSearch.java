package io.huhu.leetcode.n1162;

import io.huhu.TLE;

import java.util.ArrayList;
import java.util.List;

@TLE
class BruteForceSearch implements Code {

    private record Coordinate(int x, int y) {}

    @Override
    public int maxDistance(int[][] grid) {
        List<Coordinate> sea = new ArrayList<>();
        List<Coordinate> land = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                var index = new Coordinate(i, j);
                if (grid[i][j] == 0) {
                    sea.add(index);
                } else {
                    land.add(index);
                }
            }
        }
        if (sea.isEmpty() || land.isEmpty()) {
            return -1;
        }
        int ans = Integer.MIN_VALUE;
        for (var _sea : sea) {
            int min = Integer.MAX_VALUE;
            for (var _land : land) {
                min = Math.min(min, Math.abs(_sea.x - _land.x) + Math.abs(_sea.y - _land.y));
            }
            ans = Math.max(ans, min);
        }
        return ans;
    }

}
