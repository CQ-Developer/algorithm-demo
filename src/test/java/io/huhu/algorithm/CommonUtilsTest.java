package io.huhu.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonUtilsTest {

    @Test
    void az() {
        char[] az = CommonUtils.sequence_az();
        for (char c = 'a', i = 0; c <= 'z'; c++) {
            assertEquals(c, az[i++]);
        }
    }

    @Test
    void AZ() {
        char[] az = CommonUtils.sequence_AZ();
        for (char c = 'A', i = 0; c <= 'Z'; c++) {
            assertEquals(c, az[i++]);
        }
    }

    @Test
    void sequence_09() {
        int[] ints = CommonUtils.sequence_09();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, ints[i]);
        }
    }

}