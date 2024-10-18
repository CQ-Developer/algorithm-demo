package io.huhu.leetcode.n678;

import java.util.ArrayDeque;
import java.util.Deque;

class Stack implements Code {

    @Override
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            int i = left.pop(), j = star.pop();
            if (i > j) {
                return false;
            }
        }
        return left.isEmpty();
    }

}
