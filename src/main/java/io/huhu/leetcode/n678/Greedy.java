package io.huhu.leetcode.n678;

class Greedy implements Code {

    /**
     * min: 未匹配的左括号最小数量
     * max: 未匹配的右括号最大数量
     * <p>
     * 当遇到 ( 时, 剩余未匹配的左括号 +1
     * 当遇到 ) 时, 剩余未匹配的左括号 -1
     * 当遇到 * 时, 剩余未匹配的左括号 +1 或 -1
     * <p>
     * min最小不能小于0, 剩余左括号的数量不可能为负数
     * max小于0表示出现了未能匹配的右括号, 直接返回false
     * <p>
     * 遍历结束时, min为0表示所有左括号都已经匹配了右括号
     */
    @Override
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (--min < 0) {
                    min = 0;
                }
                if (--max < 0) {
                    return false;
                }
            } else {
                if (--min < 0) {
                    min = 0;
                }
                max++;
            }
        }
        return min == 0;
    }

}
