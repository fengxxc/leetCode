package junior;

/**
 * @author fengxxc
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class _125_ValidPalindrome {
	public static boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0;
        int r = cs.length-1;
        for (int i = 0; i < cs.length/2; i++) {
			while ( l < cs.length-1 && !((65 <= cs[l] && cs[l] <= 90) || (97 <= cs[l] && cs[l] <= 122) || (48 <= cs[l] && cs[l] <= 57)) ) {
				l++;
			}
			while ( r > 0 && !((65 <= cs[r] && cs[r] <= 90) || (97 <= cs[r] && cs[r] <= 122) || (48 <= cs[r] && cs[r] <= 57)) ) {
				r--;
			}
			if (l > r) {
				break;
			}
			if (!isEqual(cs[l], cs[r])) {
				return false;
			}
			l++;
			r--;
		}
        return true;
    }
	
	private static boolean isEqual(char a, char b) {
		if (a == b) 
			return true;
		if ( ((65 <= a && a <= 90 && 97 <= b && b <= 122) || (65 <= b && b <= 90 && 97 <= a && a <= 122)) && Math.abs(a - b) == 32 ) 
			return true;
		return false;
	}
	
	/**
	 * leetcode题解
	 * 原来Java提供了判断字母或数字的方法_(:з)∠)_
	 * @param s
	 * @return
	 */
	public boolean isPalindrome2(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }

	public static void main(String[] args) {
		boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
		
		boolean palindrome2 = isPalindrome(".,");
		System.out.println(palindrome2);
		
		boolean palindrome3 = isPalindrome("Sore was I ere I saw Eros.");
		System.out.println(palindrome3);
		
	}
}
