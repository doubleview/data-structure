package string;

/**
 * 模仿整数
 */
public class Int {

	public static void main(String[] args) {
		int n = 254;
		System.out.println(Int.toBinaryString(n));
		System.out.println(Int.toHexString(n));
		System.out.println(Int.toString(n, 8));
	}

	// 转换为二进制
	public static String toBinaryString(int n) {
		String str = "";
		// 一个int占32位，右移一位，高位以0填充
		for (int i = 0x80000000; i != 0; i >>>= 1)
			str += (n & i) == 0 ? '0' : '1';
		return str;// 返回字符串
	}

	// 转换为十六进制
	public static String toHexString(int n) {
		String str = "";
		while (n > 0) {
			int k = n % 16;// 除16取余法，余数存入str字符串
			str = (char) (k <= 9 ? k + '0' : k + 'A' - 10) + str;// 将0-9，10-15转换成'0'-'9','A'-'F'
			n /= 16;
		}
		return str;
	}

	// 转换为任意进制
	public static String toString(int n, int radix) {
		String str = "";
		while (n > 0) {
			int k = n % radix;
			str += (char) (k <= 9 ? k + '0' : k - 10 + 'A');
			n /= radix;
		}
		return str;
	}
}