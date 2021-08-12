package junior;

/**
 * @author fengxxc
 *
 * x的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class _069_SqrtX {
    // 二分法
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            final long t = (long) mid * mid;
            if (x < t) {
                right = mid - 1;
            } else if (t < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        final int i = new _069_SqrtX().mySqrt(8);
        System.out.println(i);
    }

    // TODO 牛顿迭代法
}
