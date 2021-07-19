package junior;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 * @author fengxxc
 *
 */
public class _026_Remove_Duplicates_From_SortedArray {
	/**
	 * my first version
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		if (length == 0 || length == 1) return length;
        int last = nums[0];
        int dupCount = 0; // 重复元素的个数
        for (int i = 1; i < length; last = nums[i], i++) 
            if (last == nums[i]) dupCount ++;
            else nums[i-dupCount] = nums[i];
        int newLength = length-dupCount;
//        nums = Arrays.copyOf(nums, newLength);
        return newLength;
    }
	
	public static void main() {
		long startTime = System.currentTimeMillis();
		int[] arr = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 9, 9, 9, 11, 12, 12, 12, 13, 14, 14, 14, 14, 14, 14, 14, 14, 23, 23, 23, 23, 23, 23, 23, 26, 26, 26, 26, 26, 26, 44, 44, 44, 66, 245, 248, 290, 290, 345};
		int length = new _026_Remove_Duplicates_From_SortedArray().removeDuplicates(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("test_removeDuplicates:");
		System.out.println(length);
		System.out.println(Arrays.toString(arr));
		System.out.println("执行时间: " + (endTime - startTime)/1000 + "s");
	}
	
	/**
	 * the best of leetCode
	 * @param nums
	 * @return
	 */
	public int removeDuplicatesBest(int[] nums) {
		int i=0,j=1;
        while(i<nums.length-1 && j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[++i] = nums[j];
                j++;
            }
            
        }
        return i+1;
    }
}
