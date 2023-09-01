package io.huhu.algorithm.leetcode.n43;

/**
 * <h1>字符串相乘</h1>
 * <p>给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积。</p>
 * <p>它们的乘积也表示为字符串形式。</p>
 * <p><strong>注意：</strong>不能使用任何内置的BigInteger库或直接将输入转换为整数。</p>
 * <br>
 *
 * <h3>示例一</h3>
 * <p>输入：num1="2" num2="3"</p>
 * <p>输出："6"</p>
 * <br>
 *
 * <h3>示例二</h3>
 * <p>输入：num1="123" num2="456"</p>
 * <p>输出："56088"</p>
 * <br>
 *
 * <h3>条件</h3>
 * <ul>
 * <li>1 <= num1.length, num2.length <= 200</li>
 * <li>num1和nm2只能由数字构成</li>
 * <li>num1和nm2都不包含任何前导零，除了数字0本身</li>
 * </ul>
 */
class Solution {

    /**
     * <h2>解体思路：将每一位相乘</h2>
     * <p><strong>注意：</strong>一个n位数和一个m位数相乘，其结果最大不会超过n+m位，
     * 比如3位数乘2位数最大不会超过5位数，如999*99=98901。</p>
     * <p>也就是说，可以使用一个长度为n+m的数组存下结果。操作步骤如图：</p>
     * <img src="https://pic.leetcode-cn.com/171cad48cd0c14f565f2a0e5aa5ccb130e4562906ee10a84289f12e4460fe164-image.png"/>
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int z = x * y;
                int sum = res[i + j + 1] + z;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            builder.append(res[i]);
        }
        return builder.toString();
    }

}
