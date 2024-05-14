package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_5 {

    //Ques : Sum of nodes on the longest path from root to leaf node...........             (GFG Ques.)
    //          (Sum of the Longest Bloodline of a Tree.....)


    //Approach 1 : Recursive Approach.......                                                T.C. = O(n),  S.C. = O(n)
    // Java implementation to find the sum of nodes on the longest path from root to leaf node
    public class GFG {
        // Node of a binary tree
        static class Node {
            int data;
            Node left, right;
            Node(int data){
                this.data = data;
                left = null;
                right = null;
            }
        }
        static int maxLen;
        static int maxSum;

        // function to find the sum of nodes on the longest path from root to leaf node
        static void sumOfLongRootToLeafPath(Node root, int sum, int len)
        {
            // if true, then we have traversed a root to leaf path
            if (root == null) {
                // update maximum length and maximum sum according to the given conditions
                if (maxLen < len) {
                    maxLen = len;
                    maxSum = sum;
                } else if (maxLen == len && maxSum < sum)
                    maxSum = sum;
                return;
            }


            // recur for left subtree
            sumOfLongRootToLeafPath(root.left, sum + root.data, len + 1);

            sumOfLongRootToLeafPath(root.right, sum + root.data, len + 1);

        }

        // utility function to find the sum of nodes on the longest path from root to leaf node
        static int sumOfLongRootToLeafPathUtil(Node root)
        {
            // if tree is NULL, then sum is 0
            if (root == null)
                return 0;

            maxSum = Integer.MIN_VALUE;
            maxLen = 0;

            // finding the maximum sum 'maxSum' for the maximum length root to leaf path
            sumOfLongRootToLeafPath(root, 0, 0);

            // required maximum sum
            return maxSum;
        }

        // Driver program to test above
        public static void main_1(String args[])
        {
            // binary tree formation
            Node root  = new Node(4);          /*        4        */
            root.left  = new Node(2);          /*       / \       */
            root.right = new Node(5);          /*      2   5      */
            root.left.left   = new Node(7);    /*     / \ / \     */
            root.left.right  = new Node(1);    /*    7  1 2  3    */
            root.right.left  = new Node(2);    /*      /          */
            root.right.right = new Node(3);    /*     6           */
            root.left.right.left = new Node(6);

            System.out.println( "Sum = "  + sumOfLongRootToLeafPathUtil(root));
        }
    }



    //Approach 2 : By level Order Traversal.......                                         T.C. = O(n),  S.C. = O(n)
    /*  Another Approach : Using level order traversal......
           1. Create a structure containing the current Node, level and sum in the path.
           2. Push the root element with level 0 and sum as the root’s data.
           3. Pop the front element and update the maximum level sum and maximum level if needed.
           4. Push the left and right nodes if exists.
           5. Do the same for all the nodes in tree.
    *
    * */
    // Java Code to find sum of nodes on the longest path from root to leaf node using level order traversal
    // Building a tree node having left and right pointers set to null initially
    class Main {
        static class Node {
            Node left;
            Node right;
            int data;
            // constructor to set the data of the newly created tree node
            Node(int element)
            {
                data = element;
                this.left = null;
                this.right = null;
            }
        }

        /* structure to store current Node,it's level and sum in the path */
        static class Element {
            Node data;
            int level;
            int sum;
        }
        public static int longestPathLeaf(Node root)
        {
        /*
          maxSumLevel stores maximum sum so far in the path
          maxLevel stores maximum level so far
        */
            int maxSumLevel = root.data;
            int maxLevel = 0;

            /* queue to implement level order traversal */
            Queue<Element> que = new LinkedList<>();
            Element e = new Element();

            /* Each element variable stores the current Node, it's level, sum in the path */

            e.data = root;
            e.level = 0;
            e.sum = root.data;

            /* push the root element*/
            que.add(e);

            /* do level order traversal on the tree*/
            while (!que.isEmpty()) {
                Element front = que.poll();
                Node curr = front.data;

                /* if the level of current front element is greater than the maxLevel so far then update maxSum */
                if (front.level > maxLevel) {
                    maxSumLevel = front.sum;
                    maxLevel = front.level;
                }

                /* if another path competes then update if the sum is greater than the previous path of same height */
                else if (front.level == maxLevel   &&  front.sum > maxSumLevel) {
                    maxSumLevel = front.sum;
                }

                /* push the left element if exists*/
                if (curr.left != null) {
                    e = new Element();
                    e.data = curr.left;
                    e.sum = e.data.data;
                    e.sum += front.sum;
                    e.level = front.level + 1;
                    que.add(e);
                }

                /*push the right element if exists*/
                if (curr.right != null) {
                    e       = new Element();
                    e.data  = curr.right;
                    e.sum   = e.data.data;
                    e.sum  += front.sum;
                    e.level = front.level + 1;
                    que.add(e);
                }
            }
            /*return the answer*/
            return maxSumLevel;
        }
        // Helper function
        public static void main_2(String[] args)
        {

            Node root  = new Node(4);
            root.left  = new Node(2);
            root.right = new Node(5);
            root.left.left   = new Node(7);
            root.left.right  = new Node(1);
            root.right.left  = new Node(2);
            root.right.right = new Node(3);
            root.left.right.left = new Node(6);

            System.out.println(longestPathLeaf(root));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a binary tree containing n nodes. The problem is to find the sum of all nodes on
                 the longest path from root to leaf node. If two or more paths compete for the longest path,
                 then the path having maximum sum of nodes is being considered.


            Example : 1
            Input   : Binary tree.....
                            4
                           / \
                          2   5
                         / \ / \
                        7  1 2  3
                          /
                         6
            Output : 13
                            4
                           / \
                          2   5
                         / \ / \
                        7  1 2  3
                          /
                         6

            The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path
            having sum = (4 + 2 + 1 + 6) = 13

        *
        * */
    }




}
