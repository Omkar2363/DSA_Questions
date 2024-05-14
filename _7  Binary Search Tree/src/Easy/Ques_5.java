package Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Ques_5 {

    //Ques :  Kth smallest element in BST...........                                      (Leet Code Ques no. - 230)


    //Approach 1 : By Using ArrayList........                                             T.C. = O(nlog(n)),  S.C. = O(n)
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        static ArrayList<Integer> arr = new ArrayList<Integer>();
        static void PreeOrder(TreeNode root){
            if(root == null){
                return;
            }
            arr.add(root.val);
            PreeOrder(root.left);
            PreeOrder(root.right);
        }

        public int kthSmallest(TreeNode root, int k) {
            arr = new ArrayList<Integer>();
            PreeOrder(root);
            Collections.sort(arr);
            return arr.get(k-1);
        }
    }





    //Approach 2 : Optimized Solution.......
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution_2 {
        int i = 1;                                   //variable to track position of the element
        int ans = 0;
        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return ans;

        }

        public void inorder(TreeNode root, int k) {
            if(root == null) {
                return;
            }

            inorder(root.left, k);

            if(i==k){
                ans = root.val;                      // store root value in ans when i == k
            }
            i++;                                     //increament variable for every call
            inorder(root.right, k);
        }
    }






    public static void main(String[] args) {

        /*Ques :


        *
        * */
    }
}
