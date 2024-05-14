package Medium;

import java.util.HashSet;
import java.util.Set;

public class Ques_LB2 {

    //Ques : Find first node of loop in a linked list.........                                  (GFG Ques.)


    //Approach 1 : Floyd's Cycle Detection Algorithm.........
    // Java program to return first node of loop.
    class GFG_1{
        static class Node
        {
            int key;
            Node next;
        }
        static Node newNode(int key)
        {
            Node temp = new Node();
            temp.key = key;
            temp.next = null;
            return temp;
        }

        // A utility function to print a linked list
        static void printList(Node head)
        {
            while (head != null)
            {
                System.out.print(head.key + " ");
                head = head.next;
            }
            System.out.println();
        }

        // Function to detect and remove loop in a linked list that may contain loop
        static Node detectAndRemoveLoop(Node head)
        {
            // If list is empty or has only one node without loop
            if (head == null || head.next == null)
                return null;

            Node slow = head, fast = head;

            // Move slow and fast 1 and 2 steps ahead respectively.
            slow = slow.next;
            fast = fast.next.next;

            // Search for loop using slow and fast pointers
            while (fast != null &&
                    fast.next != null)
            {
                if (slow == fast)
                    break;
                slow = slow.next;
                fast = fast.next.next;
            }

            // If loop does not exist
            if (slow != fast)
                return null;

            // If loop exists. Start slow from head and fast from meeting point.
            slow = head;
            while (slow != fast)
            {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            Node head = newNode(50);
            head.next = newNode(20);
            head.next.next = newNode(15);
            head.next.next.next = newNode(4);
            head.next.next.next.next = newNode(10);

            // Create a loop for testing
            head.next.next.next.next.next = head.next.next;

            Node res = detectAndRemoveLoop(head);
            if (res == null)
                System.out.print("Loop does not exist");
            else
                System.out.print("Loop starting node is " +  res.key);
        }
    }



    //Approach 2 :                                                                             T.C. = O(n),  S.C. = O(1)
    /*  Method 2 :
            In this method, a temporary node is created. The next pointer of each node that is traversed is made to
            point to this temporary node. This way we are using the next pointer of a node as a flag to indicate
            whether the node has been traversed or not. Every node is checked to see if the next is pointing to a
            temporary node or not. In the case of the first node of the loop,
            the second time we traverse it this condition will be true, hence we return that node.

            The code runs in O(n) time complexity and uses constant memory space.

    * */
    // Java program to return first node of loop
    class GFG_2 {
        static class Node
        {
            int key;
            Node next;
        }
        static Node newNode(int key)
        {
            Node temp = new Node();
            temp.key = key;
            temp.next = null;
            return temp;
        }

        // A utility function to print a linked list
        static void printList(Node head)
        {
            while (head != null)
            {
                System.out.print(head.key + " ");
                head = head.next;
            }
            System.out.println();
        }

        // Function to detect first node of loop in a linked list that may contain loop
        static Node detectLoop(Node head)
        {
            // Create a temporary node
            Node temp = new Node();
            while (head != null)
            {

                // This condition is for the case when there is no loop
                if (head.next == null)
                {
                    return null;
                }

                // Check if next is already pointing to temp
                if (head.next == temp)
                {
                    break;
                }

                // Store the pointer to the next node in order to get to it in the next step
                Node nex = head.next;

                // Make next point to temp
                head.next = temp;

                // Get to the next node in the list
                head = nex;
            }

            return head;
        }

        /* Driver program to test above function*/
        public static void main_2(String[] args)
        {
            Node head = newNode(50);
            head.next = newNode(20);
            head.next.next = newNode(15);
            head.next.next.next = newNode(4);
            head.next.next.next.next = newNode(10);

            /* Create a loop for testing */
            head.next.next.next.next.next = head.next.next;

            Node res = detectLoop(head);
            if (res == null)
                System.out.print("Loop does not exist");
            else
                System.out.print("Loop starting node is " +
                        res.key);

        }
    }



    /*
    Approach 3 : By using Hashing........                                                   T.C. = O(nlog(n)), S.C. = O(n)
     The below function take head of Linked List as input and return Address
     of first node in the loop if present else return NULL.
    */
    static class Node {
        int key;
        Node next;
    }
    class GFG_3 {
        static Node detectCycle(Node A)
        {
            // declaring map to store node address
            Set<Node> uset = new HashSet<Node>();
            Node ptr = A;                                            //A : A represents the Link List

            // Default consider that no cycle is present
            while (ptr != null)
            {

                // checking if address is already present in map
                if(uset.contains(ptr))
                {
                    return ptr;
                }

                // if address not present then insert into the set
                else
                {
                    uset.add(ptr);
                }
                ptr = ptr.next;
            }
            return null;
        }
    }





    public static void main(String[] args) {

        /*Ques : Write a function findFirstLoopNode() that checks whether a given Linked List contains a loop.
                 If the loop is present then it returns point to the first node of the loop. Else it returns NULL.


            Example :
            Input   : Head of below linked list
            Output  : Pointer to node 2

            Follow the link for visual representation......
            Link : https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/


        * */
    }


}
