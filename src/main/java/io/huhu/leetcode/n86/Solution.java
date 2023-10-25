package io.huhu.leetcode.n86;

/**
 * <h1>
 * 86.分割链表
 * </h1>
 *
 * <p>
 * 给你一个链表的头节点head和一个特定值x，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * 链表中节点的数目在范围[0,200]内
 * <br/>
 * -100 <= Node.val <= 100
 * <br/>
 * -200 <= x <= 200
 * </p>
 */
class Solution {

    /**
     * 双指针
     */
    public ListNode partition(ListNode head, int x) {
        var h = new ListNode();
        var i = h;
        var b = new ListNode();
        var j = b;
        while (head != null) {
            if (head.val < x) {
                i.next = head;
                i = i.next;
            } else {
                j.next = head;
                j = j.next;
            }
            head = head.next;
        }
        j.next = null;
        i.next = b.next;
        return h.next;
    }

}
