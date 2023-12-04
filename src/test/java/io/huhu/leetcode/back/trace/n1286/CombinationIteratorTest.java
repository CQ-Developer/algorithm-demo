package io.huhu.leetcode.back.trace.n1286;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombinationIteratorTest {

    CombinationIterator iterator;

    @Test
    void run() {
        iterator = new CombinationIterator("abc", 2);
        Assertions.assertEquals("ab", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("ac", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("bc", iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

}
