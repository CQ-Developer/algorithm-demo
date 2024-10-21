package io.huhu.leetcode.n718;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        int[] nums1 = {1, 2, 3, 2, 1}, nums2 = {3, 2, 1, 4, 7};
        Assertions.assertEquals(3, code.findLength(nums1, nums2));
    }

    @Test
    void test_2() {
        int[] nums1 = {0, 0, 0, 0, 0}, nums2 = {0, 0, 0, 0, 0};
        Assertions.assertEquals(5, code.findLength(nums1, nums2));
    }

}