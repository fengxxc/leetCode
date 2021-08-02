package junior;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author fengxxc
 *
 * 矩阵中战斗力最弱的 K 行
 *
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 */
public class _1337_TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        Arrays.fill(res, -1);
        int index = 0;
        for (int c = 0; c < mat[0].length; c++) {
            for (int r = 0; r < mat.length; r++) {
                final int val = mat[r][c];
                if ( val == 0 && !has(res, r) ) {
                    res[index++] = r;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (!has(res, i) && index < k) {
                res[index++] = i;
            }
        }
        return res;
    }

    private static boolean has(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { {1, 1, 0, 0, 0},
                                    {1, 1, 1, 1, 0},
                                    {1, 0, 0, 0, 0},
                                    {1, 1, 0, 0, 0},
                                    {1, 1, 1, 1, 1} };
        final int[] res = new _1337_TheKWeakestRowsinaMatrix().kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(res));

        int[][] mat2 = new int[][] {{1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1},
                                    {1, 1, 1, 1, 1, 1} };
        final int[] res2 = new _1337_TheKWeakestRowsinaMatrix().kWeakestRows(mat2, 1);
        System.out.println(Arrays.toString(res2));

        int[][] mat3 = new int[][] {{1, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0},
                                    {1, 1, 0, 0, 0},
                                    {1, 1, 1, 1, 0},
                                    {1, 1, 1, 1, 1} };
        final int[] res3 = new _1337_TheKWeakestRowsinaMatrix().kWeakestRows(mat3, 3);
        System.out.println(Arrays.toString(res3));
    }
}
