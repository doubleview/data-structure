package stackqueue.test;

import list.SeqList;
import stackqueue.SeqQueue;

public class PrimeRing {

	public static void main(String[] args) {
		new PrimeRing(10);
	}

	/**
     * 求1-n素数环
     */
	public PrimeRing(int n) {
        SeqList<Integer> ring = new SeqList<Integer>(n);// 创建一个顺序表存储素数环
        ring.append(new Integer(1));// 1添加到素数环中
		SeqQueue<Integer> que = new SeqQueue<>(n);// 创建一个队列
		for (int i = 2; i <= n; i++)
            // 2-n全部入队
            que.enquenu(new Integer(i));
		int i = 0;
		while (!que.isEmpty()) {
            int k = que.dequeue();// 全部出队
            if (isPrime(ring.get(i) + k)) {// 判断是否为素数
                i++;
                ring.append(k);// k添加到素数环中
            } else
                que.enquenu(k);// k再次入队
        }
        System.out.println("素数环:" + ring.toString());

	}

	/**
     * k再次入队
     */
	public boolean isPrime(int k) {
		if (k == 2)
			return true;
		if (k < 2 || k > 2 && k % 2 == 0)
			return false;
		int j = (int) Math.sqrt(k);
		if (j % 2 == 0)
			j--;
		while (j > 2 && k % j != 0)
			j -= 2;
		return j < 2;
	}
}
