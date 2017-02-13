package graph;

/**
 * 图接口,图抽象数据类型
 */
public interface GGraph<T> {

	int MAX_WEIGHT = 99999;// 最大权值

	int vertexCount();// 返回顶点数

	T get(int i); // 返回定点vi的数据元素

	int getWeight(int i, int j);// 返回<vi,vj>边的权值

	int insertVertex(T x);// 插入元素值x的顶点,返回顶点序号

	void insertEdge(int i, int j, int weight);// 插入一条权值为weight<vi,vj>

	void removeVertex(int i);// 删除顶点vi及其关联的边

	void removeEdge(int i, int j);// 删除顶点<vi,vj>

	int getNextNeighbor(int i, int j);// 返回vi在vj后的下一个领结顶点序号

	void DFSTraverse(int i);// 从顶点vi出发对图进行一次深度优先搜索遍历

	void BFSTraverse(int i);// 从顶点vj出发对图进行一次广度优先遍历
}