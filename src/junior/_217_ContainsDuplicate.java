package junior;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fengxxc
 *
 * 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 */
public class _217_ContainsDuplicate {

	/**
	 * 2019/01/08 16:03 一周目
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) 
				return true;
			set.add(nums[i]);
		}
		return false;
    }

	/**
	 * 2021/08/24 15:15 二周目
     * 双BitSet 用时：4ms，内存消耗：40.7MB
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate_2(int[] nums) {
		final BitSet set = new BitSet();
		final BitSet neSet = new BitSet();

		for (int i = 0; i < nums.length; i++) {
			final int num = nums[i];
			if (num >= 0) {
				if (set.get(num)) {
					return true;
				}
				set.set(num);
			} else {
				if (neSet.get(-num)) {
					return true;
				}
				neSet.set(-num);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[] {1,1,1,3,3,4,3,2,4,2}; // true
		int[] t2 = new int[] {1,2,3,4}; // false
		int[] t3 = new int[] {1,2,3,1}; // true
		int[] t4 = new int[] {1,5,-2,-4,0}; // false

		System.out.println(new _217_ContainsDuplicate().containsDuplicate(t1));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate(t2));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate(t3));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate(t4));

		System.out.println("------------------------------------------");

		System.out.println(new _217_ContainsDuplicate().containsDuplicate_2(t1));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate_2(t2));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate_2(t3));
		System.out.println(new _217_ContainsDuplicate().containsDuplicate_2(t4));

	}
}
