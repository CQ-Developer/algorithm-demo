package io.huhu.leetcode.n61;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void rotateRight_1() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        head = solution.rotateRight(head, 2);
        assertEquals(4, head.val);
        head = head.next;
        assertEquals(5, head.val);
        head = head.next;
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(3, head.val);
        head = head.next;
        assertNull(head);
    }

    @Test
    void rotateRight_2() {
        ListNode head = new ListNode(0,
                new ListNode(1,
                        new ListNode(2)));
        head = solution.rotateRight(head, 4);
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(0, head.val);
        head = head.next;
        assertEquals(1, head.val);
        head = head.next;
        assertNull(head);
    }

}
