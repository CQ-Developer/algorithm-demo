package io.huhu.algorithm.fourth.Edition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

class TwoSumTest {

    static final int MAX = 1000000;
    static final int[] ARR = new int[MAX];

    @BeforeAll
    static void before() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.setSeed(System.currentTimeMillis());
        Set<Integer> set = new HashSet<>(MAX);
        while (set.size() < MAX) {
            int i = random.nextInt(-MAX, MAX);
            set.add(i);
        }
        int i = 0;
        for (int j : set) {
            ARR[i++] = j;
        }
    }

    @Test
    void count() {
        // slow
        long s1 = System.currentTimeMillis();
        int c1 = TwoSum.count(ARR);
        long e1 = System.currentTimeMillis() - s1;
        System.out.printf("cost: %dms%n", e1);
        // fast
        long s2 = System.currentTimeMillis();
        int c2 = TwoSum.countFast(ARR);
        long e2 = System.currentTimeMillis() - s2;
        System.out.printf("cost: %dms%n", e2);
        // assert
        Assertions.assertEquals(c1, c2);
        Assertions.assertTrue(e1 > e2);
    }

}
