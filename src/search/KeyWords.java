package search;

/**
 * 
 * 扩充的关键字表类
 */
public class KeyWords {

	public static void main(String[] args) {
		String str = "final";
		System.out.println(str + (isKeywords(str) ? "" : "不") + "是关键字");
		str = "length";
		System.out.println(str + (isKeywords(str) ? "" : "不") + "是关键字");
	}

	// 关键字表
	private static String[] keywords = { "abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "continue",
			"default", "do", "double", "else", "extends", "false", "final",
			"finally", "float", "for", "if", "implements", "import",
			"instanceof", "int", "interface", "long", "native", "new", "null",
			"package", "private", "protected", "public", "return", "short",
			"static", "super", "switch", "synchronized", "this", "throw",
			"throws", "transient", "true", "try", "void", "volatile", "while" };

	// 索引表，私有成员类
	private static class IndexItem implements Comparable<IndexItem> {

		String first;// 关键字的首字母
		int start, end;// 首字母相同的关键字快在主表中的始末下标

		public IndexItem(String first, int start, int end) {
			super();
			this.first = first;
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "(" + this.first + "," + this.start + "," + this.end + ")";
		}

		// 约定两个索引项比较大小的规则，按首字母比较大小
		public int compareTo(IndexItem item) {
			return this.first.compareTo(item.first);
		}
	}

	private static IndexItem index[];// 索引表

	static {// 静态初始化
		index = new IndexItem[26];
		int i = 0, j = 0;
		for (i = 0; i < index.length && j < keywords.length; i++) {
			char ch = (char) ('a' + i);
			if (keywords[j].charAt(0) > ch)
				index[i] = new IndexItem(ch + "", -1, -1);
			else {
				int start = j++;
				while (j < keywords.length && keywords[j].charAt(0) == ch)
					j++;
				index[i] = new IndexItem(ch + "", start, j - 1);
			}
		}
	}

	// 判断str是否为java关键字
	public static boolean isKeywords(String str) {
		int pos = str.charAt(0) - 'a';// 首字母对应的索引项序号
		if (pos < 0 || pos > 26)
			return false;
		int begin = index[pos].start;// 获得主表查找范围的下界
		if (begin == -1)
			return false;
		int end = index[pos].end;// 获得主表查找范围的上界
		return BSArray.binarySearch(keywords, begin, end, str) >= 0;// 折半查找主表的指定范围
	}
}