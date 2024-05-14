package Easy;

public class Ques_S_1 {

    //Ques : Implement two Stacks in an Array............                                 (GFG Ques.)


    //Approach 1 : By Dividing the Space of array in two halves :
    /*  Implement two stacks in an array by Dividing the space into two halves :

            The idea to implement two stacks is to divide the array into two halves and
            assign two halves to two stacks, i.e., use arr[0] to arr[n/2] for stack1, and
            arr[(n/2) + 1] to arr[n-1] for stack2     where arr[] is the array to be used
                                                      to implement two stacks and size of array be n.

            Follow the steps below to solve the problem:

              *  To implement push1():
                   - First, check whether the top1 is greater than 0
                        If it is then add an element at the top1 index and decrement top1 by 1
                        Else return Stack Overflow
              *  To implement push2():
                   - First, check whether top2 is less than n – 1
                        If it is then add an element at the top2 index and increment the top2 by 1
                        Else return Stack Overflow
              *  To implement pop1():
                   - First, check whether the top1 is less than or equal to n / 2
                        If it is then increment the top1 by 1 and return that element.
                        Else return Stack Underflow
              *  To implement pop2():
                   - First, check whether the top2 is greater than or equal to (n + 1) / 2
                        If it is then decrement the top2 by 1 and return that element.
                        Else return Stack Underflow

    * */
    static class twoStacks {
        int[] arr;
        int size;
        int top1, top2;
        // Constructor
        twoStacks(int n) {
            size = n;
            arr = new int[n];
            top1 = n / 2 + 1;
            top2 = n / 2;
        }

        // Method to push an element x to stack1
        void push1(int x)
        {
            // There is at least one empty space for new element
            if (top1 > 0) {
                top1--;
                arr[top1] = x;
            }
            else {
                System.out.println("Stack Overflow" + " By element : " + x);
                return;
            }
        }

        // Method to push an element x to stack2
        void push2(int x)
        {
            // There is at least one empty space for new element
            if (top2 < size - 1) {
                top2++;
                arr[top2] = x;
            }
            else {
                System.out.println("Stack Overflow" + " By element : " + x);
                return;
            }
        }

        // Method to pop an element from first stack
        int pop1()
        {
            if (top1 <= size / 2) {
                int x = arr[top1];
                top1++;
                return x;
            }
            else {
                System.out.print("Stack UnderFlow");
                System.exit(1);
            }
            return 0;
        }

        // Method to pop an element from second stack
        int pop2()
        {
            if (top2 >= size / 2 + 1) {
                int x = arr[top2];
                top2--;
                return x;
            }
            else {
                System.out.print("Stack UnderFlow");
                System.exit(1);
            }
            return 1;
        }
    }
    class GFG {

        /* Driver program to test twoStacks class */
        public static void main(String[] args)
        {
            twoStacks ts = new twoStacks(5);
            ts.push1(5);
            ts.push2(10);
            ts.push2(15);
            ts.push1(11);
            ts.push2(7);
            System.out.println("Popped element from stack1 is " + ": " + ts.pop1());
            ts.push2(40);
            System.out.println("Popped element from stack2 is " + ": " + ts.pop2());
        }
    }
    /*  Time Complexity  :
            Push operation : O(1)
            Pop operation  : O(1)

        Auxiliary Space  :   O(N), Use of array to implement stack.
    * */




    //Approach 2 :
    /*  Implement two stacks in an array by Starting from endpoints :

            The idea is to start two stacks from two extreme corners of arr[].

            Follow the steps below to solve the problem:

              *  Stack1 starts from the leftmost element, the first element in stack1 is pushed at index 0.
              *  Stack2 starts from the rightmost corner, the first element in stack2 is pushed at index (n-1).
              *  Both stacks grow (or shrink) in opposite directions.
              *  To check for overflow, all we need to check is for space between top elements of both stacks.
    * */
    // Java program to implement two stacks in a single array
    static class TwoStacks_2 {
        int size;
        int top1, top2;
        int arr[];

        // Constructor
        TwoStacks_2(int n)
        {
            arr = new int[n];
            size = n;
            top1 = -1;
            top2 = size;
        }

        // Method to push an element x to stack1
        void push1(int x)
        {
            // There is at least one empty space for new element
            if (top1 < top2 - 1) {
                top1++;
                arr[top1] = x;
            }
            else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        // Method to push an element x to stack2
        void push2(int x)
        {
            // There is at least one empty space for new element
            if (top1 < top2 - 1) {
                top2--;
                arr[top2] = x;
            }
            else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        // Method to pop an element from first stack
        int pop1()
        {
            if (top1 >= 0) {
                int x = arr[top1];
                top1--;
                return x;
            }
            else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }

        // Method to pop an element from second stack
        int pop2()
        {
            if (top2 < size) {
                int x = arr[top2];
                top2++;
                return x;
            }
            else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }

        // Driver program to test twoStack class
        public static void main(String args[])
        {
            TwoStacks_2 ts = new TwoStacks_2(5);
            ts.push1(5);
            ts.push2(10);
            ts.push2(15);
            ts.push1(11);
            ts.push2(7);
            System.out.println("Popped element from" + " stack1 is " + ts.pop1());
            ts.push2(40);
            System.out.println("Popped element from" + " stack2 is " + ts.pop2());
        }
    }
    /*  Time Complexity   :
            Push operation  : O(1)
            Pop operation   : O(1)
        Auxiliary Space   :   O(N), Use of the array to implement stack.
    * */




    public static void main(String[] args) {

        /*Ques : Create a data structure twoStacks that represent two stacks. Implementation of twoStacks
                 should use only one array.
                 i.e. Both stacks should use the same array for storing elements.

            Following functions must be supported by twoStacks.

                push1(int x) –> pushes x to first stack
                push2(int x) –> pushes x to second stack
                pop1() –> pops an element from first stack and return the popped element
                pop2() –> pops an element from second stack and return the popped element
                Implementation of twoStack should be space efficient.

        * */
    }


}
