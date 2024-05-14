package Easy;

public class Ques_LB12 {

    //Ques : Nth node from end of linked list.......                                      (GFG Ques.)


    //Approach 1 : Naive Approach.....                                                    T.C. = O(n),  S.C. = O(1)
    /*  Naive Approach :
        Follow the given steps to solve the problem using this approach :
          1. Calculate the length of the Linked List. Let the length be len.
          2. Print the (len - n + 1)th node from the beginning of the Linked List.
    *
    * */
    // Java program to find Nth node from end of linked list
    static class LinkedList {
        Node head;                                  // head of the list
        /* Linked List node */
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Function to get the Nth node from the last of a linked list */
        void printNthFromLast(int N)
        {
            int len = 0;
            Node temp = head;

            // 1) count the number of nodes in Linked List
            while (temp != null) {
                temp = temp.next;
                len++;
            }

            // check if value of N is not more than length of the linked list
            if (len < N)
                return;

            temp = head;

            // 2) get the (len-N+1)th node from the beginning
            for (int i = 1; i < len - N + 1; i++)
                temp = temp.next;

            System.out.println(temp.data);
        }

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

        // Driver's code
        public static void main_1(String[] args)
        {
            LinkedList llist = new LinkedList();
            llist.push(20);
            llist.push(4);
            llist.push(15);
            llist.push(35);

            // Function call
            llist.printNthFromLast(4);
        }
    }



    //Approach 2 : Recursive approach....                                                T.C. = O(n),  S.C. = O(n)
    class Node_2 {
        int data;
        Node_2 next;

        Node_2(int d) {
            data = d;
            next = null;
        }
    }
    static void printNthFromLast(Node_2 head, int N) {

        int i = 0;                                         //Check this code on LeetCode.....

        if (head == null)
            return;
        printNthFromLast(head.next, N);

        if (++i == N)
            System.out.print(head.data);
    }



    //Approach 3 : By using Two pointer........                                         T.C. = O(n),  S.C. = O(1)
    /*  Nth node from the end of a Linked List using two pointers :
        As Nth node from the end equals to (Length - N + 1)th node from the start,
        so the idea is to Maintain two pointers starting from the head of the Linked-List
        and move one pointer to the Nth node from the start and then move both the pointers
        together until the pointer at the Nth position reaches the last node.

        Now the pointer which was moved later points at the Nth node from the end of the Linked-List.

    * */
    // Java program to find N'th node from end
    static class LinkedList_3 {
        Node head;                                       // head of the list
        /* Linked List node */
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Function to get the Nth node from end of list */
        void printNthFromLast(int N)
        {
            Node main_ptr = head;
            Node ref_ptr = head;

            int count = 0;
            if (head != null) {
                while (count < N) {
                    if (ref_ptr == null) {
                        System.out.println( N + " is greater than the no " + " of nodes in the list");
                        return;
                    }
                    ref_ptr = ref_ptr.next;
                    count++;
                }

                if (ref_ptr == null) {

                    if (head != null)
                        System.out.println("Node no. " + N + " from last is " + head.data);
                }
                else {

                    while (ref_ptr != null) {
                        main_ptr = main_ptr.next;
                        ref_ptr = ref_ptr.next;
                    }
                    System.out.println("Node no. " + N + " from last is " + main_ptr.data);
                }
            }
        }

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

        // Driver's code
        public static void main_3(String[] args)
        {
            LinkedList_3 llist = new LinkedList_3();
            llist.push(20);
            llist.push(4);
            llist.push(15);
            llist.push(35);

            // Function call
            llist.printNthFromLast(4);
        }
    }




    public static void main(String[] args) {


        /*Ques : Given a linked list consisting of L nodes and given a number N. The task is to find
                 the Nth node from the end of the linked list.


            Example : 1
            Input   : N = 2
                      LinkedList: 1->2->3->4->5->6->7->8->9
            Output  : 8
            Explanation : In the first example, there are 9 nodes in linked list, and we need
                          to find 2nd node from end.
                          2nd node from end is 8.

            Example : 2
            Input   : N = 5
                      LinkedList : 10->5->100->5
            Output  : -1
            Explanation : In the second example, there are 4 nodes in the linked list, and we
                          need to find 5th from the end.
                          Since 'n' is more than the number of nodes in the linked list, the output is -1.


            Your Task :
            The task is to complete the function getNthFromLast() which takes two arguments :
            reference to head and N and you need to return Nth from the end or -1 in case node doesn't exist...


            Note : Try to solve in single traversal.

            Expected Time Complexity  : O(N).
            Expected Auxiliary Space  : O(1).

        *
        * */
    }



}
