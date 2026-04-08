/*
Definition for a Node.
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
        HashMap<Integer,Node> clones = new HashMap<Integer,Node>();
        return cloneNode(node, clones);
    }
    
    public Node cloneNode(Node node, HashMap<Integer,Node> clones){
        if(node == null)
            return null;
            
        Node clone = new Node(node.val, new ArrayList<Node>());
        clones.put(node.val, clone);
        
        for(Node neighbor: node.neighbors){
            if(clones.containsKey(neighbor.val)){
                clone.neighbors.add(clones.get(neighbor.val));
            }
            else{
                clone.neighbors.add(cloneNode(neighbor, clones));
            }
        }

        return clone;
    }
}


