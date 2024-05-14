package Easy;

public class Ques_2 {

    //Ques : Minimum element in BST.........                                           (GFG Ques.)


    //Approach 1 :
    class Node{
        int data;

        Node left,right;
    }
    class Tree {
        // Function to find the minimum element in the given BST.
        int minValue(Node node) {
            // base case
            if (node == null)
                return -1;

            Node current = node;

            // leftmost node is minimum so we move in BST till left node is not
            // NULL.
            while (current.left != null) {
                current = current.left;
            }
            // returning the data at leftmost node.
            return (current.data);
        }
    }


    /*  Complexity Analysis :
           * Time Complexity : O(H),  Worst case happens for left skewed trees.
           * Auxiliary Space : O(1),  we are not using any extra memory.

    *
    * */

    public static void main(String[] args) {

        /*Ques : Given a Binary Search Tree. The task is to find the minimum element in this given BST.

            Example : 1
            Input   :
                           5
                         /    \
                        4      6
                       /        \
                      3          7
                     /
                    1

            Output  : 1


            Example : 2
            Input   :
                         9
                          \
                           10
                            \
                             11
            Output  : 9


            Your Task :
            The task is to complete the function minValue() which takes root as the argument and
            returns the minimum element of BST. If the tree is empty, there is no minimum element,
            so return -1 in that case.

            Expected Time Complexity : O(Height of the BST)
            Expected Auxiliary Space : O(1).





        *
        * */
    }
}
