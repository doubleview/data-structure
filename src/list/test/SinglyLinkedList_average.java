package list.test;

import list.Node;
import list.SinglyLinkedList;

/**
 * 计算单链表中的平均值(去掉最大值和最小值)
 */
public class SinglyLinkedList_average {

	public static Integer[] random(int n) {
		Integer[] element = new Integer[n];
		for (int i = 0; i < n; i++)
			element[i] = new Integer((int) (Math.random() * 100));
		return element;
	}

    // 去掉最高分和最低分，再求平均值
    public static double averageExceptMaxMin(SinglyLinkedList<Integer> list) {
		if (list.isEmpty())
            throw new IllegalArgumentException("不能对空单链表计算其平均值。");// 无效参数异常

		int sum = 0, i = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Node<Integer> p = list.head.next;// 要求head权限必须是public
        while (p != null) {
			int value = p.data;
			sum += value;
			if (value > max)
				max = value;
			if (value < min)
				min = value;
			p = p.next;
			i++;
		}

		if (i == 1 || i == 2)
            return (double) sum / i;// 返回连个元素的平均值，避免了除数为0的错误
        return (double) (sum - max - min) / (i - 2);// 返回去掉最高分和最低分的平均值
    }

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(
				random(10));
		System.out.println("list :" + list.toString());
		System.out
				.println("averageExceptMaxMin:  " + averageExceptMaxMin(list));
	}
}
