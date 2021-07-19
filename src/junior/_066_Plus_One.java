package junior;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class _066_Plus_One {
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int[] res = digits.clone();
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] == 9) {
                res[i] = 0;
            } else {
                res[i] = res[i] + 1;
                return res;
            }
        }
        res = new int[res.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3};
        int[] r1 = plusOne(t1);
        System.out.println(Arrays.toString(r1));

        int[] t2 = {4, 9, 9, 9};
        int[] r2 = plusOne(t2);
        System.out.println(Arrays.toString(r2));

        int[] t3 = {9, 9, 9, 9};
        int[] r3 = plusOne(t3);
        System.out.println(Arrays.toString(r3));

        int[] t4 = {9};
        int[] r4 = plusOne(t4);
        System.out.println(Arrays.toString(r4));

        int[] t5 = {};
        int[] r5 = plusOne(t5);
        System.out.println(Arrays.toString(r5));
    }
}
