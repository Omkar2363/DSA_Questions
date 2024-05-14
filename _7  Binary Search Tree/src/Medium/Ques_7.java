package Medium;

import java.util.Stack;

public class Ques_7 {

    //Ques : Preorder to BST........                                                     (GFG Ques.)


    //Approach 1 : Recursive Solution.......                                              T.C. = O(N),   S.C. = O(N)
    //Back-end complete function Template for Java
    //Function that constructs BST from its preorder traversal.
    /*
    static class Node {
        int data;
        Node left, right;
    }

    public static Node post_order(int pre[], int size)
    {
        //first element of preorder traversal is always root of BST.
        Node root = new Node(pre[0]);

        //creating a stack of capacity equal to size of array.
        Stack<Node> s = new Stack<Node>();

        //pushing root into the stack.
        s.push(root);

        //iterating over rest of the array elements.
        for (int i = 1; i < size; ++i)
        {
            Node temp = null;

            //we keep on popping from stack while data at top of stack is less
            //than the current array element.
            while (!s.isEmpty() && pre[i] > s.peek().data)
            {
                temp = s.pop();
            }

            //we make this greater value as the right child and push it into stack.
            if (temp != null)
            {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }
            //if current array element is less than data at top of stack, we make
            //it as the left child of the stack's top node and push it into stack.
            else
            {
                s.peek().left = new Node(pre[i]);
                s.push(s.peek().left);
            }
        }
        return root;
    }
    */


    public static void main(String[] args) {

        /*Ques : Given an array arr[] of N nodes representing preorder traversal of some BST. You have to build
                 the exact BST from, it's given preorder traversal.
                 In Pre-Order traversal, the root node is visited before the left child and right child nodes.

            Example : 1
            Input   : N = 5
                      arr[]  = {40,30,35,80,100}
            Output  : 35 30 100 80 40
            Explanation : PreOrder : 40 30 35 80 100
                          Therefore, the BST will be :
                                  40
                               /      \
                             30       80
                               \        \
                               35      100
                    Hence, the postOrder traversal will be : 35 30 100 80 40

            Example : 2
            Input   : N = 8
                      arr[]  = {40,30,32,35,80,90,100,120}
            Output  : 35 32 30 120 100 90 80 40


            Your Task :
            You need to complete the given function and return the root of the tree. The driver code will then use
            this root to print the post order traversal.

            Expected Time Complexity : O(N).
            Expected Auxiliary Space : O(N).


        *
        * */
    }



}
