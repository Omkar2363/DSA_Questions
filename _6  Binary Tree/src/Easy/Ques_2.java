package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ques_2 {

    //Ques : Preorder Tree Traversal – Iterative and Recursive..........                      (GFG Ques.)


    //Approach 1 : Recursive Implementation.......
    // Data structure to store a binary tree node
    static class Node_1 {
        int data;
        Node_1 left, right;
        // Function to create a new binary tree node having a given key
        public Node_1(int key)
        {
            data = key;
            left = right = null;
        }
    }
    class Main_1 {
        // Recursive function to perform preorder traversal on the tree
        public static void preorder(Node_1 root)
        {
            // return if the current node is empty
            if (root == null) {
                return;
            }

            // Display the data part of the root (or current node)
            System.out.print(root.data + " ");

            // Traverse the left subtree
            preorder(root.left);

            // Traverse the right subtree
            preorder(root.right);
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

            Node_1 root = new Node_1(1);
            root.left  =  new Node_1(2);
            root.right =  new Node_1(3);
            root.left.left   = new Node_1(4);
            root.right.left  = new Node_1(5);
            root.right.right = new Node_1(6);
            root.right.left.left  = new Node_1(7);
            root.right.left.right = new Node_1(8);

            preorder(root);
        }
    }


    //Leet Code Submission.......
    //Definition for a binary tree node.
    public static class TreeNode_1 {
        int val;
        TreeNode_1 left;
        TreeNode_1 right;
        TreeNode_1() {}
        TreeNode_1(int val) { this.val = val; }
        TreeNode_1(int val, TreeNode_1 left, TreeNode_1 right) {
            this.val   = val;
            this.left  = left;
            this.right = right;
        }
    }
    class Solution {
        public List<Integer> preorderTraversal(TreeNode_1 root)
        {
            List<Integer> list = new ArrayList<>();

            if(root == null)
                return list;

            preOrder(root, list);
            return list;
        }

        public List<Integer> preOrder(TreeNode_1 root, List list){
            if(root == null)
                return list;

            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);

            return list;
        }
    }





    //Approach 2 : Iterative Approach.......By  using Stack....
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

        // Iterative function to perform preorder traversal on the tree
        public static void preorderIterative(Node_2 root)
        {
            // return if the tree is empty
            if (root == null) {
                return;
            }

            // create an empty stack and push the root node
            Stack<Node_2> stack = new Stack<>();
            stack.push(root);

            // loop till stack is empty
            while (!stack.empty())
            {
                // pop a node from the stack and print it
                Node_2 curr = stack.pop();

                System.out.print(curr.data + " ");

                // push the right child of the popped node into the stack
                if (curr.right != null) {
                    stack.push(curr.right);
                }

                // push the left child of the popped node into the stack
                if (curr.left != null) {
                    stack.push(curr.left);
                }

                // the right child must be pushed first so that the left child
                // is processed first (LIFO order)
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
            root.left   = new Node_2(2);
            root.right  = new Node_2(3);
            root.left.left   = new Node_2(4);
            root.right.left  = new Node_2(5);
            root.right.right = new Node_2(6);
            root.right.left.left  = new Node_2(7);
            root.right.left.right = new Node_2(8);

            preorderIterative(root);
        }
    }

    //The above solution can be further optimized by pushing only the right children to the stack.
    // Data structure to store a binary tree node
    static class Node_3 {
        int data;
        Node_3 left, right;

        // Function to create a new binary tree node having a given key
        public Node_3(int key)
        {
            data = key;
            left = right = null;
        }
    }
    class Main_3 {
        // Iterative function to perform preorder traversal on the tree
        public static void preorderIterative(Node_3 root)
        {
            // return if the tree is empty
            if (root == null) {
                return;
            }

            // create an empty stack and push the root node
            Stack<Node_3> stack = new Stack<>();
            stack.push(root);

            // start from the root node (set current node to the root node)
            Node_3 curr = root;

            // loop till stack is empty
            while (!stack.empty())
            {
                // if the current node exists, print it and push its right child
                // to the stack before moving to its left child
                if (curr != null)
                {
                    System.out.print(curr.data + " ");

                    if (curr.right != null) {
                        stack.push(curr.right);
                    }

                    curr = curr.left;
                }
                // if the current node is null, pop a node from the stack
                // set the current node to the popped node
                else {
                    curr = stack.pop();
                }
            }
        }

        public static void main_3(String[] args)
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

            Node_3 root = new Node_3(1);
            root.left   = new Node_3(2);
            root.right  = new Node_3(3);
            root.left.left   = new Node_3(4);
            root.right.left  = new Node_3(5);
            root.right.right = new Node_3(6);
            root.right.left.left  = new Node_3(7);
            root.right.left.right = new Node_3(8);

            preorderIterative(root);
        }
    }




    //Leet Code Submission........
    public class TreeNode_4 {
        int val;
        TreeNode_4 left;
        TreeNode_4 right;
        TreeNode_4() {}
        TreeNode_4(int val) { this.val = val; }
        TreeNode_4(int val, TreeNode_4 left, TreeNode_4 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution_4 {
        public List<Integer> preorderTraversal(TreeNode_4 root)
        {
            List<Integer> list = new ArrayList<Integer>();

            if(root == null)
                return list;

            Stack<TreeNode_4> stack = new Stack<TreeNode_4>();
            stack.add(root);
            TreeNode_4 node;
            while(!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);

                if(node.right != null)
                    stack.push(node.right);

                if(node.left != null)
                    stack.push(node.left);              //pushed the left node last so that we can access it first
            }
            return list;
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a binary tree, write an iterative and recursive solution to
                 traverse the tree using preorder traversal
        *
        * */
    }




}
