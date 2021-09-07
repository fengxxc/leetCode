package junior;

import java.util.*;

/**
 * @author fengxxc
 *
 * 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 */
public class _977_SquaresOfASortedArray {

    /**
     * 1 ms	39.9 MB	Java	2021/09/07 12:14
     * 一周目 第一次
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int l = -1; // 左指针，指负数的右边界，包括自己
        int r = 0;  // 右指针，指正数的左指针，包括自己
        int i = 0;  // res的索引
        for (r = 0; r < nums.length; r++) {
            if (nums[r] < 0) {
                l = r;
                continue;
            }
            break;
        }
        while (!(l < 0 && nums.length - 1 < r)) {
            if (l < 0) {
                res[i] = nums[r] * nums[r];
                r++;
            } else if (nums.length - 1 < r) {
                res[i] = nums[l] * nums[l];
                l--;
            } else if (-nums[l] > nums[r]) {
                res[i] = nums[r] * nums[r];
                r++;
            } else {
                res[i] = nums[l] * nums[l];
                l--;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{1})));
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{-1})));
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{-2, -1})));
        System.out.println(Arrays.toString(new _977_SquaresOfASortedArray().sortedSquares(new int[]{1, 2})));
    }
}
