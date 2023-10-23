package io.huhu.leetcode.n82;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1>
 * 82.删除排序链表中的重复元素II
 * </h1>
 *
 * <p>
 * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表。
 * </p>
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        var tmp = head;
        while (tmp != null) {
            map.compute(tmp.val, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            tmp = tmp.next;
        }
        for (var key : map.keySet()) {
            if (map.get(key) == 1) {
                if (tmp == null) {
                    head = new ListNode(key);
                    tmp = head;
                } else {
                    head.next = new ListNode(key);
                    head = head.next;
                }
            }
        }
        return tmp;
    }

}
