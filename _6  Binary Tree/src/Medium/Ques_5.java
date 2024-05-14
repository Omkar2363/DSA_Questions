package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_5 {

    //Ques : Print Left View of a Binary Tree...........                                 (GFG Ques.)


    //Approach 1 : Recursive Solution.........                                           T.C. = O(n),   S.C. = O(n)
    // Java program to print left view of binary tree
    /* Class containing left and right child of current node and key value */
    static class Node {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    /* Class to print the left view */
    static class BinaryTree_1 {
        Node root;
        static int max_level = 0;
        // recursive function to print left view
        void leftViewUtil(Node node, int level)
        {
            // Base Case
            if (node == null)
                return;

            // If this is the first node of its level
            if (max_level < level) {
                System.out.print(node.data + " ");
                max_level = level;
            }

            // Recur for left and right subtrees
            leftViewUtil(node.left, level + 1);
            leftViewUtil(node.right, level + 1);
        }

        // A wrapper over leftViewUtil()
        void leftView()
        {
            max_level = 0;
            leftViewUtil(root, 1);
        }

        /* testing for example nodes */
        public static void main_1(String args[])
        {
            /* creating a binary tree and entering the nodes */
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root       = new Node(10);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(7);
            tree.root.left.right  = new Node(8);
            tree.root.right.right = new Node(15);
            tree.root.right.left  = new Node(12);
            tree.root.right.right.left = new Node(14);

            tree.leftView();
        }
    }




    //Approach 2 : By using Level Order Traversal.......                                T.C. = O(n),   S.C. = O(n)
    // Java program to print left view of Binary Tree
    public class PrintRightView {
        // Binary tree node
        private static class Node {
            int data;
            Node left, right;
            public Node(int data)
            {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }
        // function to print left view of binary tree
        private static void printLeftView(Node root)
        {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                // number of nodes at current level
                int n = queue.size();

                // Traverse all nodes of current level
                for (int i = 1; i <= n; i++) {
                    Node temp = queue.poll();

                    // Print the left most element at the level
                    if (i == 1)
                        System.out.print(temp.data + " ");

                    // Add left node to queue
                    if (temp.left != null)
                        queue.add(temp.left);

                    // Add right node to queue
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
        }

        // Driver code
        public static void main_2(String[] args)
        {
            // construct binary tree as shown in above diagram
            Node root  = new Node(10);
            root.left  = new Node(2);
            root.right = new Node(3);
            root.left.left   = new Node(7);
            root.left.right  = new Node(8);
            root.right.right = new Node(15);
            root.right.left  = new Node(12);
            root.right.right.left = new Node(14);

            printLeftView(root);
        }
    }





    //Approach 3 : By using Queue and a null pointer.......                            T.C. = O(n),   S.C. = O(n)
    // Java Program to print the left view
    class GFG {
        // Binary Tree Node
        static class Node {
            int data;
            Node left, right;
            public Node(int item)
            {
                data = item;
                left = right = null;
            }
        }
        // function to print the left view of binary tree
        public static ArrayList<Integer> leftView(Node root)
        {
            // Your code here
            ArrayList<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            boolean ok = true;

            while (!q.isEmpty()) {
                Node it = q.poll();
                if (it == null) {
                    if (ok == false) {
                        ok = true;
                    }

                    if (q.size() == 0)
                        break;

                    else {
                        q.add(null);
                    }
                }
                else {

                    if (ok) {
                        ans.add(it.data);
                        ok = false;
                    }

                    if (it.left != null) {
                        q.add(it.left);
                    }

                    if (it.right != null) {
                        q.add(it.right);
                    }
                }
            }

            return ans;
        }
        // driver code
        public static void main(String[] args)
        {
            Node root  = new Node(10);
            root.left  = new Node(2);
            root.right = new Node(3);
            root.left.left   = new Node(7);
            root.left.right  = new Node(8);
            root.right.right = new Node(15);
            root.right.left  = new Node(12);
            root.right.right.left = new Node(14);

            ArrayList<Integer> vec = leftView(root);
            for (int x : vec) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }








    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, the task is to print the left view of the Binary Tree. The left view
                 of a Binary Tree is a set of leftmost nodes for every level.

            Example : 1
            Input   :
                               4
                            /   \
                          5     2
                               /   \
                            3     1
                          /  \
                       6    7

            Output  : 4 5 3 6


            Example : 2
            Input   :
                             1
                          /   \
                        2       3
                          \
                           4
                             \
                              5
                                \
                                 6

            Output  : 1 2 4 5 6



        */
    }




}
