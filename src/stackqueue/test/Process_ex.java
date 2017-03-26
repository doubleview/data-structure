package stackqueue.test;

import stackqueue.PriorityQueue;

/**
 * 模拟操作系统进程调度(利用队列)
 */

public class Process_ex {

	public static void main(String[] args) {
		Process process[] = { new Process("A", 4), new Process("B", 3),
				new Process("C", 5), new Process("D", 4), new Process("E", 10),
				new Process("F", 1) };
        PriorityQueue<Process> que = new PriorityQueue<Process>();// 创建一个优先队列
        System.out.println("入队进程");
        for (int i = 0; i < process.length; i++) {
            que.enquenu(process[i]);// 进程入队
            System.out.print(process[i] + " ");
		}
        System.out.println("\n出对进程");
        while (!que.isEmpty())
			System.out.print(que.dequeue().toString() + " ");
		System.out.println();
	}
}

/**
 * 进程
 */
class Process implements Comparable<Process> {

    private String name;// 进程名
    private int priority;// 优先级

	public Process(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;
	}

	public String toString() {
		return "(" + this.name + "," + this.priority + ")";
	}

    // 比较两个进程的大小，约定进程排序的规则
    public int compareTo(Process p) {
		return this.priority - p.priority;
	}
}