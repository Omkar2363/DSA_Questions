package Medium;

import java.util.ArrayList;
import java.util.List;

public class Ques_13 {

    //Ques : Lowest Common Ancestor in a Binary Tree..........                             (GFG Ques.)


    //Approach 1 :                                                                         T.C. = O(n),  s.C. = O(n)
    /*  Approach 1 : (By Storing root to n1 and root to n2 paths).......
            The idea of this approach is to store the path from the root to n1 and root to n2 in two
            separate data structures. Then look simultaneously into the values stored in the data structure,
            and look for the first mismatch.


        Illustration :

        Find the LCA of 5 and 6

        Path from root to 5 = { 1, 2, 5 }
        Path from root to 6 = { 1, 3, 6 }

        We start checking from 0 index. As both of the value matches( pathA[0] = pathB[0] ), we move to the next index.
        pathA[1] not equals to pathB[1], there’s a mismatch so we consider the previous value.
        Therefore the LCA of (5,6) = 1

        * Following is a simple O(n) algorithm to find the LCA of n1 and n2.
           1. Find a path from the root to n1 and store it in a vector or array.
           2. Find a path from the root to n2 and store it in another vector or array.
           3. Traverse both paths till the values in arrays are the same. Return the common element just before the mismatch.

    * */
    // Java Program for Lowest Common Ancestor in a Binary Tree
    // A O(n) solution to find LCA of two given values n1 and n2
    // A Binary Tree node
    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    public static class BT_NoParentPtr_Solution1 {
        Node root;
        private List<Integer> path1 = new ArrayList<>();
        private List<Integer> path2 = new ArrayList<>();

        // Finds the path from root node to given root of the tree.
        int findLCA(int n1, int n2) {
            path1.clear();
            path2.clear();
            return findLCAInternal(root, n1, n2);
        }

        private int findLCAInternal(Node root, int n1, int n2) {

            if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
                System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
                System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
                return -1;
            }

            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {

                // System.out.println(path1.get(i) + " " + path2.get(i));
                if (!path1.get(i).equals(path2.get(i)))
                    break;
            }

            return path1.get(i-1);
        }

        // Finds the path from root node to given root of the tree, Stores the
        // path in a vector path[], returns true if path exists otherwise false
        private boolean findPath(Node root, int n, List<Integer> path)
        {
            // base case
            if (root == null) {
                return false;
            }

            // Store this node .The node will be removed if not in path from root to n.
            path.add(root.data);

            if (root.data == n) {
                return true;
            }

            if (root.left != null && findPath(root.left, n, path)) {
                return true;
            }

            if (root.right != null && findPath(root.right, n, path)) {
                return true;
            }

            // If not present in subtree rooted with root, remove root from path[] and return false
            path.remove(path.size()-1);

            return false;
        }

        // Driver code
        public static void main(String[] args)
        {
            BT_NoParentPtr_Solution1 tree = new BT_NoParentPtr_Solution1();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(5);
            tree.root.right.left  = new Node(6);
            tree.root.right.right = new Node(7);

            System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
            System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
            System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
            System.out.println("LCA(2, 4): " + tree.findLCA(2,4));

        }
    }





    //Approach 2 : Using Single Traversal........
    //Java implementation to find the lowest common ancestor of n1 and n2 using one traversal of binary tree
    /* Class containing left and right child of current node and key value */
    public  static class BinaryTree {
        static class Node {
            int data;
            Node left, right;

            public Node(int item)
            {
                data = item;
                left = right = null;
            }
        }
        //Root of the Binary Tree
        Node root;

        Node findLCA(int n1, int n2)
        {
            return findLCA(root, n1, n2);
        }

        // This function returns pointer to LCA of two given values n1 and n2.
        // This function assumes that n1 and n2 are present in Binary Tree
        Node findLCA(Node node, int n1, int n2)
        {
            // Base case
            if (node == null)
                return null;

            // If either n1 or n2 matches with root's key, report the presence by returning root
            // (Note  that if a key is ancestor of other, then the ancestor key becomes LCA )
            if (node.data == n1 || node.data == n2)
                return node;

            // Look for keys in left and right subtrees
            Node left_lca  = findLCA(node.left, n1, n2);
            Node right_lca = findLCA(node.right, n1, n2);

            // If both of the above calls return Non-NULL, then one key is present in once subtree
            // and other is present in other, So this node is the LCA
            if (left_lca!=null && right_lca!=null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;
        }

        /* Driver program to test above functions */
        public static void main_2(String args[])
        {
            BinaryTree tree = new BinaryTree();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(5);
            tree.root.right.left  = new Node(6);
            tree.root.right.right = new Node(7);
            System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
            System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
            System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
            System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
        }
    }

    /*  Time Complexity : O(n)   as the method does a simple tree traversal in a bottom-up fashion.
        Auxiliary Space : O(h),  where h is the height of the tree.

    * */






    //Approach 3 :
    // Java implementation to find the lowest common ancestor of n1 and n2 using one traversal of binary tree
    // It also handles cases even when n1 and n2 are not there in Tree




    /* Class containing left and right child of current node and key */
    public static class BinaryTree_3 {
        static class Node {
            int data;
            Node left, right;
            public Node(int item) {
                data = item;
                left = right = null;
            }
        }
        // Root of the Binary Tree
        Node root;
        static boolean v1 = false, v2 = false;

        // This function returns pointer to LCA of two given values n1 and n2.
        // v1 is set as true by this function if n1 is found
        // v2 is set as true by this function if n2 is found
        Node findLCAUtil(Node node, int n1, int n2)
        {
            // Base case
            if (node == null)
                return null;

            //Store result in temp, in case of key match so that we can search for other key also.
            Node temp=null;

            // If either n1 or n2 matches with root's key, report the presence by setting v1 or v2 as true
            // and return root (Note that if a key is ancestor of other, then the ancestor key becomes LCA)
            if (node.data == n1)
            {
                v1 = true;
                temp = node;
            }
            if (node.data == n2)
            {
                v2 = true;
                temp = node;
            }

            // Look for keys in left and right subtrees
            Node left_lca  = findLCAUtil(node.left, n1, n2);
            Node right_lca = findLCAUtil(node.right, n1, n2);

            if (temp != null)
                return temp;

            // If both of the above calls return Non-NULL, then one key is present in once subtree and
            // other is present in other, So this node is the LCA
            if (left_lca != null && right_lca != null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null)  ?  left_lca  :  right_lca;
        }

        // Finds lca of n1 and n2 under the subtree rooted with 'node'
        Node findLCA(int n1, int n2)
        {
            // Initialize n1 and n2 as not visited
            v1 = false;
            v2 = false;

            // Find lca of n1 and n2 using the technique discussed above
            Node lca = findLCAUtil(root, n1, n2);

            // Return LCA only if both n1 and n2 are present in tree
            if (v1 && v2)
                return lca;

            // Else return NULL
            return null;
        }

        /* Driver program to test above functions */
        public static void main_3(String args[])
        {
            BinaryTree_3 tree = new BinaryTree_3();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left   = new Node(4);
            tree.root.left.right  = new Node(5);
            tree.root.right.left  = new Node(6);
            tree.root.right.right = new Node(7);

            Node lca = tree.findLCA(4, 5);
            if (lca != null)
                System.out.println("LCA(4, 5) = " + lca.data);
            else
                System.out.println("Keys are not present");

            lca = tree.findLCA(4, 10);
            if (lca != null)
                System.out.println("LCA(4, 10) = " + lca.data);
            else
                System.out.println("Keys are not present");
        }
    }

    /*  Time Complexity : O(n)
        Auxiliary Space : O(h) where h is the height of the tree.
    *
    */







    public static void main(String[] args) {

        /*Ques : What is Lowest Common Ancestor in Binary Tree....?

            The lowest common ancestor is the lowest node in the tree that has both n1 and n2 as descendants,
            where n1 and n2 are the nodes for which we wish to find the LCA. Hence, the LCA of a binary tree
            with nodes n1 and n2 is the shared ancestor of n1 and n2 that is located farthest from the root.
        *
        * */
    }



}
