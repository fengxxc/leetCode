package junior;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) 
				return true;
			set.add(nums[i]);
		}
		return false;
    }
	
	public static void main(String[] args) {
		int[] t1 = new int[] {1,1,1,3,3,4,3,2,4,2}; // true
		int[] t2 = new int[] {1,2,3,4}; // false
		int[] t3 = new int[] {1,2,3,1}; // true
		
		boolean rs = containsDuplicate(t1);
		System.out.println(rs);
		boolean rs2 = containsDuplicate(t2);
		System.out.println(rs2);
		boolean rs3 = containsDuplicate(t3);
		System.out.println(rs3);
	}
}
