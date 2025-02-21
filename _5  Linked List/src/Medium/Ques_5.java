package Medium;

public class Ques_5 {

    //Ques : Flatten a multilevel linked list.........                                   (GFG Ques.)


    //Approach 1 :  Recursive Solution......                                             T.C. = O(n),  S.C. = O(1)
    // Java program to flatten linked list with next and child pointers

    static class LinkedList {
        static Node head;
        class Node {
            int data;
            Node next, child;
            Node(int d) {
                data = d;
                next = child = null;
            }
        }

        /*
         A utility function to create a linked list with n nodes.
         The data of nodes is taken from arr[].  All child pointers are set as NULL
        */
        Node createList(int arr[], int n) {
            Node node = null;
            Node p = null;

            int i;
            for (i = 0; i < n; ++i) {
                if (node == null) {
                    node = p = new Node(arr[i]);
                } else {
                    p.next = new Node(arr[i]);
                    p = p.next;
                }
                p.next = p.child = null;
            }
            return node;
        }

        // A utility function to print all nodes of a linked list
        void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println("");
        }

        Node createList() {
            int arr1[] = new int[]{10, 5, 12, 7, 11};
            int arr2[] = new int[]{4, 20, 13};
            int arr3[] = new int[]{17, 6};
            int arr4[] = new int[]{9, 8};
            int arr5[] = new int[]{19, 15};
            int arr6[] = new int[]{2};
            int arr7[] = new int[]{16};
            int arr8[] = new int[]{3};

            /* create 8 linked lists */
            Node head1 = createList(arr1, arr1.length);
            Node head2 = createList(arr2, arr2.length);
            Node head3 = createList(arr3, arr3.length);
            Node head4 = createList(arr4, arr4.length);
            Node head5 = createList(arr5, arr5.length);
            Node head6 = createList(arr6, arr6.length);
            Node head7 = createList(arr7, arr7.length);
            Node head8 = createList(arr8, arr8.length);

            /* modify child pointers to create the list shown above */
            head1.child = head2;
            head1.next.next.next.child = head3;
            head3.child = head4;
            head4.child = head5;
            head2.next.child = head6;
            head2.next.next.child = head7;
            head7.child = head8;

            /* Return head pointer of first linked list.  Note that all nodes are  reachable from head1 */
            return head1;
        }

        /* The main function that flattens a multilevel linked list */
        void flattenList(Node node) {

            /*Base case*/
            if (node == null) {
                return;
            }

            Node tmp = null;

            /* Find tail node of first level linked list */
            Node tail = node;
            while (tail.next != null) {
                tail = tail.next;
            }

            // One by one traverse through all nodes of first level linked list till we reach the tail node
            Node cur = node;
            while (cur != tail) {

                // If current node has a child
                if (cur.child != null) {

                    // then append the child at the end of current list
                    tail.next = cur.child;

                    // and update the tail to new last node
                    tmp = cur.child;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tail = tmp;
                }

                // Change current node
                cur = cur.next;
            }
        }

        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            head = list.createList();
            list.flattenList(head);
            list.printList(head);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a linked list where in addition to the next pointer, each node has a child pointer,
                 which may or may not point to a separate list. These child lists may have one or more
                 children of their own, and so on, to produce a multilevel data structure, as shown in below figure.
                 You are given the head of the first level of the list. Flatten the list so that all the nodes appear
                 in a single-level linked list. You need to flatten the list in way that all nodes at the first level
                 should come first, then nodes of second level, and so on.

                Each node is a C struct with the following definition.


                The above list should be converted to 10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15


                Follow the link for visual representation :
                Link : https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
        *
        * */
    }



}
