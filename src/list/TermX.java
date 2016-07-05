package list;

/**
 * 一元多项式的一项，实现可比较接口和可相加接口
 */
public class TermX implements Comparable<TermX>, Addible<TermX> {

	protected int ceof, exp;// 系数和指数

	public TermX(int ceof, int exp) {
		this.ceof = ceof;
		this.exp = exp;
	}

	public TermX(TermX term) {
		this(term.ceof, term.exp);
	}

	// 以系数x^指数的简略形式构造一元多项式的一项
	public TermX(String termStr) {
		if (termStr.charAt(0) == '+') {// 去掉+
			termStr = termStr.substring(1);
		}
		int i = termStr.indexOf('x');// 没有x。即指数为0
		if (i == -1) {
			this.ceof = Integer.parseInt(termStr);
			this.exp = 0;
		} else {
			if (i == 0)// 以x开头，则系数为1
				this.ceof = 1;
			else {
				String sub = termStr.substring(0, i);
				if (sub.equals("-"))// 系数只有-号，则系数为1
					this.ceof = -1;
				else
					this.ceof = Integer.parseInt(sub);// 获得系数
			}
			i = termStr.indexOf('^');
			if (i == -1)
				this.exp = 1;// 没有^即指数为1
			else
				this.exp = Integer.parseInt(termStr.substring(i + 1));
		}
	}

	@Override
	// 加法，+=运算符作用
	public void add(TermX term) {
		if (this.compareTo(term) == 0)
			this.ceof += term.ceof;
		else
			throw new IllegalArgumentException("两项指数不同，不能相加");
	}

	@Override
	public boolean removeable() {
		return this.ceof == 0;
	}

	@Override
	// 约定按指数比较两项大小
	public int compareTo(TermX o) {
		if (this.exp == o.exp)// 比较相等，进指数相等
			return 0;// 比较规则与equals不同
		return this.exp < o.exp ? -1 : 1;// 比较大小仅比较指数
	}

	@Override
	// 返回一元多项式的字符串表示形式
	public String toString() {
		String str = this.ceof > 0 ? "+" : "-";// 系数的符号位
		if (this.exp == 0 || this.exp > 0 && this.ceof != 1 && this.ceof != -1)
			str += Math.abs(this.ceof);// 系数绝对值省略系数1
		if (this.exp > 0)
			str += "x";// 指数为0时，省略x^0,只写系数
		if (this.exp > 1)
			str += "^" + this.exp;// 指数为1时，省略^1，只写x
		return str;
	}

	@Override
	// 比较两项是否相等
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TermX))
			return false;
		TermX term = (TermX) obj;
		return this.ceof == term.ceof && this.exp == term.exp;// 比较规则与compare不同
	}
}
