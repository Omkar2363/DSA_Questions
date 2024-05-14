package Medium;

public class Ques_1 {

    //Ques : Lowest Common Ancestor of a Binary Search Tree........                         (Leet Code Ques no. - 235)


    //Approach 1 : Simple Solution.........                                                 T.C. = O(n),  S.C. = O(n)
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
            if(root==null)
                return null;

            if(root==n1 || root==n2)
                return root;

            TreeNode leftLCA  = lowestCommonAncestor(root.left, n1, n2);
            TreeNode rightLCA = lowestCommonAncestor(root.right, n1, n2);

            if(leftLCA != null && rightLCA != null){
                return root;
            }
            if(leftLCA != null){
                return leftLCA;
            }
            return rightLCA;
        }
    }




    //Approach 2 : Efficient Solution.........(DFS)                                        T.C. = O(n),   S.C. = O(1)
    class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if(root == null) return null;
            int curr = root.val;

            if(p.val < curr && q.val < curr)
                return lowestCommonAncestor(root.left, p, q);

            if(p.val > curr && q.val > curr)
                return lowestCommonAncestor(root.right, p, q);

            return root;
        }
    }





    //From GFG :

    //Approach 3 : Recursive Solution........                                             T.C. = O(H),  S.C. = O(H)
    // Recursive Java program to print lca of two nodes

    // A binary tree node
    static class Node {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_3 {
        Node root;

        /* Function to find LCA of n1 and n2. The function assumes that both n1 and n2 are present in BST */
        Node lca(Node node, int n1, int n2)
        {
            if (node == null)
                return null;

            // If both n1 and n2 are smaller than root, then LCA lies in left
            if (node.data > n1 && node.data > n2)
                return lca(node.left, n1, n2);

            // If both n1 and n2 are greater than root, then LCA lies in right
            if (node.data < n1 && node.data < n2)
                return lca(node.right, n1, n2);

            return node;
        }

        /* Driver code */
        public static void main(String args[])
        {
            // Let us construct the BST shown in the above figure
            BinaryTree_3 tree = new BinaryTree_3();
            tree.root = new Node(20);
            tree.root.left = new Node(8);
            tree.root.right = new Node(22);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(12);
            tree.root.left.right.left = new Node(10);
            tree.root.left.right.right = new Node(14);

            // Function calls
            int n1 = 10, n2 = 14;
            Node t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

            n1 = 14;
            n2 = 8;
            t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2  + " is " + t.data);

            n1 = 10;
            n2 = 22;
            t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2  + " is " + t.data);
        }

    }





    //Approach 4 : Iterative Solution......                                              T.C. = O(H),  S.C. = O(1)
    // Recursive Java program to print lca of two nodes
    // A binary tree node
    static class Node_2 {
        int data;
        Node_2 left, right;
        Node_2(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_4 {
        Node_2 root;

        /* Function to find LCA of n1 and n2.
           The function assumes that both n1 and n2 are present in BST */
        static Node_2 lca(Node_2 root, int n1, int n2)
        {
            while (root != null) {
                // If both n1 and n2 are smaller than root, then LCA lies in left
                if (root.data > n1 && root.data > n2)
                    root = root.left;

                // If both n1 and n2 are greater than root, then LCA lies in right
                else if (root.data < n1 && root.data < n2)
                    root = root.right;

                else
                    break;
            }
            return root;
        }

        /* Driver code */
        public static void main_4(String args[])
        {
            // Let us construct the BST shown in the above figure
            BinaryTree_4 tree = new BinaryTree_4();
            tree.root       = new Node_2(20);
            tree.root.left  = new Node_2(8);
            tree.root.right = new Node_2(22);
            tree.root.left.left  = new Node_2(4);
            tree.root.left.right = new Node_2(12);
            tree.root.left.right.left = new Node_2(10);
            tree.root.left.right.right = new Node_2(14);

            // Function calls
            int n1 = 10, n2 = 14;
            Node_2 t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

            n1 = 14;
            n2 = 8;
            t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2  + " is " + t.data);

            n1 = 10;
            n2 = 22;
            t = tree.lca(tree.root, n1, n2);
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

                 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
                 two nodes p and q as the lowest node in T that has both p and q as descendants
                 (where we allow a node to be a descendant of itself).”


            Example : 1
            Input   : root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
            Output  : 6
            Explanation : The LCA of nodes 2 and 8 is 6.


            Example : 2
            Input   : root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
            Output  : 2
            Explanation : The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to
                          the LCA definition.


            Example : 3
            Input   : root = [2,1], p = 2, q = 1
            Output  : 2

        *
        *
        * */
    }




}
