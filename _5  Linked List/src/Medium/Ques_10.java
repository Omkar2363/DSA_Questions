package Medium;

public class Ques_10 {

    //Ques : Rearrange a given linked list in-place.........                                  (GFG Ques.)


    //Approach 1 : Simple Solution.......                                                     T.C. = O(n^2),  S.C. = O(1)
    /*   Simple Solution :
            1) Initialize current node as head.
            2) While next of current node is not null, do following
                a) Find the last node, remove it from the end and insert it as next
                   of the current node.
                b) Move current  to next of current
            The time complexity of the above simple solution is O(n2) where n is the number of nodes in the linked list.

    * */


    //Approach 2 : Better Solution.....
    /*  Better Solution :
          1.  Copy contents of the given linked list to a vector.
          2.  Rearrange the given vector by swapping nodes from both ends.
          3.  Copy the modified vector back to the linked list.
    * */



    //Approach 3 : Efficient Solution.....                                                  T.C. = O(n),  S.C. = O(1)
    /*    Efficient Solution :
            1) Find the middle point using tortoise and hare method.
            2) Split the linked list into two halves using found middle point in step 1.
            3) Reverse the second half.
            4) Do alternate merge of first and second halves.

            The Time Complexity of this solution is : O(n).
    * */
    // Java program to rearrange link list in place
    static class LinkedList_3 {
        static Node head;                               // head of the list
        /* Node Class */
        static class Node {
            int data;
            Node next;
            // Constructor to create a new node
            Node(int d) {
                data = d;
                next = null;
            }
        }

        void printlist(Node node)
        {
            if (node == null) {
                return;
            }
            while (node != null) {
                System.out.print(node.data + " -> ");
                node = node.next;
            }
        }

        Node reverselist(Node node)
        {
            Node prev = null;
            Node curr = node;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            node = prev;
            return node;
        }

        void rearrange(Node node)
        {

            // 1) Find the middle point using tortoise and hare method
            Node slow = node, fast = slow.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2) Split the linked list in two halves
            //      node1, head of first half    1 -> 2 -> 3
            //      node2, head of second half   4 -> 5
            Node node1 = node;
            Node node2 = slow.next;
            slow.next = null;

            // 3) Reverse the second half, i.e., 5 -> 4
            node2 = reverselist(node2);

            // 4) Merge alternate nodes
            node = new Node(0); // Assign dummy Node

            // curr is the pointer to this dummy Node, which will be used to form the new list
            Node curr = node;
            while (node1 != null || node2 != null) {

                // First add the element from first list
                if (node1 != null) {
                    curr.next = node1;
                    curr = curr.next;
                    node1 = node1.next;
                }

                // Then add the element from second list
                if (node2 != null) {
                    curr.next = node2;
                    curr = curr.next;
                    node2 = node2.next;
                }
            }

            // Assign the head of the new list to head pointer
            node = node.next;
        }

        public static void main_3(String[] args)
        {

            LinkedList_3 list = new LinkedList_3();
            list.head = new Node(1);
            list.head.next = new Node(2);
            list.head.next.next = new Node(3);
            list.head.next.next.next = new Node(4);
            list.head.next.next.next.next = new Node(5);

            list.printlist(head); // print original list
            list.rearrange(head); // rearrange list as per ques
            System.out.println("");
            list.printlist(head); // print modified list
        }
    }



    //Approach 4 :                                                                         T.C. = O(n),  S.C. = O(1)
    /*  Another approach :
            1. Take two pointers prev and curr, which hold the addresses of head and head-> next.
            2. Compare their data and swap.

        After that, a new linked list is formed.
    * */
    // Java code to rearrange linked list in place
    class Geeks {
        static class Node {
            int data;
            Node next;
        }

        // function for rearranging a linked list with high and low value.
        static Node rearrange(Node head)
        {
            //Base case
            if (head == null)
                return null;

            // two pointer variable.
            Node prev = head, curr = head.next;

            while (curr != null)
            {
                // swap function for swapping data.
                if (prev.data > curr.data) {
                    int t = prev.data;
                    prev.data = curr.data;
                    curr.data = t;
                }

                // swap function for swapping data.
                if (curr.next != null
                        && curr.next.data > curr.data) {
                    int t = curr.next.data;
                    curr.next.data = curr.data;
                    curr.data = t;
                }

                prev = curr.next;

                if (curr.next == null)
                    break;
                curr = curr.next.next;
            }
            return head;
        }

        // function to insert a Node in the linked list at the beginning.
        static Node push(Node head, int k)
        {
            Node tem = new Node();
            tem.data = k;
            tem.next = head;
            head = tem;
            return head;
        }

        // function to display Node of linked list.
        static void display(Node head)
        {
            Node curr = head;
            while (curr != null) {
                System.out.printf("%d ", curr.data);
                curr = curr.next;
            }
        }

        // Driver code
        public static void main_4(String args[])
        {
            Node head = null;

            // let's create a linked list :
            // 9-> 6-> 8-> 3-> 7
            head = push(head, 7);
            head = push(head, 3);
            head = push(head, 8);
            head = push(head, 6);
            head = push(head, 9);

            head = rearrange(head);

            display(head);
        }
    }



    //Approach 5 : By using Recursion......
    /*  Another Approach : (Using recursion)
            1. Hold a pointer to the head node and go till the last node using recursion
            2. Once the last node is reached, start swapping the last node to the next of head node
            3. Move the head pointer to the next node
            4. Repeat this until the head and the last node meet or come adjacent to each other
            5. Once the Stop condition met, we need to discard the left nodes to fix the loop created
               in the list while swapping nodes
    * */
    // Java implementation

    // Creating the structure for node
    static class Node {
        int data;
        Node next;
        // Function to create newNode in a linkedlist
        Node(int key) {
            data = key;
            next = null;
        }
    }
    static class GFG {
        Node left = null;
        // Function to print the list
        void printlist(Node head) {

            while (head != null) {
                System.out.print(head.data + " ");
                if (head.next != null) {
                    System.out.print("->");
                }
                head = head.next;
            }
            System.out.println();
        }

        // Function to rearrange
        void rearrange(Node head)
        {
            if (head != null) {
                left = head;
                reorderListUtil(left);
            }
        }
        void reorderListUtil(Node right)
        {
            if (right == null) {
                return;
            }
            reorderListUtil(right.next);

            // we set left = null, when we reach stop condition, so no processing required after that
            if (left == null) {
                return;
            }

            // Stop condition : odd case  : left = right,
            //                  even case : left.next = right
            if (left != right && left.next != right) {
                Node temp = left.next;
                left.next = right;
                right.next = temp;
                left = temp;
            }
            else {                        // stop condition , set null to left nodes
                if (left.next == right) {
                    left.next.next = null;                   // even case
                    left = null;
                }
                else {
                    left.next = null;                       // odd case
                    left = null;
                }
            }
        }

        // Drivers Code
        public static void main_5(String[] args)
        {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            GFG gfg = new GFG();

            // Print original list
            gfg.printlist(head);

            // Modify the list
            gfg.rearrange(head);

            // Print modified list
            gfg.printlist(head);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list
                 so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...

                 You are required to do this in place without altering the nodes’ values.


            Example : 1
            Input   : 1 -> 2 -> 3 -> 4
            Output  : 1 -> 4 -> 2 -> 3


            Example : 2
            Input   : 1 -> 2 -> 3 -> 4 -> 5
            Output  : 1 -> 5 -> 2 -> 4 -> 3

        *
        * */
    }



}
