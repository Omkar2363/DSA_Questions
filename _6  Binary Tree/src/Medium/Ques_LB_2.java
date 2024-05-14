package Medium;

public class Ques_LB_2 {

    //Ques : Check if a given Binary Tree is SumTree............                             (GFG Ques.)


    //Approach 1 : Simple Method.........                                                    T.C. = O(n^2),  S.C. = O(n)
    /*  Method 1 : (Simple)
            Get the sum of nodes in the left subtree and right subtree. Check if the sum calculated is equal
            to the root’s data. Also, recursively check if the left and right subtrees are SumTrees.
    *
    * */
    // Java program to check if Binary tree is sum tree or not
    // A binary tree node has data, left child and right child
    static class Node {
        int data;
        Node left, right, nextRight;
        // Helper function that allocates a new node with the given data and NULL left and right pointers.
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_1 {
        public static Node root;

        // A utility function to get the sum of values in tree with root as root
        static int sum(Node node)
        {
            if(node == null)
            {
                return 0;
            }
            return (sum(node.left) + node.data+sum(node.right));
        }

        // Returns 1 if sum property holds for
        // the given node and both of its children
        static int isSumTree(Node node)
        {
            int ls,rs;

            // If node is NULL, or it's a leaf node then return true
            if(node == null || (node.left == null && node.right == null))
            {
                return 1;
            }

            // Get sum of nodes in left and  right subtrees
            ls = sum(node.left);
            rs = sum(node.right);

            // If the node and both of its children satisfy the property return 1 else 0
            if((node.data == ls + rs) && isSumTree(node.left) != 0 && isSumTree(node.right) != 0)
            {
                return 1;
            }
            return 0;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root       = new Node(26);
            tree.root.left  = new Node(10);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(6);
            tree.root.right.right = new Node(3);
            if(isSumTree(root) != 0)
            {
                System.out.println("The given tree is a SumTree");
            }
            else
            {
                System.out.println("The given tree is not a SumTree");
            }
        }
    }

    /*  Time Complexity : O(n2) in the worst case. The worst-case occurs for a skewed tree.
        Auxiliary Space : O(n)  for stack space
    *
    */




    //Approach 2 :                                                                         T.C. = O(n),  S.C. = O(n)
    /*  Method 2 : (Tricky)
            Method 1 uses sum() to get the sum of nodes in left and right subtrees.
            Method 2 uses the following rules to get the sum directly.
                1) If the node is a leaf node then the sum of the subtree rooted with this node is equal
                   to the value of this node.
                2) If the node is not a leaf node then the sum of the subtree rooted with this node is twice
                   the value of this node (Assuming that the tree rooted with this node is SumTree).
    *
    * */
    // Java program to check if Binary tree is sum tree or not
    /* A binary tree node has data, left child and right child */
    static class Node_2 {
        int data;
        Node_2 left, right, nextRight;
        Node_2 (int item)
        {
            data = item;
            left = right = nextRight = null;
        }
    }
    static class BinaryTree_2 {
        Node_2 root;
        /* Utility function to check if the given node is leaf or not */
        int isLeaf(Node_2 node)
        {
            if (node == null)
                return 0;
            if (node.left == null && node.right == null)
                return 1;
            return 0;
        }

        /* returns 1 if SumTree property holds for the given tree */
        int isSumTree(Node_2 node)
        {
            int ls;                                   // for sum of nodes in left subtree
            int rs;                                   // for sum of nodes in right subtree

        /* If node is NULL, or it's a leaf node then return true */
            if (node == null || isLeaf(node) == 1)
                return 1;

            if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0)
            {
                // Get the sum of nodes in left subtree
                if (node.left == null)
                    ls = 0;
                else if (isLeaf(node.left) != 0)
                    ls = node.left.data;
                else
                    ls = 2 * (node.left.data);

                // Get the sum of nodes in right subtree
                if (node.right == null)
                    rs = 0;
                else if (isLeaf(node.right) != 0)
                    rs = node.right.data;
                else
                    rs = 2 * (node.right.data);

               /* If root's data is equal to sum of nodes in left and right subtrees then return 1 else return 0 */
                if ((node.data == rs + ls))
                    return 1;
                else
                    return 0;
            }

            return 0;
        }

        /* Driver program to test above functions */
        public static void main_2(String args[])
        {
            BinaryTree_2 tree = new BinaryTree_2();
            tree.root       = new Node_2(26);
            tree.root.left  = new Node_2(10);
            tree.root.right = new Node_2(3);
            tree.root.left.left   = new Node_2(4);
            tree.root.left.right  = new Node_2(6);
            tree.root.right.right = new Node_2(3);

            if (tree.isSumTree(tree.root) != 0)
                System.out.println("The given tree is a SumTree");
            else
                System.out.println("The given tree is not a SumTree");
        }
    }




    //Approach 3 :                                                                        T.C. = O(n),   S.C. = O(n)
    /*  Method 3 :
          1. Similar to postorder traversal iteratively find the sum in each step
          2. Return left + right + current data if left + right is equal to current node data
          3. Else return -1
    *
    *
    * */
    // Java program to check if Binary tree is sum tree or not
    class GFG {
        /* A binary tree node has data, left child and right child */
        static class Node {
            int data;
            Node left, right;

        }
        /* Utility function to check if the given node is leaf or not */
        static int isLeaf(Node node)
        {
            if(node == null)
                return 0;
            if(node.left == null && node.right == null)
                return 1;
            return 0;
        }

        /* returns data if SumTree property holds for the given tree else return -1 */
        static int isSumTree(Node node)
        {
            if(node == null)
                return 0;

            int ls;                                     // for sum of nodes in left subtree
            int rs;                                     // for sum of nodes in right subtree


            ls = isSumTree(node.left);
            if(ls == -1)                               // To stop for further traversal of tree if found not sumTree
                return -1;

            rs = isSumTree(node.right);
            if(rs == -1)                              // To stop for further traversal of tree if found not sumTree
                return -1;


            if(isLeaf(node)==1 || ls + rs == node.data)
                return ls + rs + node.data;
            else
                return -1;

        }

        /* Helper function that allocates a new node with the given data and null left and right pointers. */
        static Node newNode(int data)
        {
            Node node1 = new Node();
            node1.data = data;
            node1.left = null;
            node1.right = null;
            return(node1);
        }

        public static void main_3(String args[])
        {
            Node root  = newNode(26);
            root.left  = newNode(10);
            root.right = newNode(3);
            root.left.left   = newNode(4);
            root.left.right  = newNode(6);
            root.right.right = newNode(3);

            int total = isSumTree(root);
            if(total != -1 && total == 2*(root.data))
                System.out.print("Tree is a Sum Tree");
            else
                System.out.print("Given Tree is not sum Tree");
        }
    }






    public static void main(String[] args) {

        /*Ques : Write a function that returns true if the given Binary Tree is SumTree else false.
                 A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present
                 in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can
                 be considered as 0. A leaf node is also considered as SumTree.

            Following is an example of SumTree.

                      26
                    /   \
                  10     3
                /    \     \
              4      6      3

        *
        *
        * */
    }



}
