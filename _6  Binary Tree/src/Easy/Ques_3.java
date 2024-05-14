package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ques_3 {

    //Ques : Postorder Tree Traversal – Iterative and Recursive.............               (GFG Ques.)


    //Approach 1 : Recursive Solution......
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
        // Recursive function to perform postorder traversal on the tree
        public static void postorder(Node_1 root)
        {
            // return if the current node is empty
            if (root == null) {
                return;
            }

            // Traverse the left subtree
            postorder(root.left);

            // Traverse the right subtree
            postorder(root.right);

            // Display the data part of the root (or current node)
            System.out.print(root.data + " ");
        }

        public static void main_1(String[] args)
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
            root.left   = new Node_1(2);
            root.right  = new Node_1(3);
            root.left.left = new Node_1(4);
            root.right.left = new Node_1(5);
            root.right.right = new Node_1(6);
            root.right.left.left = new Node_1(7);
            root.right.left.right = new Node_1(8);

            postorder(root);
        }
    }

    //Leet Code Submission.....
    // Definition for a binary tree node.
    public class TreeNode_1 {
        int val;
        TreeNode_1 left;
        TreeNode_1 right;
        TreeNode_1() {}
        TreeNode_1(int val) { this.val = val; }
        TreeNode_1(int val, TreeNode_1 left, TreeNode_1 right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }
    class Solution_1 {
        public List<Integer> postorderTraversal(TreeNode_1 root) {

            List<Integer> list = new ArrayList<>();

            postOrder(root, list);

            return list;
        }
        public List<Integer> postOrder(TreeNode_1 root, List list){

            if(root == null)
                return list;

            postOrder(root.left, list);
            postOrder(root.right, list);

            list.add(root.val);

            return list;
        }
    }






    //Approach 2 : Iterative Solution.......
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
        // Iterative function to perform postorder traversal on the tree
        public static void postorderIterative(Node_2 root)
        {
            // return if the tree is empty
            if (root == null) {
                return;
            }

            // create an empty stack and push the root node
            Stack<Node_2> stack1 = new Stack<>();
            stack1.push(root);

            // create another stack to store postorder traversal
            Stack<Integer> stack_2 = new Stack<>();

            // loop till stack is empty
            while (!stack1.empty())
            {
                // pop a node from the stack and push the data into the output stack
                Node_2 curr = stack1.pop();
                stack_2.push(curr.data);

                // push the left and right child of the popped node into the stack
                if (curr.left != null) {
                    stack1.push(curr.left);
                }

                if (curr.right != null) {
                    stack1.push(curr.right);
                }
            }

            // print postorder traversal
            while (!stack_2.empty()) {
                System.out.print(stack_2.pop() + " ");
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

            postorderIterative(root);
        }
    }

    //Leet Code Submission.......
    public class TreeNode_2 {
        int val;
        TreeNode_2 left;
        TreeNode_2 right;
        TreeNode_2() {}
        TreeNode_2(int val) { this.val = val; }
        TreeNode_2(int val, TreeNode_2 left, TreeNode_2 right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution_2 {
        public List<Integer> postorderTraversal(TreeNode_2 root)
        {
            LinkedList<Integer> list = new LinkedList<>();
            Stack<TreeNode_2> stack = new Stack<>();

            if (root == null)
                return list;

            stack.push(root);
            while (!stack.isEmpty())
            {
                TreeNode_2 currNode = stack.pop();
                list.addFirst(currNode.val);

                if (currNode.left != null) {
                    stack.push(currNode.left);
                }
                if (currNode.right != null) {
                    stack.push(currNode.right);
                }
            }
            return list;
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a binary tree, write an iterative and recursive solution to
                 traverse the tree using postorder traversal


         */

    }


}