package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class Ques_9 {

    //Ques : Boundary Traversal of binary tree..........                                   (GFG Ques.)


    //Approach 1 :                                                                         T.C. = O(n),  S.C. = O(n)
    // Java program to print boundary traversal of binary tree
    /* A binary tree node has data, pointer to left child and a pointer to right child */
    static class Node {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_1 {
        Node root;
        // A simple function to print leaf nodes of a binary tree
        void printLeaves(Node node)
        {
            if (node == null)
                return;

            printLeaves(node.left);
            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.data + " ");
            printLeaves(node.right);
        }

        // A function to print all left boundary nodes, except a leaf node.
        // Print the nodes in TOP-DOWN manner......
        void printBoundaryLeft(Node node)
        {
            if (node == null)
                return;

            if (node.left != null)
            {
                // to ensure top down order, print the node before calling itself for left subtree
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            }
            else if (node.right != null)
            {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid duplicates in output
        }

        // A function to print all right boundary nodes, except a leaf node
        // Print the nodes in BOTTOM UP manner
        void printBoundaryRight(Node node)
        {
            if (node == null)
                return;

            if (node.right != null)
            {
                // to ensure bottom up order, first call for right subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            }
            else if (node.left != null)
            {
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
            }
            // do nothing if it is a leaf node, this way we avoid duplicates in output
        }

        // A function to do boundary traversal of a given binary tree
        void printBoundary(Node node)
        {
            if (node == null)
                return;

            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }

        // Driver program to test above functions
        public static void main_1(String args[])
        {
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root      = new Node(20);
            tree.root.left = new Node(8);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(12);
            tree.root.left.right.left  = new Node(10);
            tree.root.left.right.right = new Node(14);
            tree.root.right       = new Node(22);
            tree.root.right.right = new Node(25);
            tree.printBoundary(tree.root);
        }
    }





    //Approach 2 :                                                                       T.C. = O(n),  S.C. = O(n)
    /*  # Clean Code with returning the traversal :
            [No direct printing + Iterative Version of the code]

        * Algorithm :
            1. Right Boundary – Go Right, Right until no Right. Do not Include Leaf nodes. (as it leads to duplication)
            2. Left Boundary  – Go Left, Left until no Left. Do not Include Leaf nodes.    (as it leads to duplication)
            3. Leaf Boundary  – Do inorder, if leaf node add to the List.
            4. We pass the array as reference, so it is the same memory location used by all functions, to coordinate
               the result at one place.
    *
    * */
    // Java program to print boundary traversal of binary tree
    static class BinaryTree_2 {
        Node root;
        /* A binary tree node has data, pointer to left child and a pointer to right child */
        static class Node {
            int data;
            Node left, right;
            Node(int d)
            {
                data = d;
                left = null;
                right = null;
            }
        }
        private boolean isLeaf(Node node)
        {
            if (node.left == null && node.right == null) {
                return true;
            }
            return false;
        }

        private void addLeftBound(Node root, ArrayList<Integer> ans)
        {
            // Go left, left and no left then right but again check from left
            root = root.left;
            while (root != null)
            {
                if (!isLeaf(root)) {
                    ans.add(root.data);
                }

                if (root.left != null) {
                    root = root.left;
                }
                else {
                    root = root.right;
                }
            }
        }

        private void addRightBound(Node root, ArrayList<Integer> ans)
        {
            // Go right, right and no right then left but again check from right
            root = root.right;

            // As we need the reverse of this for Anticlockwise
            Stack<Integer> stk = new Stack<>();
            while (root != null)
            {
                if (!isLeaf(root)) {
                    stk.push(root.data);
                }
                if (root.right != null) {
                    root = root.right;
                }
                else {
                    root = root.left;
                }
            }

            while (!stk.isEmpty()) {
                ans.add(stk.peek());
                stk.pop();
            }
        }

        // its kind of inorder
        private void addLeaves(Node root, ArrayList<Integer> ans)
        {
            if (root == null) {
                return;
            }

            if (isLeaf(root)) {
                ans.add(root.data);                                     // just store leaf nodes
                return;
            }

            addLeaves(root.left, ans);
            addLeaves(root.right, ans);
        }

        ArrayList<Integer> boundary(Node root)
        {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            if (!isLeaf(root)) {
                ans.add(root.data);                                     // if leaf then its done by addLeaves
            }

            addLeftBound(root, ans);
            addLeaves(root, ans);
            addRightBound(root, ans);
            return ans;
        }

        public static void main_2(String[] args)
        {
            // Let us construct the tree given in the above diagram
            BinaryTree_2 tree = new BinaryTree_2();
            tree.root      = new Node(20);
            tree.root.left = new Node(8);
            tree.root.left.left  = new Node(4);
            tree.root.left.right = new Node(12);
            tree.root.left.right.left  = new Node(10);
            tree.root.left.right.right = new Node(14);
            tree.root.right       = new Node(22);
            tree.root.right.right = new Node(25);

            ArrayList<Integer> ans = tree.boundary(tree.root);

            for (int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }






    public static void main(String[] args) {

        /*Ques :
            Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order :

               1. Left boundary nodes: defined as the path from the root to the left-most node
                  i.e. - the leaf node you could reach when you always travel preferring the left subtree over
                         the right subtree.
               2. Leaf nodes : All the leaf nodes except for the ones that are part of left or right boundary.
               3. Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most
                  node is the leaf node you could reach when you always travel preferring the right subtree over the left
                  subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.

            Note : If the root doesn't have a left subtree or right subtree, then the root itself is the left or
                   right boundary.


            Example : 1
            Input   :
                            1
                          /   \
                         2     3
                        / \   / \
                       4   5 6   7
                          / \
                         8   9

            Output  : 1 2 4 8 9 6 7 3


            Example : 2
            Input   :
                                1
                               /
                              2
                            /  \
                           4    9
                         /  \    \
                        6    5    3
                                 /  \
                                7     8

            Output  : 1 2 4 6 5 7 8


            As you can see we have not taken the right subtree.

            Your Task :
            This is a function problem. You don't have to take input. Just complete the function boundary() that takes
            the root node as input and returns an array containing the boundary values in anti-clockwise.

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(Height of the Tree)
        *
        *
        * */
    }




}
