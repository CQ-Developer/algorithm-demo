package io.huhu.huawei.od.s200.n18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139456">考古学家考古问题</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] letters = new String[n];
        for (int i = 0; i < n; i++) {
            letters[i] = scanner.next();
        }
        Arrays.sort(letters);
        List<String> ans = new ArrayList<>();
        backtrace(letters, new boolean[n], new StringBuilder(), ans);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static void backtrace(String[] letters, boolean[] used, StringBuilder path, List<String> ans) {
        if (path.length() == letters.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && letters[i].equals(letters[i - 1]) && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.append(letters[i]);
            backtrace(letters, used, path, ans);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

}
