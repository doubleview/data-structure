package search;

import list.SinglyLinkedList;

/**
 * 采用链地址法的散列表类
 */
public class HashSet<T> {

	private SinglyLinkedList<T>[] table;// 散列表，同义词单链表对象数组

	@SuppressWarnings("unchecked")
	// 构造指定容量的散列表
	public HashSet(int size) {
		this.table = new SinglyLinkedList[Math.abs(size)];
		for (int i = 0; i < table.length; i++) {
			table[i] = new SinglyLinkedList<T>();
		}
	}

	// 构造默认容量的散列表，默认97是100以内的最大素数
	public HashSet() {
		this(97);
	}

	// 散列函数，确定关键字为key的元素的散列地址
	private int hash(T x) {
		int key = Math.abs(x.hashCode());// 每个对象的hashcode方法返回int
		return key % table.length;// 除流余数法，除数是散列表长度
	}

	// 插入x元素，插入作为同义词单恋表的第一个节点
	public void insert(T x) {
		table[hash(x)].insert(0, x);
	}

	// 删除x元素，插入作为同义词单链表的第一个节点
	public void remove(T x) {
		table[hash(x)].remove(x);
	}

	// 返回找到的关键字为key元素，若查找不成功则返回null
	public T search(T key) {
		return table[hash(key)].search(key);
	}

	// 判断散列表中是否包含关键字为key元素
	public boolean contain(T key) {
		return this.search(key) == null;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < table.length; i++) {// 遍历散列表所有元素的描述字符串
			if (!table[i].isEmpty())
				str += table[i].toString() + "\n";
		}
		return str;
	}
}