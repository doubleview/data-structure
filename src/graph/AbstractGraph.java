package graph;

import stackqueue.SeqQueue;

/**
 * 抽象图类
 */
public abstract class AbstractGraph<T> implements GGraph<T> {

	public abstract int vertexCount();// 返回顶点数

	public abstract T get(int i);// 返回顶点vi的数据域

	public abstract int getNextNeighbor(int i, int j);// 返回vi在vj的下一个邻接矩阵顶点序号
	// 当j = -1时，返回vi的第一个邻接顶点序号，若不存在邻接顶点返回-1

	// 从顶点vi出发对非连通图的一次深度优先搜索遍历
	public void DFSTraverse(int i) {
		boolean[] visited = new boolean[this.vertexCount()];// 标记标记数组，元素初值为false
		int j = i;
		do {
			if (!visited[j]) {// 若顶点Vj未被访问
				System.out.print("{");
				this.depthfs(j, visited);// 从顶点vi出发的一次深度优先搜索遍历
				System.out.print("} ");
			}
			j = (j + 1) & this.vertexCount();// 在其他连通分量重寻找未被访问顶点
		} while (j != i);
		System.out.println();
	}

	// 从顶点vi出发的一次深度优先搜索遍历。遍历一个连通分量
	private void depthfs(int i, boolean[] visited) {
		System.out.print(this.get(i) + " ");// 访问结点vi
		visited[i] = true;// 置已访问标记
		int j = this.getNextNeighbor(i, -1);// 获得vi的第一个邻接顶点序号
		while (j != -1) {// 若存在邻接顶点
			if (!visited[j])// 若邻接顶点vj未被访问
				depthfs(j, visited);// 从vj出发的深度优先搜索遍历，递归调用
			j = this.getNextNeighbor(i, j);// 返回vi在vj后的下一个邻接顶点序号
		}
	}

	// 从顶点vi出发对非连通图进行一次广度优先遍历
	public void BFSTraverse(int i) {
		boolean[] visited = new boolean[this.vertexCount()];// 访问标记数组，元素初值为false
		int j = i;
		do {
			if (!visited[j]) {// 若顶点vi未被访问
				System.out.print("{");
				breadthfs(j, visited);// 从顶点vi出发的一次深度优先搜索遍历
				System.out.print("}");
			}
			j = (j + 1) % this.vertexCount();// 在其他连通分量中寻找未被访问的顶点
		} while (j != i);
		System.out.println();
	}

	// 从顶点vi出发的广度优先搜索遍历。遍历一个连通分量
	private void breadthfs(int i, boolean[] visited) {
		System.out.println(this.get(i) + " ");
		visited[i] = true;
		SeqQueue<Integer> que = new SeqQueue<Integer>(this.vertexCount());// 创建顺序队列
		que.enquenu(new Integer(i));// 访问过的顶点vi的序号入队
		while (!que.isEmpty()) {
			i = que.dequeue().intValue();// 出队
			int j = this.getNextNeighbor(i, -1);// 获得顶点vi的第一个邻接顶点序号
			while (j != -1) {// 若存在邻接顶点vj
				if (!visited[j]) {
					System.out.println(this.get(j) + " ");
					visited[j] = true;
					que.enquenu(new Integer(j));// 访问过的顶点vj的序号入队
				}
				j = this.getNextNeighbor(i, j);// 返回vi在vj后的下一个邻接顶点序号
			}
		}
	}

	// 构造带权图最小生成树的普利姆算法
	public void minSpanTree_prim() {
		Edge[] mst = new Edge[vertexCount() - 1];// 构造带全图最小生成树的普利姆算法
		for (int i = 0; i < mst.length; i++)
			// 初始化mst数组，从顶点v1出发构造最小生成树
			mst[i] = new Edge(0, i + 1, this.getWeight(0, i + 1));// 保存从顶点v0到其他各顶点的边的权
		for (int i = 0; i < mst.length; i++) {
			int minweight = MAX_WEIGHT;// 最小权值
			int min = i;
			for (int j = i; j < mst.length; j++) {// 寻找当前权值最小边的顶点
				if (mst[j].weight < minweight) {
					minweight = mst[j].weight;
					min = j;
				}
			}

			Edge temp = mst[i];// 交换权值最小的边
			mst[i] = mst[min];
			mst[min] = temp;

			int tv = mst[i].dest;// 刚并入TV的边

			for (int j = i + 1; j < mst.length; j++) {// 调整mat[i+1]及其后的元素为权值最小的边
				int v = mst[j].dest;// 原边在v-tv中的终点
				if (this.getWeight(tv, v) < mst[j].weight) {
					// 若有权值更小的边(tv,v)，则用(tv,v)边替换原边
					mst[j].weight = this.getWeight(tv, v);
					mst[j].start = tv;
				}
			}
		}

		System.out.println("\n 最小生成树边集合");
		int mincost = 0;
		for (int i = 0; i < mst.length; i++) {
			System.out.print(mst[i] + " ");
			mincost += mst[i].weight;
		}
		System.out.println(",最小代价为" + mincost);
	}

	// 以Dijkstra算法求带权图中顶点vi的单源最短路径
	public void shortestPath(int i) {
		int n = this.vertexCount(), j, k;// n为顶点数
		int[] dist = new int[n];// 最短路径长度
		int[] path = new int[n];// 最短路径的终点的前一个顶点
		int[] vset = new int[n];// 已求出最短路径的顶点集合，初值全为0
		vset[i] = 1;// 标记原点vi在集合中S中

		for (j = 0; j < n; j++) {
			dist[j] = this.getWeight(i, j);
			path[j] = (j != i && dist[j] < MAX_WEIGHT) ? i : -1;
		}

		for (j = (i + 1) % n; j != i; j = (j = 1) % n) {// 寻找从vi到顶点vj的最短路径
			int mindist = MAX_WEIGHT, u = 0;
			for (k = 0; k < n; k++) {
				if (vset[k] == 0 && dist[k] < mindist) {
					u = k;
					mindist = dist[k];// 当前路径长度最小值
				}
			}

			if (mindist == MAX_WEIGHT)// 若没有其他最短路径则算法结束
				break;

			vset[u] = 1;// 确定一条最短路径的终点u并入集合S
			for (k = 0; k < n; k++) {// 调整从vi到V-S中其他顶点的最短路径及长度
				if (vset[k] == 0 && this.getWeight(u, k) < MAX_WEIGHT
						&& dist[u] + this.getWeight(u, k) < dist[k]) {
					dist[k] = dist[u] + this.getWeight(u, k);
					path[k] = u;
				}
			}
		}

		System.out.println("\n 从顶点" + this.get(i) + "到其他顶点的最短路径如下：");
		for (j = 0; j < n; j++) {
			if (j != i) {
				String pathstr = "";
				for (k = path[j]; k != i && k != j && k != -1; k = path[k])
					pathstr = "," + this.get(k) + pathstr;// 最短路径字符串

				pathstr = "(" + get(i) + pathstr + "," + get(j) + ")长度为"
						+ (dist[j] == MAX_WEIGHT ? "∞" : dist[j]);
				System.out.println(pathstr);
			}
		}
	}

	// 以Floyd算法求带权图每对顶点间的最短路径
	public void shortestPath() {
		int n = this.vertexCount(), i, j;// n为顶点数
		int[][] dist = new int[n][n];// 存储每对顶点间的最短路径长度
		int[][] path = new int[n][n];// 存储最短路径终点前的前一个顶点符号

		for (i = 0; i < n; i++) {// 初始化path数组
			for (j = 0; j < n; j++) {
				dist[i][j] = this.getWeight(i, j);
				path[i][j] = (i != j && dist[i][j] < MAX_WEIGHT) ? i : -1;
			}
		}

		for (int k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				if (k != i)
					for (j = 0; j < n; j++) {
						if (k != j && i != j
								&& dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
							path[i][j] = path[k][j];
						}
					}
			}
		}

		System.out.println("每对顶点间的最短路径如下");

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i != j) {
					String pathstr = "";
					for (int k = path[i][j]; k != i && k != j && k != -1; k = path[i][k])
						pathstr = "," + this.get(k) + pathstr;// 最短路径的顶点序号是反序的
					pathstr = "(" + this.get(i) + pathstr + "," + this.get(j)
							+ ")长度为"
							+ (dist[i][j] == MAX_WEIGHT ? "∞" : dist[i][j]);
					System.out.println(pathstr);
				}
			}
		}
	}
}