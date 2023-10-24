package io.huhu.leetcode.n86;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void partition1() {
        var head =
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(5,
                                                        new ListNode(2))))));
        head = solution.partition(head, 3);
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(4, head.val);
        head = head.next;
        assertEquals(3, head.val);
        head = head.next;
        assertEquals(5, head.val);
        head = head.next;
        assertNull(head);
    }

    @Test
    void partition2() {
        var head =
                new ListNode(2,
                        new ListNode(1));
        head = solution.partition(head, 2);
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertNull(head);
    }

}