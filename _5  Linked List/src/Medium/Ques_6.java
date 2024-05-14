package Medium;

public class Ques_6 {

    //Ques : Rearrange a Linked List in Zig-Zag fashion........                       (GFG Ques.)


    //Approach 1 : Simple  approach......
    /*  A simple approach to do this is to sort the linked list using merge sort and then swap alternate,
        but that requires O(n Log n) time complexity. Here n is a number of elements in the linked list.

     * */



    //Approach 2 :
    /*  An efficient approach that requires O(n) time is, using a single scan similar to bubble sort and
        then maintain a flag for representing which order () currently we are.
        If the current two elements are not in that order then swap those elements otherwise not.
        Please refer to this for a detailed explanation of the swapping order.

    * */
    // Java program to arrange linked list in zigzag fashion
    class GfG {
        /* Link list Node */
        static class Node {
            int data;
            Node next;
        }
        static Node head = null;
        static int temp = 0;

        // This function distributes the Node in zigzag fashion
        static void zigZagList(Node head)
        {
            // If flag is true, then next node should be greater in the desired output.
            boolean flag = true;

            // Traverse linked list starting from head.
            Node current = head;
            while (current != null && current.next != null) {
                if (flag == true) /* "<" relation expected */
                {
                    /* If we have a situation like A > B > C
                       where A, B and C are consecutive Nodes in list we get A > B < C by swapping B and C */
                    if (current.data > current.next.data) {
                        temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;
                    }
                }
                else                                              /* ">" relation expected */
                {
                    /* If we have a situation like A < B < C
                       where  A, B and C are consecutive Nodes in list we get A < C > B by swapping B and C */
                    if (current.data < current.next.data) {
                        temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;
                    }
                }

                current = current.next;

                /* flip flag for reverse checking */
                flag = !(flag);
            }
        }

        /* UTILITY FUNCTIONS */
        /* Function to push a Node */
        static void push(int new_data)
        {
            /* allocate Node */
            Node new_Node = new Node();

            /* put in the data */
            new_Node.data = new_data;

            /* link the old list off the new Node */
            new_Node.next = (head);

            /* move the head to point to the new Node */
            (head) = new_Node;
        }

        /* Function to print linked list */
        static void printList(Node Node)
        {
            while (Node != null) {
                System.out.print(Node.data + "->");
                Node = Node.next;
            }
            System.out.println("NULL");
        }

        /* Driver code*/
        public static void main(String[] args)
        {
            /* Start with the empty list */
            // Node head = null;

            // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
            // answer should be -> 3 7 4 8 2 6 1
            push(1);
            push(2);
            push(6);
            push(8);
            push(7);
            push(3);
            push(4);

            System.out.println("Given linked list ");
            printList(head);

            zigZagList(head);

            System.out.println("Zig Zag Linked list ");
            printList(head);
        }
    }



    //Approach 3 :
    /*  Another Approach :
            In the above code, the push function pushes the node at the front of the linked list,
            the code can be easily modified for pushing the node at the end of the list.
            Another thing to note is, swapping of data between two nodes is done by swap by value not swap
            by links for simplicity, for the swap by links technique please see this.

            This can be also be done recursively. The idea remains the same, let us suppose the value of
            the flag determines the condition we need to check for comparing the current element.
            So, if the flag is 0 (or false) the current element should be smaller than the next and
            if the flag is 1 ( or true ) then the current element should be greater than the next.
            If not, swap the values of nodes.
    * */
    // Java program for the above approach
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    static class GFG_3 {
        private Node head;
        // Print Linked List
        public void printLL()
        {
            Node t = head;
            while (t != null) {
                System.out.print(t.data + " ->");
                t = t.next;
            }
            System.out.println();
        }

        // Swap both nodes
        public void swap(Node a, Node b)
        {
            if (a == null || b == null)
                return;
            int temp = a.data;
            a.data = b.data;
            b.data = temp;
        }

        // Rearrange the linked list in zig-zag way
        public Node zigZag(Node node, int flag)
        {
            if (node == null || node.next == null) {
                return node;
            }
            if (flag == 0) {
                if (node.data > node.next.data) {
                    swap(node, node.next);
                }
                return zigZag(node.next, 1);
            }
            else {
                if (node.data < node.next.data) {
                    swap(node, node.next);
                }
                return zigZag(node.next, 0);
            }
        }

        // Driver Code
        public static void main(String[] args)
        {
            GFG_3 lobj = new GFG_3();
            lobj.head = new Node(11);
            lobj.head.next = new Node(15);
            lobj.head.next.next = new Node(20);
            lobj.head.next.next.next = new Node(5);
            lobj.head.next.next.next.next = new Node(10);
            lobj.printLL();

            // 0 means the current element should be smaller than the next
            int flag = 0;
            lobj.zigZag(lobj.head, flag);

            System.out.println("LL in zig zag fashion : ");
            lobj.printLL();
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a linked list, rearrange it such that the converted list should be of
                 the form a < b > c < d > e < f ...   where a, b, c... are consecutive data nodes of the linked list.


            Example : 1
            Input   :  1->2->3->4
            Output  : 1->3->2->4
            Explanation : 1 and 3 should come first before 2 and 4 in zig-zag fashion, So resultant
                          linked-list will be 1->3->2->4.

            Example : 2
            Input   :  11->15->20->5->10
            Output  : 11->20->5->15->10
        *
        * */
    }



}
