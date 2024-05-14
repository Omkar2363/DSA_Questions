package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Ques_LB_11 {

    //Ques : Construct Tree from given Inorder and Preorder traversals..........                (GFG Ques.)


    //Approach 1 : Simple Approach......                                                        T.C. = O(n^2), O(n)
    /*  Algorithm : buildTree()
           1. Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code)
              to pick the next element in the next recursive call.
           2. Create a new tree node tNode with the data as the picked element.
           3. Find the picked element’s index in Inorder. Let the index be inIndex.
           4. Call buildTree for elements before inIndex and make the built tree as a left subtree of tNode.
           5. Call buildTree for elements after inIndex and make the built tree as a right subtree of tNode.
           6. return tNode.

    *
    * */
    // Java program to construct a tree using inorder and preorder traversal
    /* A binary tree node has data, pointer to left child and a pointer to right child */
    static class Node {
        char data;
        Node left, right;
        Node(char item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_1 {
        Node root;
        static int preIndex = 0;

        /* Recursive function to construct binary of size len from Inorder traversal in[] and Preorder traversal pre[].
           Initial values of inStrt and inEnd should be 0 and len -1.
           The function doesn't do any error checking for cases where inorder and preorder do not form a tree */
        Node buildTree(char in[], char pre[], int inStrt, int inEnd)
        {
            if (inStrt > inEnd)
                return null;

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
            Node tNode = new Node(pre[preIndex++]);

            /* If this node has no children then return */
            if (inStrt == inEnd)
                return tNode;

            /* Else find the index of this node in Inorder traversal */
            int inIndex = search(in, inStrt, inEnd, tNode.data);

            /* Using index in Inorder traversal, construct left and right subtrees */
            tNode.left  = buildTree(in, pre, inStrt, inIndex - 1);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

            return tNode;
        }

        /* UTILITY FUNCTIONS */

        /* Function to find index of value in arr[start...end]
         The function assumes that value is present in in[] */
        int search(char arr[], int strt, int end, char value)
        {
            int i;
            for (i = strt; i <= end; i++) {
                if (arr[i] == value)
                    return i;
            }
            return i;
        }

        /* This function is here just to test buildTree() */
        void printInorder(Node node)
        {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print(node.data + " ");

            /* now recur on right child */
            printInorder(node.right);
        }

        // driver program to test above functions
        public static void main_1(String args[])
        {
            BinaryTree_1 tree = new BinaryTree_1();
            char in[]  = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
            char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
            int len    = in.length;
            Node root  = tree.buildTree(in, pre, 0, len - 1);

            // building the tree by printing inorder traversal
            System.out.println("Inorder traversal of constructed tree is : ");
            tree.printInorder(root);
        }
    }

    /*  Time Complexity : O(n^2), The worst case occurs when the tree is left-skewed.
                                  Example Preorder and Inorder traversals for worst-case are {A, B, C, D} and {D, C, B, A}.
        Auxiliary Space : O(n),   The extra space used is due to the recursive call stack and the worst case
                                  occurs for a skewed tree.
    * */



    //Approach 2 : Efficient Approach........                                                  T.C. = O(n),  S.C. = O(n)
    /*Efficient Approach :
            We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java).
            We store indexes of inorder traversal in a hash table. So that search can be done O(1) time.
    * */
    /* Java program to construct tree using inorder and preorder traversals */
    /* A binary tree node has data, pointer to left child and a pointer to right child */
    class Node_2 {
        char data;
        Node_2 left,right;
        Node_2(char item)
        {
            data = item;
            left = right = null;
        }
    }
    class Tree {

        public static Node root;

        // Store indexes of all items so that we can quickly find later
        static HashMap<Character,Integer> mp = new HashMap<>();
        static int preIndex = 0;

        /* Recursive function to construct binary of size len from Inorder traversal in[] and Preorder traversal
           pre[]. Initial values of inStrt and inEnd should be 0 and len -1. The function doesn't do any error
           checking for cases where inorder and preorder do not form a tree */
        public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd)
        {
            if(inStrt > inEnd)
            {
                return null;
            }

            /* Pick current node from Preorder traversal using preIndex and increment preIndex */
            char curr = pre[preIndex++];
            Node tNode;
            tNode = new Node(curr);

            /* If this node has no children then return */
            if (inStrt == inEnd)
            {
                return tNode;
            }

            /* Else find the index of this node in Inorder traversal */
            int inIndex = mp.get(curr);

            /* Using index in Inorder traversal, construct left and right subtress */
            tNode.left  = buildTree(in, pre, inStrt, inIndex - 1);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
            return tNode;
        }

        // This function mainly creates an unordered_map, then calls buildTree()
        public static Node buldTreeWrap(char[] in, char[] pre, int len)
        {
            for(int i = 0; i < len; i++)
            {
                mp.put(in[i], i);
            }
            return buildTree(in, pre, 0, len - 1);
        }

        /* This function is here just to test buildTree() */
        static void printInorder(Node node)
        {
            if(node == null)
            {
                return;
            }
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

        /* Driver code */
        public static void main_2 (String[] args)
        {
            char[] in  = {'D', 'B', 'E', 'A', 'F', 'C'};
            char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
            int len = in.length;

            Tree.root=buldTreeWrap(in, pre, len);

            /* Let us test the built tree by printing Inorder traversal */
            System.out.println("Inorder traversal of the constructed tree is");
            printInorder(root);
        }
    }




    //Approach 3 : By using Stack and Set........                                             T.C. = O(n),  S.C. = O(n)
    // Java program to construct a tree using inorder and preorder traversal
    public static class TreeNode_3 {
        int val;
        TreeNode_3 left;
        TreeNode_3 right;
        TreeNode_3(int x) {
            val = x;
        }
    }
    static class BinaryTree_3 {
        static Set<TreeNode_3>    set  = new HashSet<>();
        static Stack<TreeNode_3> stack = new Stack<>();

        // Function to build tree using given traversal
        public TreeNode_3 buildTree(int[] preorder, int[] inorder)
        {
            TreeNode_3 root = null;
            for (int pre = 0, in = 0; pre < preorder.length;) {

                TreeNode_3 node = null;
                do {
                    node = new TreeNode_3( preorder[pre] );
                    if (root == null) {
                        root = node;
                    }
                    if (!stack.isEmpty()) {
                        if (set.contains(stack.peek())) {
                            set.remove(stack.peek());
                            stack.pop().right = node;
                        }
                        else {
                            stack.peek().left = node;
                        }
                    }
                    stack.push(node);
                } while (preorder[pre++] != inorder[in] && pre < preorder.length);

                node = null;
                while (!stack.isEmpty() && in < inorder.length && stack.peek().val == inorder[in]) {
                    node = stack.pop();
                    in++;
                }

                if (node != null) {
                    set.add(node);
                    stack.push(node);
                }
            }

            return root;
        }

        // Function to print tree in Inorder
        void printInorder(TreeNode_3 node)
        {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print(node.val + " ");

            /* now recur on right child */
            printInorder(node.right);
        }

        // driver program to test above functions
        public static void main_3(String args[])
        {
            BinaryTree_3 tree = new BinaryTree_3();

            int in[]  = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
            int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
            int len   = in.length;

            TreeNode_3 root = tree.buildTree(pre, in);

            tree.printInorder(root);
        }
    }




    //Leet Code Submission ..........
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val   = val;
            this.left  = left;
            this.right = right;
        }
    }
    static class Solution {
        int preIndex = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        public void CreateMapping(int[] inOrder,int n)
        {
            for(int i=0; i<n; i++)
            {
                map.put(inOrder[i],i);
            }
        }
        public TreeNode solve(int[] preOrder, int[] inOrder,int inOrderStart,int inOrderEnd,int n) {

            if(inOrderStart > inOrderEnd){
                return null;
            }
            int element   = preOrder[preIndex++];
            TreeNode root = new TreeNode(element);
            int position  = map.get(element);

            root.left  = solve(preOrder, inOrder, inOrderStart, position-1, n);
            root.right = solve(preOrder, inOrder, position+1, inOrderEnd, n);

            return root;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int index = 0;
            int n = preorder.length;
            CreateMapping(inorder, n);
            TreeNode root = solve(preorder, inorder, 0, n-1, n);
            return root;
        }
    }




    public static void main(String[] args) {

        /*Ques : Let us consider the below traversals :

                    Inorder sequence  : D B E A F C
                    Preorder sequence : A B D E C F

                 Construct Tree from Inorder & Preorder Tree.

            * In a Preorder sequence, the leftmost element is the root of the tree. So we know ‘A’ is the root
              for given sequences. By searching ‘A’ in the Inorder sequence, we can find out all elements on
              the left side of ‘A’ is in the left subtree and elements on right in the right subtree.
              So we know the below structure now.

                     A
                   /   \
                 /       \
               D B E     F C

              We recursively follow the above steps and get the following tree.

                     A
                   /   \
                 /       \
                B         C
               / \        /
             /     \    /
            D       E  F



        *
        * */
    }

}
