package io.huhu.leetcode.n2525;

/**
 * <h1>
 * 2525.根据规则将箱子分类
 * </h1>
 *
 * <p>
 * 给你四个整数length、width、height、mass，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子类别的字符串。
 * <br/>
 * 如果满足以下条件，那么箱子是"Bulky"的：
 * <br/>
 * 1.箱子至少有一个维度大于等于10<sup>4</sup>
 * <br/>
 * 2.或者箱子的体积大于等于10<sup>9</sup>
 * <br/>
 * 如果箱子的质量大于等于100，那么箱子是"Heavy"的
 * <br/>
 * 如果箱子同时是"Bulky"和"Heavy"，那么返回类别为"Both"
 * <br/>
 * 如果箱子既不是"Bulky"，也不是"Heavy"，那么返回类别为"Neither"
 * <br/>
 * 如果箱子是"Bulky"但不是"Heavy"，那么返回类别为"Bulky"
 * <br/>
 * 如果箱子是"Heavy"但不是"Bulky"，那么返回类别为"Heavy"
 * <br/>
 * 注意，箱子的体积等于箱子的长度，宽度和高度的乘积
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * 输入：length=1000, width=35, height=700, mass=300
 * <br/>
 * 输出："Heavy"
 * <br/>
 * 解释：
 * <br/>
 * 箱子没有任何维度大于等于10<sup>4</sup>
 * <br/>
 * 体积为24500000<=10<sup>9</sup>，所以不能归类为"Bulky"
 * <br/>
 * 但是质量>=100，所以箱子"Heavy"的
 * <br/>
 * 由于箱子不是"Bulky"但是是"Heavy"，所以我们返回"Heavy"
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：length=200，width=50，height=800，mass=50
 * <br/>
 * 输出："Neither"
 * <br/>
 * 解释：
 * <br/>
 * 箱子没有任何维度大于等于10<sup>4</sup>
 * <br/>
 * 体积为8*10<sup>6</sup><=10<sup>9</sup>，所以不能归类为"Bulky"
 * <br/>
 * 质量小于100，所以不能归类为"Heavy"
 * <br/>
 * 由于不属于上述两者任何一类，所以我们返回"Neither"
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * 1 <= length, width, height <= 10<sup>5</sup>
 * <br/>
 * 1 <= mass <= 10<sup>3</sup>
 * </p>
 */
class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        double a = Math.pow(10, 4);
        double b = Math.pow(10, 9);
        boolean bulky = length >= a || width >= a || height >= a || (1L * length * width * height) >= b;
        boolean heavy = mass >= 100;
        if (bulky && heavy) {
            return "Both";
        }
        if (bulky) {
            return "Bulky";
        }
        if (heavy) {
            return "Heavy";
        }
        return "Neither";
    }

}
