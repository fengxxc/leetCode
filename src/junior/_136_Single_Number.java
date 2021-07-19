package junior;

/**
 * 136. Single Number
 * 只出现一次的数字
 * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
 * 一个线性时间复杂度，不用额外空间。
 * @author fengxxc
 *
 */
public class _136_Single_Number {
	/**
	 * my first version
	 * 也是leetCode最快的实现方式
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return -1;
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            result = result ^ nums[i];
        return result;
    }
	public static void main() {
		int[] arr = { 0, 1, 3, 5, 1, 0, 5 };  
		System.out.println("test_singleNumber:");
        System.out.println(new _136_Single_Number().singleNumber(arr));  
	}
	
}
