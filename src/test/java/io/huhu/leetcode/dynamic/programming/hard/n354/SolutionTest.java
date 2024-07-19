package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

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
        String[] s = loadFile("n354/1.txt").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        int[][] envelopes = new int[s.length >> 1][2];
        for (int i = 0, j = 0, k = 0; i < s.length; i++, j = i >> 1, k ^= 1) {
            envelopes[j][k] = Integer.parseInt(s[i]);
        }
        Assertions.assertEquals(100000, solution.maxEnvelopes(envelopes));
    }

    @Test
    void test_4() throws Exception {
        String[] s = loadFile("n354/2.txt").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        int[][] envelopes = new int[s.length >> 1][2];
        for (int i = 0, j = 0, k = 0; i < s.length; i++, j = i >> 1, k ^= 1) {
            envelopes[j][k] = Integer.parseInt(s[i]);
        }
        Assertions.assertEquals(35, solution.maxEnvelopes(envelopes));
    }

    String loadFile(String filename) throws IOException {
        ClassLoader classLoader = SolutionTest.class.getClassLoader();
        StringBuilder builder = new StringBuilder();
        try (var reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filename)))) {
            String s;
            while ((s = reader.readLine()) != null) {
                builder.append(s);
            }
        }
        return builder.toString();
    }

}
