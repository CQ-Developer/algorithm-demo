package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Assertions.assertEquals(3, solution.maxEnvelopes(envelopes));
    }

    @Test
    void test_2() {
        int[][] envelopes = {{1, 1}, {1, 1}, {1, 1}};
        Assertions.assertEquals(1, solution.maxEnvelopes(envelopes));
    }

    @Test
    void test_3() throws Exception {
        var classLoader = SolutionTest.class.getClassLoader();
        var builder = new StringBuilder();
        try (var reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("n354.txt")))) {
            String s;
            while ((s = reader.readLine()) != null) {
                builder.append(s);
            }
        }
        String[] s = builder.toString().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        int[][] envelopes = new int[s.length >> 1][2];
        for (int i = 0, j = 0, k = 0; i < s.length; i++, j = i >> 1, k ^= 1) {
            envelopes[j][k] = Integer.parseInt(s[i]);
        }
        Assertions.assertEquals(100000, solution.maxEnvelopes(envelopes));
    }

}
