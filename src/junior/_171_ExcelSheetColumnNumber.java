package junior;

/**
 * @author fengxxc
 *
 * Excel 表列序号
 *
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *  
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 示例 4:
 *
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 *  
 *
 * 提示：
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 */
public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        final int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            res += (columnTitle.charAt(i) - 64) * Math.pow(26, length - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        final int number = new _171_ExcelSheetColumnNumber().titleToNumber("FXSHRXW");
        System.out.println(number);
    }
}
