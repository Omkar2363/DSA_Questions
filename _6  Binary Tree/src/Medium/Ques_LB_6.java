package Medium;

public class Ques_LB_6 {

    //Ques : Find the largest subtree sum in a tree...........                           (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(n),   S.C. = O(n)
    // Java program to find the largest subtree sum in a given binary tree.
    class GFG {

        // Structure of a tree node.
        static class Node
        {
            int key;
            Node left, right;
        }
        static class INT
        {
            int v;
            INT(int a)
            {
                v = a;
            }
        }

        // Function to create new tree node.
        static Node newNode(int key)
        {
            Node temp = new Node();
            temp.key = key;
            temp.left = temp.right = null;
            return temp;
        }

        // Helper function to find the largest subtree sum recursively.
        static int findLargestSubtreeSumUtil(Node root, INT ans)
        {
            // If current node is null then return 0 to parent node.
            if (root == null)
                return 0;

            // Subtree sum rooted at current node.
            int currSum = root.key +
                    findLargestSubtreeSumUtil(root.left, ans) +
                    findLargestSubtreeSumUtil(root.right, ans);

            // Update answer if current subtree sum is greater than answer so far.
            ans.v = Math.max(ans.v, currSum);

            // Return current subtree sum to its parent node.
            return currSum;
        }

        // Function to find the largest subtree sum.
        static int findLargestSubtreeSum(Node root)
        {
            // If tree does not exist, then answer is 0.
            if (root == null)
                return 0;

            // Variable to store maximum subtree sum.
            INT ans = new INT(-9999999);

            // Call to recursive function to find maximum subtree sum.
            findLargestSubtreeSumUtil(root, ans);

            return ans.v;
        }

        // Driver Code
        public static void main_1(String args[])
        {
        /*
                 1
                / \
               /   \
              /     \
            -2       3
            / \     / \
           /   \   /   \
          4     5 -6     2

        */

            Node root  = newNode(1);
            root.left  = newNode(-2);
            root.right = newNode(3);
            root.left.left   = newNode(4);
            root.left.right  = newNode(5);
            root.right.left  = newNode(-6);
            root.right.right = newNode(2);

            System.out.println(findLargestSubtreeSum(root));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a binary tree, task is to find subtree with maximum sum in tree.

            Example : 1
            Input   :         1
                            /   \
                           2      3
                          / \    / \
                         4   5  6   7
            Output  : 28

            As all the tree elements are positive, the largest subtree sum is equal to
            sum of all tree elements.


            Input   :         1
                            /    \
                          -2      3
                          / \    /  \
                         4   5  -6   2
            Output  : 7

            Subtree with the largest sum is  :   -2
                                                 /  \
                                                4    5
            Also, entire tree sum is also 7.

        *
        *
        * */
    }




}
