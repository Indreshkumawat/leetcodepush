/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        Node src = new Node(node.val);

        map.put(node, src);
        q.add(node);

        while (!q.isEmpty()) {

            Node n = q.poll();

            Node s = map.get(n);

            for (Node x : n.neighbors) {

                if (!map.containsKey(x)) {

                    Node temp = new Node(x.val);

                    map.put(x, temp);
                    q.add(x);
                }

                s.neighbors.add(map.get(x));
            }
        }

        return src;
    }
}