package io.huhu.leetcode.dynamic.programming.hard.n2435;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int[][] grid = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        int k = 3;
        Assertions.assertEquals(2, solution.numberOfPaths(grid, k));
    }

    @Test
    void test2() {
        int[][] grid = {{0, 0}};
        int k = 5;
        Assertions.assertEquals(1, solution.numberOfPaths(grid, k));
    }

    @Test
    void test3() {
        int[][] grid = {{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}};
        int k = 1;
        Assertions.assertEquals(10, solution.numberOfPaths(grid, k));
    }

    @Test
    void test4() throws Exception {
        URL url = SolutionTest.class.getClassLoader().getResource("n2435.txt");
        if (url == null) {
            return;
        }
        List<String> lines = Files.readAllLines(Paths.get(url.toURI()));
        int[][] grid = new int[lines.size()][];
        for (int i = 0; i < grid.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(lines.get(i), ",");
            grid[i] = new int[tokenizer.countTokens()];
            int j = 0;
            while (tokenizer.hasMoreTokens()) {
                grid[i][j++] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int k = 4;
        Assertions.assertEquals(365124505, solution.numberOfPaths(grid, k));
    }

}
