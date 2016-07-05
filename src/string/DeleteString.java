package string;

/**
 * 用于删除与指定字符串匹配的子串
 */
public class DeleteString {

	// 返回将target串中首个与pattern匹配的子串删除后的字符串
	public static String deleteFirst(String target, String pattern) {
		int i = target.indexOf(pattern);
		if (i == -1)
			return target;
		return target.substring(0, i) + target.substring(i + pattern.length());
	}

	// 返回将target串中所有与pattern匹配的子串删除后的字符串
	public static String deleteAll(String target, String pattern) {
		int i = target.indexOf(pattern);
		while (i != -1) {
			target = target.substring(0, i)
					+ target.substring(i + pattern.length());
			i = target.indexOf(pattern, i);
		}
		return target;
	}

	public static void main(String[] args) {
		String target = "ababdabcdabcabc";
		String pattern = "abc";
		String replacement = "xy";
		System.out.println(target.indexOf(pattern));
		System.out.println(target.replaceFirst(pattern, replacement));
		System.out.println(target.replaceAll(pattern, replacement));
		System.out.println(deleteFirst(target, pattern));
		System.out.println(deleteAll(target, pattern));
	}
}