package junior;

/**
 * @author fengxxc
 * 
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class _014_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) 
			return "";
		String comPre = strs[0];
        for (int i = 1; i < strs.length; i++) 
			comPre = getCommonPrefix(comPre, strs[i]);
        return comPre;
    }

	private static String getCommonPrefix(String a, String b) {
		String min = a, max = b;
		if (a.length() > b.length()) {
			min = b; max = a;
		}
		char[] minChars = min.toCharArray();
		char[] maxChars = max.toCharArray();
		for (int i = 0; i < minChars.length; i++) 
			if (minChars[i] != maxChars[i]) 
				return a.substring(0, i);
		return min;
	}
	
	public static void main(String[] args) {
		String longestCommonPrefix = longestCommonPrefix(new String[]{"flower","flow","flight"});
		System.out.println(longestCommonPrefix);
		
		String longestCommonPrefix2 = longestCommonPrefix(new String[]{"dog","racecar","car"});
		System.out.println(longestCommonPrefix2);
	}
}
