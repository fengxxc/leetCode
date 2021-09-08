package junior;

import java.util.Arrays;

/**
 * @author fengxxc
 *
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class _283_MoveZeroes {
    /**
     * 0 ms	39.5 MB	Java	2020/09/17 15:13 一周目
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int moveStep = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                moveStep++;
                i++;
                continue;
            }
            if (moveStep > 0) {
                nums[i-moveStep] = nums[i];
                nums[i] = 0;
            }
            i++;
        }
    }

    private static void test_moveZeroes() {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {1, 0, 0, 0, 12};
        moveZeroes(ints2);
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = {0, 0, 0, 0, 0};
        moveZeroes(ints3);
        System.out.println(Arrays.toString(ints3));

        int[] ints4 = {1, 1, 1, 1, 1};
        moveZeroes(ints4);
        System.out.println(Arrays.toString(ints4));
    }

    /**
     * 0 ms	38.9 MB	Java	2021/09/08 10:48 二周目
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        for (int i = 0, leftJump = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftJump++;
            } else if (leftJump != 0){
                nums[i - leftJump] = nums[i];
                nums[i] = 0;
            }
        }
    }

    private static void test_moveZeroes2() {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes2(ints);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {1, 0, 0, 0, 12};
        moveZeroes2(ints2);
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = {0, 0, 0, 0, 0};
        moveZeroes2(ints3);
        System.out.println(Arrays.toString(ints3));

        int[] ints4 = {1, 1, 1, 1, 1};
        moveZeroes2(ints4);
        System.out.println(Arrays.toString(ints4));
    }

    public static void main(String[] args) {
        test_moveZeroes();
        System.out.println("-------------------------------");
        test_moveZeroes2();
    }

}
