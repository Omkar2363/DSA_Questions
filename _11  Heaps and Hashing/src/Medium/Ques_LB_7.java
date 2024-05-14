package Medium;

public class Ques_LB_7 {

    //Ques : Merge K sorted linked lists..........                                       (GFG Ques.)


    //Approach 1 : Naive Approach......
    /*  Naive Approach :
            A Simple Solution is to initialize the result as the first list. Now traverse all lists starting
            from the second list. Insert every node of the currently traversed list into the result in a sorted way.
    *
    * */
    // Java program to merge k sorted arrays of size n each
    // A Linked List node
    static class Node {
        int data;
        Node next;
        // Utility function to create a new node.
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    class GFG {

        static Node head;
        static Node temp;

        /* Function to print nodes in a given linked list */
        static void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");

                node = node.next;
            }
            System.out.println();
        }

        // The main function that takes an array of lists arr[0...last] and
        // generates the sorted output
        static Node mergeKLists(Node arr[], int last)
        {

            // Traverse form second list to last
            for (int i = 1; i <= last; i++) {
                while (true) {

                    // head of both the lists, 0 and ith list.
                    Node head_0 = arr[0];
                    Node head_i = arr[i];

                    // Break if list ended
                    if (head_i == null)
                        break;

                    // Smaller than first element
                    if (head_0.data >= head_i.data) {
                        arr[i] = head_i.next;
                        head_i.next = head_0;
                        arr[0] = head_i;
                    }
                    else {

                        // Traverse the first list
                        while (head_0.next != null) {

                            // Smaller than next element
                            if (head_0.next.data >= head_i.data) {
                                arr[i] = head_i.next;
                                head_i.next = head_0.next;
                                head_0.next = head_i;
                                break;
                            }

                            // go to next node
                            head_0 = head_0.next;

                            // if last node
                            if (head_0.next == null) {
                                arr[i] = head_i.next;
                                head_i.next = null;
                                head_0.next = head_i;
                                head_0.next.next = null;
                                break;
                            }
                        }
                    }
                }
            }
            return arr[0];
        }

        // Driver program to test above functions
        public static void main_1(String[] args)
        {
            // Number of linked lists
            int k = 3;

            // Number of elements in each list
            int n = 4;

            // an array of pointers storing the head nodes of the linked lists

            Node[] arr = new Node[k];

            arr[0] = new Node(1);
            arr[0].next = new Node(3);
            arr[0].next.next = new Node(5);
            arr[0].next.next.next = new Node(7);

            arr[1] = new Node(2);
            arr[1].next = new Node(4);
            arr[1].next.next = new Node(6);
            arr[1].next.next.next = new Node(8);

            arr[2] = new Node(0);
            arr[2].next = new Node(9);
            arr[2].next.next = new Node(10);
            arr[2].next.next.next = new Node(11);

            // Merge all lists
            head = mergeKLists(arr, k - 1);
            printList(head);
        }
    }


    /*  Time complexity : O(N^(K-1)), Traversing N times on each of the K lists.
        Auxiliary Space : O(1).
    *
    * */




    //Approach 2 : By Using Min Heap.......
    /*  Merge K sorted linked lists using Min Heap :
            This solution is based on the Min Heap approach. The process must start with creating a MinHeap and
            inserting the first element of all the K Linked Lists. Remove the root element of Minheap and put it
            in the output Linked List and insert the next element from the Linked List of the removed element.
            To get the result the step must continue until there is no element left in the MinHeap.

            For a more detailed solution and code checkout, this article Merge k sorted linked lists | Set 2 (Using Min Heap).

            Time Complexity : O(N*K*LogK)
            Auxiliary Space : O(K)
    * */



    //Approach 3 : By using Divide and Conquer Technique.......
    /*  Merge K sorted linked lists using Divide and Conquer :
            The idea is to pair up a sorted list after which K/2 list will be left to be merged and repeat
            this till all the lists gets merged.

        * Follow the steps below to solve the problem :
           1. Pair up K lists and merge each pair in linear time using O(N) space.
           2. After the first cycle, K/2 lists are left each of size 2*N. After the second cycle,
              K/4 lists are left each of size 4*N and so on.
           3. Repeat the procedure until we have only one list left.
    *
    * */
    // Java program to merge k sorted arrays of size n each
    public class MergeKSortedLists {

        static class Node {
            int data;
            Node next;
            Node(int data) { this.data = data; }
        }


        /* Takes two lists sorted in increasing order, and merge their nodes together to make one big sorted list.
           Below function takes O(Log n) extra space for recursive calls, but it can be easily modified to work
           with same time and O(1) extra space  */
        public static Node SortedMerge(Node a, Node b)
        {
            Node result = null;
            /* Base cases */
            if (a == null)
                return b;
            else if (b == null)
                return a;

            /* Pick either a or b, and recur */
            if (a.data <= b.data) {
                result = a;
                result.next = SortedMerge(a.next, b);
            }
            else {
                result = b;
                result.next = SortedMerge(a, b.next);
            }

            return result;
        }

        // The main function that takes an array of lists arr[0...last] and generates the sorted output
        public static Node mergeKLists(Node arr[], int last)
        {
            // repeat until only one list is left
            while (last != 0) {
                int i = 0, j = last;

                // (i, j) forms a pair
                while (i < j) {
                    // merge List i with List j and store merged list in List i
                    arr[i] = SortedMerge(arr[i], arr[j]);

                    // consider next pair
                    i++;
                    j--;

                    // If all pairs are merged, update last
                    if (i >= j)
                        last = j;
                }
            }

            return arr[0];
        }

        /* Function to print nodes in a given linked list */
        public static void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        public static void main_3(String args[])
        {
            int k = 3;                                       // Number of linked lists
            int n = 4;                                       // Number of elements in each list


            // an array of pointers storing the head nodes of the linked lists
            Node arr[] = new Node[k];

            arr[0] = new Node(1);
            arr[0].next = new Node(3);
            arr[0].next.next = new Node(5);
            arr[0].next.next.next = new Node(7);

            arr[1] = new Node(2);
            arr[1].next = new Node(4);
            arr[1].next.next = new Node(6);
            arr[1].next.next.next = new Node(8);

            arr[2] = new Node(0);
            arr[2].next = new Node(9);
            arr[2].next.next = new Node(10);
            arr[2].next.next.next = new Node(11);

            // Merge all lists
            Node head = mergeKLists(arr, k - 1);
            printList(head);
        }
    }




    //Approach 4 : By Selecting min of top element........
    /*  Merge K sorted linked lists by Selecting min of top element :
            The idea is to select the minimum of top elements iteratively store that in a new node and
            increment the pointer of the minimum element.

        * Follow the steps below to solve the problem :
            1. Find the node with the smallest value in all the K lists and
            2. Increment the current pointer to the next node of the list where the smallest node is found.
            3. Now make a new node and append the node to the head node of the resultant list and point the head list with this new node
            4. Repeat these steps till all nodes have been used.
    *
    * */
    //C++ Code.....
    /*  C++ program to merge k sorted arrays of size n each
        #include <bits/stdc++.h>
        using namespace std;

        // A Linked List node
        struct Node {
            int data;
            Node* next;
            Node(int x)
            {
                data = x;
                next = NULL;
            }
        };

        // Function to print nodes in a given linked list
            void printList(Node* node)
            {
                while (node != NULL) {
                    printf("%d ", node->data);
                    node = node->next;
                }
                cout << endl;
            }

        // Linked list Node structure

        struct Node {

        int data;
        Node* next;
        Node(int x){
            data = x;
            next = NULL;
        }
        };

            // Function to merge K sorted linked list.
            Node* mergeKLists(Node* arr[], int K)
            {
                Node* head = NULL;
                while (1) {
                    int a = 0;
                    int z;
                    Node* curr;
                    int min = INT_MAX;
                    for (int i = 0; i < K; i++) {
                        if (arr[i] != NULL) {
                            a++;
                            if (arr[i]->data < min) {
                                min = arr[i]->data;
                                z = i;
                            }
                        }
                    }
                    if (a != 0) {
                        arr[z] = arr[z]->next;
                        Node* temp = new Node(min);
                        if (head == NULL) {
                            head = temp;
                            curr = temp;
                        }
                        else {
                            curr->next = temp;
                            curr = temp;
                        }
                    }
                    else {
                        return head;
                    }
                }
            }

        // Driver Code Starts.

            // Driver program to test above functions
            int main()
            {
                int k = 3;                        // Number of linked lists
                int n = 4;                        // Number of elements in each list

                // an array of pointers storing the head nodes of the linked lists
                Node* arr[k];

                arr[0] = new Node(1);
                arr[0]->next = new Node(3);
                arr[0]->next->next = new Node(5);
                arr[0]->next->next->next = new Node(7);

                arr[1] = new Node(2);
                arr[1]->next = new Node(4);
                arr[1]->next->next = new Node(6);
                arr[1]->next->next->next = new Node(8);

                arr[2] = new Node(0);
                arr[2]->next = new Node(9);
                arr[2]->next->next = new Node(10);
                arr[2]->next->next->next = new Node(11);

                Node* head = mergeKLists(arr, k);

                printList(head);
                return 0;
            }

    *
    * */

    /*  Time complexity : O(N*(K^2)),  There are N*K nodes in total and to find the smallest node it takes K times
                                       so for the N*K nodes it will take N*K*K time.
        Auxiliary Space : O(N)
    * */





    public static void main(String[] args) {

        /*Ques : Given K sorted linked lists of different sizes. The task is to merge them in such a way that
                 after merging they will be a single sorted linked list.


            Example : 1
            Input   : K = 4
                      value = {{1,2,3},{4 5},{5 6},{7,8}}
            Output  : 1 2 3 4 5 5 6 7 8
            Explanation : The test case has 4 sorted linked list of size 3, 2, 2, 2
                          1st    list     1 -> 2-> 3
                          2nd   list      4->5
                          3rd    list      5->6
                          4th    list      7->8

                          The merged list will be 1->2->3->4->5->5->6->7->8.

            Example : 2
            Input   : K = 3
                      value = {{1,3},{4,5,6},{8}}
            Output  : 1 3 4 5 6 8
            Explanation : The test case has 3 sorted linked list of size 2, 3, 1.
                          1st list 1 -> 3
                          2nd list 4 -> 5 -> 6
                          3rd list 8

                          The merged list will be 1->3->4->5->6->8.

            Your Task :
            The task is to complete the function mergeKList() which merges the K given lists into a sorted one.
            The printing is done automatically by the driver code.


            Expected Time Complexity : O(n*k log(k))
            Expected Auxiliary Space : O(k)

            Note : n is the maximum size of all the k link list
        *
        *
        * */
    }





}
