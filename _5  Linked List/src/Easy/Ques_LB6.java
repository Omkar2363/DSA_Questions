package Easy;

public class Ques_LB6 {

    //Ques : Check If Circular Linked List........                                          (GFG Ques.)


    //Approach 1 :                                                                          T.C. = O(n),  S.C. = O(1)
    /*  The idea is to store head of the linked list and traverse it. If iterator reaches NULL,
        linked list is not circular. else If it reaches head again, then linked list is circular.

        * Follow the given steps to solve the problem :

            * Declare a Node pointer node and initialize it to the head’s next
            * Move node pointer to the next node, while the node is not equal to nullptr and node is not equal to the head
            * After coming out of the loop, check if the node is equal to head then return true, else return false

    * */
    // Java program to check if linked list is circular
    class GFG {

        /* Link list Node */
        static class Node {
            int data;
            Node next;
        }

        /* This function returns true if given linked list is circular, else false. */
        static boolean isCircular(Node head)
        {
            // An empty linked list is circular
            if (head == null)
                return true;

            // Next of head
            Node node = head.next;

            // This loop would stop in both cases : (1) If Circular, (2) Not circular
            while (node != null && node != head)
                node = node.next;


            // If loop stopped because of circular condition
            return (node == head);
        }

        // Utility function to create a new node.
        static Node newNode(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.next = null;
            return temp;
        }

        /* Driver code*/
        public static void main_1(String args[])
        {
            /* Start with the empty list */
            Node head = newNode(1);
            head.next = newNode(2);
            head.next.next = newNode(3);
            head.next.next.next = newNode(4);

            System.out.print( isCircular(head)   ?   "Yes\n"   :   "No\n");

            // Making linked list circular
            head.next.next.next.next = head;

            System.out.print( isCircular(head)   ?   "Yes\n"  :   "No\n");
        }
    }







    public static void main(String[] args) {

        /*Ques : Given head, the head of a singly linked list, find if the linked list is circular or not.
                 A linked list is called circular if it not NULL terminated and all nodes are connected in
                 the form of a cycle. An empty linked list is considered as circular.

                 Note : The linked list does not contain any inner loop.


            Example : 1
            Input   : LinkedList : 1->2->3->4->5
                      (the first and last node is connected, i.e. 5 --> 1)
            Output  : 1


            Example : 2
            Input   : LinkedList: 2->4->6->7->5->1
            Output  : 0

            Your Task :
            The task is to complete the function isCircular() which checks if the given linked list is circular or not.
            It should return true or false accordingly.
            (The driver code prints 1, if the returned values is true,
                          otherwise 0).

            Expected Time Complexity  : O(N).
            Expected Auxiliary Space  : O(1).
        *
        * */
    }



}
