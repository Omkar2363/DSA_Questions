package Medium;

public class Ques_8 {

    //Ques : Segregate even and odd nodes in a Linked List........                               (GFG Ques.)

    //Approach 1 :                                                                               T.C. = O(n),  S.C. = O(1)
    /*  Method 1 :
            The idea is to get pointer to the last node of list. And then traverse the list starting from
            the head node and move the odd valued nodes from their current position to end of the list.

        Follow the steps below to implement the above idea :

          1. Get a pointer to the last node.
          2. Move all the odd nodes to the end.
                * Consider all odd nodes before the first even node and move them to end.
                * Change the head pointer to point to the first even node.
                * Consider all odd nodes after the first even node and move them to the end
    *
    */
    // Java program to segregate even and odd nodes in a Linked List
    static class LinkedList_1 {
        Node head;                                                    // head of list
        /* Linked list Node*/
        class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }

        void segregateEvenOdd()
        {
            Node end = head;
            Node prev = null;
            Node curr = head;

            /* Get pointer to last Node */
            while (end.next != null)
                end = end.next;

            Node new_end = end;

            // Consider all odd nodes before getting first even node
            while (curr.data %2 !=0 && curr != end)
            {
                new_end.next = curr;
                curr = curr.next;
                new_end.next.next = null;
                new_end = new_end.next;
            }

            // do following, steps only if there is an even node
            if (curr.data %2 ==0)
            {
                head = curr;

                // now curr points to first even node
                while (curr != end)
                {
                    if (curr.data % 2 == 0)
                    {
                        prev = curr;
                        curr = curr.next;
                    }
                    else
                    {
                        /* Break the link between prev and curr*/
                        prev.next = curr.next;

                        /* Make next of curr as null */
                        curr.next = null;

                        /*Move curr to end */
                        new_end.next = curr;

                        /*Make curr as new end of list */
                        new_end = curr;

                        /*Update curr pointer */
                        curr = prev.next;
                    }
                }
            }

            /* We have to set prev before executing rest of this code */
            else prev = curr;

            if (new_end != end && end.data %2 != 0)
            {
                prev.next = end.next;
                end.next = null;
                new_end.next = end;
            }
        }

        /*  Given a reference (pointer to pointer) to the head of a list and an int,
            push a new node on the front of the list. */
        void push(int new_data)
        {
            /* 1 & 2: Allocate the Node &  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        // Utility function to print a linked list
        void printList()
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }


        /* Driver program to test above functions */
        public static void main_1(String args[])
        {
            LinkedList_1 llist = new LinkedList_1();
            llist.push(11);
            llist.push(10);
            llist.push(8);
            llist.push(6);
            llist.push(4);
            llist.push(2);
            llist.push(0);
            System.out.println("Original Linked List");
            llist.printList();

            llist.segregateEvenOdd();

            System.out.println("Modified Linked List");
            llist.printList();
        }
    }


    //Approach 2 :                                                                              T.C. = O(n),  S.C. = O(1)
    /*  Method 2 :
            The idea is to split the linked list into two:  one containing all even nodes and the other
            containing all odd nodes. And finally, attach the odd node linked list after the even node linked list.

            To split the Linked List, traverse the original Linked List and move all odd nodes to a separate
            Linked List of all odd nodes. At the end of loop, the original list will have all the even nodes
            and the odd node list will have all the odd nodes. To keep the ordering of all nodes same,
            we must insert all the odd nodes at the end of the even node list. And to do that in constant time,
            we must keep track of last pointer in the even node list.
    * */
    // Java program to segregate even and odd nodes in a Linked List
    static class LinkedList_2 {
        Node head;                                        // head of list
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
        public void segregateEvenOdd() {

            Node evenStart = null;
            Node evenEnd = null;
            Node oddStart = null;
            Node oddEnd = null;
            Node currentNode = head;

            while(currentNode != null) {
                int element = currentNode.data;

                if(element % 2 == 0) {

                    if(evenStart == null) {
                        evenStart = currentNode;
                        evenEnd = evenStart;
                    } else {
                        evenEnd.next = currentNode;
                        evenEnd = evenEnd.next;
                    }

                } else {

                    if(oddStart == null) {
                        oddStart = currentNode;
                        oddEnd = oddStart;
                    } else {
                        oddEnd.next = currentNode;
                        oddEnd = oddEnd.next;
                    }
                }
                // Move head pointer one step in forward direction
                currentNode = currentNode.next;
            }


            if(oddStart == null || evenStart == null) {
                return;
            }

            evenEnd.next = oddStart;
            oddEnd.next = null;
            head = evenStart;
        }

        /*  Given a reference (pointer to pointer) to the head of a list and an int,
            push a new node on the front of the list. */
        void push(int new_data)
        {
            /* 1 & 2 : Allocate the Node & Put in the data */
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        // Utility function to print a linked list
        void printList()
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        /* Driver program to test above functions */
        public static void main_2(String args[])
        {
            LinkedList_2 llist = new LinkedList_2();
            llist.push(11);
            llist.push(10);
            llist.push(9);
            llist.push(6);
            llist.push(4);
            llist.push(1);
            llist.push(0);
            System.out.println("Original Linked List");
            llist.printList();

            llist.segregateEvenOdd();

            System.out.println("Modified Linked List");
            llist.printList();
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a Linked List of integers, write a function to modify the linked list such that all
                 even numbers appear before all the odd numbers in the modified linked list.

                 Also, keep the order of even and odd numbers the same.


            Example : 1
            Input   : 17->15->8->12->10->5->4->1->7->6->NULL
            Output  : 8->12->10->4->6->17->15->5->1->7->NULL

            Example : 2
            Input   : 8->12->10->5->4->1->6->NULL
            Output  : 8->12->10->4->6->5->1->NULL

            // If all numbers are even then do not change the list
            Input  : 8->12->10->NULL
            Output : 8->12->10->NULL

            // If all numbers are odd then do not change the list
            Input  : 1->3->5->7->NULL
            Output : 1->3->5->7->NULL
        *
        * */
    }


}
