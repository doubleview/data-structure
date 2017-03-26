package graph.test;

import graph.AdjListGraph;
import graph.Edge;

/**
 * 邻接表图测试
 */
public class WeightedDirectedGraph4 {

	public static void main(String[] args) {
		String[] vertices = { "A", "B", "C", "D", "E" };
		Edge edges[] = { new Edge(0, 1, 5), new Edge(0, 3, 2),
				new Edge(1, 0, 6), new Edge(1, 2, 7), new Edge(2, 4, 3),
				new Edge(3, 2, 8), new Edge(3, 4, 9) };
		AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);
        System.out.println("带权有向图G4" + graph.toString());
        System.out.println("插入顶点F，插入边(A,F,20),删除顶点C");
        int i = graph.insertVertex("F");
        graph.insertEdge(0, i, 20);// 插入边<A,F,20>
        graph.removeVertex(2);// 删除顶点C
        System.out.println(graph.toString());
	}
}