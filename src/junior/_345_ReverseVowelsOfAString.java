package junior;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fengxxc
 *
 * 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 */
public class _345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        final int n = s.length();
        if (n == 0) {
            return s;
        }
        final char[] chars = s.toCharArray();
        final Set set = new HashSet() {{
            add('a'); add('e'); add('i'); add('o'); add('u');
            add('A'); add('E'); add('I'); add('O'); add('U');
        }};
        for (int i = 0, j = n - 1; i < j; i++) {
            if (set.contains(chars[i])) {
                for (; j > i; j--) {
                    if (set.contains(chars[j])) {
                        if (chars[j] != chars[i]) {
                            final char t = chars[j];
                            chars[j] = chars[i];
                            chars[i] = t;
                        }
                        j--;
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new _345_ReverseVowelsOfAString().reverseVowels("hello"));
        System.out.println(new _345_ReverseVowelsOfAString().reverseVowels("leetcode"));
        System.out.println(new _345_ReverseVowelsOfAString().reverseVowels("race car"));
    }
}
