package Medium;

import java.util.*;
import java.util.Map.Entry;

public class Ques_4 {

    //Ques : Bottom View of Binary Tree..........                                          (GFG Ques.)


    //Approach 1 : By using Queue.......(Via Level Order Traversal)                        T.C. = O(n*log(n)),  S.C. = O(n)
    /*  Method 1 : (By Using Queue)...... The following are steps to print the Bottom View of the Binary Tree.
           1. We put tree nodes in a queue for the level order traversal.
           2. Start with the horizontal distance(hd) 0 of the root node, and keep on adding a left child to
              the queue along with the horizontal distance as hd-1 and the right child as hd+1.
           3. Also, use a TreeMap which stores key-value pairs sorted on key.
           4. Every time, we encounter a new horizontal distance or an existing horizontal distance put the node data
              for the horizontal distance as the key. For the first time it will add to the map, next time it will
              replace the value. This will make sure that the bottom-most element for that horizontal distance is
              present on the map and if you see the tree from beneath that you will see that element.
    * */
    // Java Program to print Bottom View of Binary Tree.
    // Tree node class
    static class Node  {
        int data;                                 //data of the node
        int hd;                                   //horizontal distance of the node
        Node left, right;                         //left and right references
        // Constructor of tree node
        public Node(int key)
        {
            data = key;
            hd   = Integer.MAX_VALUE;
            left = right = null;
        }
    }
    //Tree class
    static class Tree {
        Node root;                              //root node of tree
        // Default constructor
        public Tree() {}

        // Parameterized tree constructor
        public Tree(Node node)
        {
            root = node;
        }

        // Method that prints the bottom view.
        public void bottomView()
        {
            if (root == null)
                return;

            // Initialize a variable 'hd' with 0 for the root element.
            int hd = 0;

            // TreeMap which stores key value pair sorted on key value
            Map<Integer, Integer> map = new TreeMap<>();

            // Queue to store tree nodes in level order traversal
            Queue<Node> queue = new LinkedList<Node>();

            // Assign initialized horizontal distance value to root node and add it to the queue.
            root.hd = hd;
            queue.add(root);

            // Loop until the queue is empty (standard level order loop)
            while (!queue.isEmpty())
            {
                Node temp = queue.remove();

                // Extract the horizontal distance value from the dequeued tree node.
                hd = temp.hd;

                // Put the dequeued tree node to TreeMap having key as horizontal distance.
                // Every time we find a node having same horizontal distance we need to replace
                // the data in the map.
                map.put(hd, temp.data);

                // If the dequeued node has a left child add it to the queue with a horizontal distance hd-1.
                if (temp.left != null)
                {
                    temp.left.hd = hd-1;
                    queue.add(temp.left);
                }
                // If the dequeued node has a right child add it to the queue with a horizontal distance hd+1.
                if (temp.right != null)
                {
                    temp.right.hd = hd+1;
                    queue.add(temp.right);
                }
            }

            // Extract the entries of map into a set to traverse an iterator over that.
            Set<Entry<Integer, Integer>> set = map.entrySet();

            // Make an iterator
            Iterator<Entry<Integer, Integer>> iterator = set.iterator();

            // Traverse the map elements using the iterator.
            while (iterator.hasNext())
            {
                Map.Entry<Integer, Integer> me = iterator.next();
                System.out.print(me.getValue()+" ");
            }
        }
    }
    // Main driver class
    public class BottomView {
        public static void main_1(String[] args)
        {
            Node root  = new Node(20);
            root.left  = new Node(8);
            root.right = new Node(22);
            root.left.left   = new Node(5);
            root.left.right  = new Node(3);
            root.right.left  = new Node(4);
            root.right.right = new Node(25);
            root.left.right.left  = new Node(10);
            root.left.right.right = new Node(14);
            Tree tree = new Tree(root);
            System.out.println("Bottom view of the given binary tree:");
            tree.bottomView();
        }
    }






    //Approach 2 : By Using HasHMap........(DFS- Depth First Search)                      T.C. = O(n*log(n)),  S.C. = O(n)
    /*  Method 2 : (Using HashMap())......
            Create a map where the key is the horizontal distance and the value is a pair(a, b) where, a is the value
            of the node and b is the height of the node. Perform a pre-order traversal of the tree.
            If the current node at a horizontal distance of h is the first we’ve seen, insert it into the map.
            Otherwise, compare the node with the existing one in map and if the height of the new node is greater,
            update the Map.
    * */
    // Java program to print Bottom View of Binary Tree
    class GFG_2 {
        // Tree node class
        static class Node
        {
            // Data of the node
            int data;
            // Horizontal distance of the node
            int hd;
            // Left and right references
            Node left, right;
            // Constructor of tree node
            public Node(int key)
            {
                data = key;
                hd   = Integer.MAX_VALUE;
                left = right = null;
            }
        }

        static void printBottomViewUtil(Node root, int curr, int hd, TreeMap<Integer, int[]> m)
        {
            // Base case
            if (root == null)
                return;

            // If node for a particular horizontal distance is not present, add to the map.
            if (!m.containsKey(hd))
            {
                m.put(hd, new int[]{ root.data, curr });
            }

            // Compare height for already present node at similar horizontal distance
            else
            {
                int[] p = m.get(hd);
                if (p[1] <= curr)
                {
                    p[1] = curr;
                    p[0] = root.data;
                }
                m.put(hd, p);
            }

            // Recur for left subtree
            printBottomViewUtil(root.left, curr + 1,hd - 1, m);

            // Recur for right subtree
            printBottomViewUtil(root.right, curr + 1,hd + 1, m);
        }

        static void printBottomView(Node root)
        {

            // Map to store Horizontal Distance, Height and Data.
            TreeMap<Integer, int[]> m = new TreeMap<>();

            printBottomViewUtil(root, 0, 0, m);

            // Prints the values stored by printBottomViewUtil()
            for(int val[] : m.values())
            {
                System.out.print(val[0] + " ");
            }
        }

        // Driver Code
        public static void main(String[] args)
        {
            Node root  = new Node(20);
            root.left  = new Node(8);
            root.right = new Node(22);
            root.left.left   = new Node(5);
            root.left.right  = new Node(3);
            root.right.left  = new Node(4);
            root.right.right = new Node(25);
            root.left.right.left  = new Node(10);
            root.left.right.right = new Node(14);

            System.out.println("Bottom view of the given binary tree:");

            printBottomView(root);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given a binary tree, print the bottom view from left to right.
                 A node is included in bottom view if it can be seen when we look at the tree from bottom.

                          20
                        /    \
                      8       22
                    /   \        \
                  5      3       25
                        /   \
                      10    14

            For the above tree, the bottom view is 5 10 3 14 25.
            If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                                  20
                                /    \
                              8       22
                            /   \     /   \
                          5      3 4     25
                                 /    \
                             10       14

            For the above tree the output should be 5 10 4 14 25.


            Example : 1
            Input   :
                           1
                         /   \
                        3     2

            Output  : 3 1 2
            Explanation : First case represents a tree with 3 nodes and 2 edges where root is 1,
                          left child of 1 is 3 and right child of 1 is 2.

            Thus, nodes of the binary tree will be printed as such 3 1 2.


            Example : 2
            Input   :
                             10
                           /    \
                          20    30
                         /  \
                        40   60

            Output  : 40 20 60 30


            Your Task :
            This is a functional problem, you don't need to care about input, just complete the function bottomView()
            which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

            Expected Time Complexity : O(N).
            Expected Auxiliary Space : O(N).
        *
        *
        *
        * */
    }



}
