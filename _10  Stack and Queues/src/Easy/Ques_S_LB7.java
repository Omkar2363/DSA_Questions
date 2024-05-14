package Easy;

import java.util.ListIterator;
import java.util.Stack;

public class Ques_S_LB7 {

    //Ques : Sort a stack.........                                                    (GFG Ques.)


    //Approach 1 : Sort a Stack by using Stack......
    // Java program to sort a Stack using recursion :
    // Note that here predefined Stack class is used for stack operation
    class Test {
        // Recursive Method to insert an item x in sorted way
        static void sortedInsert(Stack<Integer> s, int x)
        {
            // Base case :  Either stack is empty or newly inserted item is
            //              greater than top (more than all existing)
            if (s.isEmpty() || x > s.peek())
            {
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
            if (!s.isEmpty())
            {
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
            while(lt.hasNext())
                lt.next();

            // printing from top to bottom
            while(lt.hasPrevious())
                System.out.print(lt.previous()+" ");
        }

        // Driver method
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

            System.out.println(" \n\nStack elements after sorting:");
            printStack(s);

        }
    }




    //Approach 2 : Sort a Stack by using Temporary Stack.
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

                // while temporary stack is not empty and
                // top of stack is greater than temp
                while(!tmpStack.isEmpty() && tmpStack.peek()   >  tmp)
                {
                    // pop from temporary stack and
                    // push it to the input stack
                    input.push(tmpStack.pop());
                }

                // push temp in tempory of stack
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

        /*Ques : Given a stack, the task is to sort it such that the top of the stack has the greatest element.


            Example : 1
            Input   : Stack : 3 2 1
            Output  : 3 2 1


            Example : 2
            Input   : Stack: 11 2 32 3 41
            Output  : 41 32 11 3 2


            Your Task :
            You don't have to read input or print anything. Your task is to complete the function sort() which
            sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by
            popping the elements of the stack.)


            Expected Time Complexity   :  O(N*N)
            Expected Auxilliary Space  :  O(N) recursive.
        *
        * */
    }


}
