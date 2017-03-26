package graph.test;

import graph.AdjListGraph;
import graph.Edge;

/**
 * 带权有向图测试
 */
public class WeightedDirectedG6 {

	public static void main(String[] args) {
		String[] vertices = { "A", "B", "C", "D", "E" };
		Edge edges[] = { new Edge(0, 1, 10), new Edge(0, 3, 30),
				new Edge(0, 4, 99), new Edge(1, 2, 50), new Edge(1, 3, 40),
				new Edge(2, 4, 10), new Edge(3, 2, 20), new Edge(3, 4, 60) };
		AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);
        System.out.println("带权有向图G6，" + graph.toString());
        System.out.println("-----------------------");
        graph.shortestPath(0);//返回特定顶点的最短路径
        System.out.println("-----------------------");
        graph.shortestPath();//返回所每队顶点的最短路径
    }
}
