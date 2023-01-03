package io.huhu.algorithm.demo.linked.list;

import java.util.Stack;

/**
 * 双向链表
 */
public class TwoWayLinkedList {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
