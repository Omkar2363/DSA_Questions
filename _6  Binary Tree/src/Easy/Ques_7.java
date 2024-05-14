package Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ques_7 {

    //Ques : Maximum Depth of Binary Tree..........                                          (Leet Code Ques no. - 104)


    //Approach 1 : Recursive Solution.......
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public int maxDepth(TreeNode root) {

            if(root==null){
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));

        }
    }




    //Approach 2 : Iterative Approach.....(DFS)
    class Solution_2 {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }

            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> value = new Stack<>();
            stack.push(root);
            value.push(1);
            int max = 0;
            while(!stack.isEmpty())
            {
                TreeNode node = stack.pop();
                int temp = value.pop();
                max = Math.max(temp, max);
                if(node.left != null)
                {
                    stack.push(node.left);
                    value.push(temp+1);
                }
                if(node.right != null)
                {
                    stack.push(node.right);
                    value.push(temp+1);
                }
            }
            return max;
        }
    }


    //Approach 3 : Iterative Approach.....(BFS)
    class Solution_3 {
        public int maxDepth(TreeNode root)
        {
            if(root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count = 0;
            while(!queue.isEmpty())
            {
                int size = queue.size();
                while(size-- > 0)
                {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                count++;
            }
            return count;
        }
    }





    public static void main(String[] args) {

        /*Ques : Given the root of a binary tree, return its maximum depth.

                 A binary tree's maximum depth is the number of nodes along the longest path from the root node
                 down to the farthest leaf node.


            Example : 1
            Input   : root = [3,9,20,null,null,15,7]
            Output  : 3

            Example : 2
            Input   : root = [1,null,2]
            Output  : 2

        * */
    }


}
