package io.huhu.leetcode.n926;

class Greedy implements Code {

    /**
     * 如果后面的0比1多就把1变成0，否则将0变成1
     */
    @Override
    public int minFlipsMonoIncr(String s) {
        int ans = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                one++;
            } else {
                if (one > 0) {
                    one--;
                    ans++;
                }
            }
        }
        return ans;
    }

}
