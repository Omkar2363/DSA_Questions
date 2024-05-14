package Easy;

import java.util.Stack;

public class Ques_LB4 {

    //Ques : Add two numbers represented by linked lists........                               (GFG Ques.)


    //Approach 1 :                                                                             T.C. = O(n),   S.C. = O(n)
    /*  Approach : Traverse both lists to the end and add preceding zeros in the list with lesser digits.
                   Then call a recursive function on the start nodes of both lists which calls itself for
                   the next nodes of both lists till it gets to the end. This function creates a node for
                   the sum of the current digits and returns the carry.

        The steps are :

           1. Traverse the two linked lists in order to add preceding zeros in case a list is having
              lesser digits than the other one.
           2. Start from the head node of both lists and call a recursive function for the next nodes.
           3. Continue it till the end of the lists.
           4. Creates a node for current digits sum and returns the carry.


        * Complexity Analysis  :
            * Time Complexity  : O(m + n),  where m and n are numbers of nodes in first and second lists respectively.
                                            The lists need to be traversed only once.
            * Space Complexity : O(m + n).  A temporary linked list is needed to store the output number
    * */
    // Java program to add two numbers represented by linked list
    static class LinkedList {
        static Node head1, head2;
        static class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }

        /* Adds contents of two linked lists and prints it */
        void addTwoLists(Node first, Node second) {
            Node start1 = new Node(0);
            start1.next = first;
            Node start2 = new Node(0);
            start2.next = second;

            addPrecedingZeros(start1, start2);
            Node result = new Node(0);
            if (sumTwoNodes(start1.next, start2.next, result) == 1) {
                Node node = new Node(1);
                node.next = result.next;
                result.next = node;
            }
            printList(result.next);
        }

        /* Adds lists and returns the carry */
        private int sumTwoNodes(Node first, Node second, Node result) {
            if (first == null) {
                return 0;
            }
            int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
            Node node = new Node(number % 10);
            node.next = result.next;
            result.next = node;
            return number / 10;
        }

        /* Appends preceding zeros in case a list is having lesser nodes than the other one */
        private void addPrecedingZeros(Node start1, Node start2) {
            Node next1 = start1.next;
            Node next2 = start2.next;
            while (next1 != null && next2 != null) {
                next1 = next1.next;
                next2 = next2.next;
            }
            if (next1 == null && next2 != null) {
                while (next2 != null) {
                    Node node = new Node(0);
                    node.next = start1.next;
                    start1.next = node;
                    next2 = next2.next;
                }
            } else if (next2 == null && next1 != null) {
                while (next1 != null) {
                    Node node = new Node(0);
                    node.next = start2.next;
                    start2.next = node;
                    next1 = next1.next;
                }
            }
        }

        /* Utility function to print a linked list */
        void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println("");
        }

        // Driver Code
        public static void main(String[] args) {
            LinkedList list = new LinkedList();

            // creating first list
            list.head1 = new Node(7);
            list.head1.next = new Node(5);
            list.head1.next.next = new Node(9);
            list.head1.next.next.next = new Node(4);
            list.head1.next.next.next.next = new Node(6);
            System.out.print("First List is ");

            list.printList(head1);

            // creating second list
            list.head2 = new Node(8);
            list.head2.next = new Node(4);
            System.out.print("Second List is ");
            list.printList(head2);

            System.out.print("Resultant List is ");
            // add the two lists and see the result
            list.addTwoLists(head1, head2);
        }
    }



    //Approach 2 : By using STL....( with Stack Data Structures ).......                      T.C. = O(n),   S.C. = O(n)
    /*  Approach :
          *  Create 3 stacks namely s1,s2,s3.
          *  Fill s1 with Nodes of list1 and fill s2 with nodes of list2.
          *  Fill s3 by creating new nodes and setting the data of new nodes to the sum of s1.top(), s2.top() and carry until list1 and list2 are empty .
          *  If the sum >9
                set carry 1
          * else
                set carry 0
          *  Create a Node(say prev) that will contain the head of the sum List.
          *  Link all the elements of s3 from top to bottom
          *  return prev

    *
    * */
    // Java program to add two numbers represented by Linked Lists using Stack
    static class LinkedList_2 {
        static Node head1, head2;
        static class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }
        // function that calculates and prints the sum of two numbers represented by linked lists
        static void addTwoLists(Node l1, Node l2)
        {
            Node prev = null;
            // Create 3 stacks
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            Stack<Node> s3 = new Stack<Node>();
            // Fill first stack with first List Elements
            while (l1 != null) {
                s1.add(l1);
                l1 = l1.next;
            }
            // Fill second stack with second List Elements
            while (l2 !=null) {
                s2.add(l2);
                l2 = l2.next;
            }
            int carry = 0;
            // Fill the third stack with the sum of first and second stack
            while (!s1.isEmpty() && !s2.isEmpty()) {
                int sum = s1.peek().data + s2.peek().data + carry;
                Node temp = new Node(sum % 10);
                s3.add(temp);
                if (sum > 9) {
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                s1.pop();
                s2.pop();
            }
            while (!s1.isEmpty()) {
                int sum = carry + s1.peek().data;
                Node temp = new Node(sum % 10);
                s3.add(temp);
                if (sum > 9) {
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                s1.pop();
            }
            while (!s2.isEmpty()) {
                int sum = carry + s2.peek().data;
                Node temp = new Node(sum % 10);
                s3.add(temp);
                if (sum > 9) {
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                s2.pop();
            }
            // If carry is still present create a new node with
            // value 1 and push it to the third stack
            if (carry == 1) {
                Node temp = new Node(1);
                s3.add(temp);
            }
            // Link all the elements inside third stack with each other
            if (!s3.isEmpty())
                prev = s3.peek();

            while (!s3.isEmpty()) {
                Node temp = s3.peek();
                s3.pop();
                if (s3.size() == 0) {
                    temp.next = null;
                }
                else {
                    temp.next = s3.peek();
                }
            }
            printList(prev);
        }

        /* Utility function to print a linked list */
        static void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println("");
        }

        // Driver Code
        public static void main_2(String[] args) {
            LinkedList_2 list = new LinkedList_2();

            // creating first list
            list.head1 = new Node(7);
            list.head1.next = new Node(5);
            list.head1.next.next = new Node(9);
            list.head1.next.next.next = new Node(4);
            list.head1.next.next.next.next = new Node(6);
            System.out.print("First List : ");
            list.printList(head1);

            // creating second list
            list.head2 = new Node(8);
            list.head2.next = new Node(4);
            System.out.print("Second List : ");
            list.printList(head2);

            System.out.print("Sum List : ");
            // add the two lists and see the result
            list.addTwoLists(head1, head2);
        }
    }



    //Approach 3 : Another approach.......                                                    T.C = O(n),  S.C. = O(n)
    /*  Another Approach with time complexity O(N) :

            The given approach works as following steps :
               * First, we calculate the sizes of both the linked lists, size1 and size2, respectively.
               * Then we traverse the bigger linked list, if any, and decrement till the size of both become the same.
               * Now we traverse both linked lists till the end.
               * Now the backtracking occurs while performing addition.
               * Finally, the head node is returned to the linked list containing the answer.
    *
    * */
    class GFG {
        static class Node {
            int data;
            Node next;
        }
        // recursive function
        static Node addition(Node temp1, Node temp2, int size1, int size2)
        {
            // creating a new Node
            Node newNode= new Node();

            // base case
            if (temp1!=null && temp2!=null && temp1.next == null && temp2.next == null) {

                // addition of current nodes which is the last nodes of both linked lists
                newNode.data = (temp1.data + temp2.data);

                // set this current node's link null
                newNode.next = null;

                // return the current node
                return newNode;
            }

            // creating a node that contains sum of previously added number
            Node returnedNode = new Node();

            // if sizes are same then we move in both linked list
            if ((temp1!=null && temp2!=null) && size2 == size1) {

                // recursively call the function move ahead in both linked list
                returnedNode = addition(temp1.next, temp2.next, size1 - 1, size2 - 1);

                // add the current nodes and append the carry
                newNode.data = (temp1.data + temp2.data) + ((returnedNode.data) / 10);
            }

            // or else we just move in big linked list
            else if(temp1!=null && temp2!=null){

                // recursively call the function move ahead in big linked list
                returnedNode = addition(temp1, temp2.next, size1, size2 - 1);

                // add the current node and carry
                newNode.data = (temp2.data) + ((returnedNode.data) / 10);
            }

            // this node contains previously added numbers, so we need to set only rightmost digit of it
            returnedNode.data = (returnedNode.data) % 10;

            // set the returned node to the current node
            newNode.next = returnedNode;

            // return the current node
            return newNode;
        }

        // Function to add two numbers represented by nexted list.
        static Node addTwoLists(Node head1, Node head2)
        {
            Node temp1, temp2, ans = null;

            temp1 = head1;
            temp2 = head2;

            int size1 = 0, size2 = 0;

            // calculating the size of first linked list
            while (temp1 != null) {
                temp1 = temp1.next;
                size1++;
            }
            // calculating the size of second linked list
            while (temp2 != null) {
                temp2 = temp2.next;
                size2++;
            }

            Node returnedNode = new Node();

            // traverse the bigger linked list
            if (size2 > size1) {
                returnedNode = addition(head1, head2, size1, size2);
            }
            else {
                returnedNode = addition(head2, head1, size2, size1);
            }

            // creating new node if head node is >10
            if (returnedNode.data >= 10) {
                ans = new Node();
                ans.data = (returnedNode.data) / 10;
                returnedNode.data = returnedNode.data % 10;
                ans.next = returnedNode;
            }
            else
                ans = returnedNode;

            // return the head node of linked list that contains answer
            return ans;
        }

        static void Display(Node head)
        {
            if (head == null) {
                return;
            }
            while (head.next != null) {
                System.out.print(head.data+ "->");
                head = head.next;
            }
            System.out.print(head.data +"\n");
        }
        // Function that adds element at the end of the Linked List
        static Node push(Node head_ref, int d)
        {
            Node new_node = new Node();
            new_node.data = d;
            new_node.next = null;
            if (head_ref == null) {
                new_node.next = head_ref;
                head_ref = new_node;
                return head_ref;
            }
            Node last = head_ref;
            while (last.next != null && last != null) {
                last = last.next;
            }
            last.next = new_node;
            return head_ref;
        }
        // Driver Program for above Functions
        public static void main_3(String[] args)
        {
            // Creating two lists
            Node first  = null;
            Node second = null;
            Node sum    = null;
            first  =  push(first, 7);
            first  =  push(first, 5);
            first  =  push(first, 9);
            first  =  push(first, 4);
            first  =  push(first, 6);
            second =  push(second, 8);
            second =  push(second, 4);

            System.out.print("First List : ");
            Display(first);
            System.out.print("Second List : ");
            Display(second);
            sum = addTwoLists(first, second);
            System.out.print("Sum List : ");
            Display(sum);
        }
    }



    //Approach 4 :                                                                           T.C. = O(max(m,n)),  S.C. = O(1)
    /*  Another Approach with easy to understand code (without appending zeros) :
            In this approach we simulate how in reality we add two numbers. In the code we have taken
            9->8->7 and 1->2->3 as two numbers to add.
            What we do is reverse these two lists to get 7->8->9 and 3->2->1 and start from the head of
            the lists to add numbers of individual nodes like we would in practice if we add two numbers.


            For example, first we add 7 and 3 to get 10, which means carry = 1 and value of new node will be 0.
                         Now we continue this till the end of the list.

        * Steps :
           1. Reverse the two number lists.
           2. Simulate addition on nodes one by one. Append each node before the already calculated sum nodes.( You will better understand this step in code)
           3.  In the end we will get the final answer, and we can return the head node.



        * Complexity Analysis :
            Time Complexity   : O(max(m,n)),  where m and n are numbers of nodes in first and second lists respectively.
                                The lists need to be traversed only once.
            Space Complexity  : O(1)
                                As constant extra space is used.

     */
    // Java program to add two numbers represented by Linked Lists by reversing lists
    static class LinkedList_4 {
        static Node head1, head2;
        static class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }
        // function to reverse the linked list and return the head of the reversed list
        static Node reverseList(Node list)
        {
            Node prev = null, curr = list, next = null;
            while (curr != null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        // function that calculates and prints the sum of two numbers represented by linked lists
        static void addTwoLists(Node first, Node second)
        {
            // code here
            first = reverseList(first);
            second = reverseList(second);

            int carry = 0;
            Node head = null, prev = null;
            Node sum = null;

            while (first != null || second != null || carry == 1)         //if any one of these is left we are still left with addition
            {
                int newVal = carry;
                if (first!=null)
                    newVal += first.data;
                if (second!=null)
                    newVal += second.data;

                carry = newVal / 10;                                    //to be used in the next node calculation
                newVal = newVal % 10;

                Node newNode = new Node(newVal);
                newNode.next = sum;                                     //appending in the beginning of the final ans list,
                                                                        // this way we do not have to reverse in the end
                sum = newNode;

                if (first!=null)                                        // initialising nodes for next iteration
                    first = first.next;
                if (second!=null)
                    second = second.next;
            }

            printList(sum);
        }

        /* Utility function to print a linked list */
        static void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println("");
        }

        // Driver Code
        public static void main_4(String[] args) {
            LinkedList_4 list = new LinkedList_4();

            // creating first list
            list.head1 = new Node(9);
            list.head1.next = new Node(8);
            list.head1.next.next = new Node(7);
            System.out.print("First List : ");
            list.printList(head1);

            // creating second list
            list.head2 = new Node(1);
            list.head2.next = new Node(2);
            list.head2.next.next = new Node(3);
            System.out.print("Second List : ");
            list.printList(head2);

            System.out.print("Sum List : ");
            // add the two lists and see the result
            list.addTwoLists(head1, head2);
        }

     }





    public static void main(String[] args) {

        /*Ques : Given two decimal numbers represented by two linked lists of size N and M respectively.
                 The task is to return a linked list that represents the sum of these two numbers.

                 For example : The number 190 will be represented by the linked list, 1->9->0->null,
                               Similarly, 25 by 2->5->null.
                               Sum of these two numbers is 190 + 25 = 215,
                               which will be represented by  2->1->5->null.

                               You are required to return the head of the linked list 2->1->5->null.


                Example : 1
                Input   : N = 2
                          valueN[] = {4,5}
                          M = 3
                          valueM[] = {3,4,5}
                Output  : 3 9 0
                Explanation : For the given two linked list (4 5) and (3 4 5),
                              after adding the two linked list resultant linked list will be (3 9 0).

                Example : 2
                Input   : N = 2
                          valueN[] = {6,3}
                          M = 1
                          valueM[] = {7}
                Output  : 7 0
                Explanation : For the given two linked list (6 3) and (7),
                              after adding the two linked list resultant linked list will be (7 0).


                Your Task :
                The task is to complete the function addTwoLists() which has node reference of both
                the linked lists and returns the head of the sum list.

                Expected Time Complexity : O(N+M)
                Expected Auxiliary Space : O(Max(N,M))  for the resultant list.


        * */
    }



}
