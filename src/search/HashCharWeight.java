package search;

/**
 * 采用散列表存储统计结果
 */
public class HashCharWeight {

	public static void main(String[] args) {
		new HashCharWeight("public class");
	}

	private HashSet<CharCount> hashset;

	public HashCharWeight(String text) {
        hashset = new HashSet<>(text.length());// 创建空散列表
        for (int i = 0; i < text.length(); i++) {// 字符查找技术
			CharCount key = new CharCount(text.charAt(i), 1);
			CharCount find = hashset.search(key);// 查找，find引用查找到的元素
			if (find == null)
				hashset.insert(key);// 散列表插入
			else
				find.add(1);// 对应字符计数加1
		}
		System.out.println("字符出现次数 ： " + hashset.toString());
	}

    /**
     * 字符及其出现次数
     */
    private final class CharCount {
        char character;// 字符
        int count;// 出现次数

        public CharCount(char character, int count) {
            super();
            this.character = character;
            this.count = count;
        }

        // 返回字符及其出现次数描述字符串。形式为“（字符，出现次数）”
        public String toString() {
            return "(" + this.character + "," + this.count + ")";
        }

        public void add(int n) {
            this.count += n;
        }

        // 返回散列码，覆盖Object类的hashcode方法。根据字符决定对象在散列表中的位置
        public int hashCode() {
            return (int) this.character;
        }

        // 比较两个对象是否相等，覆盖Object类的equals方法
        public boolean equals(Object obj) {
            return obj == this || obj instanceof CharCount
                    && this.character == ((CharCount) obj).character;// 仅比较字符是否相等
        }
    }
}

