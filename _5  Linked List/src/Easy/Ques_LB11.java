package Easy;

public class Ques_LB11 {

    //Ques : Rotate Doubly linked list by N nodes........                                (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(n),  S.C. = O(1)
    /*  Algorithm :
          1. To rotate the Doubly linked list, first, we need to traverse through the linked list
             and find the address of the last node.
          2. Then make it a circular linked list.
          3. Then move the head as well as a temp by n nodes.
          4. Then make the linked list as un-circular.
    * */
    // Java program to rotate a Doubly linked list counter clock wise by N times
    class GfG_1 {
        /* Link list node */
        static class Node {
            char data;
            Node prev;
            Node next;
        }
        static Node head = null;

        /*
         This function rotates a doubly linked list counter-clockwise and updates the head.
         The function assumes that N is smaller than size of linked list. It doesn't modify the list
         if N is greater than or equal to size
        */
        static void rotate( int N)
        {
            if (N == 0)
                return;

            // Let us understand the below code :
            // For example, N = 2 and list is : a <-> b <-> c <-> d <-> e.
            Node current = head;

            // current will either point to Nth or NULL after this loop.
            // Current will point to node 'b' in the above example
            int count = 1;
            while (count < N && current != null)
            {
                current = current.next;
                count++;
            }

            // If current is NULL, N is greater than or equal to count of nodes in linked list.
            // Don't change the list in this case
            if (current == null)
                return;

            // Current points to Nth node. Store it in a variable.
            // Nth Node points to node 'b' in the above example
            Node NthNode = current;

            // current will point to last node after this loop current will point
            // to node 'e' in the above example
            while (current.next != null)
                current = current.next;

            // Change next of last node to previous head.
            // Next of 'e' is now changed to node 'a'
            current.next = head;

            // Change prev of Head node to current
            // Prev of 'a' is now changed to node 'e'
            (head).prev = current;

            // Change head to (N+1)th node
            // head is now changed to node 'c'
            head = NthNode.next;

            // Change prev of New Head node to NULL
            // Because Prev of Head Node in Doubly linked list is NULL
            (head).prev = null;

            // change next of Nth node to NULL
            // next of 'b' is now NULL
            NthNode.next = null;
        }

        // Function to insert a node at the beginning of the Doubly Linked List
        static void push(char new_data)
        {
            Node new_node = new Node();
            new_node.data = new_data;
            new_node.prev = null;
            new_node.next = (head);
            if ((head) != null)
                (head).prev = new_node;
            head = new_node;
        }

        /* Function to print linked list */
        static void printList(Node node)
        {
            while (node != null && node.next != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
            if(node != null)
                System.out.print(node.data);
        }

        // Driver's Code
        public static void main_1(String[] args)
        {
            /* Start with the empty list */
            // Node head = null;

            /* Let us create the doubly linked list :  a<-->b<-->c<-->d<-->e */
            push( 'e');
            push( 'd');
            push('c');
            push('b');
            push( 'a');

            int N = 2;

            System.out.println("Given linked list ");
            printList(head);
            rotate( N);
            System.out.println();
            System.out.println("Rotated Linked list ");
            printList(head);
        }
    }



    //Approach 2 :                                                                      T.C. = O(n),  S.C. = O(1)
    // Java code to rotate doubly linked list by N nodes.
    static class GFG_2 {
        class Node {
            char data;
            Node next;
            Node prev;
            Node(char data)
            {
                this.data = data;
                prev = null;
                next = null;
            }
        }
        Node head = null;

        // Function to insert nodes at the start of the linked list.
        public void insertAtHead(char data)
        {
            Node n = new Node(data);
            if (head == null) {
                head = n;
                return;
            }
            n.next = head;
            head.prev = n;
            head = n;
        }

        // Function to insert nodes at the tail of the linked list.
        public void insertAtTail(char data)
        {
            if (head == null) {
                insertAtHead(data);
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node n = new Node(data);
            temp.next = n;
            n.prev = temp;
        }

        // Function to print the list.
        public void display()
        {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + "-->");
                curr = curr.next;
            }
            System.out.print("NULL\n\n");
        }

        // Function to rotate doubly linked list by N nodes.
        public void rotateByN(int pos)
        {
            if (pos == 0) {
                return;
            }
            Node curr = head;
            while (pos != 0) {
                curr = curr.next;
                pos--;
            }
            Node tail = curr.prev;
            Node NewHead = curr;
            tail.next = null;
            curr.prev = null;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = head;
            head.prev = curr;
            head = NewHead;
        }

        public static void main_2(String[] args)
        {
            GFG_2 list = new GFG_2();

            list.insertAtTail('a');
            list.insertAtTail('b');
            list.insertAtTail('c');
            list.insertAtTail('d');
            list.insertAtTail('e');

            int n = 2;
            System.out.print("Before Rotation : \n");
            list.display();

            list.rotateByN(n);
            System.out.print("After Rotation : \n");
            list.display();
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a doubly-linked list, rotate the linked list counter-clockwise by N nodes.
                 Here N is a given positive integer and is smaller than the count of nodes in linked list.


             Example :
             Input   : a  b  c  d  e,   N = 2
             Output  : c  d  e  a  b

            Example  :
            Input    : a  b  c  d  e  f  g  h,   N = 4
            Output   : e  f  g  h  a  b  c  d
         *
        * */
    }



}
