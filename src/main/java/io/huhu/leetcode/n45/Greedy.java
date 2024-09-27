package io.huhu.leetcode.n45;

class Greedy implements Code {

    @Override
    public int jump(int[] nums) {
        int step = 0, farthest = 0, position = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == position) {
                position = farthest;
                step++;
            }
            if (position == nums.length - 1) {
                break;
            }
        }
        return step;
    }

}
