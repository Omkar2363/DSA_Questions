package Easy;

import java.util.HashMap;

public class Ques_LB1 {

    //Ques : Remove duplicate element from sorted Linked List........                         (GFG Ques.)


    //Approach 1 : Iterative Approach.....                                                    T.C. = O(n),  S.C. = O(1)
    // Java program to remove duplicates from a sorted linked list
    static class LinkedList {
        Node head;                                    // head of list

        /* Linked list Node*/
        class Node
        {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }

        void removeDuplicates()
        {
            /*Another reference to head*/
            Node curr = head;

            /* Traverse list till the last node */
            while (curr != null) {
                Node temp = curr;

                 /* Compare current node with the next node and keep on deleting them
                    until it matches the current node data */
                while(temp!=null && temp.data == curr.data ) {
                    temp = temp.next;
                }

                /*Set current node next to the next different element denoted by temp*/
                curr.next = temp;
                curr = curr.next;
            }
        }

        /* Utility functions */

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
        /* 1 & 2: Allocate the Node & Put in the data*/
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
            while (temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        /* Driver program to test above functions */
        public static void main_1(String args[])
        {
            LinkedList llist = new LinkedList();
            llist.push(20);
            llist.push(13);
            llist.push(13);
            llist.push(11);
            llist.push(11);
            llist.push(11);

            System.out.println("List before removal of duplicates");
            llist.printList();

            llist.removeDuplicates();

            System.out.println("List after removal of elements");
            llist.printList();
        }
    }



    //Approach 2 : Recursive Solution......                                                  T.C. = O(n),  S.C. = O(n)
    // Java Program to remove duplicates from a sorted linked list
    class GFG {
        /* Link list node */
        static class Node
        {
            int data;
            Node next;
        }

        // The function removes duplicates from a sorted list
        static Node removeDuplicates(Node head)
        {
        /* Pointer to store the pointer of a node to be deleted */
            Node to_free;

            /* do nothing if the list is empty */
            if (head == null)
                return null;

            /* Traverse the list till last node */
            if (head.next != null)
            {

                /* Compare head node with next node */
                if (head.data == head.next.data)
                {

                /* The sequence of steps is important, to_free pointer stores the next of head
                   pointer which is to be deleted.*/
                    to_free = head.next;
                    head.next = head.next.next;
                    removeDuplicates(head);
                }

                /* This is tricky : only advance if no deletion */
                else
                {
                    removeDuplicates(head.next);
                }
            }
            return head;
        }

        /* UTILITY FUNCTIONS */
        /* Function to insert a node at the beginning of the linked list */
        static Node push(Node head_ref, int new_data)
        {
            /* allocate node */
            Node new_node = new Node();

            /* put in the data */
            new_node.data = new_data;

            /* link the old list off the new node */
            new_node.next = (head_ref);

            /* move the head to point to the new node */
            (head_ref) = new_node;
            return head_ref;
        }

        /* Function to print nodes in a given linked list */
        static void printList(Node node)
        {
            while (node != null)
            {
                System.out.print(" " + node.data);
                node = node.next;
            }
        }

        /* Driver code*/
        public static void main_2(String args[])
        {
            /* Start with the empty list */
            Node head = null;

            /* Let us create a sorted linked list to test the functions :
               Created linked list will be :  11->11->11->13->13->20 */
            head = push(head, 20);
            head = push(head, 13);
            head = push(head, 13);
            head = push(head, 11);
            head = push(head, 11);
            head = push(head, 11);

            System.out.println("Linked list before" + " duplicate removal ");

            printList(head);

            /* Remove duplicates from linked list */
            head = removeDuplicates(head);

            System.out.println("\nLinked list after" + " duplicate removal ");
            printList(head);
        }
    }



    //Approach 3 : Another approach......                                                   T.C. = O(n),  S.C. = O(1)
    /*  Another Approach : Create a pointer that will point towards  the  first occurrence of
                           every element and another pointer temp which will iterate to every
                           element and when the value of the previous pointer is not equal to
                           the temp pointer, we will set the pointer of the  previous  pointer
                           to the first occurrence of another node.
    *
    * */
    // Java program to remove duplicates from a sorted linked list
    static class LinkedList_2 {
        // head of list
        Node head;
        // Linked list Node
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        // Function to remove duplicates from the given linked list
        void removeDuplicates()
        {
            // Two references to head temp will iterate to the whole Linked List
            // prev will point towards the first occurrence of every element
            Node temp = head, prev = head;

            // Traverse list till the last node
            while (temp != null) {

                // Compare values of both pointers
                if (temp.data != prev.data) {

                    /*
                     if the value of prev is not equal to the value of temp that means there are no
                     more occurrences of the prev data. So we can set the next of prev to the temp node.
                    */
                    prev.next = temp;
                    prev = temp;
                }
                //Set the temp to the next node
                temp = temp.next;
            }
            // This is the edge case if there are more than one occurrence of the last element
            if (prev != temp)
                prev.next = null;
        }

        /* Utility functions */

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
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

        /* Driver program to test above functions */
        public static void main_2(String args[])
        {
            LinkedList_2 llist = new LinkedList_2();
            llist.push(20);
            llist.push(13);
            llist.push(13);
            llist.push(11);
            llist.push(11);
            llist.push(11);

            System.out.print("List before ");
            System.out.println("removal of duplicates");
            llist.printList();

            llist.removeDuplicates();

            System.out.println("List after removal of elements");
            llist.printList();
        }
    }




    //Approach 4 : Using HashMap......
    // Java program for the above approach
    static class Node {
        int data;
        Node next;
        Node()
        {
            data = 0;
            next = null;
        }
    }
    class GFG_2 {

        /* Function to insert a node at the beginning of the linked list */
        static Node push(Node head_ref, int new_data)
        {
            /* allocate node */
            Node new_node = new Node();

            /* put in the data */
            new_node.data = new_data;

            /* link the old list off the new node */
            new_node.next = (head_ref);

            /* move the head to point to the new node */
            head_ref = new_node;
            return head_ref;
        }

        /* Function to print nodes in a given linked list */
        static void printList(Node node)
        {
            while (node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        // Function to remove duplicates
        static void removeDuplicates(Node head)
        {
            HashMap<Integer, Boolean> track = new HashMap<>();
            Node temp = head;

            while(temp != null)
            {
                if(!track.containsKey(temp.data))
                {
                    System.out.print(temp.data + " ");
                }
                track.put(temp.data , true);
                temp = temp.next;
            }
        }

        // Driver Code
        public static void main_4 (String[] args)
        {
            Node head = null;

            /* Created linked list will be : 11->11->11->13->13->20 */
            head = push(head, 20);
            head = push(head, 13);
            head = push(head, 13);
            head = push(head, 11);
            head = push(head, 11);
            head = push(head, 11);
            System.out.print("Linked list before duplicate removal ");
            printList(head);
            System.out.print("\nLinked list after duplicate removal  ");
            removeDuplicates(head);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a singly linked list consisting of N nodes. The task is to remove duplicates
                 (nodes with duplicate values) from the given list (if exists).

                 Note : Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.


            Example : 1
            Input   : LinkedList : 2->2->4->5
            Output  : 2 4 5
            Explanation : In the given linked list....  2->2->4->5, only 2 occurs more than 1 time.


            Example : 2
            Input   : LinkedList : 2->2->2->2->2
            Output  : 2
            Explanation : In the given linked list....  2->2->2->2->2, 2 is the only element and is repeated 5 times.


            Your Task :
            The task is to complete the function removeDuplicates() which should remove the duplicates from
            linked list and return the head of the linked list.

            Expected Time Complexity  : O(N)
            Expected Auxilliary Space : O(1)


        *
        * */
    }



}
