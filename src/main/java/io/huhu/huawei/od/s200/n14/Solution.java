package io.huhu.huawei.od.s200.n14;

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
                    String ans = dfs(grid, i, j, letters, 0, new StringBuilder());
                    if ("N".equals(ans)) {
                        continue;
                    }
                    return ans;
                }
            }
        }
        return "N";
    }

    private static String dfs(char[][] grid, int i, int j, char[] word, int k, StringBuilder path) {
        if (k == word.length) {
            return path.substring(0, path.length() - 1);
        }
        if (i < 0 || i >= grid.length) {
            return "N";
        }
        if (j < 0 || j >= grid[i].length) {
            return "N";
        }
        if (grid[i][j] != word[k]) {
            return "N";
        }
        char c = grid[i][j];
        grid[i][j] = '.';
        path.append(i).append(',').append(j).append(',');
        String ans = dfs(grid, i - 1, j, word, k + 1, path);
        if (!"N".equals(ans)) {
            return ans;
        }
        ans = dfs(grid, i + 1, j, word, k + 1, path);
        if (!"N".equals(ans)) {
            return ans;
        }
        ans = dfs(grid, i, j - 1, word, k + 1, path);
        if (!"N".equals(ans)) {
            return ans;
        }
        ans =  dfs(grid, i, j + 1, word, k + 1, path);
        if (!"N".equals(ans)) {
            return ans;
        }
        grid[i][j] = c;
        path.setLength(path.length() - 4);
        return ans;
    }

}
