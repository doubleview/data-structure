package string;

/**
 * 数字类
 */
public class Number {

	public static void main(String[] args) {
		String s = "-12345";
		System.out.println("parseInt(\"" + s + " \")=" + parseInt(s));
		s = "-12345.67E-2";
		System.out.println("parseInt(\"" + s + " \")=" + parseDouble(s));
	}

	// 返回整数字符串s表示的整数值
	public static int parseInt(String s) {
		int x = 0, i = 0;
		int sign = s.charAt(0) == '-' ? -1 : 1;// 符号位，记住正负标记
		if (s.charAt(0) == '+' || s.charAt(0) == '-')// 跳过符号位
			i++;// 记住当前字符序号
		while (i < s.length()) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				x = x * 10 + s.charAt(i++) - '0';// 记住当前获得整数值
			else
				throw new NumberFormatException(s);// 抛出数值格式的异常
		}
		return x * sign;// 返回整数值，忽略其后的字符
	}

	// 返回实数字符串表示的浮点数值
	public static double parseDouble(String s) {
		int n = s.length(), i = 0;
		int sign = s.charAt(0) == '-' ? -1 : 1;
		double x = 0, power = 10.0E0;// power表示底数为10的幂
		if (s.charAt(0) == '+' || s.charAt(0) == '-')// 跳过符号位
			i++;

		while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9')
			// 获得整数部分值
			x = x * 10 + s.charAt(i++) - '0';
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {// 获得小数部分值
				x += (s.charAt(i) - '0') / power;
				i++;
				power *= 10;
			}
		}
		x *= sign;

		if (i < n && (s.charAt(i) == 'E' || s.charAt(i) == 'e')) {// 处理阶码
			i++;
			power = (s.charAt(i) == '-') ? 0.1 : 10;// 阶码的符号位决定指数的正负及其运算
			if (s.charAt(i) == '+' || s.charAt(i) == '-')
				i++;
			int exp = 0;
			while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9')
				exp = exp * 10 + s.charAt(i++) - '0';// 获得指数的绝对值

			for (int j = 0; j < exp; j++)
				x *= power;
		}
		return x;
	}
}