package Easy;

public class Ques_4 {

    //Ques : Kth largest element in BST...........                                         (GFG Ques.)


    //Approach 1 :
    // Java code to find k'th largest element in BST
    // A binary tree node
    static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
    static class BinarySearchTree {
        // Root of BST
        Node root;
        // Constructor
        BinarySearchTree()
        {
            root = null;
        }

        // function to insert nodes
        public void insert(int data)
        {
            this.root = this.insertRec(this.root, data);
        }

        /* A utility function to insert a new node with given key in BST */
        Node insertRec(Node node, int data)
        {
            /* If the tree is empty, return a new node */
            if (node == null) {
                this.root = new Node(data);
                return this.root;
            }

            if (data == node.data) {
                return node;
            }

            /* Otherwise, recur down the tree */
            if (data < node.data) {
                node.left  = this.insertRec(node.left, data);
            } else {
                node.right = this.insertRec(node.right, data);
            }
            return node;
        }

        // class that stores the value of count
        public class count {
            int c = 0;
        }

        // utility function to find kth largest no in a given tree
        void kthLargestUtil(Node node, int k, count C)
        {
            // Base cases, the second condition is important to avoid unnecessary recursive calls
            if (node == null || C.c >= k)
                return;

            // Follow reverse inorder traversal so that the largest element is visited first
            this.kthLargestUtil(node.right, k, C);

            // Increment count of visited nodes
            C.c++;

            // If c becomes k now, then this is the k'th largest
            if (C.c == k) {
                System.out.println(k + "th largest element is " + node.data);
                return;
            }

            // Recur for left subtree
            this.kthLargestUtil(node.left, k, C);
        }

        // Method to find the kth largest no in given BST
        void kthLargest(int k)
        {
            count c = new count();                                         // object of class count
            this.kthLargestUtil(this.root, k, c);
        }

        // Driver function
        public static void main(String[] args)
        {
            BinarySearchTree tree = new BinarySearchTree();

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

            for (int i = 1; i <= 7; i++) {
                tree.kthLargest(i);
            }
        }
    }


    /*  Complexity Analysis :
          *  Time Complexity : O(n)   In worst case the code can traverse each and every node of the tree
                                      if the k given is equal to n (total number of nodes in the tree).
                                      Therefor, overall time complexity is O(n).
          *  Auxiliary Space : O(h)   Max recursion stack of height h at a given time.
    *
    * */






    public static void main(String[] args) {

        /*Ques : Given a Binary search tree. Your task is to complete the function which will return
                 the Kth largest element without doing any modification in Binary Search Tree.


            Example : 1
            Input   :
                          4
                        /   \
                       2     9
            k = 2
            Output  : 4

            Example : 2
            Input   :
                           9
                            \
                              10
            K = 1
            Output  : 10

            Your Task :
            You don't need to read input or print anything. Your task is to complete the function kthLargest()
            which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(H)  where H is max recursion stack of height h at a given time.


        *
        * */
    }



}
