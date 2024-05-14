package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class Ques_8 {

    //Ques : Populate Inorder Successor for all nodes.........                               (GFG Ques.)


    //Approach 1 : By using Reverse InOrder Traversal......                                  T.C. = O(n)
    // Java program to populate inorder traversal of all nodes
    // A binary tree node
    static class Node {
        int data;
        Node left, right, next;
        Node(int item)
        {
            data = item;
            left = right = next = null;
        }
    }
    static class BinaryTree {
        Node root;
        static Node next = null;

        /* Set next of p and all descendants of p by traversing them in reverse Inorder */
        void populateNext(Node node)
        {
            // The first visited node will be the rightmost node next of the rightmost node will be NULL
            if (node != null)
            {
                // First set the next pointer in right subtree
                populateNext(node.right);

                // Set the next as previously visited node in reverse Inorder
                node.next = next;

                // Change the prev for subsequent node
                next = node;

                // Finally, set the next pointer in left subtree
                populateNext(node.left);
            }
        }

        /* Driver program to test above functions*/
        public static void main_1(String args[])
        {
            /* Constructed binary tree is

                    10
                   /   \
                  8      12
                 /
                3

            */
            BinaryTree tree = new BinaryTree();
            tree.root       = new Node(10);
            tree.root.left  = new Node(8);
            tree.root.right = new Node(12);
            tree.root.left.left = new Node(3);

            // Populates nextRight pointer in all nodes
            tree.populateNext(tree.root);

            // Let us see the populated values
            Node ptr = tree.root.left.left;
            while (ptr != null)
            {
                // -1 is printed if there is no successor
                int print  =  ptr.next  !=  null  ?  ptr.next.data : -1;
                System.out.println("Next of " + ptr.data     + " is: " + print);
                ptr = ptr.next;
            }
        }
    }



    // We can avoid the use of static variables by passing reference to next as a parameter.

    /*
    // A wrapper over populateNextRecur
    void populateNext(Node node)
    {
        // The first visited node will be the rightmost node next of the rightmost node will be NULL
        populateNextRecur(node, next);
    }

    // Set next of all descendants of p by traversing them in reverse Inorder
    void populateNextRecur(Node p, Node next_ref)
    {
        if (p != null) {

            // First set the next pointer in right subtree
            populateNextRecur(p.right, next_ref);

            // Set the next as previously visited node in reverse Inorder
            p.next = next_ref;

            // Change the prev for subsequent node
            next_ref = p;

            // Finally, set the next pointer in right subtree
            populateNextRecur(p.left, next_ref);
        }
    }
    */



    //Approach 2 :
    /*  Approach :

        Steps :
          1. Create an array or an ArrayList.
          2. Store the inorder traversal of the binary tree into the ArrayList (nodes are to be stored).
          3. Now traverse the array and replace the next pointer of the node to the immediate right node
             (next element in the array which is the required inorder successor).

                list.get(i).next = list.get(i+1)
    *
    * */
    static class Node_2 {
        int data;
        Node_2 left, right, next;
        // Constructor for initializing key value and all the pointers
        Node_2(int data)
        {
            this.data = data;
            left = right = next = null;
        }
    }
    public static class Solution {
        Node_2 root = null;

        // list to store inorder sequence
        ArrayList<Node_2> list = new ArrayList<>();

        // function for populating next pointer to inorder successor
        void populateNext()
        {
            // list = [3,8,10,12]
            // inorder successor of the present node is the immediate right node
            // for ex : inorder successor of  3 is 8
            for (int i = 0; i < list.size(); i++)
            {
                // check if it is the last node point next of last node(right most) to null
                if (i != list.size() - 1)
                {
                    list.get(i).next = list.get(i + 1);
                }
                else {
                    list.get(i).next = null;
                }
            }

            // Let us see the populated values
            Node_2 ptr = root.left.left;
            while (ptr != null) {
                // -1 is printed if there is no successor
                int print  =  ptr.next  !=  null  ?  ptr.next.data  :  -1;
                System.out.println("Next of " + ptr.data + " is: " + print);
                ptr = ptr.next;
            }
        }

        // insert the inorder into a list to keep track of the inorder successor
        void inorder(Node_2 root)
        {
            if (root != null) {
                inorder(root.left);
                list.add(root);
                inorder(root.right);
            }
        }

        // Driver function
        public static void main_2(String args[])
        {
            Solution tree = new Solution();

            /*      10
                   /   \
                  8     12
                 /
                3

            */
            tree.root       = new Node_2(10);
            tree.root.left  = new Node_2(8);
            tree.root.right = new Node_2(12);
            tree.root.left.left = new Node_2(3);

            // function calls
            tree.inorder(tree.root);
            tree.populateNext();
        }
    }




    //Approach 3 : By using Stack......                                                     T.C. = O(n),  S.C. = O(h)
    class GFG {
        static class Node {
            int data;
            Node left;
            Node right;
            Node next;
            Node(int x)
            {
                data  = x;
                left  = null;
                right = null;
                next  = null;
            }
        }
        static Node inorder(Node root)
        {
            if (root.left == null)
                return root;
            root = inorder(root.left);
            return root;
        }
        static void populateNext(Node root)
        {
            Stack<Node> s = new Stack<>();
            Node temp = root;
            while (temp.left!=null)
            {
                s.add(temp);
                temp = temp.left;
            }
            Node curr = temp;
            if (curr.right!=null) {
                Node q = curr.right;
                while (q!=null) {
                    s.add(q);
                    q = q.left;
                }
            }
            while (!s.isEmpty())
            {
                Node inorder = s.peek();
                s.pop();
                curr.next = inorder;
                if (inorder.right!=null) {
                    Node q = inorder.right;
                    while (q!=null) {
                        s.add(q);
                        q = q.left;
                    }
                }
                curr = inorder;
            }
        }

        static Node newnode(int data)
        {
            Node node = new Node(data);
            return (node);
        }

        public static void main_3(String[] args)
        {
            /* Constructed binary tree is
                       10
                       / \
                      8  12
                     /
                    3
            */
            Node root = newnode(10);
            root.left = newnode(8);
            root.right = newnode(12);
            root.left.left = newnode(3);
            populateNext(root);
            Node ptr = inorder(root);
            while (ptr != null)
            {

                // -1 is printed if there is no successor
                System.out.print("Next of " +  ptr.data+ " is " + (ptr.next!=null ? ptr.next.data : -1) +"\n");
                ptr = ptr.next;
            }
        }
    }

    /*  Complexity Analysis :
           * Time Complexity  : O(n),  where n is the number of nodes in the tree.
           * Space Complexity : O(h),  where h is the height of the tree.

           This approach is better because it overcomes the auxiliary stack space complexity in the recursive method
           and the space complexity in the arrayList method because the stack will at most store the number of elements
           equal to height of the tree at any given time.
    *
    * */






    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, write a function to populate next pointer for all nodes. The next pointer for
                 every node should be set to point to inorder successor.


            Example : 1
            Input   :
                        10
                       /  \
                      8    12
                     /
                    3

            Output  : 3->8 8->10 10->12 12->-1
            Explanation : The inorder of the above tree is.......3 8 10 12.
                            So the next pointer of node 3 is pointing to 8 ,next pointer of 8 is pointing
                            to 10 and so on. And next pointer of 12 is pointing to -1 as there is no inorder
                            successor of 12.


            Example : 2
            Input   :
                        1
                      /   \
                     2     3

            Output  : 2->1 1->3 3->-1


            Your Task :
            You do not need to read input or print anything. Your task is to complete the function populateNext()
            that takes the root node of the binary tree as input parameter.

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)

        *
        *
        * */
    }




}
