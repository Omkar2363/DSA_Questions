package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_11 {

    //Ques : Check if all leaves are at same level.........                             (GFG Ques.)


    //Approach 1 : Recursive Solution........                                           T.C. = O(n),  S.C. = O(n)
    // Java program to check if all leaves are at same level

    // A binary tree node
    static class Node {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class Leaf {
        int leaflevel = 0;
    }
    static class BinaryTree_1 {
        Node root;
        Leaf mylevel = new Leaf();

        /* Recursive function which checks whether all leaves are at same level */
        boolean checkUtil(Node node, int level, Leaf leafLevel) {

            // Base case
            if (node == null)
                return true;

            // If a leaf node is encountered
            if (node.left == null && node.right == null)
            {
                // When a leaf node is found first time
                if (leafLevel.leaflevel == 0)
                {
                    // Set first found leaf's level
                    leafLevel.leaflevel = level;
                    return true;
                }

                // If this is not first leaf node, compare its level with first leaf's level
                return (level == leafLevel.leaflevel);
            }

            // If this node is not leaf, recursively check left and right subtrees
            return checkUtil(node.left, level + 1, leafLevel)  && checkUtil(node.right, level + 1, leafLevel);
        }

        /* The main function to check if all leafs are at same level.
           It mainly uses checkUtil() */
        boolean check(Node node)
        {
            int level = 0;
            return checkUtil(node, level, mylevel);
        }

        public static void main_1(String args[])
        {
            // Let us create the tree as shown in the example
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root      = new Node(12);
            tree.root.left = new Node(5);
            tree.root.left.left  = new Node(3);
            tree.root.left.right = new Node(9);
            tree.root.left.left.left  = new Node(1);
            tree.root.left.right.left = new Node(1);
            if (tree.check(tree.root))
                System.out.println("Leaves are at same level");
            else
                System.out.println("Leaves are not at same level");
        }
    }



    //Approach 2 : Iterative Solution...........                                      T.C. = O(n),  S.C. = O(n)
    // Java program to check if all leaf nodes are at same level of binary tree

    // User defined node class
    static class Node_2 {
        int data;
        Node_2 left, right;
        // Constructor to create a new tree node
        Node_2(int key)
        {
            int data = key;
            left = right = null;
        }
    }
    static class GFG_2 {

        // return true if all leaf nodes are at same level, else false
        static boolean checkLevelLeafNode(Node_2 root)
        {
            if (root == null)
                return true;

            // create a queue for level order traversal
            Queue<Node_2> q = new LinkedList<>();
            q.add(root);

            int result = Integer.MAX_VALUE;
            int level = 0;

            // traverse until the queue is empty
            while (q.size() != 0) {
                int size = q.size();
                level++;

                // traverse for complete level
                while (size > 0) {
                    Node_2 temp = q.remove();

                    // check for left child
                    if (temp.left != null) {
                        q.add(temp.left);

                        // if its leaf node
                        if (temp.left.left == null && temp.left.right == null) {

                            // if it's first leaf node, then update result
                            if (result == Integer.MAX_VALUE)
                                result = level;

                            // if it's not first leaf node, then compare the level with level of previous leaf node.
                            else if (result != level)
                                return false;
                        }
                    }

                    // check for right child
                    if (temp.right != null) {
                        q.add(temp.right);

                        // if its leaf node
                        if (temp.right.left == null && temp.right.right == null) {

                            // if it's first leaf node, then update result
                            if (result == Integer.MAX_VALUE)
                                result = level;

                            // if it's not first leaf node, then compare
                            // the level with level of previous leaf node.
                            else if (result != level)
                                return false;
                        }
                    }
                    size--;
                }

            }
            return true;
        }

        // Driver code
        public static void main_2(String args[])
        {
            // construct a tree
            Node_2 root = new Node_2(1);
            root.left   = new Node_2(2);
            root.right  = new Node_2(3);
            root.left.right  = new Node_2(4);
            root.right.left  = new Node_2(5);
            root.right.right = new Node_2(6);

            boolean result = checkLevelLeafNode(root);
            if (result == true)
                System.out.println("All leaf nodes are at same level");
            else
                System.out.println("Leaf nodes not at same level");
        }
    }







    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, check if all leaves are at same level or not.

                      12
                    /    \
                  5       7
                /          \
               3            1
              Leaves are at same level

                      12
                    /    \
                  5       7
                /
               3
              Leaves are Not at same level


                      12
                    /
                  5
                /   \
               3     9
              /      /
             1      2
             Leaves are at same level

        * */
    }



}
