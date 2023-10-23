package io.huhu.leetcode.n82;

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
        var tmp = new ListNode(101, head);
        boolean first = true;
        while (tmp.next != null) {
            int count = 1;
            var i = tmp.next;
            while (i.next != null && i.val == i.next.val) {
                count++;
                i = i.next;
            }
            if (count > 1) {
                for (int j = 0; tmp.next != null && j < count; j++) {
                    tmp.next = tmp.next.next;
                }
            } else {
                tmp = tmp.next;
            }
            if (tmp.val == 101 && tmp.next == null) {
                return null;
            }
            if (count == 1 && first) {
                head = tmp.val == 101 ? tmp.next : tmp;
                first = false;
            }
        }
        return head;
    }

}
