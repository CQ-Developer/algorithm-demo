package io.huhu.leetcode.n83;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void deleteDuplicated1() {
        var head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2)));
        head = solution.deleteDuplicated(head);
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertNull(head);
    }

    @Test
    void deleteDuplicated2() {
        var head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(3)))));
        head = solution.deleteDuplicated(head);
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(3, head.val);
        head = head.next;
        assertNull(head);
    }

    @Test
    void deleteDuplicated3() {
        var head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1)));
        head = solution.deleteDuplicated(head);
        assertEquals(1, head.val);
        head = head.next;
        assertNull(head);
    }

}