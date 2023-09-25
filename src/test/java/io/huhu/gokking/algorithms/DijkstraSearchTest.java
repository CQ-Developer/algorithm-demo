package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraSearchTest {

    @Test
    void search() {
        assertEquals(6, DijkstraSearch.search());
    }

}
