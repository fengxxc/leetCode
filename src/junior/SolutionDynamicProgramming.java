package junior;

/**
 * 动态规划
 * @author fengxxc
 *
 */
public class SolutionDynamicProgramming {
	/**
	 * 爬楼梯
	 * 你正在爬楼梯。需要 n 步你才能到达顶部。
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
	 * 注意：给定 n 将是一个正整数。
	 * fengxxc: 其实就是斐波那契数列
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		// 递归	效率低
        /*if (n < 3) return n;
        return climbStairs(n-2) + climbStairs(n-1);*/
		
		// 迭代
		if (n < 3) return n;
		int a = 1, b = 2;
		for (int i = 3; i <= n; i++) {
			int tmp = a;
			a = b;
			b = tmp + b;
		}
		return b;
    }
	// LeetCode上 最效率最高的，缺点是占空间
	public int climbStairsFaster(int n) { 
		if(n <= 1) return 1;
		if(n == 2) return 2;
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i <= n; i++){
			arr[i] = arr[i -1] + arr[i -2];
		}
		return arr[n];
	}

	public static void main() {
		int climbStairs = climbStairs(44);
		System.out.println(climbStairs);
	}
	
}
