package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_1 {

    //Ques : Height of Binary Tree..........                                             (GFG Ques.)


    //Approach 1 : Recursive Solution.........                                           T.C. = O(n),   S.C. = O(n)
    // Java program to find height of tree
    // A binary tree node
    static class Node {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree_1 {
        Node root;

        /* Compute the "maxDepth" of a tree -- the number of nodes along the longest
           path from the root node down to the farthest leaf node.*/
        int maxDepth(Node node)
        {
            if (node == null)
                return -1;
            else
            {
                /* compute the depth of each subtree */
                int lDepth = maxDepth(node.left);
                int rDepth = maxDepth(node.right);

                /* use the larger one */
                if (lDepth > rDepth)
                    return (lDepth + 1);
                else
                    return (rDepth + 1);
            }
        }

        /* Driver program to test above functions */
        public static void main_1(String[] args)
        {
            BinaryTree_1 tree = new BinaryTree_1();

            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left  = new Node(4);
            tree.root.left.right = new Node(5);

            System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
        }
    }




    //Approach 2 : Via Level Order Traversal.........                                   T.C. = O(n),   S.C. = O(n)
    // Java program for above approach
    class GFG {
        // A tree node structure
        static class Node {
            int key;
            Node left;
            Node right;
        }

        // Utility function to create a new node
        static Node newNode(int key) {
            Node temp = new Node();
            temp.key  = key;
            temp.left = temp.right = null;
            return temp;
        }


        /*Function to find the height(depth) of the tree*/
        public static int height( Node root){

            //Initialising a variable to count the height of tree
            int depth = 0;

            Queue<Node> q=new LinkedList<>();

            //Pushing first level element along with null
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node temp = q.peek();
                q.remove();

                //When null encountered, increment the value
                if(temp == null){
                    depth++;
                }

                //If null not encountered, keep moving
                if(temp != null){
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }

                //If queue still have elements left, push null again to the queue.
                else if(!q.isEmpty()){
                    q.add(null);
                }
            }
            return depth;
        }



        // Driver Code
        public static void main_2(String args[]) {
            Node root  = newNode(1);
            root.left  = newNode(12);
            root.right = newNode(13);

            root.right.left   = newNode(14);
            root.right.right  = newNode(15);

            root.right.left.left   = newNode(21);
            root.right.left.right  = newNode(22);
            root.right.right.left  = newNode(23);
            root.right.right.right = newNode(24);

            System.out.println("Height(Depth) of tree is: "+height(root));

        }
    }




    //Approach 3 :
    /*  Method 3 :
            This method also uses the concept of Level Order Traversal but we would not be adding null in the Queue.
            We will simply increase the counter when the level will increase and then remove all the nodes from the
            queue of the current Level.
    * */
    // Java program for above approach
    class GFG_3 {

        // A tree node structure
        static class Node {
            int key;
            Node left;
            Node right;
        }

        // Utility function to create a new node
        static Node newNode(int key) {
            Node temp = new Node();
            temp.key  = key;
            temp.left = temp.right = null;
            return temp;
        }


        /*Function to find the height(depth) of the tree*/
        public static int height( Node root){

            //Initialising a variable to count the height of tree
            Queue<Node>q=new LinkedList<Node>();
            q.add(root);
            int height=0;
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    Node temp=q.poll();
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
                height++;

            }
            return height;
        }



        // Driver Code
        public static void main_3(String args[]) {
            Node root  = newNode(1);
            root.left  = newNode(12);
            root.right = newNode(13);

            root.right.left   = newNode(14);
            root.right.right  = newNode(15);

            root.right.left.left   = newNode(21);
            root.right.left.right  = newNode(22);
            root.right.right.left  = newNode(23);
            root.right.right.right = newNode(24);

            System.out.println("Height(Depth) of tree is: "+height(root));

        }
    }


    public static void main(String[] args) {

        /*Ques : Given a binary tree, find its height.


            Example : 1
            Input   :
                         1
                        /  \
                       2    3
            Output  : 2


            Example : 2
            Input   :
                          2
                           \
                            1
                           /
                         3
            Output  : 3

            Your Task :
            You don't need to read input or print anything. Your task is to complete the function height() which
            takes root node of the tree as input parameter and returns an integer denoting the height of the tree.
            If the tree is empty, return 0.


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)



        * */
    }




}
