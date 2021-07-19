package junior;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 * "@"左边时localName，右边时domainName 对于localName，"."会被忽略；"+"本身及其右边的会被忽略
 * 比如说：m.y+name@email.com 将被发送到 my@email.com.
 * 问题：输入email地址列表，输出最终发出的email地址个数
 * @author fengxxc
 *
 */
public class _929_Unique_Email_Addresses {
	public int numUniqueEmails(String[] emails) {
		Set<String> actualEmails = new HashSet<String>();
		for (int i = 0; i < emails.length; i++) {
			String e = emails[i];
			String[] split = e.split("@");
			if (split.length < 2) continue;
			String localname = split[0];
			if (localname.contains("+")) {
				int plusIndex = localname.indexOf("+");
				localname = localname.substring(0, plusIndex);
			}
			localname = localname.replace(".", "");
			actualEmails.add(localname+split[1]);
		}
		return actualEmails.size();
	}
	
	@Test
	public void test() {
		int count = numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com","testemaildavid@lee.tcode.com"});
		System.out.println(count);
	}
	
}
