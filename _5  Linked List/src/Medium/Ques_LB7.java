package Medium;

import java.util.HashMap;

public class Ques_LB7 {

    //Ques : Count triplets in a sorted doubly linked list whose sum is equal to a given value x.......    (GFG Ques.)


    //Approach 1 : Naive Approach......                                                                    T.C. = O(n^3),  S.C. = O(1)
    /*  Method 1 : (Naive Approach)
            Using three nested loops generate all triplets and check whether elements in the triplet sum up to x or not.
    * */
    // Java implementation to count triplets in a sorted doubly linked list :
    // whose sum is equal to a given value 'x'

    // Represents node of a doubly linked list
    static class Node {
        int data;
        Node prev, next;
        Node(int val) {
            data = val;
            prev = null;
            next = null;
        }
    }
    class GFG_1 {

        // function to count triplets in a sorted doubly linked list
        // whose sum is equal to a given value 'x'
        static int countTriplets(Node head, int x)
        {
            Node ptr1, ptr2, ptr3;
            int count = 0;

            // generate all possible triplets
            for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) {
                for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {
                    for (ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next) {

                        // if elements in the current triplet sum up to 'x'
                        if ((ptr1.data + ptr2.data + ptr3.data) == x)

                            // increment count
                            count++;
                    }
                }
            }
            // required count of triplets
            return count;
        }

        // A utility function to insert a new node at the beginning of doubly linked list
        static Node insert(Node head, int val)
        {
            // allocate node
            Node temp = new Node(val);

            if (head == null)
                head = temp;

            else
            {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }

            return head;
        }

        // Driver code
        public static void main_1(String args[])
        {
            // start with an empty doubly linked list
            Node head = null;

            // insert values in sorted order
            head  =  insert(head, 9);
            head  =  insert(head, 8);
            head  =  insert(head, 6);
            head  =  insert(head, 5);
            head  =  insert(head, 4);
            head  =  insert(head, 2);
            head  =  insert(head, 1);

            int x = 17;
            System.out.println("count = " + countTriplets(head, x));
        }
    }



    //Approach 2 : By using Hashing.........                                                              T.C. = O(n^2), S.C. = O(n)
    /*  Method 2 (Hashing) :
            Create a hash table with (key, value) tuples represented as (node data, node pointer) tuples.
            Traverse the doubly linked list and store each node’s data and its pointer pair(tuple)
            in the hash table. Now, generate each possible pair of nodes. For each pair of nodes,
            calculate the p_sum(sum of data in the two nodes) and check whether (x-p_sum) exists
            in the hash table or not. If it exists, then also verify that the two nodes in the pair
            are not same to the node associated with (x-p_sum) in the hash table and finally increment count.
            Return (count / 3) as each triplet is counted 3 times in the above process.
    * */
    // Java implementation to count triplets in a sorted doubly linked list
    // whose sum is equal to a given value 'x'
    class GFG_2 {
        // structure of node of doubly linked list
        static class Node {
            int data;
            Node next, prev;
            Node(int val) {
                data = val;
                prev = null;
                next = null;
            }
        }

        // function to count triplets in a sorted doubly linked list
        // whose sum is equal to a given value 'x'
        static int countTriplets(Node head, int x)
        {
            Node ptr, ptr1, ptr2;
            int count = 0;

            // unordered_map 'um' implemented as hash table
            HashMap<Integer,Node> map = new HashMap<Integer,Node>();

            // insert the <node data, node pointer> tuple in 'um'
            for (ptr = head; ptr != null; ptr = ptr.next)
                map.put(ptr.data, ptr);

            // generate all possible pairs
            for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next)
                for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {

                    // p_sum - sum of elements in the current pair
                    int p_sum = ptr1.data + ptr2.data;

                    // if 'x-p_sum' is present in 'um' and either of the two nodes
                    // are not equal to the 'um[x-p_sum]' node
                    if (map.containsKey(x - p_sum)    &&   map.get(x - p_sum) != ptr1    &&   map.get(x - p_sum) != ptr2)

                        // increment count
                        count++;
                }

            // Required count of triplets division by 3 as each triplet is counted 3 times
            return (count / 3);
        }

        // A utility function to insert a new node at the beginning of doubly linked list
        static Node insert(Node head, int val)
        {
            // allocate node
            Node temp = new Node(val);

            if (head == null)
                head = temp;

            else
            {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }

            return head;
        }

        // Driver program to test above
        public static void main_2(String[] args)
        {
            // start with an empty doubly linked list
            Node head = null;

            // insert values in sorted order
            head = insert(head, 9);
            head = insert(head, 8);
            head = insert(head, 6);
            head = insert(head, 5);
            head = insert(head, 4);
            head = insert(head, 2);
            head = insert(head, 1);

            int x = 17;

            System.out.print("Count = " + countTriplets(head, x));
        }
    }



    //Approach 3 : Two-Pointer approach...... (Efficient approach....)                                    T.C. = O(n^2),  S.C. = O(1)
    /*  Method 3 : Efficient Approach(Use of two pointers)...
            Traverse the doubly linked list from left to right. For each current node during the traversal,
            initialize two pointers first = pointer to the node next to the current node and last = pointer
            to the last node of the list. Now, count pairs in the list from first to last pointer
            that sum up to value (x – current node’s data) (algorithm described in this post).
            Add this count to the total_count of triplets. Pointer to the last node can be found only once in the beginning.


    * */
    // Java implementation to count triplets in a sorted doubly linked list
    // whose sum is equal to a given value 'x'
    class GFG_3 {

        // structure of node of doubly linked list
        static class Node {
            int data;
            Node next, prev;
        }

        // function to count pairs whose sum equal to given 'value'
        static int countPairs(Node first, Node second, int value)
        {
            int count = 0;

            // The loop terminates when either of two pointers become null,
            // or they cross each other (second.next == first), or they become same (first == second)
            while (first != null   &&   second != null    &&    first != second     &&    second.next != first) {

                // pair found
                if ((first.data + second.data) == value) {

                    // increment count
                    count++;

                    // move first in forward direction
                    first = first.next;

                    // move second in backward direction
                    second = second.prev;
                }

                // if sum is greater than 'value' move second in backward direction
                else if ((first.data + second.data) > value)
                    second = second.prev;

                    // else move first in forward direction
                else
                    first = first.next;
            }

            // required count of pairs
            return count;
        }

        // function to count triplets in a sorted doubly linked list
        // whose sum is equal to a given value 'x'
        static int countTriplets(Node head, int x)
        {
            // if list is empty
            if (head == null)
                return 0;

            Node current, first, last;
            int count = 0;

            // get pointer to the last node of the doubly linked list
            last = head;
            while (last.next != null)
                last = last.next;

            // traversing the doubly linked list
            for (current = head; current != null; current = current.next) {

                // for each current node
                first = current.next;

                // count pairs with sum(x - current.data) in the range first to last
                // and add it to the 'count' of triplets
                count += countPairs(first, last, x - current.data);
            }

            // required count of triplets
            return count;
        }

        // A utility function to insert a new node at the beginning of doubly linked list
        static Node insert(Node head, int data)
        {
            // allocate node
            Node temp = new Node();

            // put in the data
            temp.data = data;
            temp.next = temp.prev = null;

            if ((head) == null)
                (head) = temp;
            else {
                temp.next = head;
                (head).prev = temp;
                (head) = temp;
            }
            return head;
        }

        // Driver program to test above
        public static void main_3(String[] args)
        {
            // start with an empty doubly linked list
            Node head = null;

            // insert values in sorted order
            head = insert(head, 9);
            head = insert(head, 8);
            head = insert(head, 6);
            head = insert(head, 5);
            head = insert(head, 4);
            head = insert(head, 2);
            head = insert(head, 1);

            int x = 17;

            System.out.print("Count = " + countTriplets(head, x));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x.
                 Count triplets in the list that sum up to a given value x.

            Examples :

            Follow the link for visual representation of example...
            Link : https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/

        * */
    }



}
