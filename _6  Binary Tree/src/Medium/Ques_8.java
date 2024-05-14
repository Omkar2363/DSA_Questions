package Medium;

import java.util.*;
import java.util.Map.Entry;

public class Ques_8 {

    //Ques : Diagonal Traversal of Binary Tree...........                               (GFG Ques.)


    //Approach 1 : By using a Map.......(Recursive solution).......                     T.C. = O(n*log(n)),  S.C. = O(n)
    // Java program for diagonal traversal of Binary Tree
    public class DiagonalTraversalBTree {
        // Tree node
        static class Node {
            int data;
            Node left;
            Node right;
            //constructor
            Node(int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        /* root - root of the binary tree
           d    - distance of current line from rightmost
                - topmost slope.
           diagonalPrint - HashMap to store Diagonal elements (Passed by Reference) */
        static void diagonalPrintUtil(Node root, int d, TreeMap<Integer, Vector<Integer>> diagonalPrint)
        {
            // Base case
            if (root == null)
                return;

            // get the list at the particular d value
            Vector<Integer> k = diagonalPrint.get(d);

            // k is null then create a vector and store the data
            if (k == null)
            {
                k = new Vector<>();
                k.add(root.data);
            }

            // k is not null then update the list
            else
            {
                k.add(root.data);
            }

            // Store all nodes of same line together as a vector
            diagonalPrint.put(d,k);

            // Increase the vertical distance if left child
            diagonalPrintUtil(root.left,d + 1, diagonalPrint);

            // Vertical distance remains same for right child
            diagonalPrintUtil(root.right, d, diagonalPrint);
        }

        // Print diagonal traversal of given binary tree
        static void diagonalPrint(Node root)
        {
            // create a map of vectors to store Diagonal elements
            TreeMap<Integer,Vector<Integer>> diagonalPrint = new TreeMap<>();

            diagonalPrintUtil(root, 0, diagonalPrint);

            System.out.println("Diagonal Traversal of Binary Tree");
            for (Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet())
            {
                System.out.println(entry.getValue());
            }
        }

        // Driver program
        public static void main_1(String[] args)
        {
            Node root   = new Node(8);
            root.left   = new Node(3);
            root.right  = new Node(10);
            root.left.left   = new Node(1);
            root.left.right  = new Node(6);
            root.right.right = new Node(14);
            root.right.right.left = new Node(13);
            root.left.right.left  = new Node(4);
            root.left.right.right = new Node(7);

            diagonalPrint(root);
        }
    }



    //Approach 2 : By using a Map.......(Iterative Solution).......                    T.C. = O(n*log(n)),  S.C. = O(n)
    // Java Code for above approach
    // Tree node
    static class Node {
        int data;
        Node left, right;
    }
    static class BinaryTree_2 {
        public static List<Integer> diagonal(Node root)
        {
            List<Integer> diagonalVals = new ArrayList<>();

            if (root == null)
                return diagonalVals;

            // The leftQueue will be a queue which will store all left pointers while traversing the tree,
            // and will be utilized when at any point right pointer becomes NULL

            Queue<Node> leftQueue = new LinkedList<>();
            Node node = root;

            while (node != null) {

                // Add current node to output
                diagonalVals.add(node.data);

                // If left child available, add it to queue
                if (node.left != null)
                    leftQueue.add(node.left);

                // if right child, transfer the node to right
                if (node.right != null)
                    node = node.right;
                else {
                    // If left child Queue is not empty, utilize it to traverse further
                    if (!leftQueue.isEmpty())
                    {
                        node = leftQueue.peek();
                        leftQueue.remove();
                    }
                    else {
                        // All the right childs traversed and no left child left
                        node = null;
                    }
                }
            }
            return diagonalVals;
        }

        // Utility method to create a new node
        public static Node newNode(int data)
        {
            Node node = new Node();
            node.data = data;
            node.left = node.right = null;
            return node;
        }

        // Driver program
        public static void main_2(String[] args)
        {

            Node root  = newNode(8);
            root.left  = newNode(3);
            root.right = newNode(10);
            root.left.left   = newNode(1);
            root.left.right  = newNode(6);
            root.right.right = newNode(14);
            root.right.right.left = newNode(13);
            root.left.right.left  = newNode(4);
            root.left.right.right = newNode(7);

        /* Node* root = newNode(1);
        root->left  = newNode(2);
        root->right = newNode(3);
        root->left->left   = newNode(9);
        root->left->right  = newNode(6);
        root->right->left  = newNode(4);
        root->right->right = newNode(5);
        root->right->left->right = newNode(7);
        root->right->left->left  = newNode(12);
        root->left->right->left  = newNode(11);
        root->left->left->right  = newNode(10);*/

            List<Integer> diagonalValues = diagonal(root);
            for (int i = 0; i < diagonalValues.size(); i++)
            {
                System.out.print(diagonalValues.get(i) + " ");
            }
            System.out.println();
        }
    }





    //Approach 3 : By using Queue.........                                            T.C. = O(n),  S.C. = O(n)
    /*  Approach 2 : Using Queue.....
            Every node will contribute to the formation of the following diagonal. Only when the element’s left
            is available will we push it into the queue. We’ll process the node and then go to the right.
    * */
    class GFG_3 {
        // Tree node
        static class Node
        {
            int data;
            Node left;
            Node right;
            // Constructor
            Node(int data)
            {
                this.data = data;
                left = null;
                right = null;
            }
        }
        static class TNode
        {
            Node node;
            int level;
            public TNode(Node n, int l)
            {
                this.node = n;
                this.level = l;
            }
        }
        public static void diagonalPrint(Node root)
        {
            if (root == null)
            {
                return;
            }
            TreeMap<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();

            Queue<TNode> q = new LinkedList<TNode>();

            q.add(new TNode(root, 0));

            while (!q.isEmpty())
            {
                TNode curr = q.poll();
                map.putIfAbsent(curr.level, new ArrayList<>());
                map.get(curr.level).add(curr.node.data);

                if (curr.node.left != null)
                {
                    q.add(new TNode(curr.node.left,curr.level + 1));
                }
                if (curr.node.right != null)
                {
                    q.add(new TNode(curr.node.right, curr.level));
                }
            }

            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            {
                int k = entry.getKey();

                List<Integer> l = map.get(k);
                int size = l.size();

                for(int i = 0; i < l.size(); i++)
                {
                    System.out.print(l.get(i));
                    System.out.print(" ");
                }
                System.out.println("");
            }
            return;
        }

        // Driver code
        public static void main_3(String[] args)
        {
            Node root  = new Node(8);
            root.left  = new Node(3);
            root.right = new Node(10);
            root.left.left   = new Node(1);
            root.left.right  = new Node(6);
            root.right.right = new Node(14);
            root.right.right.left = new Node(13);
            root.left.right.left  = new Node(4);
            root.left.right.right = new Node(7);

            diagonalPrint(root);
        }
    }




    public static void main(String[] args) {

        /*Ques : Consider lines with a slope of -1 that cross through nodes. Print all diagonal elements
                 in a binary tree that belong to the same line, given a binary tree.


            Input  : Root of below tree

                          //Follow the link for Visual Representation.
                          //Link : https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

            Output :
            Diagonal Traversal of binary tree:
             8 10 14
             3 6 7 13
             1 4
            Observation : root and root->right values will be prioritized over all root->left values.

        *
        * */
    }



}
