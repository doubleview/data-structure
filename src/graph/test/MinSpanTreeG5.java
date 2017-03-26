package graph.test;

import graph.AdjMatrixGraph;
import graph.Edge;

/**
 * 构造带权无向图的最小生成树
 */
public class MinSpanTreeG5 {

	public static void main(String[] args) {
		String[] vertices = { "A", "B", "C", "D", "E" };
		Edge edges[] = { new Edge(0, 1, 25), new Edge(0, 2, 4),
				new Edge(0, 3, 22), new Edge(1, 0, 25), new Edge(1, 2, 16),
				new Edge(1, 4, 3), new Edge(2, 0, 4), new Edge(2, 1, 16),
				new Edge(2, 4, 7), new Edge(2, 3, 18), new Edge(3, 0, 22),
				new Edge(3, 2, 18), new Edge(3, 2, 18), new Edge(3, 4, 9),
				new Edge(4, 1, 3), new Edge(4, 2, 7), new Edge(4, 3, 9) };
		AdjMatrixGraph<String> graph = new AdjMatrixGraph<>(vertices,
				edges);
        System.out.println("带权无向图G5，" + graph.toString());
        graph.minSpanTree_prim();// 构造带权图最小生成树的普利姆算法
    }
}
