package junior;

public class SolutionOther {
	/**
	 * 位1的个数
	 * 编写一个函数，输入是一个无符号整数，返回的是它所有 位1 的个数（也被称为汉明重量）。
	 * 例如，32位整数 '11' 的二进制表示为 00000000000000000000000000001011，所以函数返回3。
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int res = 0;
		String binaryString = Integer.toBinaryString(n);
		char[] charArray = binaryString.toCharArray();
		for (int i = 0; i < charArray.length; i++)
			if (charArray[i] == '1')
				res ++;
		return res;
	}
	// leetcode上效率最高算法(1ms)
	public int hammingWeight2(int n) {
		int res = 0;
		while (n != 0) {
			res ++;
			n = n & (n-1);
		}
		return res;
	}
	// 网上查找的算法(1ms) https://segmentfault.com/a/1190000007492029
	public static int hammingWeight3(int n) {
		n = n - ((n>>1) & 0x55555555);
        n = (n & 0x33333333) + ((n>>2) & 0x33333333);
        n = (n + (n>>4)) & 0x0f0f0f0f;
        n = n + (n>>8);
        n = n + (n>>16);
        return n & 0x3f;
	}
	public static void main() {
		int hammingWeight = hammingWeight3(11);
		System.out.println(hammingWeight);
	}
}
