package list;

/**
 * 一元多项式的存储
 */
public class Polynomial {

	private PolySLinkedList<TermX> list;// 多项式排序单链表

	// 默认构造器，创建空单链表
	public Polynomial() {
		this.list = new PolySLinkedList<TermX>();
	}

	// 构造方法，由项数组指定多项式各项值
	public Polynomial(TermX terms[]) {
		this.list = new PolySLinkedList<TermX>(terms);
	}

	// 多项式深度拷贝
	public Polynomial(Polynomial poly) {
		this();// 创建空单链表，只有头结点
		Node<TermX> p = poly.list.head.next;
		Node<TermX> rear = this.list.head;
		while (p != null) {
			rear.next = new Node<TermX>(new TermX(p.data), null);
			rear = rear.next;
			p = p.next;
		}
	}

	// 构造函数，根据多项表达式进行计算
	public Polynomial(String polystr) {
		this();
		if (polystr == null || polystr.length() == 0)
			return;
		Node<TermX> rear = this.list.head;
		int start = 0, end = 0;// 序号start-end的子串为一项
		while (start < polystr.length() && end < polystr.length()) {
			int i = polystr.indexOf('+', end + 1);// 返回字符+在字符串中从end+1开始的序号
			if (i == -1)// 未找到指定字符
				i = polystr.length();
			int j = polystr.indexOf('-', end + 1);
			if (j == -1)
				j = polystr.length();
			end = i < j ? i : j;// end为下一个+或-号的序号
			rear.next = new Node<TermX>(
					new TermX(polystr.substring(start, end)), null);
			// 尾插入，以序号start-end的子串作为一串，创建节点创建元素对象
			rear = rear.next;
			start = end;
		}
	}

	// 将另一个多项式加在本多项式上
	public void add(Polynomial poly) {
		this.list.add(poly.list);
	}

	// 将两个多项式进行相加
	public Polynomial plus(Polynomial poly) {
		Polynomial cpoly = new Polynomial(this);// 深拷贝
		cpoly.add(poly);
		return cpoly;// 返回对象引用
	}

	// 返回多项式的描述字符串
	public String toString() {
		String str = "";
		Node<TermX> p = this.list.head.next;
		while (p != null) {
			str += p.data.toString();
			p = p.next;
		}
		return str;
	}

	public boolean equals(Object obj) {
		return this == obj || obj instanceof Polynomial
				&& this.list.equals(((Polynomial) obj).list);
	}

}