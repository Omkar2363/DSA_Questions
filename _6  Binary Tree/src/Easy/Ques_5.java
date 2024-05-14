package Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ques_5 {

    //Ques : Reverse Level Order Traversal.............                                 (GFG Ques.)


    //Approach 1 : Recursive function to print a given level.......                     T.C. = O(n^2),  S.C. = O(n)
    // A recursive java program to print reverse level order traversal
    // A binary tree node
    static class Node_1 {
        int data;
        Node_1 left, right;
        Node_1(int item)
        {
            data = item;
            left = right;
        }
    }
    static class BinaryTree_1 {
        Node_1 root;

        /* Function to print REVERSE level order traversal a tree*/
        void reverseLevelOrder(Node_1 node)
        {
            int h = height(node);
            int i;
            for (i = h; i >= 1; i--)
            //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
            {
                printGivenLevel(node, i);
            }
        }

        /* Print nodes at a given level */
        void printGivenLevel(Node_1 node, int level)
        {
            if (node == null)
                return;
            if (level == 1)
                System.out.print(node.data + " ");
            else if (level > 1)
            {
                printGivenLevel(node.left, level - 1);
                printGivenLevel(node.right, level - 1);
            }
        }

        /* Compute the "height" of a tree -- the number of
         nodes along the longest path from the root node
         down to the farthest leaf node.*/
        int height(Node_1 node)
        {
            if (node == null)
                return 0;
            else
            {
                /* compute the height of each subtree */
                int lheight = height(node.left);
                int rheight = height(node.right);

                /* use the larger one */
                if (lheight > rheight)
                    return (lheight + 1);
                else
                    return (rheight + 1);
            }
        }

        // Driver program to test above functions
        public static void main_1(String args[])
        {
            BinaryTree_1 tree = new BinaryTree_1();

            // Let us create trees shown in above diagram
            tree.root       = new Node_1(1);
            tree.root.left  = new Node_1(2);
            tree.root.right = new Node_1(3);
            tree.root.left.left  = new Node_1(4);
            tree.root.left.right = new Node_1(5);

            System.out.println("Level Order traversal of binary tree is : ");
            tree.reverseLevelOrder(tree.root);
        }
    }





    //Approach 2 : By using Stack and Queue..........                                 T.C. = O(n),  S.C. = O(n)
    // A recursive java program to print reverse level order traversal by using stack and queue
    /* A binary tree node has data, pointer to left and right children */
    static class Node_2 {
        int data;
        Node_2 left, right;
        Node_2(int item)
        {
            data = item;
            left = right;
        }
    }
    static class BinaryTree_2 {
        Node_2 root;

        /* Given a binary tree, print its nodes in reverse level order */
        void reverseLevelOrder(Node_2 node)
        {
            Stack<Node_2> S = new Stack();
            Queue<Node_2> Q = new LinkedList();
            Q.add(node);

            // Do something like normal level order traversal order. Following are the differences
            // with normal level order traversal
            // 1) Instead of printing a node, we push the node to stack
            // 2) Right subtree is visited before left subtree
            while (Q.isEmpty() == false)
            {
                /* Dequeue node and make it root */
                node = Q.peek();
                Q.remove();
                S.push(node);

                /* Enqueue right child */
                if (node.right != null)
                    // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                    Q.add(node.right);

                /* Enqueue left child */
                if (node.left != null)
                    Q.add(node.left);
            }

            // Now pop all items from stack one by one and print them
            while (S.empty() == false)
            {
                node = S.peek();
                System.out.print(node.data + " ");
                S.pop();
            }
        }

        // Driver program to test above functions
        public static void main_2(String args[])
        {
            BinaryTree_2 tree = new BinaryTree_2();

            // Let us create trees shown in above diagram
            tree.root       = new Node_2(1);
            tree.root.left  = new Node_2(2);
            tree.root.right = new Node_2(3);
            tree.root.left.left   = new Node_2(4);
            tree.root.left.right  = new Node_2(5);
            tree.root.right.left  = new Node_2(6);
            tree.root.right.right = new Node_2(7);

            System.out.println("Level Order traversal of binary tree is :");
            tree.reverseLevelOrder(tree.root);

        }
    }






    public static void main(String[] args) {

        /*Ques : Given a binary tree of size N, find its reverse level order traversal.
                 i.e. The traversal must begin from the last level.


            Example : 1
            Input   :
                            1
                          /   \
                         3     2

            Output  : 3 2 1
            Explanation :  Traversing level 1 : 3 2
                           Traversing level 0 : 1


            Example : 2
            Input   :
                           10
                          /  \
                         20   30
                        / \
                       40  60

            Output  : 40 60 20 30 10
            Explanation :  Traversing level 2 : 40 60
                           Traversing level 1 : 20 30
                           Traversing level 0 : 10

            Your Task :
            You don't need to read input or print anything. Complete the function reverseLevelOrder()
            which takes the root of the tree as input parameter and returns a list containing
            the reverse level order traversal of the given tree.


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)


        *
        * */
    }




}
