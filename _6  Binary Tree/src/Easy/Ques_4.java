package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ques_4 {

    //Ques : Level order traversal.......                                                    (GFG Ques)


    //Approach 1 : Recursive Solution......                                                  T.C. = O(n^2),  S.C. = O(n)
    // Recursive Java program for level order traversal of Binary Tree
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
    static class BinaryTree {
        // Root of the Binary Tree
        Node root;
        public BinaryTree() { root = null; }

        /* function to print level order traversal of tree*/
        void printLevelOrder()
        {
            int h = height(root);
            int i;
            for (i = 1; i <= h; i++)
                printCurrentLevel(root, i);
        }

        /* Compute the "height" of a tree -- the number of nodes along the longest path
           from the root node down to the farthest leaf node.*/
        int height(Node root)
        {
            if (root == null)
                return 0;
            else {
                /* compute  height of each subtree */
                int lheight = height(root.left);
                int rheight = height(root.right);

                /* use the larger one */
                if (lheight > rheight)
                    return (lheight + 1);
                else
                    return (rheight + 1);
            }
        }

        /* Print nodes at the current level */
        void printCurrentLevel(Node root, int level)
        {
            if (root == null)
                return;
            if (level == 1)
                System.out.print(root.data + " ");
            else if (level > 1) {
                printCurrentLevel(root.left, level - 1);
                printCurrentLevel(root.right, level - 1);
            }
        }

        /* Driver program to test above functions */
        public static void main_1(String args[])
        {
            BinaryTree tree = new BinaryTree();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left  = new Node(4);
            tree.root.left.right = new Node(5);

            System.out.println("Level order traversal of"  + "binary tree is ");
            tree.printLevelOrder();
        }
    }

    //Leet Code Solution......
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
        public List<List<Integer>> levelOrder(TreeNode root)
        {
            List<List<Integer>> list = new ArrayList();
            if(root == null)
                return list;

            traversal(root, 0, list);
            return list;
        }

        void traversal(TreeNode node, int level, List<List<Integer>> list)
        {
            if(node == null)
                return;

            if(level >= list.size())
                list.add(new ArrayList<Integer>());

            list.get(level).add(node.val);
            traversal(node.left, level+1, list);
            traversal(node.right, level+1, list);
        }
    }





    //Approach 2 : Level Order Binary Tree Traversal by using Queue.......                 T.C. = O(n),  S.C. = O(n)
    // Iterative Queue based Java program to do level order traversal of Binary Tree

    /* Class to represent Tree node */
    static class Node_2 {
        int data;
        Node_2 left, right;
        public Node_2(int item)
        {
            data = item;
            left = null;
            right = null;
        }
    }
    /* Class to print Level Order Traversal */
    static class BinaryTree_2 {
        Node_2 root;
        /* Given a binary tree.
           Print its nodes in level order using array for implementing queue  */
        void printLevelOrder()
        {
            Queue<Node_2> queue = new LinkedList<Node_2>();
            queue.add(root);
            while (!queue.isEmpty()) {

            /* poll() removes the present head.
               For more information on poll() visit : http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
                Node_2 tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }

        public static void main_2(String args[])
        {
        /* creating a binary tree and entering the nodes */
            BinaryTree_2 tree_level = new BinaryTree_2();
            tree_level.root       = new Node_2(1);
            tree_level.root.left  = new Node_2(2);
            tree_level.root.right = new Node_2(3);
            tree_level.root.left.left  = new Node_2(4);
            tree_level.root.left.right = new Node_2(5);

            System.out.println("Level order traversal of binary tree is - ");
            tree_level.printLevelOrder();
        }
    }



    //Leet Code Submission..........
    class Solution_2 {
        public List<List<Integer>> levelOrder(TreeNode root)
        {
            List<List<Integer>> list_2 = new ArrayList<>();

            if(root == null)
            {
                return list_2;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size=q.size();
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<size; i++){
                    TreeNode temp = q.poll();
                    list.add(temp.val);
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
                list_2.add(list);
            }
            return list_2;
        }
    }



    public static void main(String[] args) {

        /*Ques : Given a binary tree, find its level order traversal.
                 Level order traversal of a tree is breadth-first traversal for the tree.

            Example : 1
            Input   :
                            1
                          /   \
                         3     2
            Output  :  1 3 2

            Example : 2
            Input   :
                            10
                         /      \
                        20       30
                      /   \
                     40   60
            Output  : 10 20 30 40 60

            Your Task :
            You don't have to take any input. Complete the function levelOrder() that takes the root node
            as input parameter and returns a list of integers containing the level order traversal of the given Binary Tree.


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)


        *
        * */
    }



}
