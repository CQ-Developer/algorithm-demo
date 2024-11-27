package io.huhu.leetcode.n1653;

class BruteForceSearch implements Code {

    /**
     * there are 3 kind of balanced:
     * 1. all characters are 'a'
     * 2. all characters are 'b'
     * 3. all characters 'a' are before 'b'
     */
    @Override
    public int minimumDeletions(String s) {
        char[] c = s.toCharArray();
        // how many 'a' on the right side
        int a = 0;
        for (char _c : c) {
            if (_c == 'a') {
                a++;
            }
        }
        // how many 'b' on the left side
        int b = 0, ans = a;
        for (char _c : c) {
            if (_c == 'b') {
                b++;
            } else {
                a--;
            }
            // remove all 'a' on right side and remove all b on left side
            // to make the string balancer
            ans = Math.min(ans, a + b);
        }
        return ans;
    }

}
