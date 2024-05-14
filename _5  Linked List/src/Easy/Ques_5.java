package Easy;

import java.util.HashSet;

public class Ques_5 {

    //Ques : Remove duplicates from an unsorted linked list.....                            (GFG Ques.)


    //Approach 1 : Naive Approach....                                                       T.C. = O(n^2),   S.C. = O(1)
    /*  Naive approach :
        Use two loops, Outer loop is used to pick the elements one by one and the Inner loop compares
        the picked element with the rest of the elements.
    * */
    // Java program to remove duplicates from unsorted linked list
    static class LinkedList {
        static Node head;
        static class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Function to remove duplicates from an unsorted linked list */
        void remove_duplicates()
        {
            Node ptr1 = null, ptr2 = null, dup = null;
            ptr1 = head;

            /* Pick elements one by one */
            while (ptr1 != null && ptr1.next != null) {
                ptr2 = ptr1;

            /* Compare the picked element with rest of the elements */
                while (ptr2.next != null) {

                    /* If duplicate then delete it */
                    if (ptr1.data == ptr2.next.data) {

                        /* sequence of steps is important here  */
                        ptr2.next = ptr2.next.next;
                        System.gc();
                    }
                    else /* This is tricky */ {
                        ptr2 = ptr2.next;
                    }
                }
                ptr1 = ptr1.next;
            }
        }

        void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        public static void main(String[] args)
        {
            LinkedList list = new LinkedList();
            list.head = new Node(10);
            list.head.next = new Node(12);
            list.head.next.next = new Node(11);
            list.head.next.next.next = new Node(11);
            list.head.next.next.next.next = new Node(12);
            list.head.next.next.next.next.next = new Node(11);
            list.head.next.next.next.next.next.next = new Node(10);

            System.out.println("Linked List before removing duplicates : ");
            list.printList(head);

            list.remove_duplicates();
            System.out.println("\n");
            System.out.println("Linked List after removing duplicates : ");
            list.printList(head);
        }
    }



    //Approach 2 : By using Sorting.......                                                T.C. = O(nlog(n)),  S.C. = O(1)
    /*  Follow the below steps to Implement the idea :
          1.  Sort the elements using Merge Sort for Linked Lists.
          2.  Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List.
              Note : that this method doesn't preserve the original order of elements.

              Time Complexity : O(nlog(n))
              Auxiliary Space : O(1)
    *
    * */




    //Approach 3 : By using Hashing.......                                                 T.C. = O(n),   S.C. = O(n)
    /*  Traverse the link list from head to end. For every newly encountered element,
        check whether : If it is in the hash table...
        If yes, we remove it ;
        otherwise put it in the hash table.
    * */
    // Java program to remove duplicates from unsorted linked list
    public class removeDuplicates {
        static class node {
            int val;
            node next;
            public node(int val) {
                this.val = val;
            }
        }

        /* Function to remove duplicates from an unsorted linked list */
        static void removeDuplicate(node head)
        {
            // Hash to store seen values
            HashSet<Integer> hs = new HashSet<>();

            /* Pick elements one by one */
            node current = head;
            node prev = null;
            while (current != null) {
                int curr_val = current.val;

                // If current value is seen before
                if (hs.contains(curr_val)) {
                    prev.next = current.next;
                }
                else {
                    hs.add(curr_val);
                    prev = current;
                }
                current = current.next;
            }
        }

        /* Function to print nodes in a given linked list */
        static void printList(node head)
        {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }

        public static void main_2(String[] args)
        {
        /* The constructed linked list is : 10->12->11->11->12->11->10  */
            node start = new node(10);
            start.next = new node(12);
            start.next.next = new node(11);
            start.next.next.next = new node(11);
            start.next.next.next.next = new node(12);
            start.next.next.next.next.next = new node(11);
            start.next.next.next.next.next.next = new node(10);

            System.out.println("Linked list before removing duplicates : ");
            printList(start);

            removeDuplicate(start);

            System.out.println("\nLinked list after removing duplicates : ");
            printList(start);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an unsorted list of nodes. The task is to remove duplicates from the list.


            Example : 1
            Input   : linked list = 12->11->12->21->41->43->21
            Output  : 12->11->21->41->43.
            Explanation : Second occurrence of 12 and 21 is removed


            Example : 2
            Input   : linked list = 12->11->12->21->41->43->21
            Output  : 12->11->21->41->43.


        *
        * */
    }


}
