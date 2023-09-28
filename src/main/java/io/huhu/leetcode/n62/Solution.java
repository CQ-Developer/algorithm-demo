package io.huhu.leetcode.n62;

/**
 * <h1>62.不同路径</h1>
 * <p>一个机器人位于一个m*n网格的左上角(起始点在下图中标记为"Start")。<br/>
 * 机器中每次只能向下或向右移动一步，机器人试图达到网格的右下角(在下图中标记为"Finish")。<br/>
 * 问总共右多少条不同的路径？</p>
 * <br/>
 * <p>示例1：<br/>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" width="512"/><br/>
 * 输入：m=3, n=7<br/>
 * 输出：28</p>
 * <br/>
 * <p>示例2：<br/>
 * 输入：m=3, n=2<br/>
 * 输出：3<br/>
 * 解释：<br/>
 * 从左上角开始，总共有3条路径可以到达右下角。<br/>
 * 1. 向右 -> 向下 -> 向下<br/>
 * 2. 向下 -> 向下 -> 向右<br/>
 * 3. 向下 -> 向右 -> 向下</p>
 * <br/>
 * <p>示例3：<br/>
 * 输入：m=7, n=3<br/>
 * 输出：28</p>
 * <br/>
 * <p>示例4：<br/>
 * 输入：m=3, n=3<br/>
 * 输出：6</p>
 * <br/>
 * <hr/>
 * <p>提示：</p>
 * <ul>
 * <li>1 <= m, n <= 100</li>
 * <li>题目数据保证答案小于等于2*10<sup>9</sup></li>
 * </ul>
 */
class Solution {

    /**
     * <img src="../code-files/n62_unique_paths.png"/>
     * <br/>
     * 解题思路如上图。
     * <ol>
     * <li>可以选择向下走，即m-1</li>
     * <li>可以选择向右走，即n-1</li>
     * <li>其中只要右一个边走到头，那么只剩下1种走法</li>
     * </ul>
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

}
