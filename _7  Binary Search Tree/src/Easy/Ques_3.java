package Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Ques_3 {

    //Ques : Binary Tree to Binary Search Tree (BST)...........                          (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(nlog(n)),  S.C. = O(n)
    class Node{
        int data;
        Node right, left;
    }
    class Solution {
        int i=0;
        // The given root is the root of the Binary Tree
        // Return the root of the generated BST
        Node binaryTreeToBST(Node root)
        {
            ArrayList<Integer> in = new ArrayList<>();
            inOrder(root,in);
            Collections.sort(in);
            i = in.size()-1;
            makeBST(root,in);
            return root;
        }

        void inOrder(Node root, ArrayList<Integer> in){
            if(root==null) return;
            inOrder(root.left,in);
            in.add(root.data);
            inOrder(root.right,in);
        }

        void makeBST(Node root, ArrayList<Integer> in){
            if(root==null || i<0) return;
            makeBST(root.right,in);
            root.data = in.get(i);
            i--;
            makeBST(root.left,in);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps
                 the original structure of Binary Tree intact.


            Example : 1
            Input   :
                          1
                        /   \
                       2     3

            Output  : 1 2 3


            Example : 2
            Input   :
                          1
                       /    \
                     2       3
                   /
                 4

            Output  : 1 2 3 4

            Explanation : The converted BST will be

                                    3
                                  /   \
                                2     4
                              /
                             1


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST()
            which takes the root of the Binary tree as input and returns the root of the BST. The driver code will
            print inorder traversal of the converted BST.


            Expected Time Complexity : O(NLogN).
            Expected Auxiliary Space : O(N).


        *
        *
        * */
    }



}
