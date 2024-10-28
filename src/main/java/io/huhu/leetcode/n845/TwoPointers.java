package io.huhu.leetcode.n845;

class TwoPointers implements Code {

    @Override
    public int longestMountain(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int l = i;
            while (l - 1 >= 0 && arr[l] > arr[l - 1]) {
                l--;
            }
            int r = i;
            while (r + 1 < arr.length && arr[r] > arr[r + 1]) {
                r++;
            }
            if (l != i && r != i) {
                int len = r - l + 1;
                if (len >= 3 && len > ans) {
                    ans = len;
                }
            }
        }
        return ans;
    }

}
