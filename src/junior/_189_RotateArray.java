package junior;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * 旋转数组
 * 将包含 n 个元素的数组向右旋转 k 步。
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * @author fengxxc
 *
 */
public class _189_RotateArray {
	/**
	 * my first version
	 * 1.5ms
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
	public void rotate2(int[] nums, int k) {
		int len = nums.length;
		int _k = k % len;
		int start = -1;
		for (int i = 0; i < len; i++) { // i: 已挪个数
			start = i;
			int temp = nums[start];
			while (true) {
				int next = start + _k;
				temp = nums[next];
				nums[next] = nums[start];
			}
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
