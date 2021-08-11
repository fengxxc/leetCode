package junior;

/**
 * @author fengxxc
 *
 * 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class _067_AddBinary {
    public String addBinary(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int carry = 0;
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < Math.max(a.length(), b.length()); i++, ai--, bi--) {
            final int av = a.length() > i ? a.charAt(ai) - '0' : 0;
            final int bv = b.length() > i ? b.charAt(bi) - '0' : 0;
            final int v = av + bv + carry;
            if (v == 0) {
                res.insert(0, '0');
                carry = 0;
            } else if (v == 1) {
                res.insert(0, '1');
                carry = 0;
            } else if (v == 2) {
                res.insert(0, '0');
                carry = 1;
            } else {
                res.insert(0, '1');
                carry = 1;
            }
        }
        if (carry > 0) {
            res.insert(0, '1');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("new _067_AddBinary().addBinary(\"11\", \"1\") = " + new _067_AddBinary().addBinary("11", "1"));
    }
}
