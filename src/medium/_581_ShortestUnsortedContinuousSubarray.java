package medium;

/**
 * @author fengxxc
 *
 * 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 */
public class _581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, end = -1, start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (min < nums[nums.length - i - 1]) {
                start = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return end == -1 ? 0 : end - start + 1;
    }
}
