package Medium;

import java.util.Stack;

public class Ques_5 {

    //Ques : Validate Binary Search Tree...........                                          (Leet Code Ques no. - 98)


    //Approach 1 : Via InOrder Traversal.....(Not Efficient)......
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public boolean isValidBST(TreeNode root)
        {
            if (root == null)
                return true;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(prev != null && root.val <= prev.val)
                    return false;

                prev = root;
                root = root.right;
            }
            return true;
        }
    }




    //Approach 2 : Recursive Solution.........(Efficient Solution)........(DFS)            T.C. = O(n),  S.C. = O(h)
    class Solution_2 {
        public boolean isValidBST(TreeNode root)
        {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValid(TreeNode root, long min, long max)
        {
            if (root == null)
                return true;

            if (root.val >= max || root.val <= min)
                return false;

            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }
    }


    // Code 2 :
    class Solution_3 {
        public boolean isValidBST(TreeNode root)
        {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode node, long l, long h)
        {
            // Base Case
            if (node == null) {
                return true;
            }
            // Intially head can be anything between -inf to +inf
            // After head left node should be l to previous head node value and right node should be head node                value to h

            return (node.val > l && node.val < h ) && (isValid(node.left, l, node.val)                                                                            &&  isValid(node.right, node.val, h));
        }
    }

    // Code 3 :
    class Solution_4 {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        boolean helper(TreeNode root, Integer min, Integer max) {
            if (root == null)
                return true;

            if ((min != null && root.val <= min) || (max != null && root.val >= max))
                return false;

            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given the root of a binary tree, determine if it is a valid binary search tree (BST).

                 A valid BST is defined as follows :
                    * The left subtree of a node contains only nodes with keys less than the node's key.
                    * The right subtree of a node contains only nodes with keys greater than the node's key.
                    * Both the left and right subtrees must also be binary search trees.


            Example : 1
            Input   : root = [2,1,3]
            Output  : true


            Example : 2
            Input   : root = [5,1,4,null,null,3,6]
            Output  : false
            Explanation : The root node's value is 5 but its right child's value is 4.
        *
        * */
    }




}



