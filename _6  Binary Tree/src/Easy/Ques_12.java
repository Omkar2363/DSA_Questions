package Easy;

public class Ques_12 {

    //Ques : Check for Balanced Tree..........                                           (GFG Ques.)


    //Approach 1 : Naive Approach ............                                           T.C. = O(n^2),  S.C. = O(n)
    /* Java program to determine if binary tree is height balanced or not */
    /* A binary tree node has data, pointer to left child, and a pointer to right child */
    static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
    static class BinaryTree {
        Node root;
        /* Returns true if binary tree with root as root is height-balanced */
        boolean isBalanced(Node node)
        {
            int lh;                                /* for height of left subtree */

            int rh;                               /* for height of right subtree */

            /* If tree is empty then return true */
            if (node == null)
                return true;

            /* Get the height of left and right subtrees */
            lh = height(node.left);
            rh = height(node.right);

            if (Math.abs(lh - rh) <= 1 && isBalanced(node.left)  &&  isBalanced(node.right))
                return true;

            /* If we reach here then tree is not height-balanced  */
            return false;
        }

        /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
        /*  The function Compute the "height" of a tree. Height is the number of nodes along
            the longest path from the root node down to the farthest leaf node.*/
        int height(Node node)
        {
            /* base case tree is empty */
            if (node == null)
                return 0;

            /* If tree is not empty then height = 1 + max of left height and right heights */
            return 1 + Math.max(height(node.left), height(node.right));
        }

        public static void main_1(String args[])
        {
            BinaryTree tree = new BinaryTree();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left  = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.left.left.left = new Node(8);

            if (tree.isBalanced(tree.root))
                System.out.println("Tree is balanced");
            else
                System.out.println("Tree is not balanced");
        }
    }



    //Approach 2 : Efficient Recursive Approach.......                                    T.C. = O(n),  S.C. = O(n)
    // Java code to implement the approach
    // Class to define the tree node
    class Node_2 {
        int key;
        Node_2 left;
        Node_2 right;
        Node_2(int k)
        {
            key = k;
            left = right = null;
        }
    }
    class GFG {

        // Driver code
        public static void main(String args[])
        {
            Node root  = new Node(10);
            root.left  = new Node(5);
            root.right = new Node(30);
            root.right.left  = new Node(15);
            root.right.right = new Node(20);

            if (isBalanced(root) > 0)
                System.out.print("Balanced");
            else
                System.out.print("Not Balanced");
        }

        // Function to check if tree is height balanced
        public static int isBalanced(Node root)
        {
            if (root == null)
                return 0;
            int lh = isBalanced(root.left);

            if (lh == -1)
                return -1;
            int rh = isBalanced(root.right);

            if (rh == -1)
                return -1;

            if (Math.abs(lh - rh) > 1)
                return -1;
            else
                return Math.max(lh, rh) + 1;
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a binary tree, find if it is height balanced or not.

            A tree is height balanced if difference between heights of left and right subtrees is not more
            than one for all nodes of tree.

            A height balanced tree
                    1
                 /     \
               10      39
              /
            5

            An unbalanced tree
                    1
                 /
               10
              /
            5


            Example : 1
            Input   :
                  1
                /
               2
                \
                 3
            Output  : 0
            Explanation : The max difference in height of left subtree and right subtree is 2,
                          which is greater than 1. Hence, unbalanced


            Example : 2
            Input   :
                   10
                 /   \
                20   30
              /   \
             40   60
            Output  : 1
            Explanation : The max difference in height of left subtree and right subtree is 1.
                          Hence, balanced.

            Your Task :
            You don't need to take input. Just complete the function isBalanced() that takes root node
            as parameter and returns true, if the tree is balanced else returns false.


            Expected time complexity : O(N)
            Expected auxiliary space : O(h) , where h = height of tree
        * */
    }


}
