package junior;

import org.junit.Test;

public class NnumJewelsInStones {
	public int numJewelsInStones(String J, String S) {
        char[] JChar = J.toCharArray();
        String nS = S;
        for (int i = 0; i < JChar.length; i++) {
            nS = nS.replaceAll(JChar[i]+"", "");
        }
        return S.length() - nS.length();
    }
	
	@Test
	public void test_numJewelsInStones() {
		String J = "aA";
		String S = "aAAbbbb";
		int count = numJewelsInStones(J, S);
		System.out.println(count);
	}
}
