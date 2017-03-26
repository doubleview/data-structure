package sort;

/**
 * 提供数组排序算法
 */
public class ArraySort {

    // 插入排序------------直接插入排序(稳定)
    public static void insertSort(int[] table) {
        for (int i = 1; i < table.length; i++) {// n-1趟扫描
            int temp = table[i], j;// 每趟将table[i]插入到前面排序序列中
            // 将前面较大元素向后移动
            for (j = i - 1; j >= 0 && temp < table[j]; j--)
                table[j + 1] = table[j];// temp值到达插入位置
            table[j + 1] = temp;
		}
	}


    // 插入排序---------------希尔排序(不稳定)
    public static void shellSort(int[] table) {
        for (int delta = table.length / 2; delta > 0; delta /= 2) {// 若干趟扫描控制增量，增量减半
            for (int i = delta; i < table.length; i++) {// 一趟分若干组，每组进行直接插入排序
                int temp = table[i], j;
                // 每组元素相距delta远，寻找插入位置
                for (j = i - delta; j >= 0 && temp < table[j]; j -= delta)
					table[j + delta] = table[j];
                table[j + delta] = temp;// 插入元素
            }
		}
	}

    // 交换排序-------冒泡排序法(稳定)
    public static void bubbleSort(int[] table) {
        boolean exchange = true;// 是否交换的标记
        for (int i = 1; i < table.length && exchange; i++) {// 有交换时再进行下一趟，最多n-1趟
            exchange = false;// 假定元素未交换
            for (int j = 0; j < table.length - 1; j++) {// 一趟比较，交换
                if (table[j] > table[j + 1]) {
					int temp = table[j];
					table[j] = table[j + 1];
					table[j + 1] = temp;
                    exchange = true;// 有交换
                }
			}
		}
	}

    // 交换排序------------快速排序(不稳定)
    public static void quickSort(int[] table) {
		quickSort(table, 0, table.length - 1);
	}

    // 一趟快速排序，begin,end指定序列的下界和上界，递归算法
    private static void quickSort(int[] table, int begin, int end) {
        if (begin < end) {// 序列有效
            int i = begin, j = end;
            int vot = table[i];// 第一个值作为基准值
            while (i != j) {// 一趟排序
                while (i < j && vot <= table[j])
                    // 从后向前寻找最小值
                    j--;
				if (i < j)
                    table[i++] = table[j];// 较小值向前运动

				while (i < j && table[i] <= vot)
                    // 从前向后寻找较大值
                    i++;
				if (i < j)
                    table[j--] = table[i];// 较大元素向后移动
            }
            table[i] = vot;// 基准值到达最终位置
            quickSort(table, begin, j - 1);// 前端子序列再排序，递归调用
            quickSort(table, i + 1, end);// 后端子序列再排序，递归调用
        }
	}

    // 选择排序-------------直接选择排序(不稳定)
    public static void selectSort(int[] table) {
        for (int i = 0; i < table.length - 1; i++) {// n-1趟排序
            int min = i;// 设第i个元素最小
            for (int j = i + 1; j < table.length; j++) {// 在子序列中查找最小值
                if (table[j] < table[min])
					min = j;
			}
            if (min != i) {// 将本趟最小元素交换到前边
                int temp = table[i];
				table[i] = table[min];
				table[min] = temp;
			}
		}
	}

    // 选择排序-------------------堆排序(不稳定)
    public static void heapSort(int[] table) {
		int n = table.length;
        // 创建最小堆
        for (int j = n / 2 - 1; j >= 0; j--)
			sift(table, j, n - 1);
        for (int j = n - 1; j > 0; j--) {// 每趟将最小堆交换到后面，再调整成堆
            int temp = table[0];
			table[0] = table[j];
			table[j] = temp;
			sift(table, 0, j - 1);
		}
	}

    // 将以begin为跟的子树调整成最小堆，begin，end是序列下界和上界
    private static void sift(int[] table, int begin, int end) {
        int i = begin, j = 2 * i + 1;// i为子树的跟，j为i结点的跟
        int temp = table[i];// 获得第i个元素的值

        while (j <= end) {// 沿较小值孩子结点向下筛选
            if (j < end && table[j] < table[j + 1])// 数组元素比较
                j++;
            if (temp > table[j]) {// 若父母结点较大
                table[i] = table[j];// 孩子结点中的较小值上移
                i = j;// i，j向下一层
                j = 2 * i + 1;
			} else
				break;
		}
        table[i] = temp;// 当前子树的原跟值调整后的位置
    }

    // 一次归并
    private static void merge(int[] X, int[] Y, int m, int r, int n) { // 一次归并
        int i = m, j = r, k = m;

		while (i < r && j < r + n && j < X.length)
            // 将X中两个相邻子序列归并到Y中
            if (X[i] < X[j])// 较小值复制到Y中
                Y[k++] = X[i++];
			else
				Y[k++] = X[j++];
        // 将前一个子序列剩余元素复制到Y中
        while (i < r)
			Y[k++] = X[i++];
		while (j < r + n && j < X.length)
            // 将后一个子序列剩余元素复制到Y中
            Y[k++] = X[j++];
	}

    // 一趟归并
    private static void mergepass(int[] X, int[] Y, int n) {
		int i = 0;
		while (i < X.length - 2 * n + 1) {
			merge(X, Y, i, i + n, n);
			i += 2 * n;
		}
		if (i + n < X.length)
            merge(X, Y, i, i + n, n);// 再一次归并
        else
			for (int j = i; j < X.length; j++)
                // 将X剩余元素复制到Y中
                Y[j] = X[j];
	}

    // 归并排序---------------------------------(稳定)
    public static void mergeSort(int[] X) {
        int[] Y = new int[X.length];// Y数组长度同X数组
        int n = 1;// 已排序的子序列长度，初值为1
        while (n < X.length) {
            mergepass(X, Y, n);// 一趟排序，将X数组中各子序列归并到Y中
            n *= 2;// 子序列长度加倍
            if (n < X.length) {
                mergepass(Y, X, n);// 将Y数组个子序列再归并到X中
                n *= 2;
			}
		}
	}
}