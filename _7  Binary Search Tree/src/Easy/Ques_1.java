package Easy;

import java.util.Stack;

public class Ques_1 {

    //Ques : Binary Search Tree.......... (Search and Insertion)                              (GFG Ques.)


    //Approach 1 : Searching In BST......(Recursive solution...)
    // A utility function to search a given key in BST
    class Node{
        int key;
        Node right, left;
    }
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }




    //Approach 2 : Insertion of a Key in the BST.....(Recursive Solution).....
    // Java program to demonstrate insert operation in binary search tree
    static class BinarySearchTree_2 {

        /* Class containing left and right child of current node and key value*/
        class Node {
            int key;
            Node left, right;
            public Node(int item)
            {
                key = item;
                left = right = null;
            }
        }
        // Root of BST
        Node root;

        // Constructor
        BinarySearchTree_2() {
            root = null;
        }

        BinarySearchTree_2(int value) { root = new Node(value); }

        // This method mainly calls insertRec()
        void insert(int key) { root = insertRec(root, key); }

        /* A recursive function to insert a new key in BST */
        Node insertRec(Node root, int key)
        {

        /* If the tree is empty, return a new node */
            if (root == null) {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            else if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            /* return the (unchanged) node pointer */
            return root;
        }

        // This method mainly calls InorderRec()
        void inorder() { inorderRec(root); }

        // A utility function to do inorder traversal of BST
        void inorderRec(Node root)
        {
            if (root != null) {
                inorderRec(root.left);
                System.out.println(root.key);
                inorderRec(root.right);
            }
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            BinarySearchTree_2 tree = new BinarySearchTree_2();

            /* Let us create following BST
                      50
                   /     \
                  30      70
                 /  \    /  \
               20   40  60   80 */
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            // print inorder traversal of the BST
            tree.inorder();
        }
    }

    /*  Time Complexity :  O(h)
            The worst-case time complexity of search and insert operations is O(h) where h is the height
            of the Binary Search Tree. In the worst case, we may have to travel from root to the deepest leaf node.
            The height of a skewed tree may become n and the time complexity of search and insert operation
            may become O(n).


     *
    * */




    //Approach 3 : Insertion of a key in the BST.......(Iterative Solution)......
    class GFG {
        public static void main_3(String[] args) {
            BST tree = new BST();
            tree.insert(30);
            tree.insert(50);
            tree.insert(15);
            tree.insert(20);
            tree.insert(10);
            tree.insert(40);
            tree.insert(60);
            tree.inorder();
        }
    }
    static class Node_2 {
        Node_2 left;
        int val;
        Node_2 right;
        Node_2(int val){
            this.val=val;
        }
    }
    static class BST{
        Node_2 root;
        public void insert(int key){
            Node_2 node = new Node_2(key);
            if(root == null) {
                root = node;
                return;
            }
            Node_2 prev = null;
            Node_2 temp = root;
            while (temp != null){
                if(temp.val > key){
                    prev = temp;
                    temp = temp.left;

                }
                else if (temp.val < key){
                    prev = temp;
                    temp = temp.right;
                }
            }
            if(prev.val > key)
                prev.left = node;
            else prev.right = node;
        }

        public void inorder(){
            Node_2 temp = root;
            Stack<Node_2> stack = new Stack<>();
            while (temp != null || !stack.isEmpty()){
                if(temp != null){
                    stack.add(temp);
                    temp = temp.left;
                }
                else {
                    temp = stack.pop();
                    System.out.print(temp.val+" ");
                    temp = temp.right;
                }
            }
        }
    }









    public static void main(String[] args) {

        /*Ques : What is Binary Search Tree......?

             A binary Search Tree is a node-based binary tree data structure which has the following properties :
              1. The left subtree of a node contains only nodes with keys lesser than the node’s key.
              2. The right subtree of a node contains only nodes with keys greater than the node’s key.
              3. The left and right subtree each must also be a binary search tree.
                 There must be no duplicate nodes.

        *
        *
        *
        * */
    }



}
