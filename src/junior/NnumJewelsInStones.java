package junior;

public class NnumJewelsInStones {
	public static int numJewelsInStones(String J, String S) {
        char[] JChar = J.toCharArray();
        String nS = S;
        for (int i = 0; i < JChar.length; i++) {
            nS = nS.replaceAll(JChar[i]+"", "");
        }
        return S.length() - nS.length();
    }
	
	public static void main() {
		String J = "aA";
		String S = "aAAbbbb";
		int count = numJewelsInStones(J, S);
		System.out.println(count);
	}
}
