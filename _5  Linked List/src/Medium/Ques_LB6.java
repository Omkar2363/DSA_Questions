package Medium;

import java.util.Stack;

public class Ques_LB6 {

    //Ques : Check if Linked List is Palindrome...........                                (GFG Ques.)


    //Approach 1 : By using Stack......                                                   T.C. = O(n),   S.C. = O(n)
    /*  METHOD 1 : (Use a Stack)
           * A simple solution is to use a stack of list nodes. This mainly involves three steps.
           * Traverse the given list from head to tail and push every visited node to stack.
           * Traverse the list again. For every visited node, pop a node from the stack and compare data of
             popped node with the currently visited node.
           * If all nodes matched, then return true, else false.

    * */
    static class Node {
        int data;
        Node ptr;
        Node(int d) {
            ptr = null;
            data = d;
        }
    }
    static class linkedList_1 {
        public static void main_1(String args[])
        {
            Node one   = new Node(1);
            Node two   = new Node(2);
            Node three = new Node(3);
            Node four  = new Node(4);
            Node five  = new Node(3);
            Node six   = new Node(2);
            Node seven = new Node(1);
            one.ptr    = two;
            two.ptr    = three;
            three.ptr  = four;
            four.ptr   = five;
            five.ptr   = six;
            six.ptr    = seven;
            boolean condition = isPalindrome(one);
            System.out.println("isPalidrome :" + condition);
        }
        static boolean isPalindrome(Node head)
        {
            Node slow = head;
            boolean ispalin = true;
            Stack<Integer> stack = new Stack<Integer>();

            while (slow != null) {
                stack.push(slow.data);
                slow = slow.ptr;
            }

            while (head != null) {
                int i = stack.pop();
                if (head.data == i) {
                    ispalin = true;
                }
                else {
                    ispalin = false;
                    break;
                }
                head = head.ptr;
            }
            return ispalin;
        }
    }



    //Approach 2 : By Reversing the LinkedList........                                   T.C. = O(n),   S.C. = O(1)
    /*  METHOD 2 : (By reversing the list)
            This method takes O(n) time and O(1) extra space.
            1) Get the middle of the linked list.
            2) Reverse the second half of the linked list.
            3) Check if the first half and second half are identical.
            4) Construct the original linked list by reversing the second half again and attaching it back to
               the first half


            To divide the list into two halves, method 2 of this post is used.

                When a number of nodes are even, the first and second half contain exactly half nodes.
                The challenging thing in this method is to handle the case when the number of nodes is odd.
                We don't want the middle node as part of the lists as we are going to compare them for equality.
                For odd cases, we use a separate variable 'midnode'.


    * */
    static class LinkedList_2 {
        Node head;                                         // head of list
        Node slow_ptr, fast_ptr, second_half;
        /* Linked list Node*/
        class Node {
            char data;
            Node next;
            Node(char d) {
                data = d;
                next = null;
            }
        }

        /* Function to check if given linked list is palindrome or not */
        boolean isPalindrome(Node head)
        {
            slow_ptr = head;
            fast_ptr = head;
            Node prev_of_slow_ptr = head;
            Node midnode = null;                                       // To handle odd size list
            boolean res = true;                                        // initialize result

            if (head != null && head.next != null) {
                /* Get the middle of the list. Move slow_ptr by 1  and fast_ptr by 2,
                   slow_ptr will have the middle node */
                while (fast_ptr != null && fast_ptr.next != null) {
                    fast_ptr = fast_ptr.next.next;

                    /*We need previous of the slow_ptr for linked lists  with odd elements */
                    prev_of_slow_ptr = slow_ptr;
                    slow_ptr = slow_ptr.next;
                }

                /* fast_ptr would become NULL when there are even elements in the list and not NULL for odd elements.
                   We need to skip the middle node for odd case and store it somewhere so that
                   we can restore the original list  */
                if (fast_ptr != null) {
                    midnode = slow_ptr;
                    slow_ptr = slow_ptr.next;
                }

                // Now reverse the second half and compare it with first half
                second_half = slow_ptr;
                prev_of_slow_ptr.next = null;                        // NULL terminate first half
                reverse();                                           // Reverse the second half
                res = compareLists(head, second_half);               // compare

                /* Construct the original list back */
                reverse();                                           // Reverse the second half again

                if (midnode != null) {
                    /*
                     If there was a mid-node (odd size case) which
                     was not part of either first half or second half.
                    */
                    prev_of_slow_ptr.next = midnode;
                    midnode.next = second_half;
                }
                else
                    prev_of_slow_ptr.next = second_half;
            }
            return res;
        }

        /* Function to reverse the linked list  Note that this function may change the head */
        void reverse()
        {
            Node prev = null;
            Node current = second_half;
            Node next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            second_half = prev;
        }

        /* Function to check if two input lists have same data*/
        boolean compareLists(Node head1, Node head2)
        {
            Node temp1 = head1;
            Node temp2 = head2;

            while (temp1 != null && temp2 != null) {
                if (temp1.data == temp2.data) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                else
                    return false;
            }

            /* Both are empty return 1*/
            if (temp1 == null && temp2 == null)
                return true;

            /* Will reach here when one is NULL  and other is not */
            return false;
        }

        /* Push a node to linked list. Note that this function changes the head */
        public void push(char new_data)
        {
           /* Allocate the Node & Put in the data */
            Node new_node = new Node(new_data);

            /* link the old list off the new one */
            new_node.next = head;

            /* Move the head to point to new Node */
            head = new_node;
        }

        // A utility function to print a given linked list
        void printList(Node ptr)
        {
            while (ptr != null) {
                System.out.print(ptr.data + "->");
                ptr = ptr.next;
            }
            System.out.println("NULL");
        }

        /* Driver program to test the above functions */
        public static void main(String[] args)
        {

            /* Start with the empty list */
            LinkedList_2 llist = new LinkedList_2();

            char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
            String string = new String(str);
            for (int i = 0; i < 7; i++) {
                llist.push(str[i]);
                llist.printList(llist.head);
                if (llist.isPalindrome(llist.head) != false) {
                    System.out.println("Is Palindrome");
                    System.out.println("");
                }
                else {
                    System.out.println("Not Palindrome");
                    System.out.println("");
                }
            }
        }
    }



    //Approach 3 : By using Recursion..........                                         T.C. = O(n),   S.C. = O(n)
    /*  METHOD 3 : (Using Recursion)
            Use two pointers left and right. Move right and left using recursion and check for following in each recursive call.
               1) Sub-list is a palindrome.
               2) Value at current left and right are matching.


            If both above conditions are true then return true.

            The idea is to use function call stack as a container. Recursively traverse till the end of list.
            When we return from last NULL, we will be at the last node. The last node to be compared with first
            node of list.


            In order to access first node of list, we need list head to be available in the last call of recursion.
            Hence, we pass head also to the recursive function. If they both match we need to compare (2, n-2) nodes.
            Again when recursion falls back to (n-2)nd node, we need reference to 2nd node from the head. We advance
            the head pointer in the previous call, to refer to the next node in the list.

            However, the trick is identifying a double-pointer. Passing a single pointer is as good as pass-by-value,
            and we will pass the same pointer again and again. We need to pass the address of the head pointer for reflecting
            the changes in parent recursive calls.

    * */
    // Java program for the above approach
    static class LinkedList_3 {
        // Head of the list
        Node head;
        Node left;
        public class Node
        {
            public char data;
            public Node next;

            // Linked list node
            public Node(char d)
            {
                data = d;
                next = null;
            }
        }

        // Initial parameters to this function are &head and head
        boolean isPalindromeUtil(Node right)
        {
            left = head;

            // Stop recursion when right becomes null
            if (right == null)
                return true;

            // If sub-list is not palindrome then no need to check for the current left and right, return false
            boolean isp = isPalindromeUtil(right.next);
            if (isp == false)
                return false;

            // Check values at current left and right
            boolean isp1 = (right.data == left.data);

            left = left.next;

            // Move left to next node;
            return isp1;
        }

        // A wrapper over isPalindrome(Node head)
        boolean isPalindrome(Node head)
        {
            boolean result = isPalindromeUtil(head);
            return result;
        }

        // Push a node to linked list. Note that this function changes the head
        public void push(char new_data)
        {

            // Allocate the node and put in the data
            Node new_node = new Node(new_data);

            // Link the old list off the new one
            new_node.next = head;

            // Move the head to point to new node
            head = new_node;
        }

        // A utility function to print a given linked list
        void printList(Node ptr)
        {
            while (ptr != null)
            {
                System.out.print(ptr.data + "->");
                ptr = ptr.next;
            }
            System.out.println("Null");
        }

        // Driver Code
        public static void main(String[] args)
        {
            LinkedList_3 llist = new LinkedList_3();
            char[] str = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
            for(int i = 0; i < 7; i++)
            {
                llist.push(str[i]);
                llist.printList(llist.head);

                if (llist.isPalindrome(llist.head))
                {
                    System.out.println("Is Palindrome");
                    System.out.println("");
                }
                else
                {
                    System.out.println("Not Palindrome");
                    System.out.println("");
                }
            }
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a singly linked list of size N of integers. The task is to check
                 if the given linked list is palindrome or not.


            Example : 1
            Input   : N = 3
                      value[] = {1,2,1}
            Output  : 1
            Explanation : The given linked list is  1 2 1 , which is a palindrome and
                          Hence, the output is 1.

            Example : 2
            Input   : N = 4
                      value[] = {1,2,3,4}
            Output  : 0
            Explanation : The given linked list is  1 2 3 4 , which is not a palindrome and
                          Hence, the output is 0.


            Your Task  :
            The task is to complete the function isPalindrome() which takes head as reference as
            the only parameter and returns true or false if linked list is palindrome or not respectively.


            * Expected Time Complexity        : O(N)
            * Expected Auxilliary Space Usage : O(1)  (i.e. you should not use the recursive stack space as well)



        * */
    }


}
