package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengxxc
 *
 * 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 */
public class _068_TextJustification {
    /**
     * 0 ms	36.8 MB	Java	2021/09/09 17:17 一周目
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int rowLen = 0;
        int rowL = 0, rowR = 0;
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if (rowLen + word.length() > maxWidth) {
                // 超出了 处理这行
                String rowStr = dealRow(words, rowL, rowR, maxWidth - rowLen + 1, maxWidth);
                res.add(rowStr);
                rowL = rowR = i;
                rowLen = word.length() + 1;
            } else {
                rowR = i;
                rowLen += word.length() + 1;
            }

        }
        // 最后一行
        StringBuffer rowStr = new StringBuffer();
        for (int i = rowL; i <= rowR; i++) {
            rowStr.append(words[i]);
            if (i < rowR) {
                appendChar(rowStr, 1, ' ');
            }
        }
        appendChar(rowStr, maxWidth - rowStr.length(), ' ');
        res.add(rowStr.toString());
        return res;
    }

    private String dealRow(String[] words, int rowL, int rowR, int redundantBlank, int maxWidth) {
        final StringBuffer sb = new StringBuffer();
        final boolean onlyOne = rowR - rowL == 0;
        int modBlank = onlyOne ? 0 : redundantBlank % (rowR - rowL);
        final int eachBlank = onlyOne ? redundantBlank - 1 : redundantBlank / (rowR - rowL);
        // int _modBlank = modBlank;
        for (int i = rowL; i <= rowR; i++) {
            sb.append(words[i]);
            // 如果是本行最后一个单词
            if (i == rowR) {
                // 如果本行只有一个单词
                if (onlyOne) {
                    // 补上后面的空格
                    appendChar(sb, maxWidth - sb.length(), ' ');
                }
                break;
            }
            // 空隙应有的一个空格
            appendChar(sb, 1, ' ');
            // 每个空隙多余的空格
            appendChar(sb, eachBlank, ' ');
            // 剩下的、空隙多余的空格，从头开始一人一个
            if (modBlank > 0) {
                appendChar(sb, 1, ' ');
                modBlank--;
            }
        }
        // sb.append(": rowL=" + rowL + ", rowR=" + rowR + ", redundantBlank=" + redundantBlank + ", modBlank=" + _modBlank + ", eachBlank=" + eachBlank);
        return sb.toString();
    }

    private void appendChar(StringBuffer sb, int count, char what) {
        for (int i = 0; i < count; i++) {
            sb.append(what);
        }
    }

    public static void main(String[] args) {
        test_fullJustify();
    }

    private static void test_fullJustify() {
        final List<String> rows = new _068_TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println("-------------------------------------");
        final List<String> rows2 = new _068_TextJustification().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
        for (String row : rows2) {
            System.out.println(row);
        }
        System.out.println("-------------------------------------");
        final List<String> rows3 = new _068_TextJustification().fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do" }, 20);
        for (String row : rows3) {
            System.out.println(row);
        }
        System.out.println("-------------------------------------");
        final List<String> rows4 = new _068_TextJustification().fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16);
        for (String row : rows4) {
            System.out.println(row);
        }
        System.out.println("-------------------------------------");
        final List<String> rows5 = new _068_TextJustification().fullJustify(new String[]{"Listen","to    ","many, ","speak ","to   a","few.  "}, 6);
        for (String row : rows5) {
            System.out.println("\"" + row + "\"");
        }
    }
}
