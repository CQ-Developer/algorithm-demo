package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GreedyAlgorithmTest {

    @Test
    void cover() {
        Set<String> set = new HashSet<>();
        set.add("kfour");
        set.add("ktwo");
        set.add("kthree");
        set.add("kfive");
        assertIterableEquals(set, GreedyAlgorithm.cover());
    }

}
