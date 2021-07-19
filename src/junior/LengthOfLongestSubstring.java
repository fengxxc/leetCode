package junior;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author fengxxc
 *
 */
public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) 
			return 0;
		if (s.length() == 1) 
			return 1;
		char[] cs = s.toCharArray();
		int maxLength = 0;
		int start = 0;
		int end = 1;
		Set<Character> tmpSet = new HashSet<Character>();
		tmpSet.add(cs[start]);
		while (start < cs.length && end < cs.length) {
			if (tmpSet.contains(cs[end])) {
				maxLength = (tmpSet.size() > maxLength)? tmpSet.size() : maxLength;
				start ++;
				end = start + 1;
				tmpSet = new HashSet<Character>(); 
				tmpSet.add(cs[start]);
			} else {
				tmpSet.add(cs[end]);
				end ++;
			}
		}
		maxLength = (tmpSet.size() > maxLength)? tmpSet.size() : maxLength;
		return maxLength;
	}

	public static void main(String[] args) {
		int lengthOfLongestSubstring = lengthOfLongestSubstring("abcabcbb");
		System.out.println(lengthOfLongestSubstring);
		int lengthOfLongestSubstring1 = lengthOfLongestSubstring("bbbbb");
		System.out.println(lengthOfLongestSubstring1);
		int lengthOfLongestSubstring2 = lengthOfLongestSubstring("pwwkew");
		System.out.println(lengthOfLongestSubstring2);
	}
}
