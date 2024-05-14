package Medium;

public class Ques_LB8 {

    //Ques : Reverse a doubly linked list in groups of given size........                    (GFG Ques.)


    //Approach 1 :                                                                           T.C. = O(n),   S.C. = O()
    /*  Approach : Create a recursive function say reverse(head, k). This function receives the head
                   or the first node of each group of k nodes. It reverses those groups of k nodes by
                   applying the approach discussed in Reverse a doubly linked list | Set-2.
                   After reversing the group of k nodes the function checks whether next group of nodes
                   exists in the list or not. If a group exists then it makes a recursive call to itself
                   with the first node of the next group and makes the necessary adjustments with the next
                   and previous links of that group. Finally, it returns the new head node of the reversed group.
    * */
    // Java implementation to reverse a doubly linked list in groups of given size
    // Represents a node of doubly linked list
    class GFG_1 {
        static class Node {
            int data;
            Node next, prev;
            }

        // function to get a new node
        static Node getNode(int data)
        {
            // allocating node
            Node new_node = new Node();
            new_node.data = data;
            new_node.next = new_node.prev = null;

            return new_node;
        }

        // function to insert a node at the beginning of the Doubly Linked List
        static Node push(Node head, Node new_node)
        {
            // since we are adding at the beginning, prev is always NULL
            new_node.prev = null;

            // link the old list off the new node
            new_node.next = head;

            // change prev of head node to new node
            if (head != null)
                head.prev = new_node;

            // move the head to point to the new node
            head = new_node;
            return head;
        }

        // function to reverse a doubly linked list in groups of given size
        static Node revListInGroupOfGivenSize(Node head, int k)
        {
            Node current = head;
            Node next = null;
            Node newHead = null;
            int count = 0;

            // reversing the current group of k or less than k nodes
            // by adding them at the beginning of list 'newHead'
            while (current != null && count < k)
            {
                next = current.next;
                newHead = push(newHead, current);
                current = next;
                count++;
            }

            // if next group exists then making the desired adjustments in the link
            if (next != null)
            {
                head.next = revListInGroupOfGivenSize(next, k);
                head.next.prev = head;
            }

            // pointer to the new head of the reversed group
            return newHead;
        }

        // Function to print nodes in a given doubly linked list
        static void printList(Node head)
        {
            while (head != null)
            {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }

        // Driver code
        public static void main_1(String args[])
        {
            // Start with the empty list
            Node head = null;

            // Create doubly linked: 10<->8<->4<->2
            head = push(head, getNode(2));
            head = push(head, getNode(4));
            head = push(head, getNode(8));
            head = push(head, getNode(10));

            int k = 2;

            System.out.print("Original list: ");
            printList(head);

            // Reverse doubly linked list in groups of
            // size 'k'
            head = revListInGroupOfGivenSize(head, k);

            System.out.print("\nModified list: ");
            printList(head);
        }
    }



    //Approach 2 : Above algorithm's Recursive Solution......
    class GFG_2 {
        static class Node {
            int data;
            Node next, prev;
        }
        // Function to add Node at the end of a Doubly LinkedList
        static Node insertAtEnd(Node head, int data)
        {
            Node new_node = new Node();
            new_node.data = data;
            new_node.next = null;
            Node temp = head;

            if (head == null) {
                new_node.prev = null;
                head = new_node;
                return head;
            }

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.prev = temp;
            return head;
        }

        // Function to print Doubly LinkedList
        static void printDLL(Node head)
        {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        // Function to Reverse a doubly linked list in groups of given size
        static Node reverseByN(Node head, int k)
        {
            if (head == null)
                return null;

            head.prev = null;
            Node temp;
            Node curr = head;
            Node newHead = null;
            int count = 0;

            while (curr != null && count < k) {
                newHead = curr;
                temp = curr.prev;
                curr.prev = curr.next;
                curr.next = temp;
                curr = curr.prev;
                count++;
            }

            // Checking if the reversed LinkedList size is equal to K or not.
            // If it is not equal to k that means we have reversed the last set of
            // size K, and we don't need to call the recursive function
            if (count >= k) {
                Node rest = reverseByN(curr, k);
                head.next = rest;
                if (rest != null)
                    // it is required for prev link otherwise u won't be back track list due to broken links
                    rest.prev = head;
            }
            return newHead;
        }

        // Driver code
        public static void main_2(String[] args)
        {
            Node head = null;
            for (int i = 1; i <= 10; i++) {
                head = insertAtEnd(head, i);
            }

            printDLL(head);
            int n = 4;

            head = reverseByN(head, n);
            printDLL(head);
        }
    }



    //Approach 3 : Iterative method.....                                                   T.C. = O(n),  S.C. = O(1)
    /*  Another approach (Iterative Method) :  Here we will be using the iterative method in which we will begin
                                               from head node and reverse k nodes in the group.
                                               After reversing the k nodes we will continue this process with the
                                               next node after the k node until it becomes null. We will the achieving
                                               the desired result in only a single pass of the linked list with the time
                                               complexity of O(n) and space complexity of O(1).
     * */
    // Java implementation to reverse a doubly linked list in groups of given size
    // without recursion........... Iterative Method

    // Represents a node of doubly linked list
    class GFG {
        static class Node {
            int data;
            Node next, prev;
        }

        // function to get a new node
        static Node getNode(int data)
        {
            // allocating node
            Node new_node = new Node();
            new_node.data = data;
            new_node.next = new_node.prev = null;

            return new_node;
        }

        // function to insert a node at the beginning of the Doubly Linked List
        static Node push(Node head, Node new_node)
        {
            // since we are adding at the beginning, prev is always NULL
            new_node.prev = null;

            // link the old list off the new node
            new_node.next = head;

            // change prev of head node to new node
            if (head != null)
                head.prev = new_node;

            // move the head to point to the new node
            head = new_node;
            return head;
        }

        // function to reverse a doubly linked list in groups of given size
        static Node revListInGroupOfGivenSize(Node head, int k)
        {
            if (head == null)
                return head;
            Node st = head;
            Node globprev = null;
            Node ans = null;
            while (st != null) {

                int count = 1;                                  // to count k nodes
                Node curr = st;
                Node prev = null;
                Node next = null;
                while (curr != null   &&   count <= k) {        // reversing k nodes
                    next = curr.next;
                    curr.prev = next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    count++;
                }
                if (ans == null) {
                    ans = prev;                               // to store ans i.e. the new head
                    ans.prev = null;
                }
                if (globprev == null) {
                    globprev = st;                            // assigning the last node of the reversed k nodes
                }
                else {
                    globprev.next = prev;
                    prev.prev = globprev;                     // connecting last node of last k group to the first
                                                              // node of present k group
                    globprev = st;
                }

                st = curr;                                   // advancing the pointer for the next k group
            }
            return ans;
        }

        // Function to print nodes in a given doubly linked list
        static void printList(Node head)
        {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }

        // Driver code
        public static void main_3(String args[])
        {
            // Start with the empty list
            Node head = null;

            // Create doubly linked : 10<->8<->4<->2
            head = push(head, getNode(2));
            head = push(head, getNode(4));
            head = push(head, getNode(8));
            head = push(head, getNode(10));

            int k = 2;

            System.out.print("Original list: ");
            printList(head);

            // Reverse doubly linked list in groups of size 'k'
            head = revListInGroupOfGivenSize(head, k);

            System.out.print("\nModified list: ");
            printList(head);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a doubly linked list containing n nodes. The problem is to
                 reverse every group of k nodes in the list.

            Examples :


            Follow the link for visual representation of examples.....
            Link : https://www.geeksforgeeks.org/reverse-doubly-linked-list-groups-given-size/
        *
        *
        * */
    }
}
