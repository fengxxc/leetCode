package medium;

import java.util.Arrays;

/**
 * @author fengxxc
 *
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
public class _189_RotateArray {
    /**
     * 1.5ms	N/A	Java	2018/09/21 09:06 一周目
     * 1 ms	26.4 MB	Java	2019/01/08 15:43 二周目
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 0 || len == 1 || k == len) return;
        int _k = k >= len? (k % len) : k;
        if (_k == 0) return;
        for (int i = 1, start = 0; i < len; i++, start++) {
            int index = start + _k;
            int temp = nums[start];
            for (; index != start; i++) {
                nums[index] ^= temp;
                temp ^= nums[index];
                nums[index] ^= temp;
                index = (index + _k) >= (len)? (index + _k)%len : index + _k;
            }
            nums[index] = temp;
        }
    }

    /**
     * 0 ms	55.2 MB	Java	2021/09/07 14:42 三周目
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            final int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    public static void main() {
//		int[] nums = new int[]{1,-2,3,4,5,6,7,8};
//		int[] nums = new int[]{-1};
//		int[] nums = new int[]{1, 2};
//		int[] nums = new int[]{1, 2, 3};
//		int[] nums = new int[]{1, 2, 3, 4};
//		int[] nums = new int[]{1, 2, 3, 4, 5};
//		int[] nums = new int[]{1, 2, 3, 4, 5, 6};
//		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
//		int[] nums = new int[]{1};
        long startTime = System.currentTimeMillis();
        rotate(nums, 45);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间: " + (endTime - startTime)/1000 + "s");
        System.out.println(Arrays.toString(nums));
    }
}
