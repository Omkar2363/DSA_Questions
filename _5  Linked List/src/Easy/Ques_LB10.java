package Easy;

public class Ques_LB10 {

    //Ques : Find pairs with given sum in doubly linked list.....                              (GFG Ques.)


    //Approach 1 : Simple Approach......                                                       T.C. = O(n^2),  S.C. = O(1)
    /*  A simple approach for this problem is to one by one pick each node and find a second
        element whose sum is equal to x in the remaining list by traversing in the forward direction.
        The time complexity for this problem will be O(n^2), n is the total number of nodes in the doubly linked list.
     *
    * */


    //Approach 2 : Efficient approach.....                                                     T.C. = O(n), S.C. = O(1)
    /*  An efficient solution for this problem is the same as this article.

        * Here is the algorithm :
           1. Initialize two pointer variables to find the candidate elements in the sorted doubly linked list.
              Initialize first with the start of the doubly linked list      i.e. first = head and
              initialize second with the last node of the doubly linked list i.e. second = last_node.
           2. We initialize first and second pointers as first and last nodes. Here we don’t have random access,
              so to find the second pointer, we traverse the list to initialize the second.
           3. If current sum of first and second is less than x, then we move first in forward direction.
              If current sum of first and second element is greater than x, then we move second in backward direction.
           4. Loop termination conditions are also different from arrays. The loop terminates when two pointers
              cross each other (second->next = first), or they become the same (first == second).
           5. The case when no pairs are present will be handled by the condition “first==second”
    *
    * */
    // Java program to find a pair with given sum x.
    class GFG {
        // structure of node of doubly linked list
        static class Node {
            int data;
            Node next, prev;
        }

        // Function to find pair whose sum equal to given value x.
        static void pairSum( Node head, int x)
        {
            /*
             Set two pointers, first to the beginning of DLL
             and second to the end of DLL.
            */
            Node first = head;
            Node second = head;
            while (second.next != null)
                second = second.next;

            // To track if we find a pair or not
            boolean found = false;

            /*
             The loop terminates when they cross each other (second.next == first),
             or they become same (first == second)
            */
            while ( first != second && second.next != first)
            {
                // pair found
                if ((first.data + second.data) == x)
                {
                    found = true;
                    System.out.println( "(" + first.data + ", "+ second.data + ")" );

                    // move first in forward direction
                    first = first.next;

                    // move second in backward direction
                    second = second.prev;
                }
                else
                {
                    if ((first.data + second.data) < x)
                        first = first.next;
                    else
                        second = second.prev;
                }
            }

            // if pair is not present
            if (found == false)
                System.out.println("No pair found");
        }

        // A utility function to insert a new node at the beginning of doubly linked list
        static Node insert(Node head, int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.next = temp.prev = null;
            if (head == null)
                (head) = temp;
            else
            {
                temp.next = head;
                (head).prev = temp;
                (head) = temp;
            }
            return temp;
        }

        // Driver Code
        public static void main_1(String args[])
        {
            Node head = null;
            head = insert(head, 9);
            head = insert(head, 8);
            head = insert(head, 6);
            head = insert(head, 5);
            head = insert(head, 4);
            head = insert(head, 2);
            head = insert(head, 1);
            int x = 7;

            pairSum(head, x);
        }
    }



    public static void main(String[] args) {

        /*Ques : Given a sorted doubly linked list of positive distinct elements, the task is to find
                 pairs in a doubly-linked list whose sum is equal to given value x, without using any extra space?


            Example : 1
            Input   : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
                      x = 7
            Output  : (6, 1), (5,2)

            * The expected time complexity is O(n) and auxiliary space is O(1).
        * */
    }


}
