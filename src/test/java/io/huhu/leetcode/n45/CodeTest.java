package io.huhu.leetcode.n45;

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
        int[] nums = {2, 3, 1, 1, 4};
        Assertions.assertEquals(2, code.jump(nums));
    }

    @Test
    void test_2() {    
        int[] nums = {2,3,0,1,4};
        Assertions.assertEquals(2, code.jump(nums));
    }

}
