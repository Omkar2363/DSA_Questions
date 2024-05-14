package Easy;

public class Ques_LB2 {

    //Ques : Move last element to front of a given Linked List..........                       (GFG Ques.)


    //Approach 1 :                                                                             T.C. = O(n),  S.C. = O(1)
    /*  Traverse the list till the last node.
        Use two pointers : One to store the address of the last node and other for the address of the second last node.

        After the end of loop, make the second last node as the last node and the last node as the head node
    * */
    /* Java Program to move last element to front in a given linked list */
    static class LinkedList {
        Node head;                                          // head of list
        /* Linked list Node*/
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        void moveToFront() {

            /* If linked list is empty, or it contains only one node then simply return. */
            if (head == null || head.next == null)
                return;

            /* Initialize second last and last pointers */
            Node secLast = null;
            Node last = head;

            /* After this loop secLast contains address of  second last  node and last contains address of
               last node in Linked List */
            while (last.next != null) {
                secLast = last;
                last = last.next;
            }

            /* Set the next of second last as null */
            secLast.next = null;

            /* Set the next of last as head */
            last.next = head;

            /* Change head to point to last node. */
            head = last;
        }

        /* Utility functions */

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
            /* 1 & 2: Allocate the Node &  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        /* Function to print linked list */
        void printList()
        {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Driver's code
        public static void main_1(String args[])
        {
            LinkedList llist = new LinkedList();

            /* Constructed Linked List is :  1->2->3->4->5->null */
            llist.push(5);
            llist.push(4);
            llist.push(3);
            llist.push(2);
            llist.push(1);

            System.out.println("Linked List before moving last to front ");

            llist.printList();

            // Function call
            llist.moveToFront();

            System.out.println("Linked List after moving last to front ");

            llist.printList();
        }
    }





    public static void main(String[] args) {

        /*Ques : Write a function that moves the last node to the front in a given Singly Linked List.


            Example : 1
            Input   : 1->2->3->4->5
            Output  : 5->1->2->3->4

            Example : 2
            Input   : 3->8->1->5->7->12
            Output  : 12->3->8->1->5->7

        *
        * */
    }


}
