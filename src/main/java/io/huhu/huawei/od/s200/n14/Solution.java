package io.huhu.huawei.od.s200.n14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139388">找单词</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        int n = Integer.parseInt(scanner.nextLine());
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int len = (s.length() + 2) >> 1;
            char[] chars = new char[len];
            for (int j = 0, k = 0; j < s.length(); j += 2) {
                chars[k++] = s.charAt(j);
            }
            grid[i] = chars;
        }
        String word = scanner.nextLine();
        String result = findWord(grid, word);
        System.out.println(result);
    }

    public static String findWord(char[][] grid, String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == letters[0]) {
                    String ans = dfs(grid, i, j, letters, 0, new ArrayList<>());
                    if ("N".equals(ans)) {
                        continue;
                    }
                    return ans;
                }
            }
        }
        return "N";
    }

    private static String dfs(char[][] grid, int i, int j, char[] word, int k, List<Integer> path) {
        path.addLast(i);
        path.addLast(j);
        if (k == word.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int l = 0; l < path.size(); l++) {
                sb.append(path.get(l));
                if (l != path.size() - 1) {
                    sb.append(',');
                }
            }
            return sb.toString();
        }
        char c = grid[i][j];
        grid[i][j] = '.';
        if (i - 1 >= 0 && grid[i - 1][j] == word[k + 1]) {
            String ans = dfs(grid, i - 1, j, word, k + 1, path);
            if (!"N".equals(ans)) {
                return ans;
            }
        }
        if (i + 1 < grid.length && grid[i + 1][j] == word[k + 1]) {
            String ans = dfs(grid, i + 1, j, word, k + 1, path);
            if (!"N".equals(ans)) {
                return ans;
            }
        }
        if (j - 1 >= 0 && grid[i][j - 1] == word[k + 1]) {
            String ans = dfs(grid, i, j - 1, word, k + 1, path);
            if (!"N".equals(ans)) {
                return ans;
            }
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == word[k + 1]) {
            String ans = dfs(grid, i, j + 1, word, k + 1, path);
            if (!"N".equals(ans)) {
                return ans;
            }
        }
        grid[i][j] = c;
        path.removeLast();
        path.removeLast();
        return "N";
    }

}
