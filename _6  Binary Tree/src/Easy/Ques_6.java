package Easy;

import java.util.*;

public class Ques_6 {

    //Ques : ZigZag Tree Traversal..........                                               (GFG Ques.)


    //Approach 1 :                                                                         T.C. = O(n),  S.C. = O(2n) = O(n)
    // Java implementation of a O(n) time method for Zigzag order traversal
    // Binary Tree node
    static class Node {
        int data;
        Node leftChild;
        Node rightChild;
        Node(int data)
        {
            this.data = data;
        }
    }
    static class BinaryTree_1 {
        Node rootNode;
        // function to print the zigzag traversal
        void printZigZagTraversal()
        {
            // if null then return
            if (rootNode == null) {
                return;
            }

            // declare two stacks
            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();

            // push the root
            currentLevel.push(rootNode);
            boolean leftToRight = true;

            // check if stack is empty
            while (!currentLevel.isEmpty()) {

                // pop out of stack
                Node node = currentLevel.pop();

                // print the data in it
                System.out.print(node.data + " ");

                // store data according to current order.
                if (leftToRight)
                {
                    if (node.leftChild != null)
                    {
                        nextLevel.push(node.leftChild);
                    }

                    if (node.rightChild != null)
                    {
                        nextLevel.push(node.rightChild);
                    }
                }
                else {
                    if (node.rightChild != null) {
                        nextLevel.push(node.rightChild);
                    }

                    if (node.leftChild != null) {
                        nextLevel.push(node.leftChild);
                    }
                }

                if (currentLevel.isEmpty()) {
                    leftToRight = !leftToRight;
                    Stack<Node> temp = currentLevel;
                    currentLevel = nextLevel;
                    nextLevel = temp;
                }
            }
        }
    }
    public class zigZagTreeTraversal {
        // driver program to test the above function
        public static void main(String[] args)
        {
            BinaryTree_1 tree = new BinaryTree_1();
            tree.rootNode     = new Node(1);
            tree.rootNode.leftChild  = new Node(2);
            tree.rootNode.rightChild = new Node(3);
            tree.rootNode.leftChild.leftChild   = new Node(7);
            tree.rootNode.leftChild.rightChild  = new Node(6);
            tree.rootNode.rightChild.leftChild  = new Node(5);
            tree.rootNode.rightChild.rightChild = new Node(4);

            System.out.println("ZigZag Order traversal of binary tree is");
            tree.printZigZagTraversal();
        }
    }





    //Approach 2 : By using Deque..........                                               T.C. = O(n),  S.C. = O(n)
    // Java implementation of a O(n) time method for Zigzag order traversal
    public class Main {

        // Class containing left and right child of current node and key value
        static class Node {
            public int data;
            public Node left, right;
            public Node(int data)
            {
                this.data = data;
                left = right = null;
            }
        }

        // A utility function to create a new node
        static Node newNode(int data)
        {
            Node node = new Node(data);
            return node;
        }

        // Function to print the zigzag traversal
        static Vector<Integer> zigZagTraversal(Node root)
        {
            Deque<Node> q = new LinkedList<Node>();
            Vector<Integer> v = new Vector<Integer>();
            q.add(root);
            v.add(root.data);
            Node temp;

            // set initial level as 1, because root is already been taken care of.
            int l = 1;

            while (q.size() > 0) {
                int n = q.size();

                for (int i = 0; i < n; i++) {

                    // popping mechanism
                    if (l % 2 == 0) {
                        temp = q.peekLast();
                        q.pollLast();
                    }
                    else {
                        temp = q.peekFirst();
                        q.pollFirst();
                    }

                    // pushing mechanism
                    if (l % 2 != 0) {

                        if (temp.right != null) {
                            q.add(temp.right);
                            v.add(temp.right.data);
                        }
                        if (temp.left != null) {
                            q.add(temp.left);
                            v.add(temp.left.data);
                        }
                    }
                    else if (l % 2 == 0) {

                        if (temp.left != null) {
                            q.offerFirst(temp.left);
                            v.add(temp.left.data);
                        }
                        if (temp.right != null) {
                            q.offerFirst(temp.right);
                            v.add(temp.right.data);
                        }
                    }
                }
                l++;                                                  // level plus one
            }
            return v;
        }

        public static void main_2(String[] args)
        {

            // vector to store the traversal order.
            Vector<Integer> v;

            // create tree
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.left   = newNode(7);
            root.left.right  = newNode(6);
            root.right.left  = newNode(5);
            root.right.right = newNode(4);
            System.out.println("ZigZag Order traversal of binary tree is");

            v = zigZagTraversal(root);

            for (int i = 0; i < v.size(); i++) {                             // to print the order
                System.out.print(v.get(i) + " ");
            }
        }
    }




    //Approach 3 : Another Approach.......                                               T.C. = O(n),  S.C. = O(n)
    // Java implementation of a O(n) time method for Zigzag order traversal
    public class Main_3 {
        // Class containing left and right child of current node and key value
        static class Node {
            public int data;
            public Node left, right;
            public Node(int data)
            {
                this.data = data;
                left = right = null;
            }
        }
        // A utility function to create a new node
        static Node newNode(int data)
        {
            Node node = new Node(data);
            return node;
        }

        // Function to print the zigzag traversal
        static ArrayList<Integer> zigZagTraversal(Node root)
        {
            ArrayList<Integer> ans = new ArrayList<Integer>();

            // if there is no element in the tree,return empty arraylist
            if (root == null)
                return ans;

            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            // this variable helps to check if elements are to be added from left to right or right to left
            boolean leftToRight = true;
            while (q.size() > 0) {
                int size = q.size();
                // this arraylist is used to store element at current level
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                    temp.add(curr.data);
                }
                if (leftToRight)              // at current level,add element from left to right to our answer
                {
                    // do nothing
                }
                // we have to add element from to right to left and this can be done
                // by reversing our temp arraylist
                else {
                    Collections.reverse(temp);
                }
                // add element form temp arraylist to our ans arraylist
                for (int i = 0; i < temp.size(); i++) {
                    ans.add(temp.get(i));
                }
                // change the value of leftToRight from true to false or false to true for next iteration.
                leftToRight = !(leftToRight);
            }
            // return our ans arraylist
            return ans;
        }

        public static void main(String[] args)
        {

            // Arraylist to store the traversal order.
            ArrayList<Integer> ans;

            // create tree
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.left   = newNode(7);
            root.left.right  = newNode(6);
            root.right.left  = newNode(5);
            root.right.right = newNode(4);
            System.out.println("ZigZag Order traversal of binary tree is");

            ans = zigZagTraversal(root);

            for (int i = 0; i < ans.size(); i++) {                        // to print the order
                System.out.print(ans.get(i) + " ");
            }
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.


            Example : 1
            Input   :
                            1
                          /   \
                         2     3
                        / \   /  \
                       4   5 6    7

            Output  :  1 3 2 4 5 6 7


            Example : 2
            Input   :
                           7
                        /     \
                       9       7
                     /  \     /
                    8    8   6
                   /  \
                  10   9

            Output  :  7 7 9 8 8 6 9 10


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function zigZagTraversal()
            which takes the root node of the Binary Tree as its input and returns a list containing the node values
            as they appear in the Zig-Zag Level-Order Traversal of the Tree.


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)


        *
        *
        * */
    }


}
