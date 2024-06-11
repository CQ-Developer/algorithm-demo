package io.huhu.huawei.od.s200.n5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SolutionTest {

    @Test
    void test1() {
        Assertions.assertEquals(3, Solution.doSolution("ABC", "ABC"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(9, Solution.doSolution("ABCABBA", "CBABAC"));
    }

    @Test
    void test3() {
        int n = 1380;
        Random random = new Random(System.currentTimeMillis());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = random.nextInt('A', 'Z' + 1);
            sb.append((char) c);
        }
        String s1 = sb.toString();

        sb.setLength(0);
        for (int i = 0; i < n; i++) {
            int c = random.nextInt('A', 'Z' + 1);
            sb.append((char) c);
        }
        String s2 = sb.toString();

        Solution.doSolution(s1, s2);
    }

}
