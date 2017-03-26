package stackqueue.test;

/**
 * 求n阶乘
 * 
 * @author Administrator
 *
 */
public class Factorial {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(n + "!=" + factorial(n));
	}

    // 求阶乘n！，递归方法
    public static int factorial(int n) {
		if (n < 0)
            throw new IllegalArgumentException("n=" + n);// 抛出无效参数异常
        if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
