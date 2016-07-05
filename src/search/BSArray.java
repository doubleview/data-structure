package search;

/**
 * 折半查找对应数组
 */
public class BSArray {

	// 在升序排列的value数组中，折半查找关键字为key元素，若找到返回下标，否则返回-1
	public static <T> int binarySearch(Comparable<T>[] value, T key) {
		return binarySearch(value, 0, value.length - 1, key);
	}

	// 在从begin到end范围内，按升序排列的value数组中，折半查找关键字为key的元素
	public static <T> int binarySearch(Comparable<T>[] value, int begin,
			int end, T key) {
		if (key != null)
			while (begin <= end) {// 边界有效
				int mid = (begin + end) / 2;// 中间位置，当前比较元素位置
				System.out.println(value[mid] + "? ");
				if (value[mid].compareTo(key) == 0)// 对象比较大小
					return mid;// 查找成功
				if (value[mid].compareTo(key) > 0)// 给定对象小
					end = mid - 1;// 查找范围缩小到前半段
				else
					begin = mid + 1;// 查找范围缩小到后半段
			}
		return -1;// 查找不成功
	}
}
