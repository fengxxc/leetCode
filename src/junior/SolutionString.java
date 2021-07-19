package junior;

public class SolutionString {
	/**
	 * 反转字符串
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		char[] charArray = s.toCharArray();
		int len = s.length();
		int count = len/2;
        for (int i = 0; i < count; i++) {
        	char temp = charArray[i];
        	charArray[i] = charArray[len-1-i];
        	charArray[len-1-i] = temp;
        }
        return new String(charArray);
    }
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String reverseString = reverseString("1");
		long endTime = System.currentTimeMillis();
		
		System.out.println(reverseString);
		System.out.println("执行时间: " + (endTime - startTime)/1000 + "s");
	}
}
