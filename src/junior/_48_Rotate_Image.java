package junior;

import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class _48_Rotate_Image {
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int i = 0; i < Math.ceil(rowCount / 2.0); i++) {
            for (int j = i; j < rowCount - 1 - i; j++) {
                int lefti   = rowCount - 1 - j, leftj   =                i;
                int bottomi = rowCount - 1 - i, bottomj = colCount - 1 - j;
                int righti  =                j, rightj  = rowCount - 1 - i;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[lefti][leftj];
                matrix[lefti][leftj] = matrix[bottomi][bottomj];
                matrix[bottomi][bottomj] = matrix[righti][rightj];
                matrix[righti][rightj] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));

        System.out.println("-----------------------------------------");

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++)
            System.out.println(Arrays.toString(matrix2[i]));

        System.out.println("-----------------------------------------");

        int[][] matrix3 = {
                {5, 41, 5, 9, 11},
                {2, 34, 8, 9, 10},
                {13, 3, 6, 3, 7},
                {43, 15, 14, 12, 16},
                {3, 6, 9, 33, 59}
        };
        rotate(matrix3);
        for (int i = 0; i < matrix3.length; i++)
            System.out.println(Arrays.toString(matrix3[i]));
    }
}
