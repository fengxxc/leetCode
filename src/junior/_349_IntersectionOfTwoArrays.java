package junior;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * _349_IntersectionOfTwoArrays 
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 说明:
 *  输出结果中的每个元素一定是唯一的。
 *  我们可以不考虑输出结果的顺序。
 */
public class _349_IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<Integer>();
        BitSet bs1 = new BitSet(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            bs1.set(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (bs1.get(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        Integer[] res1 = res.toArray(new Integer[0]);
        int[] res2 = new int[res1.length];
        for (int i = 0; i < res1.length; i++) {
            res2[i] = res1[i];
        }
        return res2;
    }

    public static void main(String[] args) {
        int[] intersection1 = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println(Arrays.toString(intersection1));

        int[] intersection2 = intersection(new int[]{ 4, 9, 5}, new int[]{ 9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersection2));

        Runtime runtime = Runtime.getRuntime();
        System.out.println("freeMemory: " + runtime.freeMemory() / 1024 / 1024 + " M");
        System.out.println("totalMemory: " + runtime.totalMemory() / 1024 / 1024 + " M");
        System.out.println("maxMemory: " + runtime.maxMemory() / 1024 / 1024 + " M");
        System.out.println("totalMemory - freeMemory: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024 + " M");
    }
}