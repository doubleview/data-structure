package graph.test;

import graph.AdjMatrixGraph;
import graph.Edge;

/**
 * 带权无向图测试
 */
public class WeightedUndiGraph3 {

	public static void main(String[] args) {
		String[] vertices = { "A", "B", "C", "D", "E" };
		Edge edges[] = { new Edge(0, 1, 5), new Edge(0, 3, 2),
				new Edge(1, 0, 5), new Edge(1, 2, 7), new Edge(1, 3, 6),
				new Edge(2, 1, 7), new Edge(2, 3, 8), new Edge(2, 4, 3),
				new Edge(3, 0, 2), new Edge(3, 1, 6), new Edge(3, 2, 8),
				new Edge(3, 4, 9), new Edge(4, 2, 3), new Edge(4, 3, 9) };
		AdjMatrixGraph<String> graph = new AdjMatrixGraph<String>(vertices,
				edges);
        System.out.println("带权无向图G3， " + graph.toString());
        System.out.println("插入顶点F，插入边(A,F,20),删除顶点C，删除边(D,E)");
        int i = graph.insertVertex("F");
        graph.insertEdge(0, i, 20);// 插入边(A,F,20)
        graph.insertEdge(i, 0, 20);// 插入边(F,A,20)
        graph.removeVertex(2);// 删除顶点C
        graph.removeEdge(2, 3);// 删除边(D,E)
        graph.removeEdge(3, 2);// 删除边(E,D)
        System.out.println(graph.toString());
	}
}
