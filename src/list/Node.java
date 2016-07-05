package list;

/**
 * 单链表节点类，T表示指定节点的元素类型
 */
public class Node<T> {

	public T data;// 数据域，保存数据元素
	public Node<T> next;// 地址域，引用后继节点

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
		this(null, null);
	}
}
