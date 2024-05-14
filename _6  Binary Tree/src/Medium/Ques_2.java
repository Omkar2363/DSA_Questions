package Medium;

public class Ques_2 {

    //Ques : Diameter of a Binary Tree...........                                        (GFG Ques.)



    //Approach 1 : Recursive Approach........                                            T.C. = O(n^2),  S.C. = O(n)
    // Recursive optimized Java program to find the diameter of a Binary Tree
    // Class containing left and right child of current node and key value
    static class Node {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    // Class to print the Diameter
    static class BinaryTree_1 {
        Node root;
        // Method to calculate the diameter and return it to main
        int diameter(Node root)
        {
            // base case if tree is empty
            if (root == null)
                return 0;

            // get the height of left and right subtrees
            int lheight = height(root.left);
            int rheight = height(root.right);

            // get the diameter of left and right subtrees
            int ldiameter = diameter(root.left);
            int rdiameter = diameter(root.right);

            /* Return max of following three
              1) Diameter of left subtree
              2) Diameter of right subtree
              3) Height of left subtree + height of right subtree + 1
             */
            return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
        }

        // A wrapper over diameter(Node root)
        int diameter() {
            return diameter(root);
        }

        // The function Compute the "height" of a tree. Height is the number of nodes along
        // the longest path from the root node down to the farthest leaf node.
        static int height(Node node)
        {
            // base case tree is empty
            if (node == null)
                return 0;

            // If tree is not empty then height = 1 + max of left height and right heights
            return (1 + Math.max(height(node.left), height(node.right)));
        }

        // Driver Code
        public static void main_1(String args[])
        {
            // creating a binary tree and entering the nodes
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left  = new Node(4);
            tree.root.left.right = new Node(5);

            // Function Call
            System.out.println("The diameter of given binary tree is : " + tree.diameter());
        }
    }




    //Approach 2 : Optimized Solution...........                                       T.C. = O(n),  S.C. = O(n)
    /*   Optimized Approach :
            The above implementation can be optimized by calculating the height in the same recursion
            rather than calling a height() separately. Thanks to Amar for suggesting this optimized version.
            This optimization reduces time complexity to O(n).

     * */
    // Recursive Java program to find the diameter of a Binary Tree
    // Class containing left and right child of current node and key value
    static class Node_2 {
        int data;
        Node_2 left, right;

        public Node_2(int item)
        {
            data = item;
            left = right = null;
        }
    }
    // A utility class to pass height object
    static class Height {
        int h;
    }
    // Class to print the Diameter
    static class BinaryTree_2 {
        Node_2 root;

        // define height = 0 globally and  call diameterOpt(root,height) from main
        int diameterOpt(Node_2 root, Height height)
        {
            // lh --> Height of left subtree
            // rh --> Height of right subtree
            Height lh = new Height(), rh = new Height();

            if (root == null) {
                height.h = 0;
                return 0;                                           // diameter is also 0
            }
            /*
            ldiameter  --> diameter of left subtree
            rdiameter  --> Diameter of right subtree
            Get the heights of left and right subtrees in lh and rh.
            And store the returned values in ldiameter and ldiameter
            */
            int ldiameter = diameterOpt(root.left, lh);
            int rdiameter = diameterOpt(root.right, rh);

            // Height of current node is max of heights of left and right subtrees plus 1
            height.h = Math.max(lh.h, rh.h) + 1;

            return Math.max(lh.h + rh.h + 1 , Math.max(ldiameter, rdiameter));
        }

        // A wrapper over diameter(Node root)
        int diameter()
        {
            Height height = new Height();
            return diameterOpt(root, height);
        }

        // The function Compute the "height" of a tree. Height is the number of nodes along
        // the longest path from the root node down to the farthest leaf node.
        static int height(Node_2 node)
        {
            // base case tree is empty
            if (node == null)
                return 0;

            // If tree is not empty then height = 1 + max of left height and right heights
            return (1 + Math.max(height(node.left), height(node.right)));
        }

        // Driver Code
        public static void main_2(String args[])
        {
            // creating a binary tree and entering the nodes
            BinaryTree_2 tree = new BinaryTree_2();
            tree.root       = new Node_2(1);
            tree.root.left  = new Node_2(2);
            tree.root.right = new Node_2(3);
            tree.root.left.left  = new Node_2(4);
            tree.root.left.right = new Node_2(5);

            // Function Call
            System.out.println("The diameter of given binary tree is : " + tree.diameter());
        }
    }





    //Approach 3 : Another Approach......
    /*   Diameter of a tree can be calculated by only using the height function, because the diameter of a tree
         is nothing but maximum value of (left_height + right_height + 1) for each node. So we need to calculate
         this value (left_height + right_height + 1) for each node and update the result. Time complexity – O(n)
     * */
    // Simple Java program to find diameter of a binary tree.
    class GfG {
        /* Tree node structure used in the program */
        static class Node {
            int data;
            Node left, right;
        }

        static class A {
            int ans = Integer.MIN_VALUE;
        }

        /* Function to find height of a tree */
        static int height(Node root, A a)
        {
            if (root == null)
                return 0;

            int left_height  = height(root.left, a);

            int right_height = height(root.right, a);

            // update the answer, because diameter of a tree is nothing but
            // maximum value of (left_height + right_height + 1) for each node
            a.ans = Math.max(a.ans, 1 + left_height + right_height);

            return 1 + Math.max(left_height, right_height);
        }

        /* Computes the diameter of binary tree with given root. */
        static int diameter(Node root)
        {
            if (root == null)
                return 0;

            // This will store the final answer
            A a = new A();
            int height_of_tree = height(root, a);
            return a.ans;
        }

        static Node newNode(int data)
        {
            Node node  = new Node();
            node.data  = data;
            node.left  = null;
            node.right = null;

            return (node);
        }

        // Driver code
        public static void main_3(String[] args)
        {
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.left  = newNode(4);
            root.left.right = newNode(5);

            System.out.println("Diameter is " + diameter(root));
        }
    }

    /*  Time complexity  : O(n) ,  where n is number of nodes in binary tree .
        Auxiliary Space  : O(h)    for call stack , where h is height of binary tree .


    * */









    public static void main(String[] args) {

        /*Ques : The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
                 between two end nodes. The diagram below shows two trees each with diameter nine, the leaves
                 that form the ends of the longest path are shaded (note that there is more than one path in each
                 tree of length nine, but no path longer than nine nodes).


            Example : 1
            Input   :
                           1
                         /  \
                        2    3
            Output  : 3


            Example : 2
            Input   :
                         10
                        /   \
                      20    30
                    /   \
                   40   60
            Output  : 4


            Your Task :
            You need to complete the function diameter() that takes root as parameter and returns the diameter.

            Expected Time Complexity  : O(N).
            Expected Auxiliary Space  : O(Height of the Tree).


        * */
    }



}
