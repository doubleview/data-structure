package leetcode_algorithm;


import java.util.*;

/**
 克隆一个无向图，每一个节点都包含一个标签和很多邻接节点
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


        OJ's undirected graph serialization:
        Nodes are labeled uniquely.

        We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
        As an example, consider the serialized graph {0,1,2#1,2#2,2}.

        The graph has a total of three nodes, and therefore contains three parts as separated by #.

        First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
        Second node is labeled as 1. Connect node 1 to node 2.
        Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
        Visually, the graph looks like the following:

        1
        / \
        /   \
        0 --- 2
        / \
        \_/

*/

public class q133_CloneGraph {


    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    /**
     * 解法1 (DFS解法)
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if(node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }


    /**
     * 解法2 (利用队列)
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();

        map.put(newNode.label, newNode);

        Deque<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.pop();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newNode;
    }

    private static final class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

}
