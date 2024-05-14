package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_13 {

    //Ques : Same Tree..........                                                    (GFG Ques.)


    //Approach 1 : Recursive Approach......                                         T.C. = O(n),  S.C. = O(n)
    //Definition for a binary tree node.
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
        public boolean isSameTree(TreeNode root1, TreeNode root2) {
            //Base Case :
            if((root1 == null && root2 != null) || (root1 != null && root2 == null))
                return false;
            if(root1 == null && root2 == null)
                return true;

            if(root1.val == root2.val)
            {
                //compare the left subtree and the right subtree
                return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
            }
            else {
                return false;
            }
        }
    }




    //Approach 2 : By using Queue.....Not an efficient solution........
    class Solution_2 {
        public boolean isSameTree(TreeNode p, TreeNode q) {

            Queue<TreeNode> q1 = new LinkedList<TreeNode>();
            Queue<TreeNode> q2 = new LinkedList<TreeNode>();

            if(p == null && q == null)
                return true;

            if(p == null || q == null)
                return false;

            q1.add(p);
            q2.add(q);

            while(!q1.isEmpty() && !q2.isEmpty()) {

                int s1 = q1.size();
                int s2 = q2.size();

                if(s1 != s2)
                    return false;

                for(int i = 0; i < s1; i++) {

                    if(q1.peek().left != null && q2.peek().left != null) {
                        q1.add(q1.peek().left);
                        q2.add(q2.peek().left);
                    }
                    else if(q1.peek().left != null || q2.peek().left != null) {
                        return false;
                    }


                    if(q1.peek().right != null && q2.peek().right != null) {
                        q1.add(q1.peek().right);
                        q2.add(q2.peek().right);
                    }
                    else if(q1.peek().right != null || q2.peek().right != null) {
                        return false;
                    }


                    if(q1.poll().val != q2.poll().val)
                        return false;

                }

            }

            if(!q1.isEmpty() || !q2.isEmpty())
                return false;

            return true;

        }
    }




    public static void main(String[] args) {

        /*Ques : Given the roots of two binary trees p and q, write a function to check if they are the same or not.

            Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


            Example : 1
            Input   : p = [1,2,3], q = [1,2,3]
            Output  : true


            Example : 2
            Input   : p = [1,2], q = [1,null,2]
            Output  : false


            Example : 3
            Input   : p = [1,2,1], q = [1,1,2]
            Output  : false

        *
        *
        * */
    }



}
