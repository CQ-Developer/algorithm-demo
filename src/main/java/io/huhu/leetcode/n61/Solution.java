package io.huhu.leetcode.n61;

/**
 * <h1>61.旋转链表</h1>
 * <p>给你一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置。</p>
 * <p>示例1：<br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" width="512"><br>
 * 输入：head=[1,2,3,4,5], k=2<br>
 * 输出：[4,5,1,2,3]</p>
 * <p>示例2：<br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" width="512"><br>
 * 输入：head=[0,1,2], k=4<br>
 * 输出：[2,0,1]</p>
 * <p>提示：<br>
 * 链表中节点的数目在范围[0,500]<br>
 * <b>-100 <= Node.val <= 100</b><br>
 * <b>0 <= k <= 2*10<sup>9</sup></b></p>
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 将链表变成环
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        // 找到新的头节点
        int i = 0;
        ListNode newHead = head;
        while (i < k) {
            newHead = newHead.next;
            i++;
        }
        // 断开头节点的前一个节点
        ListNode pre = newHead;
        newHead = newHead.next;
        pre.next = null;
        return newHead;
    }

}
