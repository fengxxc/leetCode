package junior;

import java.util.BitSet;

/**
 * @author fengxxc
 *
 * 宝石与石头
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 */
public class _771_JewelsAndStones {
    /**
     * 2018/10/09 09:16 一周目
     * @param J
     * @param S
     * @return
     */
	public int numJewelsInStones(String J, String S) {
        char[] JChar = J.toCharArray();
        String nS = S;
        for (int i = 0; i < JChar.length; i++) {
            nS = nS.replaceAll(JChar[i]+"", "");
        }
        return S.length() - nS.length();
    }

    /**
     * 2021/08/26 11:35 二周目
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones_2(String jewels, String stones) {
        int res = 0;
        final BitSet bs = new BitSet();
        for (int i = 0; i < jewels.length(); i++) {
            bs.set(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (bs.get(stones.charAt(i))) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new _771_JewelsAndStones().numJewelsInStones(J, S));

        System.out.println(new _771_JewelsAndStones().numJewelsInStones_2(J, S));
    }
}
