package Medium;

import java.util.HashSet;

public class Ques_LB3 {

    //Ques : Intersection of two Sorted Linked Lists........                        (GFG Ques.)


    //Approach 1 : Using Dummy node......                                            T.C. = O(m+n),  S.C. = O(max(m,n))
    /* Approach :
            The idea is to use a temporary dummy node at the start of the result list.
            The pointer tail always points to the last node in the result list, so new nodes can be added easily.
            The dummy node initially gives the tail a memory space to point to. This dummy node is efficient,
            since it is only temporary, and it is allocated in the stack. The loop proceeds, removing one node
            from either ‘a’ or ‘b’ and adding it to the tail. When the given lists are traversed the result is in dummy.
            next, as the values are allocated from next node of the dummy. If both the elements are equal then remove
            both and insert the element to the tail. Else remove the smaller element among both the lists.


       * Complexity Analysis :
            Time Complexity  : O(m+n),   where m and n are number of nodes in first and second linked lists respectively.
                                         Only one traversal of the lists are needed.
            Auxiliary Space  : O(min(m, n)).
                                         The output list can store at most min(m,n) nodes .
    * */
    static class GFG_1 {

        // head nodes for pointing to 1st and 2nd linked lists
        static Node a = null, b = null;

        // dummy node for storing intersection
        static Node dummy = null;

        // tail node for keeping track of last node so that it makes easy for insertion
        static Node tail = null;

        // class --- Node
        static class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                next = null;
            }
        }

        // function for printing the list
        void printList(Node start) {
            Node p = start;
            while (p != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
            System.out.println();
        }

        // inserting elements into list
        void push(int data) {
            Node temp = new Node(data);
            if(dummy == null) {
                dummy = temp;
                tail = temp;
            }
            else {
                tail.next = temp;
                tail = temp;
            }
        }

        // function for finding intersection and adding it to dummy list
        void sortedIntersect()
        {

            // pointers for iterating
            Node p = a,q = b;
            while(p != null  &&  q != null)
            {
                if(p.data == q.data)
                {
                    // add to dummy list
                    push(p.data);
                    p = p.next;
                    q = q.next;
                }
                else if(p.data < q.data)
                    p = p.next;
                else
                    q= q.next;
            }
        }

        // Driver code
        public static void main(String args[])
        {
            GFG_1 list = new GFG_1();

            // Creating first linked list
            list.a = new Node(1);
            list.a.next = new Node(2);
            list.a.next.next = new Node(3);
            list.a.next.next.next = new Node(4);
            list.a.next.next.next.next = new Node(6);

            // Creating second linked list
            list.b = new Node(2);
            list.b.next = new Node(4);
            list.b.next.next = new Node(6);
            list.b.next.next.next = new Node(8);

            // function call for intersection
            list.sortedIntersect();

            // print required intersection
            System.out.println("Linked list containing common items of a & b");
            list.printList(dummy);
        }
    }


    //Approach 2 : Using Local reference.......                                      T.C. = O(m+n),  S.C. = O(max(m,n))
    /*  Method 2 : Using Local References.
        Approach : This solution is structurally very similar to the above, but it avoids using a dummy node
                   Instead, it maintains a struct node** pointer, lastPtrRef, that always points to
                   the last pointer of the result list. This solves the same case that the dummy node
                   did — dealing with the result list when it is empty. If the list is built at its tail,
                   either the dummy node or the struct node** “reference” strategy can be used.


        Complexity Analysis :
            Time Complexity : O(m+n),       where m and n are number of nodes in first and second linked lists respectively.
                                            Only one traversal of the lists are needed.
            Auxiliary Space : O(max(m, n)).
                                            The output list can store at most m+n nodes.

    * */
    // Java program to implement above approach
    class GFG_2 {
        // Link list node
        static class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }

        static Node sortedIntersect(Node a, Node b)
        {
            Node result = new Node(0);
            Node curr = result;

            /* Advance comparing the first nodes in both lists.
               When one or the other list runs out, we're done. */
            while (a != null && b != null) {
                if (a.data == b.data) {
                    /* found a node for the intersection */
                    curr.next = new Node(a.data);
                    curr = curr.next;

                    a = a.next;
                    b = b.next;
                }
                else if (a.data < b.data)
                    a = a.next;                             /* advance the smaller list */
                else
                    b = b.next;
            }
            result = result.next;
            return result;
        }

        /* UTILITY FUNCTIONS */
        /* Function to insert a node at the beginning of the linked list */
        static Node push(Node head_ref, int new_data)
        {
            /* Allocate node */
            Node new_node = new Node(new_data);

            /* Link the old list off the new node */
            new_node.next = head_ref;

            /* Move the head to point to the new node */
            head_ref = new_node;
            return head_ref;
        }

        /* Function to print nodes in a given linked list */
        static void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        // Driver code
        public static void main_2(String[] args)
        {

            /* Start with the empty lists */
            Node a = null;
            Node b = null;
            Node intersect = null;

            /* Let us create the first sorted linked list to test the functions
               Created linked list will be :  1->2->3->4->5->6 */
            a = push(a, 6);
            a = push(a, 5);
            a = push(a, 4);
            a = push(a, 3);
            a = push(a, 2);
            a = push(a, 1);

            /* Let us create the second sorted linked list
               Created linked list will be :  2->4->6->8 */
            b = push(b, 8);
            b = push(b, 6);
            b = push(b, 4);
            b = push(b, 2);

            /* Find the intersection two linked lists */
            intersect = sortedIntersect(a, b);

            System.out.print("\n Linked list containing " + "common items of a & b \n ");
            printList(intersect);
        }
    }



    //Approach 3 : Recursive Solution......                                          T.C. = O(n),   S.C. = O(n)
    /*  Method 3 : Recursive Solution.
        Approach :
        The recursive approach is very similar to the above two approaches. Build a recursive function that takes
        two nodes and returns a linked list node. Compare the first element of both the lists.
           * If they are similar then call the recursive function with the next node of both the lists.
             Create a node with the data of the current node and put the returned node from the recursive function
             to the next pointer of the node created. Return the node created.
           * If the values are not equal then remove the smaller node of both the lists and call the recursive function.


        Complexity Analysis  :
           * Time Complexity : O(m+n),       where m and n are number of nodes in first and second linked lists respectively.
                                             Only one traversal of the lists are needed.
           * Auxiliary Space : O(max(m, n)).
                                             The output list can store at most m+n nodes.

    * */
    static class LinkedList {
        Node head;
        static class Node {
            int data;
            Node next;
            Node(int d)  {
                data = d;
                next=null;
            }
        }
        public void printList() {
            Node n= head;
            while(n!=null) {
                System.out.println(n.data+ " ");
                n=n.next;
            }
        }
        public void append(int d)
        {
            Node n= new Node(d);
            if(head== null) {
                head= new Node(d);
                return;
            }
            n.next=null;
            Node last= head;
            while(last.next !=null) {
                last=last.next;
            }
            last.next=n;
            return;
        }
        static int[] intersection(Node tmp1, Node tmp2, int k)
        {
            int[] res = new int[k];
            HashSet<Integer> set = new HashSet<Integer>();
            while(tmp1 != null) {
                set.add(tmp1.data);
                tmp1=tmp1.next;
            }
            int cnt=0;

            while(tmp2 != null) {
                if(set.contains(tmp2.data)) {
                    res[cnt]=tmp2.data;
                    cnt++;
                }
                tmp2=tmp2.next;
            }
            return res;
        }
        public static void main_3(String[] args)
        {
            LinkedList ll = new LinkedList();
            LinkedList ll1 = new LinkedList();

            ll.append(0);
            ll.append(1);
            ll.append(2);
            ll.append(3);
            ll.append(4);
            ll.append(5);
            ll.append(6);
            ll.append(7);


            ll1.append(9);
            ll1.append(0);
            ll1.append(12);
            ll1.append(3);
            ll1.append(4);
            ll1.append(5);
            ll1.append(6);
            ll1.append(7);


            int[] arr= intersection(ll.head, ll1.head,6);

            for(int i : arr) {
                System.out.println(i);
            }
        }
    }




    public static void main(String[] args) {

        /*Ques : Given two lists sorted in increasing order, create and return a new list representing
                 the intersection of the two lists.
                 The new list should be made with its own memory — the original lists should not be changed.


            Example : 1
            Input   : First linked list     : 1->2->3->4->6
                      Second linked list be : 2->4->6->8,
            Output  : 2->4->6.
            Explanation : The elements 2, 4, 6 are common in both the list,
                          so they appear in the intersection list.

            Example : 2
            Input   : First linked list     : 1->2->3->4->5
                      Second linked list be : 2->3->4,
            Output  : 2->3->4
            Explanation : The elements 2, 3, 4 are common in both the list,
                          so they appear in the intersection list.



        * */
    }


}
