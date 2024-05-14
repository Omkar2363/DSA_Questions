package Medium;

import java.util.HashSet;
import java.util.Stack;

public class Ques_4 {

    //Ques : Write a function to get the intersection point of two Linked Lists........         (GFG Ques.)


    //Approach 1 :                                                                              T.C. = O(n*m),  S.C. = O(1)
    /*  Method 1(Simply use two loops):
            Use 2 nested for loops. The outer loop will be for each node of the 1st list and the inner loop
            will be for the 2nd list. In the inner loop, check if any of the nodes of the 2nd list is the same
            as the current node of the first linked list.
            The time complexity of this method will be O(M * N)  where m and n are the numbers of nodes in two lists.
    * */
    // Java Program to get intersection point of two linked lists.
    static class GFG {
        static class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }
        /* function to get the intersection point of two linked lists head1 and head2 */
        public Node getIntersectionNode(Node head1, Node head2)
        {
            while (head2 != null) {
                Node temp = head1;
                while (temp != null) {
                    // if both Nodes are same
                    if (temp == head2) {
                        return head2;
                    }
                    temp = temp.next;
                }
                head2 = head2.next;
            }
            // If intersection is not present between the lists, return NULL.
            return null;
        }

        public static void main_1(String[] args)
        {
            GFG list = new GFG();

            Node head1, head2;

        /*
                Create two linked lists

                1st 3->6->9->15->30
                2nd 10->15->30

                15 is the intersection point
        */

            head1 = new Node(10);
            head2 = new Node(3);

            Node newNode = new Node(6);
            head2.next = newNode;

            newNode = new Node(9);
            head2.next.next = newNode;

            newNode = new Node(15);
            head1.next = newNode;
            head2.next.next.next = newNode;

            newNode = new Node(30);
            head1.next.next = newNode;

            head1.next.next.next = null;

            Node intersectionPoint
                    = list.getIntersectionNode(head1, head2);

            if (intersectionPoint == null) {
                System.out.print(" No Intersection Point \n");
            }
            else {
                System.out.print("Intersection Point: "
                        + intersectionPoint.data);
            }
        }
    }



    //Approach 2 :
    /*  Method 2 (Mark Visited Nodes) :
            This solution requires modifications to the basic linked list data structure.
            Have a visited flag with each node. Traverse the first linked list and keep marking visited nodes.
            Now traverse the second linked list, If you see a visited node again then there is
            an intersection point, return the intersecting node.

            This solution works in O(m+n) but requires additional information with each node.
            A variation of this solution that doesn’t require modification to the basic data structure
            can be implemented using a hash. Traverse the first linked list and store the addresses of
            visited nodes in a hash. Now traverse the second linked list and if you see an address that
            already exists in the hash then return the intersecting node.
    * */


    //Approach 3 :                                                                            T.C. = O(m+n),  S.C. = O(1)
    /*  Method 3 (Using the difference in node counts) :
          1. Get the count of the nodes in the first list, let the count be c1.
          2. Get the count of the nodes in the second list, let the count be c2.
          3. Get the difference of counts d = abs(c1 – c2)
          4. Now traverse the bigger list from the first node to d nodes so that from here onwards both the lists have an equal no of nodes
          5. Then we can traverse both lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)


          Follow the link for the Visual representation of approach :
          Link : https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
    *
    * */
    // Java program to get intersection point of two linked list
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

        /*function to get the intersection point of two linked lists head1 and head2 */
        int getNode() {

            int c1 = getCount(head1);
            int c2 = getCount(head2);
            int d;

            if (c1 > c2) {
                d = c1 - c2;
                return _getIntesectionNode(d, head1, head2);
            }
            else {
                d = c2 - c1;
                return _getIntesectionNode(d, head2, head1);
            }
        }

        /* Function to get the intersection point of two linked lists head1 and head2
                where head1 has d more nodes than head2 */
        int _getIntesectionNode(int d, Node node1, Node node2)
        {
            int i;
            Node current1 = node1;
            Node current2 = node2;
            for (i = 0; i < d; i++) {
                if (current1 == null) {
                    return -1;
                }
                current1 = current1.next;
            }
            while (current1 != null  &&  current2 != null) {
                if (current1.data == current2.data) {
                    return current1.data;
                }
                current1 = current1.next;
                current2 = current2.next;
            }

            return -1;
        }

        /*Takes head pointer of the linked list and returns the count of nodes in the list  */
        int getCount(Node node) {

            Node current = node;
            int count = 0;

            while (current != null) {
                count++;
                current = current.next;
            }

            return count;
        }

        public static void main_3(String[] args)
        {
            LinkedList list = new LinkedList();

            // creating first linked list
            list.head1 = new Node(3);
            list.head1.next = new Node(6);
            list.head1.next.next = new Node(9);
            list.head1.next.next.next = new Node(15);
            list.head1.next.next.next.next = new Node(30);

            // creating second linked list
            list.head2 = new Node(10);
            list.head2.next = new Node(15);
            list.head2.next.next = new Node(30);

            System.out.println("The node of intersection is " + list.getNode());
        }
    }



    //Approach 4 :
    /*  Method 4 : (Make a circle in the first list) :
            1. Traverse the first linked list(count the elements) and make a circular linked list. (Remember the last node so that we can break the circle later on).
            2. Now view the problem as finding the loop in the second linked list. So the problem is solved.
            3. Since we already know the length of the loop(size of the first linked list) we can traverse those many numbers of nodes in the second list, and then start another pointer from the beginning of the second list. we have to traverse until they are equal, and that is the required intersection point.
            4. remove the circle from the linked list.

            Time Complexity: O(m+n)
            Auxiliary Space: O(1)

        Method 5 : (Reverse the first list and make equations) :
            1) Let X be the length of the first linked list until intersection point.
               Let Y be the length of the second linked list until the intersection point.
               Let Z be the length of the linked list from the intersection point to End of
               the linked list including the intersection node.
                 We Have,
                       X + Z = C1;
                       Y + Z = C2;
            2) Reverse first linked list.
            3) Traverse Second linked list. Let C3 be the length of second list - 1.
                 Now we have
                    X + Y = C3
                 We have 3 linear equations. By solving them, we get
                   X = (C1 + C3 – C2)/2;
                   Y = (C2 + C3 – C1)/2;
                   Z = (C1 + C2 – C3)/2;
                  WE GOT THE INTERSECTION POINT.
            4)  Reverse first linked list.
                 Advantage    : No Comparison of pointers.
                 Disadvantage : Modifying linked list(Reversing list).

        Time complexity  :  O(m+n)
        Auxiliary Space  :  O(1)


        Method 6 : (Traverse both lists and compare addresses of last nodes)
                    This method is only to detect if there is an intersection point or not.

            1) Traverse the list 1, store the last node address
            2) Traverse the list 2, store the last node address.
            3) If nodes stored in 1 and 2 are same then they are intersecting.

        The time complexity of this method is O(m+n) and the used Auxiliary space is O(1)
    * */


    //Approach 5 : By using Hashing.....                                                    T.C. = O(m+n),  S.C. = O(n)
    /*  Method 7  : (Use Hashing)......
            Basically, we need to find a common node of two linked lists. So we hash all nodes of the
            first list and then check the second list.
            1) Create an empty hash set.
            2) Traverse the first linked list and insert all nodes’ addresses in the hash set.
            3) Traverse the second list. For every node check if it is present in the hash set.
               If we find a node in the hash set, return the node.


        This method required O(n) additional space and is not very efficient if one list is large.
    *
    * */
    // Java program to get intersection point of two linked list
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    class LinkedListIntersect {
        public static void main(String[] args)
        {
            // list 1
            Node n1 = new Node(1);
            n1.next = new Node(2);
            n1.next.next = new Node(3);
            n1.next.next.next = new Node(4);
            n1.next.next.next.next = new Node(5);
            n1.next.next.next.next.next = new Node(6);
            n1.next.next.next.next.next.next = new Node(7);
            // list 2
            Node n2 = new Node(10);
            n2.next = new Node(9);
            n2.next.next = new Node(8);
            n2.next.next.next = n1.next.next.next;
            Print(n1);
            Print(n2);
            System.out.println(MegeNode(n1, n2).data);
        }

        // function to print the list
        public static void Print(Node n)
        {
            Node cur = n;
            while (cur != null) {
                System.out.print(cur.data + "  ");
                cur = cur.next;
            }
            System.out.println();
        }

        // function to find the intersection of two node
        public static Node MegeNode(Node n1, Node n2)
        {
            // define hashset
            HashSet<Node> hs = new HashSet<Node>();
            while (n1 != null) {
                hs.add(n1);
                n1 = n1.next;
            }
            while (n2 != null) {
                if (hs.contains(n2)) {
                    return n2;
                }
                n2 = n2.next;
            }
            return null;
        }
    }



    //Approach 6 : Two-Pointer Approach.....                                               T.C. = O(m+n),  S.C. = O(1)
    /*  Method 8 : ( 2-pointer technique ):
            1. Initialize two pointers ptr1 and ptr2  at head1 and  head2.
            2. Traverse through the lists, one node at a time.
            3. When ptr1 reaches the end of a list, then redirect it to head2.
            4. similarly, when ptr2 reaches the end of a list, redirect it to the head1.
            5. Once both of them go through reassigning, they will be equidistant from
               the collision point
            6. If at any node ptr1 meets ptr2, then it is the intersection node.
            7. After the second iteration if there is no intersection node it returns NULL.

    * */
    // JAVA program to print intersection of lists
    class GFG_6{
        /* Link list node */
        static class Node {
            int data;
            Node next;
        }

        // A utility function to return  intersection node
        static Node intersectPoint(Node head1, Node head2)
        {
            // Maintaining two pointers ptr1 and ptr2  at the head of A and B,
            Node ptr1 = head1;
            Node ptr2 = head2;

            // If any one of head is null i.e. no Intersection Point
            if (ptr1 == null || ptr2 == null) {

                return null;
            }

            // Traverse through the lists until they reach Intersection node
            while (ptr1 != ptr2) {

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;

                // If at any node ptr1 meets ptr2, then it is intersection node. Return intersection node.

                if (ptr1 == ptr2) {

                    return ptr1;
                }
                /* Once both of them go through reassigning, they will be equidistant from the collision point. */

                // When ptr1 reaches the end of a list, then reassign it to the head2.
                if (ptr1 == null) {

                    ptr1 = head2;
                }

                // When ptr2 reaches the end of a list, then redirect it to the head1.
                if (ptr2 == null) {

                    ptr2 = head1;
                }
            }

            return ptr1;
        }

        // Function to print intersection nodes in  a given linked list
        static void print(Node node)
        {
            if (node == null)
                System.out.print("null");
            while (node.next != null) {
                System.out.print(node.data+ ".");
                node = node.next;
            }
            System.out.print(node.data);
        }

        // Driver code
        public static void main_6(String[] args)
        {
        /* Create two linked lists :
            1st Linked list is : 3->6->9->15->30
            2nd Linked list is : 10->15->30

            15 30 are elements in the intersection list
        */

            Node newNode;
            Node head1 = new Node();
            head1.data = 10;
            Node head2 = new Node();
            head2.data = 3;
            newNode = new Node();
            newNode.data = 6;
            head2.next = newNode;
            newNode = new Node();
            newNode.data = 9;
            head2.next.next = newNode;
            newNode = new Node();
            newNode.data = 15;
            head1.next = newNode;
            head2.next.next.next = newNode;
            newNode = new Node();
            newNode.data = 30;
            head1.next.next = newNode;
            head1.next.next.next = null;
            Node intersect_node = null;

            // Find the intersection node of two linked lists
            intersect_node = intersectPoint(head1, head2);

            System.out.print("INTERSEPOINT LIST :");

            print(intersect_node);
        }
    }




    //Approach 7 : By using Two-Stacks.........
    /*  Method 9 : Using the 2-stack approach :
            1. Create 2 stacks.
            2. Iterate both the lists till the end and keep on adding the nodes of the list to the respective stack.
            3. If the last nodes are not equal. return saying no intersection.
            4. Iteratively check the stack tops. If equal, pop or else return the current node.

    * */
    // JAVA program to print intersection of lists
    class GFG_7 {

        /* Link list node */
        static class Node {
            int data;
            Node next;
        }

        // A utility function to return  intersection node
        static Node intersectPoint(Node headA, Node headB)
        {
            Stack<Node> stackA = new Stack<Node>();
            Stack<Node> stackB = new Stack<Node>();
            Node intersectNode = null;

            while (headB != null) {
                stackB.push(headB);
                headB = headB.next;
            }

            while (headA != null) {
                stackA.push(headA);
                headA = headA.next;
            }

            if (!stackA.peek().equals(stackB.peek())) {
                return null;
            }

            while (!stackA.empty() && !stackB.empty()
                    && stackA.peek().equals(stackB.peek())) {
                intersectNode = stackA.pop();
                stackB.pop();
            }

            return intersectNode;
        }

        // Driver code
        public static void main_7(String[] args)
        {
        /* Create two linked lists :
            1st Linked list is : 3->6->9->15->30
            2nd Linked list is : 10->15->30

            15 30 are elements in the intersection list
        */

            Node newNode;
            Node head1 = new Node();
            head1.data = 10;
            Node head2 = new Node();
            head2.data = 3;
            newNode = new Node();
            newNode.data = 6;
            head2.next = newNode;
            newNode = new Node();
            newNode.data = 9;
            head2.next.next = newNode;
            newNode = new Node();
            newNode.data = 15;
            head1.next = newNode;
            head2.next.next.next = newNode;
            newNode = new Node();
            newNode.data = 30;
            head1.next.next = newNode;
            head1.next.next.next = null;
            Node intersect_node = null;

            // Find the intersection node of two linked lists
            intersect_node = intersectPoint(head1, head2);

            System.out.print("INTERSECTION POINT: " + intersect_node.data);
        }
    }




    public static void main(String[] args) {

        /*Ques : There are two singly linked lists in a system. By some programming error, the end node
                 of one of the linked lists got linked to the second list, forming an inverted Y-shaped list.
                 Write a program to get the point where two linked lists merge.
         *
        * */
    }


}
