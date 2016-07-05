package string;

/**
 * 替换可变字符串的操作
 */
public class ReplaceStringBuffer {

	public static void main(String[] args) {
		StringBuffer target = new StringBuffer("aaaa");
		String pattern = "a", replacement = "ab";
		System.out.println(replaceFirst(target, pattern, replacement));
		System.out.println(replaceAll(target, pattern, replacement));
		pattern = replacement;
		System.out.println(deleteFirst(target, pattern));
	}

	// 替换第一个与指定字符串匹配的子串
	public static StringBuffer replaceFirst(StringBuffer target,
			String pattern, String replacement) {
		int i = target.indexOf(pattern);
		if (i != -1) {
			target.delete(i, i + pattern.length());
			target.insert(i, replacement);
		}
		return target;
	}

	// 替换所有与指定字符串匹配的子串
	public static StringBuffer replaceAll(StringBuffer target, String pattern,
			String replacement) {
		int i = target.indexOf(pattern);
		while (i != -1) {
			target.delete(i, i + pattern.length());
			target.insert(i, replacement);
			i = target.indexOf(pattern, i + replacement.length());
		}
		return target;
	}

	// 删除与指定字符串匹配的子串
	public static StringBuffer deleteFirst(StringBuffer target, String pattern) {
		int i = target.indexOf(pattern);
		if (i != -1) {
			target.delete(i, i + pattern.length());
		}
		return target;
	}

	// 删除所有与指定字符串匹配的子串
	public static StringBuffer deleteAll(StringBuffer target, String pattern) {
		int i = target.indexOf(pattern);
		while (i != -1) {
			target.delete(i, i + pattern.length());
			i = target.indexOf(pattern, i);
		}
		return target;
	}
}