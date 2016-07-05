package sort;

/**
 * 将随机序列进行排序
 */
public class IntRandom {

	// 产生n个随机数进行排序
	public static int[] random(int n) {
		int[] table = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = (int) (Math.random() * 100);
		}
		return table;
	}

	public static void main(String[] args) {
		int[] table = random(6);
		System.out.print("关键字序列：");
		Array.print(table);
		Array.insertSort(table);
	}
}