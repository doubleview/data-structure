package array;

/**
 * 线性压缩存储的下三角矩阵类
 */
public class DownTriangleMatrix {

	private int rows;// 下三角矩阵行数（阶数）
	private int element[];// 存储下三角矩阵的一维数组

	// 构造rows阶下三角矩阵，元素为0
	public DownTriangleMatrix(int rows) {
		if (rows < 0)
			// 抛出无效参数异常
			throw new IllegalArgumentException("矩阵行数非正数：" + rows);
		this.rows = rows;
		// rows阶下三角矩阵存储rows*(rows+1)/2个元素
		this.element = new int[rows * (rows + 1) / 2];
	}

	// 构造rows阶下三角矩阵，初值由mat提供，mat按行主序顺序存储rows阶下三角矩阵
	public DownTriangleMatrix(int rows, int mat[]) {
		this(rows);
		int n = element.length <= mat.length ? element.length : mat.length;
		for (int i = 0; i < n; i++) {
			this.element[i] = mat[i];
		}
	}

	// 返回矩阵第i行第j列元素值
	public int get(int i, int j) {
		if (i < 0 || i > this.rows || j < 0 || j > this.rows)
			throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
		return i < j ? 0 : element[i * (i + 1) / 2 + j];// 按线性压缩存储地址寻找矩阵元素
	}

	// 设置矩阵第i行和第j列元素值为value
	public void set(int i, int j, int value) {
		if (i < 0 || i > this.rows || j < 0 || j > this.rows)
			throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
		this.element[i * (i + 1) / 2 + j] = value;
	}

	// 返回下三角矩阵所有元素的描述字符串，行主序遍历
	public String toString() {
		String str = "下三角矩阵" + this.getClass().getName() + "(" + this.rows
				+ "阶 ）: \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.rows; j++)
				str += String.format("%4d", this.get(i, j));
			str += "\n";
		}
		return str;
	}

	// 当前下三角矩阵与mat矩阵相加，this+=mat，个对应元素相加，改变当前矩阵
	public void add(DownTriangleMatrix mat) {
		if (this.rows != mat.rows)
			throw new IllegalArgumentException("两个矩阵结束不同，不能相加");
		for (int i = 0; i < this.element.length; i++)
			this.element[i] += mat.element[i];
	}
}
