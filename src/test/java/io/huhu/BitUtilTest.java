package io.huhu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitUtilTest {

    @Test
    void swap() {
        int[] arr = {1, 2, 3};
        BitUtil.swap(arr, 0, 2);
        int[] expected = {3, 2, 1};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void isEven() {
        Assertions.assertTrue(BitUtil.isEven(2));
        Assertions.assertFalse(BitUtil.isEven(3));
    }

    @Test
    void abs() {
        Assertions.assertEquals(20, BitUtil.abs(20));
        Assertions.assertEquals(21, BitUtil.abs(-21));
    }

    @Test
    void count1() {
        Assertions.assertEquals(1, BitUtil.count1(1));
        Assertions.assertEquals(1, BitUtil.count1(2));
        Assertions.assertEquals(2, BitUtil.count1(3));
        Assertions.assertEquals(3, BitUtil.count1(7));
    }

    @Test
    void is2n() {
        Assertions.assertTrue(BitUtil.is2n(1));
        Assertions.assertTrue(BitUtil.is2n(2));
        Assertions.assertTrue(BitUtil.is2n(2));
        Assertions.assertTrue(BitUtil.is2n(4));
        Assertions.assertTrue(BitUtil.is2n(8));
        Assertions.assertTrue(BitUtil.is2n(16));
        Assertions.assertTrue(BitUtil.is2n(32));
        Assertions.assertFalse(BitUtil.is2n(3));
        Assertions.assertFalse(BitUtil.is2n(7));
        Assertions.assertFalse(BitUtil.is2n(15));
        Assertions.assertFalse(BitUtil.is2n(31));
    }

}
