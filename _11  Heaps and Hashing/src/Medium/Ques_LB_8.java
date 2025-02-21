package Medium;

import java.util.ArrayList;

public class Ques_LB_8 {

    //Ques : Convert BST to Min Heap............                                            (GFG Ques.)


    //Approach 1 :                                                                          T.C. = O(n),  S.C. = O(n)
    /*  Approach : To solve the problem using this approach follow the below idea.

            Store the inorder traversal of the BST in array and then do preorder traversal of the BST and
            while doing preorder traversal copy the values of inorder traversal into the current node, as copying
            the sorted elements while doing preorder traversal will make sure that a Min-Heap is constructed with
            the condition that all the values in the left subtree of a node are less than all the values in the right
            subtree of the node.

            * Follow the given steps to solve the problem :
                1. Create an array arr[] of size N, where N is the number of nodes in the given BST.
                2. Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
                3. Now perform the preorder traversal of the tree.
                4. While traversing the root during the preorder traversal, one by one copy the values from
                   the array arr[] to the nodes of the BST.

    *
    * */
    // Java implementation to convert the given BST to Min Heap
    class Gfg {
        static class Node {
            int data;
            Node left, right;

            // Constructor
            Node()
            {
                this.data = 0;
                this.left = this.right = null;
            }

            Node(int data)
            {
                this.data = data;
                this.left = this.right = null;
            }
        }

        private static void preOrder(Node root)
        {
            if (root == null)
                return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        private static void bstToArray(Node root, ArrayList<Integer> arr)
        {
            // ArrayLIst stores elements in inorder fashion
            if (root == null)
                return;

            bstToArray(root.left, arr);

            arr.add(root.data);

            bstToArray(root.right, arr);
        }

        static int index;
        private static void arrToMinHeap(Node root, ArrayList<Integer> arr)
        {
            if (root == null)
                return;

            root.data = arr.get(index++);

            arrToMinHeap(root.left, arr);
            arrToMinHeap(root.right, arr);
        }
        static void convertToMinHeap(Node root)
        {
            // initialize static index to zero
            index = 0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            bstToArray(root, arr);

            arrToMinHeap(root, arr);
        }

        // Driver's code
        public static void main_1(String[] args)
        {

            // BST formation
            Node root  = new Node(4);
            root.left  = new Node(2);
            root.right = new Node(6);
            root.left.left   = new Node(1);
            root.left.right  = new Node(3);
            root.right.left  = new Node(5);
            root.right.right = new Node(7);

            System.out.print("Preorder Traversal Before Conversion :" + "\n");
            preOrder(root);

            // Function call
            convertToMinHeap(root);

            System.out.print("\nPreorder Traversal After Conversion :" + "\n");
            preOrder(root);
        }
    }

    /* Tip : If interviewer ask not to use global index variable

             You can use LinkedList Instead of ArrayList and use LinkedList's removeFirst() method
             So instead of this :
                    root.data = arr.get(index++);
             You can write
                    root.data = list.removeFirst();

            Do not forget to initialize list in converttoMinHeap function
    */








    public static void main(String[] args) {

        /*Ques : Given a binary search tree which is also a complete binary tree. The problem is to convert
                 the given BST into a Min Heap with the condition that all the values in the left subtree of a node
                 should be less than all the values in the right subtree of the node. This condition is applied to all
                 the nodes, in the resultant converted Min Heap.


            Example : 1
            Input   :         4
                            /   \
                           2     6
                         /  \   /  \
                        1   3  5    7

            Output  :
                             1
                           /   \
                          2     5
                        /  \   /  \
                       3   4  6    7

            Explanation : The given BST has been transformed into a Min Heap. All the nodes in the Min Heap satisfies
                          the given condition, that is, values in the left subtree of a node should be less than
                          the values in the right subtree of the node.
        *
        * */

    }



}
