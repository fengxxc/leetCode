package junior;

/**
 * @author fengxxc
 *
 * 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 */
public class _557_ReverseWordsInAString_III {
    /**
     * 9 ms	38.3 MB	Java	2021/09/09 18:08    一周目
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        final StringBuffer res = new StringBuffer();
        for (int l = 0, r = 0; r <= s.length(); r++) {
            if (r == s.length() || s.charAt(r) == ' ') {
                if (res.length() != 0) {
                    res.append(' ');
                }
                reverse(s, l, r - 1, res);
                l = r + 1;
            }
        }
        return res.toString();
    }

    private void reverse(String s, int l, int r, StringBuffer res) {
        for (int i = r; i >= l; i--) {
            final char t = s.charAt(i);
            res.append(t);
        }
    }
}
