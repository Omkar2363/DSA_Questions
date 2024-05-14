package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_9 {

    //Ques : Check if a given Binary Tree is a Heap............                                  (GFG Ques.)


    //Approach 1 : By using Complete Binary Tree......                                           T.C. = O(n),  S.C. = O(1)
    /*  Check if a given Binary Tree is Heap using Complete Binary Tree :

         * Follow the given steps to solve the problem :
              1. Check each of the above conditions separately, for checking completeness isComplete and for
                 checking heap isHeapUtil functions are written.
              2. First, check if the given binary tree is complete or not.
              3. Then to check if the binary tree is a heap or not, check the following points:
                     a. Every Node has 2 children, 0 children (last level nodes), or 1 child
                        (there can be at most one such node).
                     b. If Node has No children then it’s a leaf node and returns true (Base case)
                     c. If Node has one child (it must be the left child because it is a complete tree)
                        then compare this node with its single child only.
                     d. If the Node has both children then check heap property at this Node and recur for both subtrees.
    *
    * */
    /* Java program to check, if a binary tree is max heap or not */
    // A Binary Tree node
    static class Node {
        int key;
        Node left, right;
        Node(int k)
        {
            key = k;
            left = right = null;
        }
    }
    static class Is_BinaryTree_MaxHeap {

        /* This function counts  the number of nodes in a binary tree */
        int countNodes(Node root)
        {
            if (root == null)
                return 0;
            return (1 + countNodes(root.left) + countNodes(root.right));
        }

        /* This function checks, if the binary tree is complete or not */
        boolean isCompleteUtil(Node root, int index, int number_nodes)
        {
            // An empty tree is complete
            if (root == null)
                return true;

            // If index assigned to current  node is more than number of nodes in tree,
            // then tree is not complete
            if (index >= number_nodes)
                return false;

            // Recur for left and right subtrees
            return isCompleteUtil(root.left, 2 * index + 1, number_nodes)
                                     &&   isCompleteUtil(root.right, 2 * index + 2, number_nodes);
        }

        // This Function check, the heap property in the tree.
        boolean isHeapUtil(Node root)
        {
            //  Base case : single node satisfies property
            if (root.left == null && root.right == null)
                return true;

            //  node will be in second last level
            if (root.right == null)
            {
                //  check heap property at Node
                //  No recursive call, because no need to check last level
                return root.key >= root.left.key;
            }
            else {
                //  Check heap property at Node and
                //  Recursive check heap property at left and right subtree
                if (root.key >= root.left.key  &&  root.key >= root.right.key)
                    return isHeapUtil(root.left)  && isHeapUtil(root.right);

                else
                    return false;
            }
        }

        //  Function to check binary tree is a Heap or Not.
        boolean isHeap(Node root)
        {
            if (root == null)
                return true;

            // These two are used in isCompleteUtil()
            int node_count = countNodes(root);

            if (isCompleteUtil(root, 0, node_count) == true  &&  isHeapUtil(root) == true)
                return true;

            return false;
        }

        // driver function to test the above functions
        public static void main_1(String args[])
        {
            Is_BinaryTree_MaxHeap bt  =  new Is_BinaryTree_MaxHeap();

            Node root  = new Node(10);
            root.left  = new Node(9);
            root.right = new Node(8);
            root.left.left   = new Node(7);
            root.left.right  = new Node(6);
            root.right.left  = new Node(5);
            root.right.right = new Node(4);
            root.left.left.left  = new Node(3);
            root.left.left.right = new Node(2);
            root.left.right.left = new Node(1);

            if (bt.isHeap(root) == true)
                System.out.println("Given binary tree is a Heap");
            else
                System.out.println("Given binary tree is not a Heap");
        }
    }




    //Approach 2 : By using Level Order Traversal........                                       T.C. = O(n),  S.C. = O(n)
    /*  Check if a given Binary Tree is Heap using Level Order Traversal :
            Level order traversal can be used to check heap properties at each level of the binary tree.
            Check whether value of each node is greater than the value of its children and keep track of
            when the last node is encountered and whether it is following the heap properties using
            a boolean flag

            * Follow the given steps to solve the problem :
                 1. declare a queue for level order traversal and a flag variable nullish equal to false
                 2. Start level order traversal
                     a. Check for the left child of the node and if either the nullish is true or root’s value is less than its left child node, then return false, else push this node into the queue
                     b. If the node’s left child is null then set nullish equal to true, which means we have already encountered the last node, as the node with only zero or one children can occur only once in the complete tree
                     c. Now check the right child of the node and if either the nullish is true or root’s value is less than its right child node, then return false, else push this node into the queue.
                     d. If the node’s right child is null then set nullish equal to true, which means we have already encountered the last node, as the node with only zero or one children can occur only once in the complete tree
                 3. Return true after checking every node in the level order traversal
    *
    */
    // Java program to check, if a binary tree is max heap or not
    class GFG {

        // Tree node structure
        static class Node {
            int data;
            Node left;
            Node right;
        };

        // To add a new node
        static Node newNode(int k)
        {
            Node node  = new Node();
            node.data  = k;
            node.right = node.left = null;
            return node;
        }

        static boolean isHeap(Node root)
        {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            boolean nullish = false;
            while (!q.isEmpty())
            {
                Node temp = q.peek();
                q.remove();
                if (temp.left != null)
                {
                    if (nullish || temp.left.data > temp.data)
                    {
                        return false;
                    }
                    q.add(temp.left);
                }
                else {
                    nullish = true;
                }
                if (temp.right != null) {
                    if (nullish  ||  temp.right.data > temp.data) {
                        return false;
                    }
                    q.add(temp.right);
                }
                else {
                    nullish = true;
                }
            }
            return true;
        }

        // Driver's code
        public static void main_2(String[] args)
        {
            Node root = null;
            root       = newNode(10);
            root.left  = newNode(9);
            root.right = newNode(8);
            root.left.left   = newNode(7);
            root.left.right  = newNode(6);
            root.right.left  = newNode(5);
            root.right.right = newNode(4);
            root.left.left.left  = newNode(3);
            root.left.left.right = newNode(2);
            root.left.right.left = newNode(1);

            // Function call
            if (isHeap(root))
                System.out.print("Given binary tree is a Heap\n");
            else
                System.out.print("Given binary tree is not a Heap\n");
        }
    }






    public static void main(String[] args) {

        /*Ques : Given a binary tree, check if it has heap property or not, Binary tree needs to fulfill
                 the following two conditions for being a heap –

                 It should be a complete tree                     (i.e. all levels except the last should be full).
                 Every node’s value should be greater than or equal to its child node       (considering max-heap).


            Example : 1
            Input   :

            yes

            Output  : Given binary tree is a heap



            Example : 2
            Input   :

            no

            Output  : Given binary tree is not a heap


        *   // Follow the link for visual representation of the example :
            // Link : https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

        *
        * */
    }





}
