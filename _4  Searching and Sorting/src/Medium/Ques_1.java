package Medium;

import java.util.HashMap;
import java.util.Arrays;


public class Ques_1 {

    //Ques : Majority Element.........                                            (GFG Ques.)


    //Approach 1 : Naive Approach........                                         T.C. = O(n^2),     S.C. = O(1)
    /*  The basic solution is to have two loops and keep track of the maximum count for all different elements.
        If the maximum count becomes greater than n/2 then break the loops and return the element having
        the maximum count.
        If the maximum count does not become more than n/2 then the majority element does not exist.

        * Follow the steps below to solve the given problem :

           1. Create a variable to store the max count, count = 0
           2. Traverse through the array from start to end.
           3. For every element in the array run another loop to find the count of similar elements in the given array.
           4. If the count is greater than the max count update the max count and store the index in another variable.
           5. If the maximum count is greater than half the size of the array, print the element.
              Else print there is no majority element.


    * */
    // Java program to find Majority element in an array
    class GFG {

        // Function to find Majority element in an array
        static void findMajority(int arr[], int n)
        {
            int maxCount = 0;
            int index = -1; // sentinels
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j])
                        count++;
                }

                // update maxCount if count of current element is greater
                if (count > maxCount) {
                    maxCount = count;
                    index = i;
                }
            }

            // if maxCount is greater than n/2 return the corresponding element
            if (maxCount > n / 2)
                System.out.println(arr[index]);

            else
                System.out.println("No Majority Element");
        }

        // Driver code
        public static void main_1(String[] args)
        {

            int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
            int n = arr.length;

            // Function calling
            findMajority(arr, n);
        }
    }




    //Approach 2 : By using Binary Search Tree.......                            T.C. = O(n^2),     S.C. = O(1)
    /*  Insert elements in BST one by one and if an element is already present then
        increment the count of the node. At any stage, if the count of a node becomes
        more than n/2 then return.

        Illustration:
        Follow the steps below to solve the given problem:

        * Create a binary search tree, if the same element is entered in the binary search tree
          the frequency of the node is increased.
        * traverse the array and insert the element in the binary search tree.
        * If the maximum frequency of any node is greater than half the size of the array,
          then perform an inorder traversal and find the node with a frequency greater than half
        * Else print No majority Element.

    * */
    // Java program to demonstrate insert operation in binary search tree.
    static class Node{
        int key;
        int c = 0;
        Node left,right;
    }
    class GFG_2{
        static int ma = 0;

        // A utility function to create a new BST node
        static Node newNode(int item)
        {
            Node temp = new Node();
            temp.key = item;
            temp.c = 1;
            temp.left = temp.right = null;
            return temp;
        }

        // A utility function to insert a new node with given key in BST
        static Node insert(Node node, int key)
        {
            // If the tree is empty, return a new node
            if (node == null)
            {
                if (ma == 0)
                    ma = 1;

                return newNode(key);
            }

            // Otherwise, recur down the tree
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);
            else
                node.c++;

            // Find the max count
            ma = Math.max(ma, node.c);

            // Return the (unchanged) node pointer
            return node;
        }

        // A utility function to do inorder traversal of BST
        static void inorder(Node root, int s)
        {
            if (root != null)
            {
                inorder(root.left, s);

                if (root.c > (s / 2))
                    System.out.println(root.key + "\n");

                inorder(root.right, s);
            }
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int a[] = { 1, 3, 3, 3, 2 };
            int size = a.length;
            Node root = null;

            for(int i = 0; i < size; i++)
            {
                root = insert(root, a[i]);
            }

            // Function call
            if (ma > (size / 2))
                inorder(root, size);
            else
                System.out.println("No majority element\n");
        }
    }

    //If Self-Balancing Binary Search Tree is used then T.C. = O(nlog(n))




    //Approach 3 : Majority Element By Using Moore’s Voting Algorithm.....     T.C. = O(n),     S.C. = O(1)
    /*  This is a two-step process :

        1. The first step gives the element that may be the majority element in the array.
           If there is a majority element in an array, then this step will definitely
           return majority element, otherwise, it will return candidate for majority element.
        2. Check if the element obtained from the above step is the majority element.
           This step is necessary as there might be no majority element.


        * Follow the steps below to solve the given problem :

           1. Loop through each element and maintains a count of the majority element,
              and a majority index, maj_index
           2. If the next element is the same then increment the count if the next element is not
              the same then decrement the count.
           3. if the count reaches 0 then change the maj_index to the current element and set the count again to 1.
           4. Now again traverse through the array and find the count of the majority element found.
           5. If the count is greater than half the size of the array, print the element
           6. Else print that there is no majority element

    *
    * */
    // Program for finding out majority element in an array
    static class MajorityElement {
        /* Function to print Majority Element */
        void printMajority(int a[], int size)
        {
            /* Find the candidate for Majority*/
            int cand = findCandidate(a, size);

            /* Print the candidate if it is Majority*/
            if (isMajority(a, size, cand))
                System.out.println(" " + cand + " ");
            else
                System.out.println("No Majority Element");
        }

        /* Function to find the candidate for Majority */
        int findCandidate(int a[], int size)
        {
            int maj_index = 0;
            int count = 1;
            int i;
            for (i = 1; i < size; i++) {
                if (a[maj_index] == a[i])
                    count++;
                else
                    count--;
                if (count == 0) {
                    maj_index = i;
                    count = 1;
                }
            }
            return a[maj_index];
        }

        /* Function to check if the candidate occurs more than n/2 times */
        boolean isMajority(int a[], int size, int cand)
        {
            int i;
            int count = 0;
            for (i = 0; i < size; i++) {
                if (a[i] == cand)
                    count++;
            }
            if (count > size / 2)
                return true;
            else
                return false;
        }

        /* Driver code */
        public static void main_3(String[] args)
        {
            MajorityElement majorelement = new MajorityElement();
            int a[] = new int[] { 1, 3, 3, 1, 2 };

            // Function call
            int size = a.length;
            majorelement.printMajority(a, size);
        }
    }




    //Approach 4 : Majority Element Using Hashing........                     T.C. = O(n),     S.C. = O(n)
    /*  In Hashtable(key-value pair), at value, maintain a count for each element(key), and whenever
        the count is greater than half of the array length, return that key(majority element).

        Illustration:
        arr[] = {3, 4, 3, 2, 4, 4, 4, 4}, n = 8

        Create a hashtable for the array

            3 -> 2
            4 -> 5
            2 -> 1

            Now traverse the hashtable

            Count for 3 is 2, which is less than n/2 (4) therefore it can’t be the majority element.
            Count for 4 is 5, which is greater than n/2 (4) therefore 4 is the majority element.
            Hence, 4 is the majority element.

        # Follow the steps below to solve the given problem:

            1. Create a hashmap to store a key-value pair, i.e. element-frequency pair.
            2. Traverse the array from start to end.
            3. For every element in the array, insert the element in the hashmap if the element
               does not exist as a key, else fetch the value of the key ( array[i] ), and increase the value by 1
            4. If the count is greater than half then print the majority element and break.
            5. If no majority element is found print “No Majority element”

    *
    * */
    /* Program for finding out majority element in an array */
    static class MajorityElement_2 {
        private static void findMajority(int[] arr)
        {
            HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

            for(int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    int count = map.get(arr[i]) +1;
                    if (count > arr.length /2) {
                        System.out.println("Majority found :- " + arr[i]);
                        return;
                    } else
                        map.put(arr[i], count);

                }
                else
                    map.put(arr[i],1);
            }
            System.out.println(" No Majority element");
        }


        /* Driver program to test the above functions */
        public static void main_4(String[] args)
        {
            int a[] = new int[]{2,2,2,2,5,5,2,3,3};

            findMajority(a);
        }
    }




    //Approach 5 : Majority Element by using Sorting......                   T.C. = O(nlog(n)),     S.C. = O(1)
    /*  The idea is to sort the array. Sorting makes similar elements in the array adjacent,
        so traverse the array and update the count until the present element is similar
        to the previous one. If the frequency is more than half the size of the array, print the majority element.

            Illustration:

            arr[] = {3, 4, 3, 2, 4, 4, 4, 4}, n = 8

            Array after sorting => arr[] = {2, 3, 3, 4, 4, 4, 4, 4}, count = 1

            At i = 1:

            arr[i] != arr[i – 1] => arr[1] != arr[0]
            count is not greater than n/2, therefore reinitialise count with, count = 1
            At i = 2:

            arr[i] == arr[i – 1] => arr[2] == arr[1] = 3
            count = count + 1 = 1 + 1 = 2
            At i = 3

            arr[i] != arr[i – 1] => arr[3] != arr[2]
            count is not greater than n/2, therefore reinitialise count with, count = 1
            At i = 4

            arr[i] == arr[i – 1] => arr[4] == arr[3] = 4
            count = count + 1 = 1 + 1 = 2
            At i = 5

            arr[i] == arr[i – 1] => arr[5] == arr[4] = 4
            count = count + 1 = 2 + 1 = 3
            At i = 6

            arr[i] == arr[i – 1] => arr[6] == arr[5] = 4
            count = count + 1 = 3 + 1 = 4
            At i = 7

            arr[i] == arr[i – 1] => arr[7] == arr[6] = 4
            count = count + 1 = 4 + 1 = 5
            Therefore, the count of 4 is now greater than n/2.
            Hence, 4 is the majority element.

        # Follow the steps below to solve the given problem:

            1. Sort the array and create a variable count and previous, prev = INT_MIN.
            2. Traverse the element from start to end.
            3. If the current element is equal to the previous element increase the count.
            4. Else set the count to 1.
            5. If the count is greater than half the size of the array, print the element as the majority element and break.
            6. If no majority element is found, print “No majority element”

    *
    * */
    // Java program to find Majority element in an array
    class GFG_5{
        // Function to find Majority element in an array it returns -1
        // if there is no majority element
        public static int majorityElement(int[] arr, int n)
        {
            // Sort the array in O(nlogn)
            Arrays.sort(arr);

            int count = 1, max_ele = -1,
                    temp = arr[0], ele = 0,
                    f = 0;

            for(int i = 1; i <= n; i++)
            {

                // Increases the count if the same element occurs otherwise starts counting new element
                if (temp == arr[i])
                {
                    count++;
                }
                else
                {
                    count = 1;
                    temp = arr[i];
                }

                // Sets maximum count and stores maximum occurred element so far
                // if maximum count becomes greater than n/2 it breaks out setting the flag
                if (max_ele < count)
                {
                    max_ele = count;
                    ele = arr[i];

                    if (max_ele > (n / 2))
                    {
                        f = 1;
                        break;
                    }
                }
            }

            // Returns maximum occurred element if there is no such element, returns -1
            return (f == 1 ? ele : -1);
        }

        // Driver code
        public static void main_5(String[] args)
        {
            int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
            int n = 7;

            System.out.println(majorityElement(arr, n));
        }
    }




    public static void main(String[] args) {

        /*Ques : Find the majority element in the array. A majority element in an array A[] of size n
                 is an element that appears more than n/2 times (and hence there is at most one such element).


            Example : 1
            Input   : {3, 3, 4, 2, 4, 4, 2, 4, 4}
            Output  : 4
            Explanation : The frequency of 4 is 5 which is greater than the half of the size of the array size.


            Example : 2
            Input   : {3, 3, 4, 2, 4, 4, 2, 4}
            Output  : No Majority Element
            Explanation : There is no element whose frequency is greater than the half of the size of the array size.


        *
        * */
    }


}
