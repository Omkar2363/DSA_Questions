package Medium;

public class Ques_3 {

    //Ques : Predecessor and Successor...........                                           (GFG Ques.)


    //Approach 1 :
    // Java program to find predecessor and successor in a BST
    class GFG{
        // BST Node
        static class Node
        {
            int key;
            Node left, right;
            public Node(){}
            public Node(int key) {
                this.key = key;
                this.left = this.right = null;
            }
        }
        static Node pre = new Node(), suc = new Node();

        // This function finds predecessor and successor of key in BST. It sets pre and suc as predecessor and successor respectively.
        static void findPreSuc(Node root, int key)
        {
            // Base case
            if (root == null)
                return;

            // If key is present at root
            if (root.key == key)
            {

                // The maximum value in left subtree is predecessor
                if (root.left != null)
                {
                    Node tmp = root.left;
                    while (tmp.right != null)
                        tmp = tmp.right;


                    pre = tmp;
                }

                // The minimum value in right subtree is successor
                if (root.right != null)
                {
                    Node tmp = root.right;

                    while (tmp.left != null)
                        tmp = tmp.left;

                    suc = tmp;
                }
                return;
            }

            // If key is smaller than root's key, go to left subtree
            if (root.key > key)
            {
                suc = root;
                findPreSuc(root.left, key);
            }

            // Go to right subtree
            else
            {
                pre = root;
                findPreSuc(root.right, key);
            }
        }

        // A utility function to insert a new node with given key in BST
        static Node insert(Node node, int key)
        {
            if (node == null)
                return new Node(key);
            if (key < node.key)
                node.left = insert(node.left, key);
            else
                node.right = insert(node.right, key);

            return node;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            // Key to be searched in BST
            int key = 65;

            /*
             * Let us create following BST
             *          50
             *         /  \
             *        30   70
             *       /  \ /  \
             *      20 40 60  80
             */

            Node root = new Node();
            root = insert(root, 50);
            insert(root, 30);
            insert(root, 20);
            insert(root, 40);
            insert(root, 70);
            insert(root, 60);
            insert(root, 80);

            findPreSuc(root, key);
            if (pre != null)
                System.out.println("Predecessor is " + pre.key);
            else
                System.out.println("No Predecessor");

            if (suc != null)
                System.out.println("Successor is " + suc.key);
            else
                System.out.println("No Successor");
        }
    }

    /*  Complexity Analysis :
           * Time Complexity : O(h),  where h is the height of the tree. In the worst case as explained above
                                      we travel the whole height of the tree.
           * Auxiliary Space : O(1),  since no extra space has been taken.
    *
    * */



    //Approach 2 :
    // JAVA code for inorder successor and predecessor of tree
    class GFG_2 {
        static class Node {
            int data;
            Node left,right;
        }

        // Function to return data
        static Node getnode(int info)
        {
            Node p = new Node();
            p.data = info;
            p.right = null;
            p.left = null;
            return p;
        }

        /* Since inorder traversal results in ascending order visit to node , we can store the values of
           the largest no which is smaller than a (predecessor) and smallest no which is large than
           a (successor) using inorder traversal
        */
        static Node p,q;
        static void find_p_s(Node root,int a)
        {
            // If root is null return
            if(root == null)
                return ;

            // traverse the left subtree
            find_p_s(root.left, a);

            // root data is greater than a
            if(root != null && root.data > a)
            {

                // q stores the node whose data is greater than a and is smaller than the previously
                // stored data in *q which is successor
                if((q == null) || (q != null) && q.data > root.data)
                    q = root;
            }

            // if the root data is smaller than store it in p which is predecessor
            else if(root != null && root.data < a)
            {
                p = root;
            }

            // traverse the right subtree
            find_p_s(root.right, a);
        }

        // Driver code
        public static void main(String[] args)
        {
            Node root1  = getnode(50);
            root1.left  = getnode(20);
            root1.right = getnode(60);
            root1.left.left   = getnode(10);
            root1.left.right  = getnode(30);
            root1.right.left  = getnode(55);
            root1.right.right = getnode(70);
            p = null;
            q = null;

            find_p_s(root1, 55);

            if(p != null)
                System.out.print(p.data);
            if(q != null)
                System.out.print(" " +  q.data);
        }
    }


    /*  Complexity Analysis :
           * Time Complexity : O(n), where n is the total number of nodes in the tree. In the worst case as explained above we travel the whole tree.
           * Auxiliary Space : O(n).
    *
    * */






    public static void main(String[] args) {

        /*Ques : There is BST given with root node with key part as an integer only. You need to find the in-order
                 successor and predecessor of a given key. If either predecessor or successor is not found,
                 then set it to NULL.


            Example : 1
            Input   : 2
                      6
                      50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
                      65
                      6
                      50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
                      100
            Output  : 60 70
                      80 -1


            Example : 2
            Input   : The first line of input contains an integer T denoting the number of test cases.
                      Then T test cases follow. Each test case contains n denoting the number of edges of the BST.
                      The next line contains the edges of the BST. The last line contains the key.

            Output  :
            Find the predecessor and successor of the key in BST and sets pre and suc as predecessor and successor,
            respectively Otherwise, set to NULL.

            Your Task :
            You don't need to print anything. You only need to set p.pre to the predecessor and s.succ to
            the successor. p and s have been passed in the function parameter.

        *
        *
        * */
    }



}
