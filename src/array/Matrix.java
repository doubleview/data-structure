package array;

/**
 * 矩阵类
 */
public class Matrix {

	private int element[][];// 存储矩阵的二维数组

	public Matrix(int m, int n) {
		// 若m或n为负数，java将抛出负数组异常NegativeArraySizeException
		this.element = new int[m][n];
	}

	// 构造一个n×n的零方阵
	public Matrix(int n) {
		this(n, n);
	}

	// 构造m×n矩阵，由mat提供元素
	public Matrix(int m, int n, int mat[][]) {
		this(m, n);
		// mat元素不足时补零，忽略多余元素
		for (int i = 0; i < mat.length && i < m; i++)
			for (int j = 0; j < mat[i].length && j < n; j++)
				this.element[i][j] = mat[i][j];
	}

	// 返回矩阵第i行第j列的元素值
	public int get(int i, int j) {
		return this.element[i][j];
	}

	// 设置矩阵第i行第j列的元素值为value
	public void set(int i, int j, int value) {
		this.element[i][j] = value;
	}

	// 返回矩阵所有元素的描述字符串
	public String toString() {
		String str = "矩阵Matrix(" + this.element.length + ","
				+ this.element[0].length + ") : \n";
		for (int i = 0; i < this.element.length; i++) {
			for (int j = 0; j < this.element[i].length; j++)
				str += String.format("%4d", this.element[i][j]);
			str += "\n";
		}
		return str;
	}

	// 当前矩阵与mat相加，this+=mat,各对应元素相加，改变当前矩阵
	public void add(Matrix mat) {
		if (this.element.length != mat.element.length
				&& this.element[0].length != mat.element[0].length)
			throw new IllegalArgumentException("两个矩阵不同，不能相加");// 无效参数异常
		for (int i = 0; i < this.element.length; i++) {
			for (int j = 0; j < this.element[i].length; j++) {
				this.element[i][j] += mat.element[i][j];
			}
		}
	}
}