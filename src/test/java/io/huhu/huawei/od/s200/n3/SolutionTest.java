package io.huhu.huawei.od.s200.n3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int len = 7;
        int[] numbers = {1, 2, 2, 7, 3, 6, 1};
        int n = 3;
        Assertions.assertEquals(10, Solution.dfs(numbers, n, 0, len - 1, 0));
    }

    @Test
    void test2() {
        int len = 3;
        int[] numbers = {1, 2, 3};
        int n = 3;
        Assertions.assertEquals(6, Solution.dfs(numbers, n, 0, len - 1, 0));
    }

    @Test
    void test3() {
        int len = 4;
        int[] numbers = {4, 2, 2, 3};
        int n = 2;
        Assertions.assertEquals(7, Solution.dfs(numbers, n, 0, len - 1, 0));
    }

    @Test
    void test4() {
        int len = 1000;
        int[] numbers = {129, 805, 399, 688, 789, 139, 692, 963, 356, 52, 344, 712, 35, 422, 23, 108, 149, 663, 184, 9, 295, 399, 582, 973, 546, 627, 628, 695, 313, 505, 617, 272, 957, 191, 896, 451, 246, 925, 193, 588, 516, 251, 467, 854, 19, 47, 795, 948, 617, 162, 114, 713, 831, 183, 478, 455, 789, 502, 607, 954, 536, 305, 366, 92, 137, 253, 666, 772, 587, 185, 3, 393, 925, 346, 35, 931, 572, 127, 148, 995, 195, 981, 782, 175, 245, 294, 483, 6, 530, 39, 647, 831, 688, 45, 358, 308, 76, 268, 105, 968, 950, 712, 798, 504, 100, 818, 686, 824, 989, 41, 641, 311, 872, 817, 17, 268, 186, 872, 179, 937, 98, 551, 168, 874, 74, 124, 45, 381, 509, 341, 455, 777, 468, 615, 143, 581, 452, 592, 692, 531, 970, 859, 368, 942, 749, 161, 723, 785, 432, 648, 261, 414, 927, 906, 962, 688, 809, 545, 364, 52, 859, 56, 402, 880, 66, 633, 682, 386, 28, 83, 259, 814, 323, 373, 116, 869, 998, 158, 986, 86, 107, 787, 101, 349, 942, 506, 10, 326, 684, 633, 696, 382, 602, 575, 71, 947, 469, 48, 43, 986, 921, 515, 257, 83, 305, 597, 21, 352, 84, 865, 108, 421, 971, 757, 137, 971, 705, 76, 727, 995, 316, 491, 826, 303, 108, 94, 741, 602, 574, 287, 667, 747, 63, 382, 946, 770, 86, 404, 701, 87, 376, 31, 26, 102, 99, 349, 601, 252, 928, 138, 593, 129, 627, 931, 645, 809, 617, 31, 666, 39, 422, 650, 478, 605, 442, 897, 839, 420, 944, 882, 287, 174, 345, 204, 253, 324, 804, 621, 286, 588, 328, 573, 335, 469, 782, 180, 582, 453, 253, 453, 35, 529, 257, 41, 618, 325, 229, 462, 26, 680, 463, 979, 75, 879, 422, 969, 624, 106, 96, 785, 278, 138, 854, 428, 314, 143, 810, 14, 12, 949, 10, 644, 196, 234, 636, 378, 476, 660, 799, 364, 169, 392, 763, 305, 929, 688, 437, 107, 124, 631, 339, 230, 572, 30, 836, 996, 250, 398, 449, 840, 171, 985, 817, 765, 599, 683, 453, 428, 350, 213, 913, 259, 565, 203, 244, 630, 916, 556, 737, 703, 404, 535, 347, 16, 785, 814, 345, 400, 534, 491, 261, 488, 850, 48, 290, 681, 696, 567, 25, 219, 216, 576, 513, 721, 985, 577, 423, 579, 625, 543, 714, 180, 218, 482, 385, 920, 768, 738, 464, 286, 6, 554, 750, 366, 772, 516, 210, 995, 703, 415, 395, 835, 193, 271, 699, 128, 184, 421, 276, 976, 772, 583, 169, 730, 833, 68, 742, 729, 293, 723, 670, 331, 229, 725, 263, 906, 41, 907, 918, 678, 471, 481, 397, 942, 643, 149, 872, 942, 595, 548, 220, 829, 183, 175, 811, 262, 513, 768, 473, 301, 521, 881, 227, 592, 485, 988, 32, 662, 781, 373, 662, 952, 654, 436, 927, 697, 413, 775, 229, 571, 126, 229, 459, 284, 352, 601, 437, 225, 102, 769, 336, 345, 379, 276, 577, 500, 976, 400, 600, 555, 512, 229, 899, 416, 425, 418, 977, 118, 852, 598, 795, 60, 306, 108, 853, 305, 803, 300, 952, 70, 271, 9, 862, 534, 187, 558, 587, 977, 310, 893, 964, 896, 231, 118, 663, 739, 705, 574, 199, 819, 113, 32, 143, 392, 494, 766, 280, 72, 179, 668, 962, 935, 878, 329, 754, 174, 849, 505, 911, 486, 515, 479, 644, 859, 927, 697, 322, 911, 323, 87, 897, 65, 655, 100, 938, 597, 628, 4, 509, 271, 967, 196, 294, 991, 505, 459, 752, 211, 465, 900, 124, 234, 325, 448, 910, 457, 436, 491, 421, 308, 775, 599, 580, 346, 318, 942, 279, 906, 410, 412, 856, 466, 687, 641, 858, 171, 865, 129, 768, 703, 831, 601, 929, 989, 98, 235, 515, 510, 953, 552, 29, 470, 637, 98, 916, 255, 318, 629, 885, 982, 506, 989, 107, 121, 21, 927, 433, 936, 267, 505, 962, 401, 153, 75, 556, 626, 624, 313, 4, 994, 502, 8, 53, 984, 7, 619, 4, 470, 801, 986, 91, 208, 173, 886, 142, 290, 487, 779, 862, 495, 755, 273, 927, 992, 113, 112, 562, 456, 694, 452, 535, 98, 745, 724, 764, 350, 297, 711, 151, 317, 902, 266, 86, 491, 876, 187, 467, 341, 706, 983, 554, 889, 751, 967, 656, 168, 991, 457, 927, 952, 557, 434, 562, 61, 895, 543, 284, 546, 839, 548, 393, 164, 219, 142, 394, 553, 926, 735, 294, 656, 566, 638, 218, 351, 831, 20, 215, 40, 873, 364, 555, 14, 980, 125, 308, 318, 292, 202, 115, 988, 609, 994, 281, 515, 640, 831, 648, 272, 105, 625, 917, 234, 576, 899, 12, 719, 104, 141, 480, 412, 487, 844, 240, 49, 798, 309, 251, 594, 454, 134, 561, 351, 926, 140, 206, 816, 599, 100, 396, 696, 744, 788, 401, 972, 880, 721, 970, 683, 318, 576, 297, 938, 507, 749, 27, 576, 618, 578, 532, 92, 824, 242, 983, 893, 776, 924, 917, 393, 945, 549, 365, 961, 618, 528, 814, 836, 259, 500, 679, 90, 289, 303, 674, 33, 403, 267, 871, 801, 866, 137, 411, 956, 579, 231, 238, 806, 11, 534, 787, 913, 128, 77, 79, 113, 62, 722, 364, 307, 360, 453, 518, 199, 897, 767, 994, 201, 873, 658, 4, 705, 733, 656, 160, 563, 517, 945, 290, 234, 204, 187, 607, 612, 837, 892, 735, 909, 988, 89, 77, 561, 105, 317, 738, 597, 566, 860, 850, 846, 101, 559, 443, 702, 559, 174, 459, 341, 476, 835, 74, 985, 7, 657, 143, 724, 399, 986, 187, 781, 871, 719, 228, 778, 11, 342, 798, 784, 989, 25, 586, 241, 38, 808, 492, 69, 147, 75, 690, 710, 823, 545, 716, 654, 226, 202, 714, 675, 310, 318, 34, 161, 202, 391, 189, 480, 966, 196, 257, 506, 255, 469, 310, 511, 791, 685, 694, 934, 671, 520, 265, 565, 577, 386, 313, 731, 147, 244, 344, 773, 712, 888};
        int n = 300;
        Assertions.assertEquals(150398, Solution.dfs(numbers, n, 0, len - 1, 0));
    }

}
