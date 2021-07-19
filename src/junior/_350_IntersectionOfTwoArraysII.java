package junior;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author fengxxc
 * 
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 说明：
 *  输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *  我们可以不考虑输出结果的顺序。
 * 进阶:
 *  如果给定的数组已经排好序呢？你将如何优化你的算法？
 *  如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *  如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class _350_IntersectionOfTwoArraysII {
	public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>((int)(nums1.length / 0.75F + 1.0F));
        for (int i : nums1) {
            if (!map.containsKey(i)) map.put(i, 0);
            map.put(i, map.get(i) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                res.add(j);
                if (map.get(j) == 1)
                    map.remove(j);
                else
                    map.put(j, map.get(j) - 1);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] intersect1 = intersect(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println(Arrays.toString(intersect1));

        int[] intersect2 = intersect(new int[]{ 4, 9, 5}, new int[]{ 9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersect2));

        Runtime runtime = Runtime.getRuntime();
        System.out.println("freeMemory: " + runtime.freeMemory() / 1024 / 1024 + " M");
        System.out.println("totalMemory: " + runtime.totalMemory() / 1024 / 1024 + " M");
        System.out.println("maxMemory: " + runtime.maxMemory() / 1024 / 1024 + " M");
        System.out.println("totalMemory - freeMemory: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024 + " M");
    }
}
