package Easy;

import java.util.Stack;

public class Ques_LB9 {

    //Ques : Reverse a Doubly Linked List.......                                           (GFG Ques.)


    //Approach 1 :                                                                         T.C. = O(n),  S.C. = O(1)
    // Java program to reverse a doubly linked list
    static class LinkedList_1 {
        static Node head;
        static class Node {
            int data;
            Node next, prev;
            Node(int d)
            {
                data = d;
                next = prev = null;
            }
        }

        /* Function to reverse a Doubly Linked List */
        void reverse()
        {
            Node temp = null;
            Node current = head;

            /* swap next and prev for all nodes of doubly linked list */
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }

            /* Before changing head, check for the cases like empty list and list with only one node */
            if (temp != null) {
                head = temp.prev;
            }
        }

        /* UTILITY FUNCTIONS */
        /* Function to insert a node at the beginning of the Doubly Linked List */
        void push(int new_data)
        {
            /* allocate node */
            Node new_node = new Node(new_data);

            /* since we are adding at the beginning, prev is always NULL */
            new_node.prev = null;

            /* link the old list off the new node */
            new_node.next = head;

            /* change prev of head node to new node */
            if (head != null) {
                head.prev = new_node;
            }

            /* move the head to point to the new node */
            head = new_node;
        }

        /* Function to print nodes in a given doubly linked list
         This function is same as printList() of singly linked list */
        void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        // Driver's code
        public static void main_1(String[] args)
        {
            LinkedList_1 list = new LinkedList_1();

            /* Let us create a sorted linked list to test the functions.
               Created linked list will be :   10->8->4->2     */
            list.push(2);
            list.push(4);
            list.push(8);
            list.push(10);

            System.out.println("Original linked list ");
            list.printList(head);

            // Function call
            list.reverse();

            System.out.println("");
            System.out.println("The reversed Linked List is ");
            list.printList(head);
        }
    }



    //Approach 2 : Reversing Doubly linked list using Stack.....                           T.C. = O(n),  S.C. = O(n)
    /*  Push the node’s data into the stack while traversing the doubly linked list,
        then pop out the elements from the stack and copy the value to the nodes of
        the linked list by again traversing it

        *Follow the given steps to solve the problem using the above approach :
           1. Traverse the whole Linked List and  Keep pushing the node’s data into the stack
           2. Then keep popping the elements out of the stack and updating the Doubly Linked List
    *
    * */
    // Java program to reverse a doubly linked list
    static class LinkedList_2 {
        static Node head;
        static class Node {
            int data;
            Node next, prev;
            Node(int d)
            {
                data = d;
                next = prev = null;
            }
        }

        /* Function to reverse a Doubly Linked List using Stacks         */
        void reverse()
        {
            Stack<Integer> stack = new Stack<>();
            Node temp = head;
            while (temp != null) {
                stack.push(temp.data);
                temp = temp.next;
            }

            // added all the elements sequence wise in the stack
            temp = head;
            while (temp != null) {
                temp.data = stack.pop();
                temp = temp.next;
            }
            /*
             popped all the elements and the added in the
             linked list, which are in the reversed order.
            */
        }

        /* UTILITY FUNCTIONS */
        /* Function to insert a node at the beginning of the Doubly Linked List */
        void push(int new_data)
        {
            /* allocate node */
            Node new_node = new Node(new_data);

            /* since we are adding at the beginning, prev is always NULL */
            new_node.prev = null;

            /* link the old list off the new node */
            new_node.next = head;

            /* change prev of head node to new node */
            if (head != null) {
                head.prev = new_node;
            }

            /* move the head to point to the new node */
            head = new_node;
        }

        /* Function to print nodes in a given doubly linked list
         This function is same as printList() of singly linked list */
        void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            LinkedList_2 list = new LinkedList_2();

            /* Let us create a sorted linked list to test the functions.
               Created linked list will be :  10->8->4->2     */
            list.push(2);
            list.push(4);
            list.push(8);
            list.push(10);

            System.out.println("Original linked list ");
            list.printList(head);

            list.reverse();
            System.out.println("");
            System.out.println("The reversed Linked List is ");
            list.printList(head);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a doubly linked list of n elements. The task is to reverse the doubly linked list.


            Example : 1
            Input   : LinkedList : 3 <--> 4 <--> 5
            Output  : 5 4 3


            Example : 2
            Input   : LinkedList : 75 <--> 122 <--> 59 <--> 196
            Output  : 196 59 122 75


            Your Task :
            Your task is to complete the given function reverseDLL(), which takes head reference as argument
            and should reverse the elements so that the tail becomes the new head and all pointers are correctly pointed.
            You need to return the new head of the reversed list. The printing and verification is done by the driver code.


            Expected Time Complexity : O(n).
            Expected Auxiliary Space : O(1).
        *
        * */
    }



}
