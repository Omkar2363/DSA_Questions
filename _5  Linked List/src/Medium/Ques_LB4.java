package Medium;

public class Ques_LB4 {

    //Ques : Merge Sort for Linked List......... (Very Important...)                       (GFG Ques.)

    //Approach 1 :                                                                         T.C. = O(nlog(n)),  S.C. = O(n)
    // Java program to illustrate merge sorted of linkedList
    static class linkedList_1 {
        node head = null;
        // node a, b;
        static class node {
            int val;
            node next;
            public node(int val) {
                this.val = val;
            }
        }
        node sortedMerge(node a, node b)
        {
            node result = null;
            /* Base cases */
            if (a == null)
                return b;
            if (b == null)
                return a;

            /* Pick either a or b, and recur */
            if (a.val <= b.val) {
                result = a;
                result.next = sortedMerge(a.next, b);
            }
            else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            return result;
        }

        node mergeSort(node h)
        {
            // Base case : if head is null
            if (h == null || h.next == null) {
                return h;
            }

            // get the middle of the list
            node middle = getMiddle(h);
            node nextofmiddle = middle.next;

            // set the next of middle node to null
            middle.next = null;

            // Apply mergeSort on left list
            node left = mergeSort(h);

            // Apply mergeSort on right list
            node right = mergeSort(nextofmiddle);

            // Merge the left and right lists
            node sortedlist = sortedMerge(left, right);
            return sortedlist;
        }

        // Utility function to get the middle of the linked list
        public static node getMiddle(node head)
        {
            if (head == null)
                return head;

            node slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        void push(int new_data)
        {
            /* allocate node */
            node new_node = new node(new_data);

            /* link the old list off the new node */
            new_node.next = head;

            /* move the head to point to the new node */
            head = new_node;
        }

        // Utility function to print the linked list
        void printList(node headref)
        {
            while (headref != null) {
                System.out.print(headref.val + " ");
                headref = headref.next;
            }
        }

        public static void main_1(String[] args)
        {

            linkedList_1 li = new linkedList_1();
            /* Let us create an unsorted linked list to test the functions
             * Created list shall be a  :  2->3->20->5->10->15
             */
            li.push(15);
            li.push(10);
            li.push(5);
            li.push(20);
            li.push(3);
            li.push(2);

            // Apply, merge Sort
            li.head = li.mergeSort(li.head);
            System.out.print("\n Sorted Linked List is: \n");
            li.printList(li.head);
        }
    }



    //Approach 2 : Space Optimized approach.......                                        T.C. = O(nlog(n)),   S.C. = O(log(n))
    // Node Class
    static class Node {
        int data;
        Node next;
        Node(int key)
        {
            this.data = key;
            next = null;
        }
    }
    class GFG {

        // Function to merge sort
        static Node mergeSort(Node head)
        {
            if (head.next == null)
                return head;

            Node mid = findMid(head);
            Node head2 = mid.next;
            mid.next = null;
            Node newHead1 = mergeSort(head);
            Node newHead2 = mergeSort(head2);
            Node finalHead = merge(newHead1, newHead2);

            return finalHead;
        }

        // Function to merge two linked lists
        static Node merge(Node head1, Node head2)
        {
            Node merged = new Node(-1);
            Node temp = merged;

            // While head1 is not null and head2
            // is not null
            while (head1 != null && head2 != null) {
                if (head1.data < head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                }
                else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;
            }

            // While head1 is not null
            while (head1 != null) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }

            // While head2 is not null
            while (head2 != null) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return merged.next;
        }

        // Find mid using The Tortoise and The Hare approach
        static Node findMid(Node head)
        {
            Node slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Function to print list
        static void printList(Node head)
        {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            Node head = new Node(7);
            Node temp = head;
            temp.next = new Node(10);
            temp = temp.next;
            temp.next = new Node(5);
            temp = temp.next;
            temp.next = new Node(20);
            temp = temp.next;
            temp.next = new Node(3);
            temp = temp.next;
            temp.next = new Node(2);
            temp = temp.next;

            // Apply, merge Sort
            head = mergeSort(head);
            System.out.print("\nSorted Linked List is: \n");
            printList(head);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list
                 using Merge Sort.

                 Note : If the length of linked list is odd, then the extra node should go in the first list while splitting.


            Example : 1
            Input   : N = 5
                      value[]  = {3,5,2,4,1}
            Output  : 1 2 3 4 5
            Explanation : After sorting the given linked list, the resultant matrix will be : 1->2->3->4->5.


            Example : 2
            Input   : N = 3
                      value[]  = {9,15,0}
            Output  : 0 9 15
            Explanation : After sorting the given linked list , resultant will be :   0->9->15.


            Your Task :
            For C++ and Python : The task is to complete the function mergeSort() which sort the linked list using
                                 merge sort function.
            For Java : The task is to complete the function mergeSort() and return the node which
                       can be used to print the sorted linked list.

            Expected Time Complexity  : O(N*Log(N))
            Expected Auxiliary Space  : O(N)


        *
        * */
    }



}
