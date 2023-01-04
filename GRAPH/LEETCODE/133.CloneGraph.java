//LC-133


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
    public Node Dfs(Node copy[],Node node)
    {
        if(copy[node.val]!=null)
        {
            return copy[node.val];
        }
        copy[node.val]=new Node(node.val);
        for(Node adj:node.neighbors)
        {
           copy[node.val].neighbors.add(Dfs(copy,adj));

        }
        return copy[node.val];
    }
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node copy[]=new Node[101];
        Dfs(copy,node);
        return Dfs(copy,node);

    }
}
