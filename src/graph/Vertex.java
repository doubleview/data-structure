package graph;

import list.SortedSinglyLinkedList;

/**
 * 顶点表元素
 */
public class Vertex<T> {

	public T data;// 顶点数据域
	public SortedSinglyLinkedList<Edge> adjlink;// 该顶点的边单链表

	public Vertex(T data) {
		this.data = data;
		this.adjlink = new SortedSinglyLinkedList<Edge>();
	}

	// 返回顶点及其边单链表的描述字符串
	public String toString() {
		return "\n" + this.data.toString() + ":  " + this.adjlink.toString();
	}
}
