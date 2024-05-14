package Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_8 {

    //Ques :  Invert Binary Tree........                                           (GFG Ques.)


    //Approach 1 : Recursive Solution.......(DFS)
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
        public TreeNode invertTree(TreeNode root)
        {
            if(root == null)
            {
                return null;
            }
            if(root.left == null  &&  root.right == null)
            {
                return root;
            }
            TreeNode leftNode  = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.left  = rightNode;
            root.right = leftNode;

            return root;
        }
    }



    //Approach 2 : Iterative Approach.......By using Stack....
    /* The above solution is correct, but it is also bound to the application stack, which means that
       it's no so much scalable -
       (you can find the problem size that will overflow the stack and crash your application),
       so more robust solution would be to use stack data structure.
     *
     */
    class Solution_2 {
        public TreeNode invertTree(TreeNode root)
        {
            if (root == null) {
                return null;
            }

            final Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            while(!stack.isEmpty())
            {
                final TreeNode node = stack.pop();
                final TreeNode left = node.left;
                node.left  = node.right;
                node.right = left;

                if(node.left != null) {
                    stack.push(node.left);
                }
                if(node.right != null) {
                    stack.push(node.right);
                }
            }
            return root;
        }
    }



    //Approach 3 : Iterative Approach.......By using Queue and Stack....(BFS)
    /* Finally we can easily convert the above solution to BFS - or so, called level order traversal.


     * */
    class Solution_3 {
        public TreeNode invertTree(TreeNode root)
        {
            if (root == null) {
                return null;
            }

            final Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                final TreeNode left = node.left;
                node.left  = node.right;
                node.right = left;

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }






    public static void main(String[] args) {

        /*Ques : Given the root of a binary tree, invert the tree, and return its root.


            Example : 1
            Input   : root = [4,2,7,1,3,6,9]
            Output  : [4,7,2,9,6,3,1]

            Example : 2
            Input   : root = [2,1,3]
            Output  : [2,3,1]

            Example : 3
            Input   : root = []
            Output  : []


        * */
    }



}
