package io.huhu.nowcoder.linked.list.BM1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(3);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        ListNode actual = this.solution.ReverseList(n1);

        n2 = new ListNode(2);
        n2.next = new ListNode(1);
        ListNode expected = new ListNode(3);
        expected.next = n2;

        while (actual != null && expected != null) {
            Assertions.assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }

        Assertions.assertNull(expected);
        Assertions.assertNull(actual);
    }

}