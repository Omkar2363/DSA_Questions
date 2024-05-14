package Easy;

public class Ques_10 {

    //Ques : Create a mirror tree from the given binary tree..........                    (GFG Ques.)


    //Approach 1 : Recursive Function.......
    /* Approach :
        Write a recursive function that will take two nodes as the argument, one of the original tree
        and the other of the newly created tree. Now, for every passed node of the original tree, create
        a corresponding node in the mirror tree and then recursively call the same method for the child nodes
        but passing the left child of the original tree node with the right child of the mirror tree node and
        the right child of the original tree node with the left child of the mirror tree node.


     * */
    // Java implementation of the approach
    class GFG {

        // A binary tree node has data, pointer to left child and a pointer to right child
        static class node {
            int val;
            node left;
            node right;
        }

        // Helper function that allocates a new node with the given data
        // and null left and right pointers
        static node createNode(int val)
        {
            node newNode  = new node();
            newNode.val   = val;
            newNode.left  = null;
            newNode.right = null;
            return newNode;
        }
        // Helper function to print Inorder traversal
        static void inorder(node root)
        {
            if (root == null)
                return;
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
        }

        /*
         mirrorify function takes two trees, original tree and a mirror tree.
         It recurses on both the trees, but when original tree recurses on left,
         mirror tree recurses on right and vice-versa
        */
        static node mirrorify(node root)
        {
            if (root == null)
            {
                return null;

            }
            // Create new mirror node from original tree node
            node mirror  = createNode(root.val);
            mirror.right = mirrorify(root.left);
            mirror.left  = mirrorify(root.right);
            return mirror;
        }

        // Driver code
        public static void main_1(String args[])
        {

            node tree  = createNode(5);
            tree.left  = createNode(3);
            tree.right = createNode(6);
            tree.left.left  = createNode(2);
            tree.left.right = createNode(4);

            // Print inorder traversal of the input tree
            System.out.print("Inorder of original tree: ");
            inorder(tree);
            node mirror = null;
            mirror = mirrorify(tree);

            // Print inorder traversal of the mirror tree
            System.out.print("\nInorder of mirror tree: ");
            inorder(mirror);
        }
    }




    //Approach 2 : Another approach.......
    /*  Approach 2 :
            In order to change the original tree in its mirror tree, then we simply swap the left and
            right link of each node. If the node is leaf node then do nothing.

    * */
    class GFG_2 {
        static class Node
        {
            int val;
            Node left;
            Node right;
        }

        // Helper function that allocates a new node with the given data
        // and null left and right references
        public static Node createNode(int val)
        {
            Node newNode = new Node();
            newNode.val  = val;
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }

        // Function to print the inorder traversal
        public static void inOrder(Node root)
        {
            if (root == null)
                return;

            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        // Function to convert to mirror tree by swapping the left and right links.
        public static Node mirrorTree(Node root)
        {
            if (root == null)
                return null;

            Node left  = mirrorTree(root.left);
            Node right = mirrorTree(root.right);

            root.left  = right;
            root.right = left;

            return root;
        }

        // Driver Code
        public static void main_2(String args[])
        {
            Node tree  = createNode(5);
            tree.left  = createNode(3);
            tree.right = createNode(6);
            tree.left.left  = createNode(2);
            tree.left.right = createNode(4);
            System.out.print("Inorder of original tree: ");
            inOrder(tree);

            // Function call
            mirrorTree(tree);

            System.out.print("\nInorder of mirror tree: ");
            inOrder(tree);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a binary tree, the task is to create a new binary tree which is a mirror image
                 of the given binary tree.

            Example : 1
            Input   :
                        5
                       / \
                      3   6
                     / \
                    2   4

            Output  : Inorder of original tree : 2 3 4 5 6
                      Inorder of mirror tree   : 6 5 4 3 2

            Mirror tree will be  :
                      5
                     / \
                    6   3
                       / \
                      4   2

            Example : 2
            Input   :
                        2
                       / \
                      1   8
                     /     \
                    12      9

            Output  : Inorder of original tree : 12 1 2 8 9
                      Inorder of mirror tree   : 9 8 2 1 12


        *
        */
    }



}
