package io.huhu.leetcode.n71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>
 * 71.简化路径
 * </h1>
 *
 * <p>
 * 给你一个字符串path, 表示只想某一文件或目录的Unix风格绝对路径(以'/'开头),
 * 请你将其转换为更加简洁的规范路径.
 * </p>
 *
 * <p>
 * 在Unix风格的文件系统中, 一个点(.)表示当前目录本身;
 * 此外, 两个点(..)表示将目录切换到上一级(执行父目录);
 * 两者都可以是复杂相对路径的组成部分.
 * 任意多个连续的斜杠('//')都被视为单个斜杠'/'.
 * 对于此问题, 任何其他格式的点(如'....')均被视为文件或目录名称.
 * </p>
 *
 * <p>
 * 请注意, 返回的规范路径必须遵循下述格式:
 * </p>
 *
 * <ul>
 * <li>始终以斜杠'/'开头</li>
 * <li>两个目录之间必须只有一个斜杠'/'</li>
 * <li>最后一个目录名(如果存在)不能以'/'结尾</li>
 * <li>此外, 路径仅包含从根目录到目标文件或目录的路径上的目录(即, 不包含'.'或'..')</li>
 * </ul>
 *
 * <p>
 * 返回简化后得到的规范路径.
 * </p>
 *
 * <p>
 * 示例1:
 * <br/>
 * 输入: path = "/home/"
 * <br/>
 * 输出: "/home"
 * <br/>
 * 解释: 注意, 最后一个目录名后面没有斜杠
 * </p>
 *
 * <p>
 * 示例2:
 * <br/>
 * 输入: path = "/../"
 * <br/>
 * 输出: "/"
 * <br/>
 * 解释: 从更目录向上一级是不行的, 因为根目录是你可以到达的最高级
 * </p>
 *
 * <p>
 * 示例3:
 * <br/>
 * 输入: path = "/home//foo/"
 * <br/>
 * 输出: "/home/foo"
 * <br/>
 * 解释: 在规范路径中, 多个连续斜杠需要用一个斜杠替换
 * </p>
 *
 * <p>
 * 示例4:
 * <br/>
 * 输入: path = "/a/./b/../../c/"
 * <br/>
 * 输出: "/c"
 * </p>
 *
 * <p>
 * 提示:
 * <br/>
 * 1 <= path.length <= 3000
 * <br/>
 * path有英文字母, 数字, '.', '/', '_'组成
 * <br/>
 * path是一个有效的Unix风格绝对路径
 * </p>
 */
class Solution {

    /**
     * 实际上使用API可以快速搞定, 如下:
     * <pre>
     * {@code
     * public String simplifyPath(String path) {
     *     return Path.of(path).normalize().toString();
     * }
     * }
     * </pre>
     */
    public String simplifyPath(String path) {
        String[] part = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String s : part) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                stack.pollLast();
                continue;
            }
            stack.addLast(s);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollFirst());
        }
        if (result.isEmpty()) {
            return "/";
        }
        return result.toString();
    }

}
