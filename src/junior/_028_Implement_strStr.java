package junior;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class _028_Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            char c = haystack.charAt(i);
            if (needle.charAt(0) == c) {
                if (needle.length() == 1)
                    return i;
                for (int j = 1; j < needle.length(); j++) {
                    int baki = i;
                    if (needle.charAt(j) == c)
                        baki = i + j;
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        i = baki;
                        break;
                    }
                    if (j == needle.length() - 1)
                        return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "hello";
        String n = "ll";
        System.out.println(strStr(h, n));

        System.out.println("---------------------------");

        String h2 = "hell";
        String n2 = "ll";
        System.out.println(strStr(h2, n2));

        System.out.println("---------------------------");

        String h3 = "helo";
        String n3 = "ll";
        System.out.println(strStr(h3, n3));

        System.out.println("---------------------------");

        String h4 = "lhelo";
        String n4 = "ll";
        System.out.println(strStr(h4, n4));

        System.out.println("---------------------------");

        String h5 = "llhelo";
        String n5 = "ll";
        System.out.println(strStr(h5, n5));

        System.out.println("---------------------------");

        String h6 = "hello, world~";
        String n6 = "lo, ";
        System.out.println(strStr(h6, n6));

        System.out.println("---------------------------");

        String h7 = "a";
        String n7 = "a";
        System.out.println(strStr(h7, n7));

    }
}
