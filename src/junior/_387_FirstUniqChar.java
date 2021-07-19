package junior;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fengxxc
 *
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 */
public class _387_FirstUniqChar {
	public static int firstUniqChar(String s) {
		if ("".equals(s)) 
			return -1;
		char[] charArray = s.toCharArray();
		 // key: 字母; value: 字母索引（重复的话就置为-1）
		Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (charMap.containsKey(c)) {
				charMap.put(c, -1);
			} else {
				charMap.put(c, i);
			}
		}
		for (int i : charMap.values()) {
			if (i != -1) {
				return i;
			}
		}
		return -1;
    }
	
	/**
	 * leetcode上执行时间1ms的代码
	 * @param s
	 * @return
	 */
	public static int firstUniqChar1(String s) {
		int res = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			int index = s.indexOf(ch);
			if (index != -1 && s.lastIndexOf(ch) == index) {
				res = (res == -1 || index < res)? index : res;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int firstUniqChar = firstUniqChar1("arsdffdsa");
		System.out.println(firstUniqChar);
		
		int firstUniqChar2 = firstUniqChar1("aadadaad");
		System.out.println(firstUniqChar2);
		
	}
}
