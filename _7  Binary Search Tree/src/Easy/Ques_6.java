package Easy;

public class Ques_6 {

    //Ques : Count BST nodes that lie in a given range..........                           (GFG Ques.)

    //Approach 1 :
    static class Node{
        int data;
        Node left, right;
    }
    class Solution {
        //Function to count number of nodes in BST that lie in the given range.
        int getCount(Node node, int low, int high)
        {
            if(node == null)
                return 0;

            //if data at current node is equal to lower and upper range, we return 1.
            if (node.data == high && node.data == low)
                return 1;

            /*
            if data at current node is within range then we include it in count
            and call function recursively for its left and right children.
            */
            if(node.data >= low && node.data <= high)
                return 1 + this.getCount(node.left, low, high) + this.getCount(node.right, low, high);

            /*
            else if data at current node is smaller than lower range then
            we call function recursively only for right child.
            */
            else if(node.data < low)
                return this.getCount(node.right, low, high);

                //else we call function recursively only for left child.
            else
                return this.getCount(node.left, low, high);
        }
    }

    /*  Time complexity : O(H + k)  where h is the height of BST and k is the number of nodes in the given range.
        Auxiliary Space : O(n)
    *
    *
    * */






    public static void main(String[] args) {

        /*Ques : Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST
                 that lie in the given range.

            The values smaller than root go to the left side
            The values greater and equal to the root go to the right side


            Example : 1
            Input   :
                          10
                         /  \
                        5    50
                       /    /  \
                      1    40  100
            l = 5, h = 45
            Output  : 3
            Explanation : 5 10 40 are the node in the range


            Example : 2
            Input   :
                             5
                            /  \
                           4    6
                          /      \
                         3        7
            l = 2, h = 8
            Output  : 5
            Explanation : All the nodes are in the given range.


            Your Task :
            This is a function problem. You don't have to take input. You are required to complete the function
            getCountOfNode() that takes root, l ,h as parameters and returns the count.

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(Height of the BST).


        *
        *
        * */
    }




}
