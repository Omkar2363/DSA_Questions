package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_6 {

    //Ques : Print Right View of a Binary Tree..........                                  (GFG Ques.)


    //Approach 1 : Recursive Solution.......                                              T.C. = O(n),  S.C. = O(n)
    // Java program to print right view of binary tree
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
    // class to access maximum level by reference
    static class Max_level {
        int max_level;
    }
    static class BinaryTree_1 {
        Node root;
        Max_level max = new Max_level();

        // Recursive function to print right view of a binary tree.
        void rightViewUtil(Node node, int level, Max_level max_level)
        {
            // Base Case
            if (node == null)
                return;

            // If this is the last Node of its level
            if (max_level.max_level < level) {
                System.out.print(node.data + " ");
                max_level.max_level = level;
            }

            // Recur for right subtree first, then left subtree
            rightViewUtil(node.right, level + 1, max_level);
            rightViewUtil(node.left, level + 1, max_level);
        }

        void rightView() {
            rightView(root);
        }

        // A wrapper over rightViewUtil()
        void rightView(Node node)
        {
            rightViewUtil(node, 1, max);
        }

        // Driver program to test the above functions
        public static void main_1(String args[])
        {
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(5);
            tree.root.right.left  = new Node(6);
            tree.root.right.right = new Node(7);
            tree.root.right.left.right = new Node(8);

            tree.rightView();
        }
    }




    //Approach 2 : By using Level Order Traversal..........                             T.C. = O(n),  S.C. = O(n)
    // JAVA program to print right view of Binary Tree
    // A Binary Tree Node
    static class Node_2 {
        int data;
        Node_2 left, right;
        public Node_2(int d)
        {
            data = d;
            left = right = null;
        }
    }
    static class BinaryTree_2 {
        Node root;

        // function to print Right view of binary tree
        void rightView(Node root)
        {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {

                // get number of nodes for each level
                int n = q.size();

                // traverse all the nodes of the current level
                for (int i = 0; i < n; i++) {
                    Node curr = q.peek();
                    q.remove();

                    // print the last node of each level
                    if (i == n - 1) {
                        System.out.print(curr.data);
                        System.out.print(" ");
                    }

                    // if left child is not null add it into the queue
                    if (curr.left != null) {
                        q.add(curr.left);
                    }

                    // if right child is not null add it into the queue
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Driver code
        public static void main_2(String[] args)
        {
            // Let's construct the tree as shown in example
            BinaryTree_2 tree = new BinaryTree_2();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(5);
            tree.root.right.left  = new Node(6);
            tree.root.right.right = new Node(7);
            tree.root.right.left.right = new Node(8);

            tree.rightView(tree.root);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, print the Right view of it.
                The right view of a Binary Tree is a set of nodes visible when the tree is visited from the Right side.


            Example : 1
            Input   :
                              1
                           /     \
                         2        3
                       /   \       /  \
                      4     5   6    7
                                     \
                                       8

            Output  : Right view of the tree is 1 3 7 8


            Example : 2
            Input   :
                             1
                           /
                         8
                       /
                      7

            Output  : Right view of the tree is 1 8 7


                *
                *
                * */
        }



    }
