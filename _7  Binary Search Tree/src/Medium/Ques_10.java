package Medium;

import java.util.ArrayList;

public class Ques_10 {

    //Ques : Merge Two Balanced Binary Search Trees...........                             (GFG Ques.)


    //Approach 1 :
    /*  Method 1 (Insert elements of the first tree to the second) :
            Take all elements of the first BST one by one, and insert them into the second BST. Inserting an element
            to a self-balancing BST takes Log(n) time (See this) where n is the size of the BST. So time complexity of
            this method is Log(n) + Log(n+1) … Log(m+n-1).

            The value of this expression will be between m(Log(n)) and mLog(m+n-1). As an optimization, we can pick the
            smaller tree as the first tree.
    *
    * */


    //Approach 2 :
    /*  Method 2 : (Merge Inorder Traversals)
          1. Do inorder traversal of the first tree and store the traversal in one temp array arr1[].
             This step takes O(m) time.
          2. Do inorder traversal of the second tree and store the traversal in another temp array arr2[].
             This step takes O(n) time.
          3. The arrays created in steps 1 and 2 are sorted arrays. Merge the two sorted arrays into one array
             of size m + n. This step takes O(m+n) time.
          4. Construct a balanced tree from the merged array using the technique discussed in this post.
             This step takes O(m+n) time.

        The time complexity of this method is O(m+n) which is better than method 1. This method takes O(m+n) time even
        if the input BSTs are not balanced.
    *
    */
    // Java program to Merge Two Balanced Binary Search Trees
    // A binary tree node
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static class BinarySearchTree {
        // Root of BST
        Node root;
        // Constructor
        BinarySearchTree() {
            root = null;
        }
        // Inorder traversal of the tree
        void inorder()
        {
            inorderUtil(this.root);
        }
        // Utility function for inorder traversal of the tree
        void inorderUtil(Node node)
        {
            if(node==null)
                return;

            inorderUtil(node.left);
            System.out.print(node.data + " ");
            inorderUtil(node.right);
        }
        // A Utility Method that stores inorder traversal of a tree
        public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list)
        {
            if(node == null)
                return list;

            //recur on the left child
            storeInorderUtil(node.left, list);

            // Adds data to the list
            list.add(node.data);

            //recur on the right child
            storeInorderUtil(node.right, list);

            return list;
        }

        // Method that stores inorder traversal of a tree
        ArrayList<Integer> storeInorder(Node node)
        {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = storeInorderUtil(node,list1);
            return list2;
        }

        // Method that merges two ArrayLists into one.
        ArrayList<Integer> merge(ArrayList<Integer>list1, ArrayList<Integer>list2, int m, int n)
        {
            // list3 will contain the merge of list1 and list2
            ArrayList<Integer> list3 = new ArrayList<>();
            int i=0;
            int j=0;

            //Traversing through both ArrayLists
            while( i<m && j<n)
            {
                // Smaller one goes into list3
                if(list1.get(i)<list2.get(j))
                {
                    list3.add(list1.get(i));
                    i++;
                }
                else
                {
                    list3.add(list2.get(j));
                    j++;
                }
            }

            // Adds the remaining elements of list1 into list3
            while(i < m)
            {
                list3.add(list1.get(i));
                i++;
            }

            // Adds the remaining elements of list2 into list3
            while(j < n)
            {
                list3.add(list2.get(j));
                j++;
            }
            return list3;
        }

        // Method that converts an ArrayList to a BST
        Node ALtoBST(ArrayList<Integer> list, int start, int end)
        {
            // Base case
            if(start > end)
                return null;

            // Get the middle element and make it root
            int mid = (start+end)/2;
            Node node = new Node(list.get(mid));

            /* Recursively construct the left subtree and make it left child of root */
            node.left = ALtoBST(list, start, mid-1);

            /* Recursively construct the right subtree and make it right child of root */
            node.right = ALtoBST(list, mid+1, end);

            return node;
        }

        // Method that merges two trees into a single one.
        Node mergeTrees(Node node1, Node node2)
        {
            //Stores Inorder of tree1 to list1
            ArrayList<Integer> list1 = storeInorder(node1);

            //Stores Inorder of tree2 to list2
            ArrayList<Integer> list2 = storeInorder(node2);

            // Merges both list1 and list2 into list3
            ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());

            //Eventually converts the merged list into resultant BST
            Node node = ALtoBST(list3, 0, list3.size()-1);
            return node;
        }

        // Driver function
        public static void main_2 (String[] args)
        {

        /* Creating following tree as First balanced BST
                100
                / \
               50 300
              / \
             20 70
        */

            BinarySearchTree tree1 = new BinarySearchTree();
            tree1.root       = new Node(100);
            tree1.root.left  = new Node(50);
            tree1.root.right = new Node(300);
            tree1.root.left.left  = new Node(20);
            tree1.root.left.right = new Node(70);

        /* Creating following tree as second balanced BST
                80
                / \
              40 120
        */

            BinarySearchTree tree2 = new BinarySearchTree();
            tree2.root       = new Node(80);
            tree2.root.left  = new Node(40);
            tree2.root.right = new Node(120);


            BinarySearchTree tree = new BinarySearchTree();
            tree.root = tree.mergeTrees(tree1.root, tree2.root);
            System.out.println("The Inorder traversal of the merged BST is: ");
            tree.inorder();
        }
    }






    //Approach 3 :
    /*  Method 3 : (In-Place Merge using DLL)
            We can use a Doubly Linked List to merge trees in place. Following are the steps :
             1. Convert the given two Binary Search Trees into a doubly linked list in place (Refer to this post for this step).
             2. Merge the two sorted Linked Lists (Refer to this post for this step).
             3. Build a Balanced Binary Search Tree from the merged list created in step 2. (Refer to this post for this step)

            The time complexity of this method is also O(m+n) and this method does conversion in place.
    * */
    //C++ Code :
    /*  C++ Code for the above approach
        #include <bits/stdc++.h>
        using namespace std;

        // A binary tree node has data, a pointer to left child and a pointer to right child
        class Node {
            public:
            int data;
            Node* left;
            Node* right;
        }

        // Function to return a new Node
        Node* newNode(int data)
        {
            Node* node = new Node();
            node->data = data;
            node->left = NULL;
            node->right = NULL;

            return (node);
        }

        // Function to convert bst to a doubly linked list
        void bstTodll(Node* root, Node*& head)
        {
            // if root is NULL
            if (!root)
                return;

            // Convert right subtree recursively
            bstTodll(root->right, head);

            // Update root
            root->right = head;

            // if head is not NULL
            if (head) {

                // Update left of the head
                head->left = root;
            }

            // Update head
            head = root;

            // Convert left subtree recursively
            bstTodll(root->left, head);
        }

        // Function to merge two sorted linked list
        Node* mergeLinkedList(Node* head1, Node* head2)
        {

            // Create head and tail for result list
            Node* head = NULL;
            Node* tail = NULL;

            while (head1 && head2) {

                if (head1->data < head2->data) {

                    if (!head)
                        head = head1;
                    else {

                        tail->right = head1;
                        head1->left = tail;
                    }

                    tail = head1;
                    head1 = head1->right;
                }

                else {

                    if (!head)
                        head = head2;
                    else {
                        tail->right = head2;
                        head2->left = tail;
                    }

                    tail = head2;
                    head2 = head2->right;
                }
            }

            while (head1) {
                tail->right = head1;
                head1->left = tail;
                tail = head1;
                head1 = head1->right;
            }

            while (head2) {
                tail->right = head2;
                head2->left = tail;
                tail = head2;
                head2 = head2->right;
            }

            // Return the created DLL
            return head;
        }

        // function to convert list to bst
        Node* sortedListToBST(Node*& head, int n)
        {
            // if no element is left or head is null
            if (n <= 0 || !head)
                return NULL;

            // Create left part from the list recursively
            Node* left = sortedListToBST(head, n / 2);

            Node* root = head;
            root->left = left;
            head = head->right;

            // Create left part from the list recursively
            root->right = sortedListToBST(head, n - (n / 2) - 1);

            // Return the root of BST
            return root;
        }

        // This function merges two balanced BSTs
        Node* mergeTrees(Node* root1, Node* root2, int m, int n)
        {
            // Convert BSTs into sorted Doubly Linked Lists

            Node* head1 = NULL;
            bstTodll(root1, head1);
            head1->left = NULL;

            Node* head2 = NULL;
            bstTodll(root2, head2);
            head2->left = NULL;

            // Merge the two sorted lists into one
            Node* head = mergeLinkedList(head1, head2);

            // Construct a tree from the merged lists
            return sortedListToBST(head, m + n);
        }

        void printInorder(Node* node)
        {
            // if current node is NULL
            if (!node) {
                return;
            }

            printInorder(node->left);

            // Print node of current data
            cout << node->data << " ";

            printInorder(node->right);
        }

        // Driver code
        int main()
        {
         // Create following tree as first balanced BST
               100
               / \
              50 300
             / \
            20 70

            Node* root1 = newNode(100);
            root1->left = newNode(50);
            root1->right = newNode(300);
            root1->left->left = newNode(20);
            root1->left->right = newNode(70);

        // Create following tree as second balanced BST
                 80
                / \
               40 120

            Node* root2 = newNode(80);
            root2->left = newNode(40);
            root2->right = newNode(120);

            // Function Call
            Node* mergedTree = mergeTrees(root1, root2, 5, 3);

            cout << "Following is Inorder traversal of the merged "
            "tree \n";
            printInorder(mergedTree);

            return 0;
        }
    *
    *
    */

    /*  Time Complexity : O(N + M), where N and M are the numbers of nodes in the given trees.
        Auxiliary Space : O(1),     as constant extra space is used.
    *
    * */




    public static void main(String[] args) {

        /*Ques : You are given two balanced binary search trees e.g., AVL or Red-Black Tree. Write a function that merges
                 the two given balanced BSTs into a balanced binary search tree. Let there be m elements in the first tree
                 and n elements in the other tree. Your merge function should take O(m+n) time.

                In the following solutions, it is assumed that the sizes of trees are also given as input.
                If the size is not given, then we can get the size by traversing the tree (See this).
        *
        * */
    }



}
