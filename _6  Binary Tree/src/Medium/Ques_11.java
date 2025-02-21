package Medium;

import java.util.HashSet;

public class Ques_11 {

    //Ques : Check if a Binary Tree contains duplicate subtrees of size 2 or more........   (GFG Ques.)


    //Approach 1 :
    /*  Method 1 :
            A simple solution is that, we pick every node of tree and try to find is any subtree of given tree
            is present in tree which is identical with that subtree. Here we can use below post to find if a
            subtree is present anywhere else in tree.
    *

            //Follow the Link for solution.......
            //Link : https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
    *
    */





    //Approach 2 : Efficient Solution........                                               T.C. = O()
    // Java program to find if there is a duplicate subtree of size 2 or more.
    // A binary tree Node has data, pointer to left child and a pointer to right child
    static class Node {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }
    public class Main {
        static char MARKER = '$';

        // This function returns empty string if tree contains a duplicate subtree of size 2 or more.
        public static String dupSubUtil(Node root, HashSet<String> subtrees)
        {
            String s = "";

            // If current node is NULL, return marker
            if (root == null)
                return s + MARKER;

            // If left subtree has a duplicate subtree.
            String lStr = dupSubUtil(root.left,subtrees);
            if (lStr.equals(s))
                return s;

            // Do same for right subtree
            String rStr = dupSubUtil(root.right,subtrees);
            if (rStr.equals(s))
                return s;

            // Serialize current subtree
            s = s + root.data + lStr + rStr;

            // If current subtree already exists in hash table.
            // [Note that size of a serialized tree with single node is 3 as it has two marker nodes].
            if (s.length() > 3 && subtrees.contains(s))
                return "";

            subtrees.add(s);
            return s;
        }

        //Function to find if the Binary Tree contains duplicate subtrees of size 2 or more
        public static String dupSub(Node root)
        {
            HashSet<String> subtrees=new HashSet<>();
            return dupSubUtil(root,subtrees);
        }

        public static void main_1(String args[])
        {
            Node root  = new Node('A');
            root.left  = new Node('B');
            root.right = new Node('C');
            root.left.left   = new Node('D');
            root.left.right  = new Node('E');
            root.right.right = new Node('B');
            root.right.right.right = new Node('E');
            root.right.right.left  = new Node('D');
            String str = dupSub(root);
            if(str.equals(""))
                System.out.print(" Yes ");
            else
                System.out.print(" No ");
        }
    }









    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, check whether the Binary tree contains a duplicate subtree of size 2 or more.

           Note : Two same leaf nodes are not considered as subtree size of a leaf node is one.

            Input  :  Binary Tree
                           A
                         /    \
                       B        C
                     /   \       \
                    D     E       B
                                 /  \
                                D    E
            Output : Yes

        *
        * */
    }




}
