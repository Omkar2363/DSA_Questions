package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ques_1 {

    //Ques : Inorder Tree Traversal – Iterative and Recursive.........                      (GFG Ques.)


    //Approach 1 : Recursive Approach........                                               T.C. = O(n),  S.C. = O(1)
    // Data structure to store a binary tree node
    static class Node {
        int data;
        Node left, right;

        // Function to create a new binary tree node having a given key
        public Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    class Main {

        // Recursive function to perform inorder traversal on the tree
        public static void inorder(Node root) {

            // return if the current node is empty
            if (root == null) {
                return;
            }

            // Traverse the left subtree
            inorder(root.left);

            // Display the data part of the root (or current node)
            System.out.print(root.data + " ");

            // Traverse the right subtree
            inorder(root.right);
        }

        public static void main(String[] args)
        {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.left = new Node(5);
            root.right.right = new Node(6);
            root.right.left.left = new Node(7);
            root.right.left.right = new Node(8);

            inorder(root);
        }
    }


    //Leet Code Submission......
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<Integer>();
            if(root == null)
                return list;

            return inOrder(root, list);
        }
        public List inOrder(TreeNode root, List list){

            if(root == null)
                return list;

            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);

            return list;
        }
    }







    //Approach 2 : Iterative Approach......
    // Data structure to store a binary tree node
    static class Node_2 {
        int data;
        Node_2 left, right;
        // Function to create a new binary tree node having a given key
        public Node_2(int key)
        {
            data = key;
            left = right = null;
        }
    }
    class Main_2 {

        // Iterative function to perform inorder traversal on the tree
        public static void inorderIterative(Node_2 root)
        {
            // create an empty stack
            Stack<Node_2> stack = new Stack<>();

            // start from the root node (set current node to the root node)
            Node_2 curr = root;

            // if the current node is null and the stack is also empty, we are done
            while (!stack.empty() || curr != null)
            {
                // if the current node exists, push it into the stack (defer it)
                // and move to its left child
                if (curr != null)
                {
                    stack.push(curr);
                    curr = curr.left;
                }
                else {
                    // otherwise, if the current node is null, pop an element from the stack, print it,
                    // and finally set the current node to its right child
                    curr = stack.pop();
                    System.out.print(curr.data + " ");

                    curr = curr.right;
                }
            }
        }

        public static void main_2(String[] args)
        {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

            Node_2 root = new Node_2(1);
            root.left = new Node_2(2);
            root.right = new Node_2(3);
            root.left.left = new Node_2(4);
            root.right.left = new Node_2(5);
            root.right.right = new Node_2(6);
            root.right.left.left = new Node_2(7);
            root.right.left.right = new Node_2(8);

            inorderIterative(root);
        }
    }



    //Leet Code Submission :
    public class TreeNode_2 {
        int val;
        TreeNode_2 left;
        TreeNode_2 right;
        TreeNode_2() {}
        TreeNode_2(int val) { this.val = val; }
        TreeNode_2(int val, TreeNode_2 left, TreeNode_2 right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }
    class Solution_2 {

        public List<Integer> inorderTraversal_2(TreeNode_2 root) {
            List<Integer> list = new ArrayList<Integer>();

            Stack<TreeNode_2> stack = new Stack<TreeNode_2>();
            TreeNode_2 curr = root;

            while(curr!=null || !stack.empty()){
                while(curr!=null){
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }

            return list;
        }
    }








    public static void main(String[] args) {

        /*Ques : Given a binary tree, write an iterative and recursive solution to traverse
                 the tree using inorder traversal............



         * */
    }


}
