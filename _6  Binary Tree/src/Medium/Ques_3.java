package Medium;

import java.util.*;
import java.util.Map.Entry;

public class Ques_3 {

    //Ques : Top View of Binary Tree.........                                            (GFG Ques.)


    //Approach 1 : By using Hashing......                                                T.C. = O(n*log(n)),  S.C. = O(n)
    // Java program to print top view of binary tree
    // class to create a node
    static class Node {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    // class of binary tree
    static class BinaryTree_1 {
        Node root;
        public BinaryTree_1() {
            root = null;
        }
        // function should print the topView of the binary tree
        private void TopView(Node root)
        {
            class QueueObj {
                Node node;
                int hd;
                QueueObj(Node node, int hd)
                {
                    this.node = node;
                    this.hd = hd;
                }
            }
            Queue<QueueObj> q = new LinkedList<QueueObj>();
            Map<Integer, Node> topViewMap  = new TreeMap<Integer, Node>();

            if (root == null) {
                return;
            }
            else {
                q.add(new QueueObj(root, 0));
            }
            System.out.println("The top view of the tree is : ");

            // count function returns 1 if the container contains an element whose key is equivalent
            // to hd, or returns zero otherwise.
            while (!q.isEmpty())
            {
                QueueObj tmpNode = q.poll();
                if (!topViewMap.containsKey(tmpNode.hd)) {
                    topViewMap.put(tmpNode.hd, tmpNode.node);
                }

                if (tmpNode.node.left != null) {
                    q.add(new QueueObj(tmpNode.node.left,tmpNode.hd - 1));
                }
                if (tmpNode.node.right != null) {
                    q.add(new QueueObj(tmpNode.node.right,tmpNode.hd + 1));
                }
            }
            for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
                System.out.print(entry.getValue().data + " ");
            }
        }

        // Driver Program to test above functions
        public static void main_1(String[] args)
        {
        /* Create following Binary Tree
            1
           / \
          2   3
           \
             4
              \
               5
                 \
                  6
        */
            BinaryTree_1 tree = new BinaryTree_1();
            tree.root       = new Node(1);
            tree.root.left  = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.right       = new Node(4);
            tree.root.left.right.right = new Node(5);
            tree.root.left.right.right.right = new Node(6);
            System.out.println("Following are nodes in top view of Binary Tree");
            tree.TopView(tree.root);
        }
    }

    /*  Time complexity  : O(n*log(n)),  where n is the number of nodes in the given tree.
        Auxiliary Space  : O(n),         As we store nodes in the map and queue.

    * */



    //Approach 2 : HashMap Approach........( Improvement over the TreeMap approach)    T.C. = O(n),  S.C. = O(n)
    /* HashMap Approach : Improvement over the TreeMap approach
            Since we need the horizontal distance in sorted order TreeMap was used in the above solution;
            but instead, a minimum and maximum horizontal distance variable can be maintained for each iteration.
            After that traverse from minimum to maximum while printing the first acquired node during the traversal
            of the tree that was stored in the map.

            Since, each horizontal distance from minimum to maximum is guaranteed to have at least one node in the map
    *
    */
    class GFG {
        // Structure of binary tree
        static class Node {
            Node left;
            Node right;
            int data;
            Node(int data)
            {
                this.left = this.right = null;
                this.data = data;
            }
        }
        //Queue Object Structure
        static class QueueObj {
            Node node;
            int hd;
            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        static void topView(Node root)
        {
            if (root == null)
                return;

            Queue<QueueObj> q = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int min = 0;
            int max = 0;
            //Level Order Traversal
            q.add(new QueueObj(root, 0));
            while (!q.isEmpty())
            {
                QueueObj curr = q.poll();

                //only include in map if this is the first node of this specific horizontal distance
                if (!map.containsKey(curr.hd))
                {
                    map.put(curr.hd, curr.node.data);
                }


                if (curr.node.left != null)
                {
                    //min can be found only in left side due to "-1"
                    //minimum horizontal distance of any node from root
                    min = Math.min(min, curr.hd - 1);
                    q.add( new QueueObj(curr.node.left, curr.hd - 1));
                }

                if (curr.node.right != null) {
                    //max can be found only in right side due to "+1"
                    //maximum horizontal distance of any node from root
                    max = Math.max(max, curr.hd + 1);
                    q.add( new QueueObj(curr.node.right, curr.hd + 1));
                }
            }

            //traversal of (horizontal distance from root) minimum to maximum
            for (; min <= max; min++) {
                System.out.print(map.get(min)+" ");
            }
        }

        // Driver Code
        public static void main_2(String args[])
        {
            Node root  = new Node(1);
            root.left  = new Node(2);
            root.right = new Node(3);
            root.left.right       = new Node(4);
            root.left.right.right = new Node(5);
            root.left.right.right.right = new Node(6);
            System.out.println("Following are nodes in" + " top view of Binary Tree");
            topView(root);
        }
    }
    /*  Time Complexity : O(N), Since we only perform level-order traversal and print some part of the N nodes
                                which at max will be 2N in case of skew tree
        Auxiliary Space : O(N), Since we store the nodes in the map and queue.

    * */




    //Approach 3 : Without using Queue........                                        T.C. = O(n*log(n)), S.C. = O(n)
    /*  Another approach :
                This approach does not require a queue. Here we use the two variables, one for the vertical distance
                of the current node from the root and another for the depth of the current node from the root. We use
                the vertical distance for indexing. If one node with the same vertical distance comes again, we check
                if the depth of the new node is lower or higher with respect to the current node with the same vertical
                distance in the map. If depth of new node is lower, then we replace it.


     * */
    // Java program to print top view of binary tree
    class GFG_3 {
        // Structure of binary tree
        static class Node {
            Node left;
            Node right;
            int data;
        }
        static class pair {
            int first, second;
            pair() {}
            pair(int i, int j)
            {
                first = i;
                second = j;
            }
        }

        // map to store the pair of node value and its level with respect to
        // the vertical distance from root.
        static TreeMap<Integer, pair> m = new TreeMap<>();

        // function to create a new node
        static Node newNode(int key)
        {
            Node node = new Node();
            node.left = node.right = null;
            node.data = key;
            return node;
        }

        // function to fill the map
        static void fillMap(Node root, int d, int l)
        {
            if (root == null)
                return;

            if (m.get(d) == null) {
                m.put(d, new pair(root.data, l));
            }
            else if (m.get(d).second > l) {
                m.put(d, new pair(root.data, l));
            }

            fillMap(root.left, d - 1, l + 1);
            fillMap(root.right, d + 1, l + 1);
        }

        // function should print the topView of the binary tree
        static void topView(Node root)
        {
            fillMap(root, 0, 0);

            for (Map.Entry<Integer, pair> entry :  m.entrySet()) {
                System.out.print(entry.getValue().first + " ");
            }
        }

        // Driver Code
        public static void main_3(String args[])
        {
            Node root  = newNode(1);
            root.left  = newNode(2);
            root.right = newNode(3);
            root.left.right       = newNode(4);
            root.left.right.right = newNode(5);
            root.left.right.right.right = newNode(6);
            System.out.println("Following are nodes in" + " top view of Binary Tree");
            topView(root);
        }
    }





    //Approach 4 : Another approach....(Via using Level Order Traversal)....          T.C. = O(n),  S.C. = O(n)
    /*  Another approach :
          1. This approach is based on the level order traversal. We’ll keep a record of the current max so far left,
             right horizontal distances from the root.
          2. And if we found less distance (or greater in magnitude) then max left so far distance then update it
             and also push data on this node to a stack (stack is used because in level order traversal the left
             nodes will appear in reverse order), or if we found greater distance then max right so far distance
             then update it and also push data on this node to a vector.
          3. In this approach, no map is used.
    * */
    // Java program to print top view of binary tree
    class GFG_4 {
        // Structure of binary tree
        static class Node {
            Node left;
            Node right;
            int data;
        }
        /*
                  1
                 / \
                2   3
                 \
                  4
                   \
                    5
                     \
                      6
            Top view of the above binary tree is
            2 1 3 6
        */
        static class pair {
            Node node;
            int hd;

            pair() {}
            pair(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }

        // function to create a new node
        static Node newNode(int key)
        {
            Node node = new Node();
            node.left = node.right = null;
            node.data = key;
            return node;
        }

        // function should print the topView of
        // the binary tree
        static void topView(Node root)
        {
            // queue for holding nodes and their horizontal
            // distance from the root node
            Queue<pair> q = new LinkedList<>();

            // pushing root node with distance 0
            q.add(new pair(root, 0));

            // hd is current node's horizontal distance from
            // root node l is current left min horizontal
            // distance (or max in magnitude) so far from the
            // root node r is current right max horizontal
            // distance so far from the root node

            int hd = 0, l = 0, r = 0;

            // stack is for holding left node's data because
            // they will appear in reverse order that is why
            // using stack

            Stack<Integer> left = new Stack<>();

            // ArrayList is for holding right node's data
            ArrayList<Integer> right = new ArrayList<>();
            Node node = null;

            while (!q.isEmpty()) {
                node = q.peek().node;
                hd = q.peek().hd;

                if (hd < l) {
                    left.push(node.data);
                    l = hd;
                }

                if (hd > r) {
                    right.add(node.data);
                    r = hd;
                }

                if (node.left != null) {
                    q.add(new pair(node.left, hd - 1));
                }
                if (node.right != null) {
                    q.add(new pair(node.right, hd + 1));
                }

                q.poll();
            }

            // printing the left node's data in reverse order
            while (!left.isEmpty()) {
                System.out.print(left.peek() + " ");
                left.pop();
            }

            // then printing the root node's data
            System.out.print(root.data + " ");

            // finally printing the right node's data
            for (int d : right) {
                System.out.print(d + " ");
            }
        }

        // Driver Code
        public static void main(String args[])
        {
            Node root = newNode(1);
            root.left = newNode(2);
            root.right = newNode(3);
            root.left.right = newNode(4);
            root.left.right.right = newNode(5);
            root.left.right.right.right = newNode(6);
            System.out.println("Following are nodes in"
                    + " top view of Binary Tree");
            topView(root);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given below is a binary tree. The task is to print the top view of binary tree.
                 Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
                 For the given below tree

                        1
                     /     \
                    2       3
                  /  \     /  \
                 4    5   6    7


            Top view will be : 4 2 1 3 7
            Note : Return nodes from leftmost node to rightmost node.


            Example : 1
            Input   :
                              1
                           /    \
                          2      3
            Output  : 2 1 3


            Example : 2
            Input   :
                               10
                            /      \
                          20        30
                         /   \    /    \
                        40   60  90    100
            Output  : 40 20 10 30 100


            Your Task  :
            Since this is a function problem. You don't have to take input. Just complete the function topView()
            that takes root node as parameter and returns a list of nodes visible from the top view from left to right.


            Expected Time Complexity : O(Nlog(N))
            Expected Auxiliary Space : O(N)

        *
        * */
    }


}
