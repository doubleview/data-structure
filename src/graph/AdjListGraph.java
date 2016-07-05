package graph;

import list.Node;
import list.SeqList;
import list.SortedSinglyLinkedList;

/**
 * 邻接表表示的带权图类
 */
public class AdjListGraph<T> extends AbstractGraph<T> {

	protected SeqList<Vertex<T>> vertexlist;// 顶点顺序表
	int MAX_WEIGHT = 99999;// 最大权值

	// 构造方法，size指定顶点顺序表容量
	public AdjListGraph(int size) {
		size = size < 10 ? 10 : size;
		this.vertexlist = new SeqList<Vertex<T>>(size);
	}

	// 以顶点集合和边结合构造一个图
	public AdjListGraph(T[] vertices, Edge[] edges) {
		this(vertices.length * 2);

		if (vertices != null)
			for (int i = 0; i < vertices.length; i++)
				insertVertex(vertices[i]);
		if (edges != null)
			for (int j = 0; j < edges.length; j++)
				insertEdge(edges[j]);
	}

	// 返回顶点数
	public int vertexCount() {
		return this.vertexlist.length();
	}

	// 返回顶点i的数据元素，若i指定元素无效，则返回null
	public T get(int i) {
		return this.vertexlist.get(i).data;
	}

	// 返回<vi.vj>边的权值
	public int getWeight(int i, int j) {
		int n = this.vertexCount();
		if (i >= 0 && i < n && j >= 0 && j < n) {
			if (i == j)
				return 0;
			Node<Edge> p = this.vertexlist.get(i).adjlink.head.next;// 第i条边的单链表的第一个节点
			while (p != null) {
				if (p.data.dest == j)
					return p.data.weight;// 返回<vi,vj>的权值
				p = p.next;
			}
			return MAX_WEIGHT;
		}
		throw new IndexOutOfBoundsException("i = " + i + "j=" + j);// 抛出序号越界异常
	}

	// 返回图的顶点集合和邻接表描述字符串
	public String toString() {
		return "出边表：  \n" + this.vertexlist.toString() + "\n";
	}

	// 插入元素为x的顶点，返回该顶点在顶点顺序表中的序号
	public int insertVertex(T x) {
		this.vertexlist.append(new Vertex<T>(x));// 顺序表追加元素,自动扩容
		return this.vertexlist.length() - 1;
	}

	// 插入一条权值为weight的边<vi,vj>，若该边已存在，则不插入
	public void insertEdge(int i, int j, int weight) {
		if (i >= 0 && i < vertexCount() && j >= 0 && j < vertexCount()
				&& j != i) {
			Edge edge = new Edge(i, j, weight);
			SortedSinglyLinkedList<Edge> adjlink = this.vertexlist.get(i).adjlink;// 获得第i条边单链表
			Node<Edge> front = adjlink.head, p = front.next;

			while (p != null && p.data.compareTo(edge) < 0) {// 寻找插入位置
				front = p;
				p = p.next;
			}

			if (p != null && p.data.compareTo(edge) == 0)// 若该边已存在，则不插入
				return;
			front.next = new Node<Edge>(edge, p);// 将edge边结点插入到front结点之后
		}
	}

	// 插入一条边
	public void insertEdge(Edge e) {
		insertEdge(e.start, e.dest, e.weight);
	}

	// 删除边<vi,vj>,i，j指定顶点序号
	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount() && j >= 0 && j < vertexCount()
				&& i != j) {
			this.vertexlist.get(i).adjlink.remove(new Edge(i, j, 1));// 调用排序单链表的删除操作
			// 在第i条边单链表删除指定结点，查找依据是Edge的compareTo(e)方法返回0
		}
	}

	// 删除边
	public void removeEdge(Edge edge) {
		removeEdge(edge.start, edge.dest);
	}

	// 删除序号weivi的顶点及其关联的边
	public void removeVertex(int i) {
		int n = vertexCount();// 删除之前的顶点数
		if (i < 0 || i > n)
			return;
		this.vertexlist.remove(i);// 顶点序号减1
		for (int j = 0; j < n - 1; j++) {// 未删除的边结点更改某些顶点序号
			Node<Edge> front = this.vertexlist.get(j).adjlink.head;
			Node<Edge> p = front.next;
			while (p != null) {
				Edge e = p.data;
				if (e.start == i || e.dest == i) {
					front.next = p.next;
					p = front.next;
				} else {
					if (e.start > i)
						e.start--;// 顶点序号减1
					if (e.dest > i)
						e.dest--;
					front = p;
					p = p.next;
				}
			}
		}
	}

	@Override
	// 返回//返回vi在vj的下一个邻接矩阵顶点序号
	// 当j = -1时，返回vi的第一个邻接顶点序号，若不存在邻接顶点返回-1
	public int getNextNeighbor(int i, int j) {
		int n = this.vertexCount();
		if (i >= 0 && i < n && j >= -1 && j < n && j != i) {
			Node<Edge> p = this.vertexlist.get(i).adjlink.head.next;// 获得第i条边单链表首个结点
			while (p != null) {// 寻找下一个邻接顶点
				if (p.data.dest > j)// 当j=-1时，返回第一个邻接顶点序号
					return p.data.dest;// 返回下一个邻接顶点序号
				p = p.next;
			}
		}
		return -1;
	}
}