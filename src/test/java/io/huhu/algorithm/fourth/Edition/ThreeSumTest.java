package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    final int[] arr = CommonUtils.generateArray(5000);

    @Test
    void count() {
        // slow
        long s1 = System.currentTimeMillis();
        int c1 = ThreeSum.count(arr);
        long e1 = System.currentTimeMillis() - s1;
        System.out.printf("cost: %dms%n", e1);
        // fast
        long s2 = System.currentTimeMillis();
        int c2 = ThreeSum.countFast(arr);
        long e2 = System.currentTimeMillis() - s2;
        System.out.printf("cost: %dms%n", e2);
        // assert
        Assertions.assertEquals(c1, c2);
        Assertions.assertTrue(e1 > e2);
    }

}
