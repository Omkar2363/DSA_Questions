package Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Ques_S_1 {

    //Ques : Design a stack with operations on middle element......                              (GFG Ques.)


    //Approach 1 :
    /*  Method 1 :
           - The important question is, whether to use a linked list or array for the implementation of the stack?
           - Please note that we need to find and delete the middle element.
             Deleting an element from the middle is not O(1) for the array. Also, we may need to move
             the middle pointer up when we push an element and move down when we pop().
             In a singly linked list, moving the middle pointer in both directions is not possible.
           - The idea is to use a Doubly Linked List (DLL). We can delete the middle element in O(1) time by
             maintaining mid-pointer. We can move the mid-pointer in both directions using previous and next pointers.
           - Following is implementation of push(), pop() and findMiddle() operations. If there are even elements in stack,
             findMiddle() returns the second middle element.
             For example, if stack contains {1, 2, 3, 4}, then findMiddle() would return 3.

    * */
    /* Java Program to implement a stack that supports findMiddle() and deleteMiddle in O(1) time */
    /* A Doubly Linked List Node */
    static class DLLNode {
        DLLNode prev;
        int data;
        DLLNode next;
        DLLNode(int data) { this.data = data; }
    }
    /* Representation of the stack data structure that supports findMiddle() in O(1) time.
       The Stack is implemented using Doubly Linked List. It maintains pointer to head node,
       pointer to middle node and count of nodes */
    public static class myStack {
        DLLNode head;
        DLLNode mid;
        DLLNode prev;
        DLLNode next;
        int size;
        /* Function to push an element to the stack */
        void push(int new_data)
        {

            /* allocate DLLNode and put in data */
            DLLNode new_node = new DLLNode(new_data);

            // if stack is empty
            if (size == 0) {
                head = new_node;
                mid = new_node;
                size++;
                return;
            }
            head.next = new_node;
            new_node.prev = head;

            head = head.next;
            if (size % 2 != 0) {
                mid = mid.next;
            }
            size++;
        }

        /* Function to pop an element from stack */
        int pop()
        {
            int data = -1;
            /* Stack underflow */
            if (size == 0) {
                System.out.println("Stack is empty");
                // return -1;
            }

            if (size != 0) {
                if (size == 1) {
                    head = null;
                    mid = null;
                }
                else {
                    data = head.data;
                    head = head.prev;
                    head.next = null;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    }
                }
                size--;
            }
            return data;
        }

        // Function for finding middle of the stack
        int findMiddle()
        {
            if (size == 0) {
                System.out.println("Stack is empty now");
                return -1;
            }
            return mid.data;
        }
        void deleteMiddleElement()
        {
            // This function will not only delete the middle element but also update the mid in case of even
            // and odd number of Elements when the size is even then findmiddle() will show the
            // second middle element as mentioned in the problem statement
            if (size != 0) {
                if (size == 1) {
                    head = null;
                    mid = null;
                }
                else if (size == 2) {
                    head = head.prev;
                    mid = mid.prev;
                    head.next = null;
                }
                else {
                    mid.next.prev = mid.prev;
                    mid.prev.next = mid.next;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    }
                    else {
                        mid = mid.next;
                    }
                }
                size--;
            }
        }

        // Driver program to test functions of myStack
        public static void main_1(String args[])
        {
            myStack ms = new myStack();
            ms.push(11);
            ms.push(22);
            ms.push(33);
            ms.push(44);
            ms.push(55);
            ms.push(66);
            ms.push(77);
            ms.push(88);
            ms.push(99);

            System.out.println("Popped : " + ms.pop());
            System.out.println("Popped : " + ms.pop());
            System.out.println("Middle Element : " + ms.findMiddle());
            ms.deleteMiddleElement();
            System.out.println("New Middle Element : " + ms.findMiddle());
        }
    }




    //Approach 2 : By Using a standard stack and a deque
    /*  We will use a standard stack to store half of the elements and the other half of the elements which
        were added recently will be present in the deque. Insert operation on myStack will add an element into
        the back of the deque. The number of elements in the deque stays 1 more or equal to that in the stack,
        however, whenever the number of elements present in the deque exceeds the number of elements in the stack
        by more than 1 we pop an element from the front of the deque and push it into the stack.
        The pop operation on myStack will remove an element from the back of the deque. If after the pop operation,
        the size of the deque is less than the size of the stack, we pop an element from the top of the stack and
        insert it back into the front of the deque so that size of the deque is not less than the stack.
        We will see that the middle element is always the front element of the deque. So deleting of the middle element
        can be done in O(1) if we just pop the element from the front of the deque.

        Consider Operations on My_stack:

        Operation                        stack                             deque

        add(2)                            { }                               {2}
        add(5)                            {2}                               {5}
        add(3)                            {2}                               {5,3}
        add(7)                            {2,5}                             {3,7}
        add(4)                            {2,5}                             {3,7,4}


        deleteMiddle()                    {2,5}                             {7,4}
        deleteMiddle()                    {2}                               {5,4}


        pop()                             {2}                               {5}
        pop()                             { }                               {2}


        deleteMiddle()                    { }                               { }


    * */
    /*package whatever //do not write package name here */
    static class MyStack {
        Stack<Integer> s;
        Deque<Integer> dq;

        MyStack()
        {
            s = new Stack<Integer>();
            dq = new ArrayDeque<Integer>();
        }
        void add(int data)
        {
            dq.addLast(data);
            if (dq.size() > s.size() + 1) {
                int temp = dq.pollFirst();
                s.push(temp);
            }
        }
        void pop()
        {
            int data = dq.pollLast();
            if (s.size() > dq.size()) {
                int temp = s.pop();
                dq.offerFirst(temp);
            }
        }
        int getMiddleElement() { return dq.getFirst(); }
        void deleteMiddleElement()
        {
            dq.pollFirst();
            if (s.size() > dq.size()) {
                int temp = s.pop();
                dq.offerFirst(temp);
            }
        }
    }
    class GFG {
        public static void main(String[] args)
        {
            MyStack s = new MyStack();
            s.add(2);
            s.add(5);

            System.out.println("Middle element:" + s.getMiddleElement());
            s.add(3);
            s.add(7);
            s.add(4);
            System.out.println("Middle element:" + s.getMiddleElement());

            s.deleteMiddleElement();
            System.out.println("Middle element:" + s.getMiddleElement());

            s.deleteMiddleElement();
            System.out.println("Middle element:" + s.getMiddleElement());

            s.pop();
            s.pop();
            s.deleteMiddleElement();
        }
    }




    public static void main(String[] args) {

        /*Ques : How to implement a stack which will support the following operations in O(1) time complexity.....?
                    1) push() which adds an element to the top of stack.
                    2) pop() which removes an element from top of stack.
                    3) findMiddle() which will return middle element of the stack.
                    4) deleteMiddle() which will delete the middle element.

                    Push and pop are standard stack operations.


        * */
    }



}
