package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_15 {

    //Ques : Kth ancestor of a node in binary tree........                              (GFG Ques.)


    //Approach 1 : Level Order Traversal Approach.....(BFS)                             T.C. = O(n),  S.C. = O(n)
    /* Java program to calculate Kth ancestor of given node */
    class GfG {
        // A Binary Tree Node
        static class Node
        {
            int data;
            Node left, right;
        }

        // function to generate array of ancestors
        static void generateArray(Node root, int ancestors[])
        {
            // There will be no ancestor of root node
            ancestors[root.data] = -1;

            // level order traversal to generate 1st ancestor
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            while(!q.isEmpty())
            {
                Node temp = q.peek();
                q.remove();

                if (temp.left != null)
                {
                    ancestors[temp.left.data] = temp.data;
                    q.add(temp.left);
                }

                if (temp.right != null)
                {
                    ancestors[temp.right.data] = temp.data;
                    q.add(temp.right);
                }
            }
        }

        // function to calculate Kth ancestor
        static int kthAncestor(Node root, int n, int k, int node)
        {
            // create array to store 1st ancestors
            int ancestors[] = new int[n + 1];

            // generate first ancestor array
            generateArray(root,ancestors);

            // variable to track record of number of ancestors visited
            int count = 0;

            while (node != -1)
            {
                node = ancestors[node];
                count++;

                if(count == k)
                    break;
            }

            // print Kth ancestor
            return node;
        }

        // Utility function to create a new tree node
        static Node newNode(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.left = null;
            temp.right = null;
            return temp;
        }

        // Driver program to test above functions
        public static void main_1(String[] args)
        {
            // Let us create binary tree shown in above diagram
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.left  = newNode(4);
            root.left.right = newNode(5);

            int k = 2;
            int node = 5;

            // print kth ancestor of given node
            System.out.println(kthAncestor(root,5,k,node));
        }
    }




    //Approach 2 :                                                                     T.C. = O(n),  S.C. = O(n)
    /*  Method 2 : In this method first we will get an element whose ancestor has to be searched and from that node,
                   we will decrement count one by one till we reach that ancestor node.

           * For example :–

             - Consider the tree given below:-
                     (1)
                    /    \
                  (4)   (2)
                 /    \      \
               (3)  (7)    (6)
                          \

                          (8)
                Then check if k=0 if yes then return that element as an ancestor else climb a level up and
                reduce k (k = k-1).

                Initially k = 2
                First we search for 8 then,
                at 8 => check if(k == 0) but k = 2 so k = k-1 => k = 2-1 = 1 and climb a level up i.e. at 7
                at 7 => check if(k == 0) but k = 1 so k = k-1 => k = 1-1 = 0 and climb a level up i.e. at 4
                at 4 => check if(k == 0) yes k = 0 return this node as ancestor.
    * */
    // Java program for finding kth ancestor of a particular nod
    class GFG{
        static class Node
        {
            int data;
            Node left, right;
            Node(int x)
            {
                this.data = x;
                this.left = this.right = null;
            }
        }
        static int k = 1;

        static boolean ancestor(Node root, int item)
        {
            if (root == null)
                return false;

            // Element whose ancestor is to be searched
            if (root.data == item)
            {

                // Reduce count by 1
                k = k-1;
                return true;
            }
            else
            {
                // Checking in left side
                boolean flag = ancestor(root.left, item);
                if (flag)
                {
                    if (k == 0)
                    {

                        // If count = 0 i.e. element is found
                        System.out.print("[" + root.data + "] ");
                        return false;
                    }

                    // If count != 0
                    // i.e. this is not the ancestor we are searching for so decrement count
                    k = k - 1;
                    return true;
                }

                // Similarly Checking in right side
                boolean flag2 = ancestor(root.right, item);
                if (flag2)
                {
                    if (k == 0)
                    {
                        System.out.print("[" + root.data + "] ");
                        return false;
                    }
                    k = k - 1;
                    return true;
                }
            }
            return false;
        }

        // Driver code
        public static void main_2(String[] args)
        {
            Node root = new Node(1);
            root.left = new Node(4);
            root.left.right  = new Node(7);
            root.left.left   = new Node(3);
            root.left.right.left = new Node(8);
            root.right       = new Node(2);
            root.right.right = new Node(6);

            int item = 3;
            int loc  = k;
            boolean flag = ancestor(root, item);

            if (flag)
                System.out.println("Ancestor doesn't exist");
            else
                System.out.println("is the " + (loc) + "th ancestor of [" + (item) + "]");
        }
    }



    //Approach 3 : Recursive Solution.....(DFS)                                        T.C. = O(n)
    // Java program to calculate Kth ancestor of given node
    class Solution {

        // A Binary Tree Node
        static class Node
        {
            int data;
            Node left, right;
        }

        // temporary node to keep track of Node returned from previous recursive call during backtrack
        static Node temp = null;
        static int k;

        // recursive function to calculate Kth ancestor
        static Node kthAncestorDFS(Node root, int node )
        {
            // Base case
            if (root == null)
                return null;

            if (root.data == node ||
                    (temp = kthAncestorDFS(root.left,node)) != null || (temp = kthAncestorDFS(root.right,node)) != null)
            {
                if (k > 0)
                    k--;

                else if (k == 0)
                {
                    // print the kth ancestor
                    System.out.print("Kth ancestor is: "+root.data);

                    // return null to stop further backtracking
                    return null;
                }

                // return current node to previous call
                return root;
            }
            return null;
        }

        // Utility function to create a new tree node
        static Node newNode(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.left = temp.right = null;
            return temp;
        }

        // Driver code
        public static void main_3(String args[])
        {
            // Let us create binary tree shown in above diagram
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.left  = newNode(4);
            root.left.right = newNode(5);

            k = 2;
            int node = 5;

            // print kth ancestor of given node
            Node parent = kthAncestorDFS(root,node);

            // check if parent is not null, it means there is no Kth ancestor of the node
            if (parent != null)
                System.out.println("-1");
        }
    }


    /*  Time Complexity  : O(n),  where n is the number of nodes in the binary tree.
     *
    * */





    public static void main(String[] args) {

        /*Ques : Given a binary tree in which nodes are numbered from 1 to n. Given a node and a positive integer K.
                 We have to print the Kth ancestor of the given node in the binary tree. If there does not exist any
                 such ancestor then print -1.

            For example in the below given binary tree, the 2nd ancestor of 5 is 1. 3rd ancestor of node 5 will be -1.
        *
        *
        * */
    }




}
