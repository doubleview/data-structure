package stackqueue.test;

public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 0; i <= 24; i++)
			System.out.println(fib(i) + " ");
		System.out.println();
	}

    // 返回Fibonacci数列的第n项，递归算法
    public static int fib(int n) {
		if (n < 0)
            throw new IllegalArgumentException("n=" + n);// 抛出无效参数异常
        if (n == 0 || n == 1)
			return n;
		return fib(n - 2) + fib(n - 1);
	}
}
