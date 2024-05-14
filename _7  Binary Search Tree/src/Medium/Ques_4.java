package Medium;

import java.util.HashSet;

public class Ques_4 {

    //Ques : Check whether BST contains Dead End...........                                    (GFG Ques.)


    //Approach 1 : Simple Approach.........                                                    T.C. = O(n)
    // Java program check whether BST contains dead end or not
    class Main {
        // Create two empty hash sets that store all BST elements and leaf nodes respectively.
        static HashSet<Integer> all_nodes = new HashSet<Integer>();
        static HashSet<Integer> leaf_nodes = new HashSet<Integer>();

        /* A utility function to insert a new Node with given key in BST */
        public static Node insert(Node node, int key)
        {
            /* If the tree is empty, return a new Node */
            if (node == null)
                return new Node(key);

            /* Otherwise, recur down the tree */
            if (key < node.data)
                node.left = insert(node.left, key);
            else if (key > node.data)
                node.right = insert(node.right, key);

            /* return the Node */
            return node;
        }
        // Function to store all node of given binary search tree
        public static void storeNodes(Node root)
        {
            if (root == null)
                return;

            // store all node of binary search tree
            all_nodes.add(root.data);

            // store leaf node in leaf_hash
            if (root.left == null && root.right == null) {
                leaf_nodes.add(root.data);
                return;
            }

            // recur call rest tree
            storeNodes(root.left);
            storeNodes(root.right);
        }

        // Returns true if there is a dead end in tree, else false.
        public static boolean isDeadEnd(Node root)
        {
            // Base case
            if (root == null)
                return false;

            // insert 0 in 'all_nodes' for handle case if bst contain value 1
            all_nodes.add(0);

            // Call storeNodes function to store all BST Node
            storeNodes(root);

            // Traversal leaf node and check Tree contain continuous sequence of size tree or Not
            for (int i : leaf_nodes) {
                int x = i;

                // Here we check first and last element of continuous sequence that are x-1 & x+1
                if (all_nodes.contains(x + 1)  &&  all_nodes.contains(x - 1)) {
                    return true;
                }
            }
            return false;
        }

        // Driver program
        public static void main_1(String[] args)
        {
        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
            Node root = null;
            root = insert(root, 8);
            root = insert(root, 5);
            root = insert(root, 2);
            root = insert(root, 3);
            root = insert(root, 7);
            root = insert(root, 11);
            root = insert(root, 4);
            if (isDeadEnd(root) == true)
                System.out.println("Yes");

            else
                System.out.println("No");
        }
    }
    // A BST node
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }



    //Approach 2 : Improved Approach.........
    //C++ Code :
    /*  C++ program check whether BST contains dead end or not
        #include<bits/stdc++.h>
        using namespace std;

        // A BST node
        struct Node
        {
            int data;
            struct Node *left, *right;
        }

        // A utility function to create a new node
        Node *newNode(int data)
        {
            Node *temp = new Node;
            temp->data = data;
            temp->left = temp->right = NULL;
            return temp;
        }

            // A utility function to insert a new Node with given key in BST
            struct Node* insert(struct Node* node, int key)
            {
                // If the tree is empty, return a new Node
                if (node == NULL) return newNode(key);

                // Otherwise, recur down the tree
                if (key < node->data)
                    node->left = insert(node->left, key);
                else if (key > node->data)
                    node->right = insert(node->right, key);

                // return the (unchanged) Node pointer
                return node;
            }
            void findallNodes(Node* root,map<int,int> &allnodes)
            {
                if(root == NULL)
                    return ;

                allnodes[root->data] = 1;
                findallNodes(root->left,allnodes);
                findallNodes(root->right,allnodes);
            }
            bool check(Node* root,map<int,int> &allnodes)
            {
                if(root == NULL)
                    return false;

                if(root->left == NULL and root->right == NULL)
                {
                    int pre = root->data - 1;
                    int next = root->data + 1;

                    if(allnodes.find(pre) != allnodes.end() and allnodes.find(next) != allnodes.end())
                    return true;
                }

                return check(root->left,allnodes) or check(root->right,allnodes);

            }
            bool isDeadEnd(Node *root)
            {
                // Base case
                if (root == NULL)
                    return false ;
                map<int,int> allnodes;
                // adding 0 for handling the exception of node having data = 1
                allnodes[0] = 1;
                findallNodes(root,allnodes);

                return check(root,allnodes);

            }

            // Driver program
            int main()
            {
                 8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4
                Node *root = NULL;
                root = insert(root, 8);
                root = insert(root, 5);
                root = insert(root, 2);
                root = insert(root, 3);
                root = insert(root, 7);
                root = insert(root, 11);
                root = insert(root, 4);
                if (isDeadEnd(root) == true)
                    cout << "Yes " << endl;
                else
                    cout << "No " << endl;
                return 0;
            }
            *
     */




    //Approach 3 : Recursive Solution........
    // Java Program to check if there is a dead end in BST or not.
    static class BinarySearchTree {

        // Class containing left and right child of current node and key value
        class Node {
            int data;
            Node left, right;
            public Node(int item) {
                data = item;
                left = right = null;
            }
        }

        // Root of BST
        Node root;
        // Constructor
        BinarySearchTree() {
            root = null;
        }

        // This method mainly calls insertRec()
        void insert(int data) {
            root = insertRec(root, data);
        }

        // A recursive function to insert a new key in BST
        Node insertRec(Node root, int data) {

            // If the tree is empty, return a new node
            if (root == null) {
                root = new Node(data);
                return root;
            }

            // Otherwise, recur down the tree
            if (data < root.data)
                root.left = insertRec(root.left, data);
            else if (data > root.data)
                root.right = insertRec(root.right, data);

            // return the (unchanged) node pointer
            return root;
        }

        // Returns true if tree with given root contains dead end or not. min and max indicate range
        // of allowed values for current node. Initially these values are full range.
        boolean deadEnd(Node root, int min, int max)
        {
            // if the root is null or the recursion moves after leaf node it will return false
            // i.e. no dead end.
            if (root==null)
                return false;

            // if this occurs means dead end is present.
            if (min == max)
                return true;

            // heart of the recursion lies here.
            return deadEnd(root.left, min, root.data - 1)||
                    deadEnd(root.right, root.data + 1, max);
        }


        // Driver Program
        public static void main_3(String[] args) {

            BinarySearchTree tree = new BinarySearchTree();

            /*       8
                   /   \
                  5    11
                 /  \
                2    7
                 \
                  3
                   \
                    4

            */
            tree.insert(8);
            tree.insert(5);
            tree.insert(2);
            tree.insert(3);
            tree.insert(7);
            tree.insert(11);
            tree.insert(4);

            if (tree.deadEnd(tree.root ,1 ,
                    Integer.MAX_VALUE) == true)

                System.out.println("Yes ");
            else
                System.out.println("No " );
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a Binary search Tree that contains positive integer values greater than 0. The task is
                 to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false.
                 Here Dead End means, we are not able to insert any element after that node.


            Example : 1
            Input   :
                           8
                         /   \
                       5      9
                     /  \
                    2    7
                   /
                  1

            Output : Yes
            Explanation : Node "1" is the dead End because after that
                          we cant insert any element.

            Example : 2
            Input   :
                          8
                        /   \
                       7     10
                     /      /   \
                    2      9     13

            Output : Yes
            Explanation : We can't insert any element at node 9.


            Here,
            Input  : The first line of the input contains an integer 'T' denoting the number of test cases.
                     Then 'T' test cases follow. Each test case consists of three lines. First line of each test case
                     contains an integer N denoting the no of nodes of the BST . Second line of each test case consists
                     of 'N' space separated integers denoting the elements of the BST. These elements are inserted into
                     BST in the given order.
            Output : The output for each test case will be 1 if the BST contains a dead end else 0.


            Example : 2............(To be used only for expected output)
            Input   : 2
                      6
                      8 5 9 7 2 1
                      6
                      8 7 10 9 13 2
            Output  : 1
                      1
        *
        *
        * */
    }



}
