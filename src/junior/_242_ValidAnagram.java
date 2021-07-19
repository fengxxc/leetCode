package junior;

/**
 * @author fengxxc
 *
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class _242_ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
            return false;
		int offset = 'a';
        int[] count = new int[offset];
        for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - offset] ++;
			count[t.charAt(i) - offset] --;
		}
        for (int i = 0; i < count.length; i++) 
			if (count[i] != 0) 
				return false;
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}
}
