package Medium;

import java.util.ListIterator;
import java.util.Stack;

public class Ques_S_8 {

    //Ques : How to Sort a Stack using Recursion.........                                    (GFG Ques.)


    //Approach 1 : By using a predefined Stack........                                       T.C. = O(n^2),  S.C. = O(n)
    /*  How to Sort a Stack Using Stack :
            The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty.
            When the stack becomes empty, insert all held items one by one in sorted order. and then print the stack


        * Illustration :
        Below is the illustration of above approach :
            Let given stack be
                 -3
                 14
                 18
                 -5
                 30
        Let us illustrate sorting of stack using the above example:
           1). First pop all the elements from the stack and store popped element in the variable ‘temp’.
               After popping all the elements function’s stack frame will look like this:

                -3	stack frame 1
                14	stack frame 2
                18	stack frame 3
                -5	stack frame 4
                30	stack frame 5

            Now stack is empty so function insert in sorted order is called and it inserts 30 (from stack frame 5) at the bottom of the stack.
                Now stack looks like the below :
                     30
            Now next element  -5 (from stack frame 4) is picked. Since -5 < 30, -5 is inserted at the bottom of the stack.
                Now stack becomes :
                     30
                     -5
            Next 18 (from stack frame 3) is picked. Since 18 < 30, 18 is inserted below 30.
                Now stack becomes :
                     30
                     18
                     -5
            Next 14 (from stack frame 2) is picked. Since 14 < 30 and 14 < 18, it is inserted below 18.
                Now stack becomes :
                     30
                     18
                     14
                     -5
            Now -3 (from stack frame 1) is picked, as -3 < 30 and -3 < 18 and -3 < 14, it is inserted below 14.
                Now stack becomes :
                     30
                     18
                     14
                     -3
                     -5

            * Follow the steps mentioned below to implement the idea :
               1. Create a stack and push all the elements in it.
               2. Call sortStack(), which will pop an element from the stack and pass the popped element
                  to function sortInserted(),
               3. then it will keep calling itself until the stack is empty.
               4. Whenever sortInserted() is called it will insert the passed element in stack in sorted order.
               5. Print the stack

    * */
    // Java program to sort a Stack using recursion
    // Note that here predefined Stack class is used for stack operation
    class Test {

        // Recursive Method to insert an item x in sorted way
        static void sortedInsert(Stack<Integer> s, int x)
        {
            // Base case : Either stack is empty or newly inserted item is greater than top (more than all existing)
            if (s.isEmpty() || x > s.peek()) {
                s.push(x);
                return;
            }

            // If top is greater, remove the top item and recur
            int temp = s.pop();
            sortedInsert(s, x);

            // Put back the top item removed earlier
            s.push(temp);
        }

        // Method to sort stack
        static void sortStack(Stack<Integer> s)
        {
            // If stack is not empty
            if (!s.isEmpty()) {

                // Remove the top item
                int x = s.pop();

                // Sort remaining stack
                sortStack(s);

                // Push the top item back in sorted stack
                sortedInsert(s, x);
            }
        }

        // Utility Method to print contents of stack
        static void printStack(Stack<Integer> s)
        {
            ListIterator<Integer> lt = s.listIterator();

            // forwarding
            while (lt.hasNext())
                lt.next();

            // printing from top to bottom
            while (lt.hasPrevious())
                System.out.print(lt.previous() + " ");
        }

        // Driver code
        public static void main_1(String[] args)
        {
            Stack<Integer> s = new Stack<>();
            s.push(30);
            s.push(-5);
            s.push(18);
            s.push(14);
            s.push(-3);

            System.out.println("Stack elements before sorting: ");
            printStack(s);

            sortStack(s);

            System.out.println("\n\nStack elements after sorting: ");
            printStack(s);
        }
    }




    //Approach 2 : By using a Temporary Stack.......
    /*
        # We follow this algorithm :
            1. Create a temporary stack say tmpStack.
            2. While input stack is NOT empty do this:
                 - Pop an element from input stack call it temp
                 - while temporary stack is NOT empty and top of temporary stack is greater than temp,
                   pop from temporary stack and push it to the input stack
                 - push temp in temporary stack
            3. The sorted numbers are in tmpStack


        * Here is a dry run of above pseudo-code.
            Input    : [34, 3, 31, 98, 92, 23]

            Element taken out : 23
            Input    : [34, 3, 31, 98, 92]
            tmpStack : [23]

            Element taken out : 92
            Input    : [34, 3, 31, 98]
            tmpStack : [23, 92]

            Element taken out : 98
            Input    : [34, 3, 31]
            tmpStack : [23, 92, 98]

            Element taken out : 31
            input    : [34, 3, 98, 92]
            tmpStack : [23, 31]

            Element taken out : 92
            input    : [34, 3, 98]
            tmpStack : [23, 31, 92]

            Element taken out : 98
            input    : [34, 3]
            tmpStack : [23, 31, 92, 98]

            Element taken out : 3
            input    : [34, 98, 92, 31, 23]
            tmpStack : [3]

            Element taken out : 23
            input    : [34, 98, 92, 31]
            tmpStack : [3, 23]

            Element taken out : 31
            input    : [34, 98, 92]
            tmpStack : [3, 23, 31]

            Element taken out : 92
            input    : [34, 98]
            tmpStack : [3, 23, 31, 92]

            Element taken out : 98
            input    : [34]
            tmpStack : [3, 23, 31, 92, 98]

            Element taken out : 34
            input    : [98, 92]
            tmpStack : [3, 23, 31, 34]

            Element taken out : 92
            input    : [98]
            tmpStack : [3, 23, 31, 34, 92]

            Element taken out : 98
            input    : []
            tmpStack : [3, 23, 31, 34, 92, 98]

            final sorted list    :   [3, 23, 31, 34, 92, 98]

    * */
    // Java program to sort a stack using an auxiliary stack.
    class SortStack {
        // This function return the sorted stack
        public static Stack<Integer> sortstack(Stack<Integer> input)
        {
            Stack<Integer> tmpStack = new Stack<Integer>();
            while(!input.isEmpty())
            {
                // pop out the first element
                int tmp = input.pop();

                // while temporary stack is not empty and top of stack is greater than temp
                while(!tmpStack.isEmpty() && tmpStack.peek()   >  tmp)
                {
                    // pop from temporary stack and push it to the input stack
                    input.push(tmpStack.pop());
                }

                // push temp in temporary of stack
                tmpStack.push(tmp);
            }
            return tmpStack;
        }

        // Driver Code
        public static void main_2(String args[])
        {
            Stack<Integer> input = new Stack<Integer>();
            input.add(34);
            input.add(3);
            input.add(31);
            input.add(98);
            input.add(92);
            input.add(23);

            // This is the temporary stack
            Stack<Integer> tmpStack=sortstack(input);

            System.out.println("Sorted numbers are:");

            while (!tmpStack.empty())
            {
                System.out.print(tmpStack.pop()+" ");
            }
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a stack, the task is to sort it using recursion.


            Example : 1
            Input   : elements present in stack from top to bottom -3 14 18 -5 30
            Output  : 30 18 14 -3 -5
            Explanation : The given stack is sorted know 30 > 18 > 14 > -3 > -5

            Example : 2
            Input   : elements present in stack from top to bottom 1 2 3
            Output  : 3 2 1
            Explanation : The given stack is sorted know 3 > 2 > 1




         *
         * */

    }




}
