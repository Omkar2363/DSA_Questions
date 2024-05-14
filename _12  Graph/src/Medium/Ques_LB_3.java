package Medium;

import java.util.*;

public class Ques_LB_3 {

    //Ques :  Clone Graph.........                                                        (Leet Code Ques no.- 133)


    //Approach 1 : BFS Solution........(Efficient Solution.....)                          T.C. = O(V+E),  S.C. = O(V)
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
    class Solution_1 {
        private Node BFS(Node node)
        {
            HashMap<Node, Node> h_map = new HashMap<>();
            Queue<Node> q = new LinkedList<>();

            if(node != null) {
                h_map.put(node, new Node(node.val));
                q.add(node);
            }
            while(!q.isEmpty())
            {
                Node currNode = q.remove();
                for(Node adj : currNode.neighbors)
                {
                    if(!h_map.containsKey(adj))
                    {
                        h_map.put(adj, new Node(adj.val));
                        q.add(adj);
                    }
                    h_map.get(currNode).neighbors.add(h_map.get(adj));
                }
            }
            return h_map.get(node);
        }
        public Node cloneGraph(Node node)                //main function.....
        {
            return BFS(node);
        }
    }





    //Approach 2 : DFS Solution........                                                  T.C. = O(V+E),  S.C. = O(V)
    class Solution {
        private HashMap<Node, Node> h_map = new HashMap<>();

        private Node DFS(Node currNode)
        {
            if(currNode == null)
                return currNode;

            if(h_map.containsKey(currNode))
                return h_map.get(currNode);

            h_map.put(currNode, new Node(currNode.val));
            for(Node adj : currNode.neighbors)
            {
                h_map.get(currNode).neighbors.add(DFS(adj));
            }

            return h_map.get(currNode);
        }
        public Node cloneGraph(Node node)               //main function.....
        {
            return DFS(node);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a reference of a node in a connected undirected graph.

                 Return a deep copy (clone) of the graph.

                 Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
                    class Node {
                        public int val;
                        public List<Node> neighbors;
                    }


            Test case format :
                For simplicity, each node's value is the same as the node's index (1-indexed).
                For example : the first node with val == 1, the second node with val == 2, and so on. The graph is
                              represented in the test case using an adjacency list.

                An adjacency list is a collection of unordered lists used to represent a finite graph. Each list
                describes the set of neighbors of a node in the graph.

            The given node will always be the first node with val = 1. You must return the copy of the given node
            as a reference to the cloned graph.


            Example : 1
            Input   : adjList = [[2,4],[1,3],[2,4],[1,3]]
            Output  : [[2,4],[1,3],[2,4],[1,3]]
            Explanation : There are 4 nodes in the graph.
                            1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                            2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
                            3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                            4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).


            Example : 2
            Input   : adjList = [[]]
            Output  : [[]]
            Explanation : Note that the input contains one empty list. The graph consists of only one node with
                          val = 1 and it does not have any neighbors.


            Example : 3
            Input   : adjList = []
            Output  : []
            Explanation : This an empty graph, it does not have any nodes.


            // Follow the link for the visual representation of the example....
            // Link : https://leetcode.com/problems/clone-graph/

        *
        * */
    }



}
