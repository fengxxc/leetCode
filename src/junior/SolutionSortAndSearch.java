package junior;

import java.util.Arrays;


/**
 * 排序和搜索
 * @author fengxxc
 *
 */
public class SolutionSortAndSearch {
	/**
	 * 合并两个有序数组
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
	 * 注意:
	 * 你可以假设 nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。在 nums1 和 nums2 中初始化的元素的数量分别是 m 和 n。
	 * 网友：特别注意这里的m只是nums1中元素的个数，不是最终第一个数组的长度 不要用m=nums1.length;不然会造成数据越界的报错
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1, j = n-1, index = m+n-1;
		while (i >= 0 && j >= 0)
			if (nums1[i] > nums2[j])
				nums1[index--] = nums1[i--];
			else
				nums1[index--] = nums2[j--];
		while (j >= 0)
			nums1[index--] = nums2[j--];
    }

	public static void test_merge() {
		int m = 6;
		int n = 6;
		int[] nums1 = new int[12];
		nums1[0] = 1;
		nums1[1] = 1;
		nums1[2] = 3;
		nums1[3] = 6;
		nums1[4] = 6;
		nums1[5] = 9;
//		int[] nums1 = {1, 1, 3, 6, 6, 9};
		int[] nums2 = new int[n];
		nums2[0] = 1;
		nums2[1] = 1;
		nums2[2] = 2;
		nums2[3] = 5;
		nums2[4] = 6;
		nums2[5] = 7;
//		int[] nums2 = {1, 1, 2, 5, 6, 7};
		merge(nums1, m, nums2, n);
//		[1, 1, 1, 1, 2, 3, 5, 6, 6, 6, 7, 9]
		System.out.println(Arrays.toString(nums1));
		
		
		/*int m = 1;
		int n = 1;
		int[] nums1 = new int[2];
		nums1[0] = 1;
//		int[] nums1 = {1, 0};
		int[] nums2 = new int[n];
		nums2[0] = 2;
//		int[] nums2 = {2};
		merge(nums1, m, nums2, n);
//		[1, 2]
		System.out.println(Arrays.toString(nums1));*/
	}

	public static void main(String[] args) {
		test_merge();
	}
}
