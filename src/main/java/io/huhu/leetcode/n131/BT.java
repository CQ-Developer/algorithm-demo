package io.huhu.leetcode.n131;

import java.util.ArrayList;
import java.util.List;

class BT implements Code {

    @Override
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        f(s.toCharArray(), 0, new ArrayList<>(), ans);
        return ans;
    }

    private void f(char[] s, int i, List<String> path, List<List<String>> ans) {
        if (i == s.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length; j++) {
            if (isPalindrome(s, i, j)) {
                path.add(String.valueOf(s, i, j - i + 1));
                f(s, j + 1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(char[] s, int l, int r) {
        while (l <= r) {
            if (s[l++] != s[r--]) {
                return false;
            }
        }
        return true;
    }

}
