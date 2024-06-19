package io.huhu.leetcode.dynamic.programming.medium.n376;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        int[] nums = {1, 7, 4, 9, 2, 5};
        Assertions.assertEquals(6, solution.wiggleMaxLength(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Assertions.assertEquals(7, solution.wiggleMaxLength(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertEquals(2, solution.wiggleMaxLength(nums));
    }

    @Test
    void test4() {
        int[] nums = {1};
        Assertions.assertEquals(1, solution.wiggleMaxLength(nums));
    }

    @Test
    void test5() {
        int[] nums = {1, 2};
        Assertions.assertEquals(2, solution.wiggleMaxLength(nums));
    }

    @Test
    void test6() {
        int[] nums = {0, 0};
        Assertions.assertEquals(1, solution.wiggleMaxLength(nums));
    }

    @Test
    void test7() {
        int[] nums = {0, 0, 0};
        Assertions.assertEquals(1, solution.wiggleMaxLength(nums));
    }

    @Test
    void test8() {
        int[] nums = {3, 3, 3, 2, 5};
        Assertions.assertEquals(3, solution.wiggleMaxLength(nums));
    }

    @Test
    void test9() {
        int[] nums = {372, 492, 288, 399, 81, 2, 320, 94, 416, 469, 427, 117, 265, 357, 399, 456, 496, 337, 355, 219, 475, 295, 457, 350, 490, 470, 281, 127, 131, 36, 430, 412, 442, 174, 128, 253, 1, 56, 306, 295, 340, 73, 253, 130, 259, 223, 14, 79, 409, 384, 209, 151, 317, 441, 156, 275, 140, 224, 128, 250, 290, 191, 161, 472, 477, 125, 470, 230, 321, 5, 311, 23, 27, 248, 138, 284, 215, 356, 320, 194, 434, 136, 221, 273, 450, 440, 28, 179, 36, 386, 482, 203, 24, 8, 391, 21, 500, 484, 135, 348, 292, 396, 145, 443, 406, 61, 212, 480, 455, 78, 309, 318, 84, 474, 209, 225, 177, 356, 227, 263, 181, 476, 478, 151, 494, 395, 23, 114, 395, 429, 450, 247, 245, 150, 354, 230, 100, 172, 454, 155, 189, 33, 290, 187, 443, 123, 59, 358, 241, 141, 39, 196, 491, 381, 157, 157, 134, 431, 295, 20, 123, 118, 207, 199, 317, 188, 267, 335, 315, 308, 115, 321, 56, 52, 253, 492, 97, 374, 398, 272, 74, 206, 109, 172, 471, 55, 452, 452, 329, 367, 372, 252, 99, 62, 122, 287, 320, 325, 307, 481, 316, 378, 87, 97, 457, 21, 312, 249, 354, 286, 196, 43, 170, 500, 265, 253, 19, 480, 438, 113, 473, 247, 257, 33, 395, 456, 246, 310, 469, 408, 112, 385, 53, 449, 117, 122, 210, 286, 149, 20, 364, 372, 71, 26, 155, 292, 16, 72, 384, 160, 79, 241, 346, 230, 15, 427, 96, 95, 59, 151, 325, 490, 223, 131, 81, 294, 18, 70, 171, 339, 14, 40, 463, 421, 355, 123, 408, 357, 202, 235, 390, 344, 198, 98, 361, 434, 174, 216, 197, 274, 231, 85, 494, 57, 136, 258, 134, 441, 477, 456, 318, 155, 138, 461, 65, 426, 162, 90, 342, 284, 374, 204, 464, 9, 280, 391, 491, 231, 298, 284, 82, 417, 355, 356, 207, 367, 262, 244, 283, 489, 477, 143, 495, 472, 372, 447, 322, 399, 239, 450, 168, 202, 89, 333, 276, 199, 416, 490, 494, 488, 137, 327, 113, 189, 430, 320, 197, 120, 71, 262, 31, 295, 218, 74, 238, 169, 489, 308, 300, 260, 397, 308, 328, 267, 419, 84, 357, 486, 289, 312, 230, 64, 468, 227, 268, 28, 243, 267, 254, 153, 407, 399, 346, 385, 77, 297, 273, 484, 366, 482, 491, 368, 221, 423, 107, 272, 98, 309, 426, 181, 320, 77, 185, 382, 478, 398, 476, 22, 328, 450, 299, 211, 285, 62, 344, 484, 395, 466, 291, 487, 301, 407, 28, 295, 36, 429, 99, 462, 240, 124, 261, 387, 30, 362, 161, 156, 184, 188, 99, 377, 392, 442, 300, 98, 285, 312, 312, 365, 415, 367, 105, 81, 378, 413, 43, 326, 490, 320, 266, 390, 53, 327, 75, 332, 454, 29, 370, 392, 360, 1, 335, 355, 344, 120, 417, 455, 93, 60, 256, 451, 188, 161, 388, 338, 238, 26, 275, 340, 109, 185};
        Assertions.assertEquals(334, solution.wiggleMaxLength(nums));
    }

}
