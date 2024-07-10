package io.huhu.leetcode.binary.search.hard.n2141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int[] batteries = {3, 3, 3};
        Assertions.assertEquals(4, solution.maxRunTime(2, batteries));
    }

    @Test
    void test2() {
        int[] batteries = {1, 1, 1, 1};
        Assertions.assertEquals(2, solution.maxRunTime(2, batteries));
    }

    @Test
    void test3() throws Exception {
        URL url = SolutionTest.class.getClassLoader().getResource("n2141.txt");
        if (Objects.isNull(url)) {
            return;
        }
        Path path = Paths.get(url.getFile());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            String[] s = line.split(",");
            int[] batteries = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                batteries[i] = Integer.parseInt(s[i]);
            }
            Assertions.assertEquals(318353, solution.maxRunTime(5099, batteries));
        }
    }

}
