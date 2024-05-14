package Easy;

public class Ques_LB_1 {

    //Ques : Check for BST..........                                                        (GFG Ques.)


    //Approach 1 : Simple But Wrong Approach.........                                       T.C. = O(n),  S.C. = O(n)
    class Node{
        int data;
        Node left, right;
    }
    boolean isBST(Node node) {
        if (node == null)
            return true;

        /* False if left is > than node */
        if (node.left != null && node.left.data > node.data)
            return false;

        /* False if right is < than node */
        if (node.right != null && node.right.data < node.data)
            return false;

        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }

    /*Follow the link for Visual Representation......
    * Link : https://practice.geeksforgeeks.org/problems/check-for-bst/1
    * */



    //Approach 2 : Correct But not Efficient.......                                        T.C. = O(n^2),  S.C. = O(n)
    /* Returns true if a binary tree is a binary search tree

    int isBST(Node node)
    {
        if (node == null)
            return 1;

        //false if the max of the left is > than us
        if (node.left != null && maxValue(node.left) >= node.data)
            return 0;

        //false if the min of the right is <= than us
        if (node.right != null && minValue(node.right) <= node.data)
            return 0;

        //false if, recursively, the left or right is not a BST
        if (!isBST(node.left) || !isBST(node.right))
            return 0;

        //passing all that, it's a BST
        return 1;
    }*/

    /* It is assumed that you have helper functions minValue() and maxValue() that return the min or max int value
       from a non-empty tree

        * Time Complexity : O(n^2)   As we visit every node just once and our helper method also takes O(n) time,
                                     so overall time complexity becomes O(n) * O(n) = O(n^2)
        * Auxiliary Space : O(h)     Here h is the height of the tree and the extra space is used due to function call stack.
    *
    * */



    //Approach 3 : Correct and Efficient.........                                         T.C. = O(n),  S.C. = O(1)
    //Java implementation to check if given Binary tree is a BST or not

    /* Class containing left and right child of current node and key value */
    static class Node_3 {
        int data;
        Node_3 left, right;

        public Node_3(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public static class BinaryTree {
        //Root of the Binary Tree
        Node_3 root;

        /* can give min and max value according to your code or
           can write a function to find min and max value of tree. */

        /* returns true if given search tree is binary search tree (efficient version) */
        boolean isBST()  {
            return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        /* Returns true if the given tree is a BST and its values are >= min and <= max. */
        boolean isBSTUtil(Node_3 node, int min, int max)
        {
            /* an empty tree is BST */
            if (node == null)
                return true;

            /* false if this node violates the min/max constraints */
            if (node.data < min || node.data > max)
                return false;

            /* otherwise check the subtrees recursively tightening the min/max constraints */
            // Allow only distinct values
            return (isBSTUtil(node.left, min, node.data-1) &&
                    isBSTUtil(node.right, node.data+1, max));
        }

        /* Driver program to test above functions */
        public static void main(String args[])
        {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node_3(4);
            tree.root.left = new Node_3(2);
            tree.root.right = new Node_3(5);
            tree.root.left.left = new Node_3(1);
            tree.root.left.right = new Node_3(3);

            if (tree.isBST())
                System.out.println("IS BST");
            else
                System.out.println("Not a BST");
        }
    }




    //Approach  4 : Simplified method.........                                          T.C. = O(n),  S.C. = O(h)
    // Java program to check if a given tree is BST.
    class Solution {

        // A binary tree node has data, pointer to left child && a pointer to right child /
        static class Node {
            int data;
            Node left, right;
        }

        // Returns true if given tree is BST.
        static boolean isBST(Node root, Node l, Node r)
        {
            // Base condition
            if (root == null)
                return true;

            // if left node exist then check it has correct data or not
            // i.e. left node's data should be less than root's data
            if (l != null && root.data <= l.data)
                return false;

            // if right node exist then check it has correct data or not
            // i.e. right node's data should be greater than root's data
            if (r != null && root.data >= r.data)
                return false;

            // check recursively for every node.
            return isBST(root.left, l, root) &&
                    isBST(root.right, root, r);
        }

        // Helper function that allocates a new node with the given data && null left && right pointers. /
        static Node newNode(int data)
        {
            Node node = new Node();
            node.data = data;
            node.left = node.right = null;
            return (node);
        }

        // Driver code
        public static void main(String args[])
        {
            Node root = newNode(3);
            root.left = newNode(2);
            root.right = newNode(5);
            root.left.left = newNode(1);
            root.left.right = newNode(4);

            if (isBST(root,null,null))
                System.out.print("Is BST");
            else
                System.out.print("Not a BST");
        }
    }





    //Approach 5 : By using in-order Traversal.......                                  T.C. = O(n),  S.C. = O(h)
    // Java implementation to check if given Binary tree is a BST or not

    /* Class containing left and right child of current node and key value */
    static class BinaryTree_5 {
        static class Node {
            int data;
            Node left, right;
            public Node(int item)
            {
                data = item;
                left = right = null;
            }
        }

        // Root of the Binary Tree
        Node root;

        // To keep tract of previous node in Inorder Traversal
        Node prev;

        boolean isBST()  {
            prev = null;
            return isBST(root);
        }

        /* Returns true if given search tree is binary search tree (efficient version) */
        boolean isBST(Node node)
        {
            // traverse the tree in inorder fashion and keep a track of previous node
            if (node != null)
            {
                if (!isBST(node.left))
                    return false;

                // allows only distinct values node
                if (prev != null && node.data <= prev.data )
                    return false;
                prev = node;
                return isBST(node.right);
            }
            return true;
        }

        /* Driver program to test above functions */
        public static void main(String args[])
        {
            BinaryTree_5 tree = new BinaryTree_5();
            tree.root       = new Node(4);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(5);
            tree.root.left.left  = new Node(1);
            tree.root.left.right = new Node(3);

            if (tree.isBST())
                System.out.println("IS BST");
            else
                System.out.println("Not a BST");
        }
    }


    //The use of a static variable can also be avoided by using a reference to the prev node as a parameter.

    // Java program to check if a given tree is BST.
    class GFG {

        /* A binary tree node has data, pointer to left child and a pointer to right child */
        public static class Node
        {
            public int data;
            public Node left, right;

            public Node(int data)
            {
                this.data = data;
                left = right = null;
            }
        }
        static  Node prev;
        static Boolean isBSTUtil(Node root)
        {
            // traverse the tree in inorder fashion and keep track of prev node
            if (root != null)
            {
                if (!isBSTUtil(root.left))
                    return false;

                // Allows only distinct valued nodes
                if (prev != null &&
                        root.data <= prev.data)
                    return false;

                prev = root;

                return isBSTUtil(root.right);
            }
            return true;
        }

        static Boolean isBST(Node root)
        {
            return isBSTUtil(root);
        }

        // Driver Code
        public static void main (String[] args)
        {
            Node root  = new Node(3);
            root.left  = new Node(2);
            root.right = new Node(5);
            root.left.left  = new Node(1);
            root.left.right = new Node(4);

            if (isBST(root))
                System.out.println("Is BST");
            else
                System.out.println("Not a BST");
        }
    }






    public static void main(String[] args) {

        /*Ques :  Given the root of a binary tree. Check whether it is a BST or not.

                  Note : We are considering that BSTs can not contain duplicate Nodes.

                A BST is defined as follows :
                The left subtree of a node contains only nodes with keys less than the node's key.
                The right subtree of a node contains only nodes with keys greater than the node's key.
                Both the left and right subtrees must also be binary search trees.


            Example : 1
            Input   :
                       2
                     /    \
                    1      3
            Output  : 1
            Explanation : The left subtree of root node contains node with key lesser than the root nodes key and
                          the right subtree of root node contains node with key greater than the root nodes key.
                          Hence, the tree is a BST.

            Example : 2
            Input   :
                      2
                       \
                        7
                         \
                          6
                           \
                            5
                             \
                              9
                               \
                                2
                                 \
                                  6
            Output  : 0
            Explanation : Since the node with value 7 has right subtree nodes with keys less than 7, this is not a BST.

            Your Task :
            You don't need to read input or print anything. Your task is to complete the function isBST() which takes
            the root of the tree as a parameter and returns true if the given binary tree is BST, else returns false.

            Expected Time Complexity : O(N).
            Expected Auxiliary Space : O(Height of the BST).
        *
        *
        * */
    }



}
