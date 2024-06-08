package io.huhu.nowcoder.linked.list.BM1;

/**
 * <a href="https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany"></a>
 */
class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode h = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = h;
            h = head;
            head = n;
        }
        return h;
    }

}
