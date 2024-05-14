package Hard;

public class Ques_11 {

    //Ques : Min distance between two given nodes of a Binary Tree..........                     (GFG Ques.)
    // Link : https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/

    //Approach 1 :
    // A Java Program to find distance between
    // n1 and n2 using one traversal
    class GFG
    {

// (To the moderator) in Java solution these
// variables are declared as pointers hence
//changes made to them reflects in the whole program

        // Global static variable
        static int d1 = -1;
        static int d2 = -1;
        static int dist = 0;

        // A Binary Tree Node
        static class Node
        {
            Node left, right;
            int key;

            // constructor
            Node(int key)
            {
                this.key = key;
                left = null;
                right = null;
            }
        }

        // Returns level of key k if it is present
// in tree, otherwise returns -1
        static int findLevel(Node root, int k,
                             int level)
        {

            // Base Case
            if (root == null)
            {
                return -1;
            }

            // If key is present at root, or in left
            // subtree or right subtree, return true;
            if (root.key == k)
            {
                return level;
            }

            int l = findLevel(root.left, k, level + 1);
            return (l != -1)? l : findLevel(root.right, k,
                    level + 1);
        }

        // This function returns pointer to LCA of
// two given values n1 and n2. It also sets
// d1, d2 and dist if one key is not ancestor of other
// d1 -. To store distance of n1 from root
// d2 -. To store distance of n2 from root
// lvl -. Level (or distance from root) of current node
// dist -. To store distance between n1 and n2
        public static Node findDistUtil(Node root, int n1,
                                        int n2, int lvl)
        {

            // Base case
            if (root == null)
            {
                return null;
            }

            // If either n1 or n2 matches with root's
            // key, report the presence by returning
            // root (Note that if a key is ancestor of
            // other, then the ancestor key becomes LCA
            if (root.key == n1)
            {
                d1 = lvl;
                return root;
            }
            if (root.key == n2)
            {
                d2 = lvl;
                return root;
            }

            // Look for n1 and n2 in left and right subtrees
            Node left_lca = findDistUtil(root.left, n1,
                    n2, lvl + 1);
            Node right_lca = findDistUtil(root.right, n1,
                    n2, lvl + 1);

            // If both of the above calls return Non-null,
            // then one key is present in once subtree and
            // other is present in other, So this node is the LCA
            if (left_lca != null && right_lca != null)
            {
                dist = (d1 + d2) - 2 * lvl;
                return root;
            }

            // Otherwise check if left subtree
            // or right subtree is LCA
            return (left_lca != null)? left_lca : right_lca;
        }

        // The main function that returns distance
// between n1 and n2. This function returns -1
// if either n1 or n2 is not present in
// Binary Tree.
        public static int findDistance(Node root, int n1, int n2)
        {
            d1 = -1;
            d2 = -1;
            dist = 0;
            Node lca = findDistUtil(root, n1, n2, 1);

            // If both n1 and n2 were present
            // in Binary Tree, return dist
            if (d1 != -1 && d2 != -1)
            {
                return dist;
            }

            // If n1 is ancestor of n2, consider
            // n1 as root and find level
            // of n2 in subtree rooted with n1
            if (d1 != -1)
            {
                dist = findLevel(lca, n2, 0);
                return dist;
            }

            // If n2 is ancestor of n1, consider
            // n2 as root and find level
            // of n1 in subtree rooted with n2
            if (d2 != -1)
            {
                dist = findLevel(lca, n1, 0);
                return dist;
            }
            return -1;
        }

        // Driver Code
        public static void main(String[] args)
        {

            // Let us create binary tree given
            // in the above example
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            root.right.left.right = new Node(8);
            System.out.println("Dist(4, 5) = " +
                    findDistance(root, 4, 5));
            System.out.println("Dist(4, 6) = " +
                    findDistance(root, 4, 6));
            System.out.println("Dist(3, 4) = " +
                    findDistance(root, 3, 4));
            System.out.println("Dist(2, 4) = " +
                    findDistance(root, 2, 4));
            System.out.println("Dist(8, 5) = " +
                    findDistance(root, 8, 5));
        }
    }



    public static void main(String[] args) {

        /*Ques : Given a binary tree and two node values your task is to find the minimum distance between them.
                 The given two nodes are guaranteed to be in the binary tree.
                 Please Note that a and b are not always leaf node.


            Example : 1
            Input   :
                            1
                          /  \
                         2    3
                    a = 2, b = 3
            Output  : 2

            Explanation : The tree formed is:
                           1
                         /   \
                        2     3
            We need the distance between 2 and 3. Being at node 2, we need to take two
            steps ahead in order to reach node 3.
            The path followed will be :
            2 -> 1 -> 3. Hence, the result is 2.


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function findDist()
            which takes the root node of the Tree and the two node values a and b as input parameters and
            returns the minimum distance between the nodes represented by the two given node values.

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(Height of the Tree)


        *
        *
        * */
    }



}
