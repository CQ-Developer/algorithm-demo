package io.huhu.newcoder.ZJ24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test1() {
        int[] arr = {3, 4, 3, 2, 4};
        Assertions.assertEquals(4, Main.robotJump(arr));
    }

    @Test
    void test2() {
        int[] arr = {4, 4, 4};
        Assertions.assertEquals(4, Main.robotJump(arr));
    }

    @Test
    void test3() {
        int[] arr = {1, 6, 4};
        Assertions.assertEquals(3, Main.robotJump(arr));
    }

}
