package Medium;

import java.util.HashMap;

public class Ques_14 {

    //Ques : Find All Duplicate Subtrees............                                       (GFG Ques.)


    //Approach 1 : By using Hashing........
    // A java program to find all duplicate subtrees in a binary tree.
    public class Duplicate_subtress {

        /* A binary tree node has data, pointer to left child and a pointer to right child */
        static HashMap<String, Integer> m;
        static class Node {
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data = data;
                left = null;
                right = null;
            }
        }
        static String inorder(Node node)
        {
            if (node == null)
                return "";

            String str = "(";
            str += inorder(node.left);
            str += Integer.toString(node.data);
            str += inorder(node.right);
            str += ")";

            // Subtree already present (Note that we use HashMap instead of HashSet because we want
            // to print multiple duplicates only once),
            // consider example of 4 in above subtree, it should be printed only once.
            if (m.get(str) != null  &&  m.get(str)==1 )
                System.out.print( node.data + " ");

            if (m.containsKey(str))
                m.put(str, m.get(str) + 1);
            else
                m.put(str, 1);


            return str;
        }

        // Wrapper over inorder()
        static void printAllDups(Node root)
        {
            m = new HashMap<>();
            inorder(root);
        }
        // Driver code
        public static void main_1(String args[])
        {
            Node root = null;
            root      = new Node(1);
            root.left = new Node(2);
            root.right      = new Node(3);
            root.left.left  = new Node(4);
            root.right.left = new Node(2);
            root.right.left.left = new Node(4);
            root.right.right     = new Node(4);
            printAllDups(root);
        }
    }


    /*  Time Complexity : O(N^2)  Since string copying takes O(n) extra time.
        Auxiliary Space : O(N^2)  Since we are hashing a string for each node and length of this string
                                  can be of the order N.

    *
    */







    public static void main(String[] args) {

        /*Ques : Given a binary tree, find all duplicate subtrees. For each duplicate subtree, we only need
                 to return the root node of any one of them. Two trees are duplicates if they have the same
                 structure with the same node values.


            Example : 1
            Input   :
                           1
                          / \
                         2   3
                        /   / \
                       4   2   4
                          /
                         4

            Output  :
                           2
                          /    and    4
                         4

            Explanation : Above Trees are two duplicate subtrees. Therefore, you need to return
                          above trees root in the form of a list.
        *
        * */
    }




}
