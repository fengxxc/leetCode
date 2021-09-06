package junior;

/**
 * @author fengxxc
 *
 * 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class _704_BinarySearch {
    /**
     * 2021/09/06 11:16 一周目
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int l = 0, r = nums.length - 1, m = nums.length / 2;
        while (l <= r && r > -1 && l < nums.length) {
            if (target == nums[m]) {
                return m;
            }
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (r-l)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _704_BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new _704_BinarySearch().search(new int[]{5}, -5));
        System.out.println(new _704_BinarySearch().search(new int[]{5}, 15));
        System.out.println(new _704_BinarySearch().search(new int[]{2, 5}, 2));
    }
}
