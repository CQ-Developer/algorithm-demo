package io.huhu.leetcode.n82;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void deleteDuplicates1() {
        var head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4,
                                                                new ListNode(5)))))));
        head = solution.deleteDuplicates(head);
        Assertions.assertEquals(1, head.val);
        head = head.next;
        Assertions.assertEquals(2, head.val);
        head = head.next;
        Assertions.assertEquals(5, head.val);
        head = head.next;
        Assertions.assertNull(head);
    }

    @Test
    void deleteDuplicates2() {
        var head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3)))));
        head = solution.deleteDuplicates(head);
        Assertions.assertEquals(2, head.val);
        head = head.next;
        Assertions.assertEquals(3, head.val);
        head = head.next;
        Assertions.assertNull(head);
    }

    @Test
    void deleteDuplicates3() {
        var head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4)))));
        head = solution.deleteDuplicates(head);
        Assertions.assertEquals(1, head.val);
        head = head.next;
        Assertions.assertEquals(3, head.val);
        head = head.next;
        Assertions.assertEquals(4, head.val);
        head = head.next;
        Assertions.assertNull(head);
    }

    @Test
    void deleteDuplicates4() {
        var head =
                new ListNode(1,
                        new ListNode(1));
        head = solution.deleteDuplicates(head);
        Assertions.assertNull(head);
    }

    @Test
    void deleteDuplicates5() {
        var head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4))));
        head = solution.deleteDuplicates(head);
        Assertions.assertEquals(1, head.val);
        head = head.next;
        Assertions.assertEquals(2, head.val);
        head = head.next;
        Assertions.assertEquals(3, head.val);
        head = head.next;
        Assertions.assertEquals(4, head.val);
        head = head.next;
        Assertions.assertNull(head);
    }

    @Test
    void deleteDuplicates6() {
        var head =
                new ListNode(-3,
                        new ListNode(-1,
                                new ListNode(0,
                                        new ListNode(0,
                                                new ListNode(0,
                                                        new ListNode(3,
                                                                new ListNode(3)))))));
        head = solution.deleteDuplicates(head);
        Assertions.assertEquals(-3, head.val);
        head = head.next;
        Assertions.assertEquals(-1, head.val);
        head = head.next;
        Assertions.assertNull(head);
    }

}
