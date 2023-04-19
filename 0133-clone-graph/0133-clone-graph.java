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

class Solution 
{
    Node[] copyNode=new Node[100];
    public Node cloneGraph(Node node)
    {
        if(node==null)
            return null;
        int index=node.val-1;
        if(copyNode[index]==null)
        {
            copyNode[index]=new Node(node.val);
            for(Node neighbors : node.neighbors)
                copyNode[index].neighbors.add(cloneGraph(neighbors));
        }
        return copyNode[index];
        
    }
}