/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap =
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hashMap.put(node, head);

        dfs(hashMap, node);
        return head;
    }

    private void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap,
        UndirectedGraphNode node) {
        if (node == null)
            return;

        for (UndirectedGraphNode aNeighbor : node.neighbors) {
            if (!hashMap.containsKey(aNeighbor)) {
                UndirectedGraphNode newNeighbor = new UndirectedGraphNode(aNeighbor.label);
                hashMap.put(aNeighbor, newNeighbor);
                dfs(hashMap, aNeighbor);
            }
            hashMap.get(node).neighbors.add(hashMap.get(aNeighbor));
        }
    } 
}