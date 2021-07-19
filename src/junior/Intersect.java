package junior;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Intersect {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		int[] min, max;
		if (nums1.length > nums2.length) {
			min = nums2;
			max = nums1;
		} else {
			min = nums1;
			max = nums2;
		}
		Set set = new HashSet<>(Arrays.asList(max));
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < min.length; i++) {
			if (set.contains(min[i])) {
				res.add(min[i]);
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
//		return res.toArray(new int[res.size()]);
    }
	
	public static void main(String[] args) {
		Intersect intersect = new Intersect();
		int[] nums1 = new int[]{1,2,3,5,3,4,8};
		int[] nums2 = new int[]{1,6,7,9,13};
		int[] is = intersect.intersect(nums1, nums2);
		System.out.println(Arrays.toString(is));
	}
}
