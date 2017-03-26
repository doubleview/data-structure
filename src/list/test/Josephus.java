package list.test;

import list.SeqList;

/**
 * 利用顺序表解决约瑟夫环问题
 */

public class Josephus {
    // 创建约瑟夫环并求解，参数指定环长度，起始位置，计数
    public Josephus(int number, int start, int distance) {
        // 采用顺序表存储约瑟夫环的元素，元素类型是字符串，构造方法参数指定顺序表容量
        SeqList<String> list = new SeqList<String>(number);

		for (int i = 0; i < number; i++) {
            list.append((char) ('A' + i) + "");// 添加字符串对象
        }

        System.out.println("约瑟夫环(" + number + "," + start + "," + distance);
        System.out.println(list.toString());// 输出顺序表的描述字符串
        int i = start;// 记录起始位置
        while (list.length() > 1) {// 多余一个对象时循环
            i = (i + distance - 1) % list.length();// 计数按循环规律变化，顺序表可看做环形结构
            System.out.print("刪除" + list.remove(i).toString() + ",   ");// 删除指定位置对象
            System.out.println(list.toString());
		}

        System.out.println("被赦免的是" + list.get(0).toString());
    }

	public static void main(String[] args) {
		new Josephus(5, 0, 2);
	}
}
