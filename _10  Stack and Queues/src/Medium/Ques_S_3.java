package Medium;

import java.util.Stack;

public class Ques_S_3 {

    //Ques : Design and Implement Special Stack Data Structure | Added Space Optimized Version.....   (GFG Ques.)


    //Approach 1 : By using two Stacks.......
    /*  Solution :
         - By using two stacks : one to store actual stack elements and the other as an auxiliary stack
                                 to store minimum values. The idea is to do push() and pop() operations
                                 in such a way that the top of the auxiliary stack is always the minimum.

             # Let us see how push() and pop() operations work.

                * Push(int x)                                      // inserts an element x to Special Stack
                    1) push x to the first stack (the stack with actual elements)
                    2) compare x with the top element of the second stack (the auxiliary stack). Let the top element be y.
                          a. If x is smaller than y then push x to the auxiliary stack.
                          b. If x is greater than y then push y to the auxiliary stack.
                * int Pop()                                      // removes an element from Special Stack and
                                                                 // return the removed element

                    1) pop the top element from the auxiliary stack.
                    2) pop the top element from the actual stack and return it. Step 1 is necessary to
                       make sure that the auxiliary stack is also updated for future operations.

                * int getMin()                                   // returns the minimum element from Special Stack
                    1) Return the top element of the auxiliary stack.

                We can see that all the above operations are O(1).

         - Let us see an example. Let us assume that both stacks are initially empty and
           18, 19, 29, 15, and 16 are inserted to the SpecialStack.

               -> When we insert 18, both stacks change to following.
                    Actual Stack
                    18 <--- top
                    Auxiliary Stack
                    18 <---- top

               -> When 19 is inserted, both stacks change to following.
                    Actual Stack
                    19 <--- top
                    18
                    Auxiliary Stack
                    18 <---- top
                    18

               -> When 29 is inserted, both stacks change to following.
                    Actual Stack
                    29 <--- top
                    19
                    18
                    Auxiliary Stack
                    18 <---- top
                    18
                    18

                -> When 15 is inserted, both stacks change to following.
                    Actual Stack
                    15 <--- top
                    29
                    19
                    18
                    Auxiliary Stack
                    15 <---- top
                    18
                    18
                    18

               -> When 16 is inserted, both stacks change to following.
                    Actual Stack
                    16 <--- top
                    15
                    29
                    19
                    18
                    Auxiliary Stack
                    15 <---- top
                    15
                    18
                    18
                    18

    * */
    // Java implementation of SpecialStack
    // Note : here we use Stack class for
    // Stack implementation

    /* A class that supports all the stack operations and one additional operation getMin() that returns
       the minimum element from stack at any time. This class inherits from the stack class and uses an
       auxiliary stack that holds minimum elements */
    static class SpecialStack extends Stack<Integer> {
        Stack<Integer> min = new Stack<>();

        /* SpecialStack's member method to insert an element to it. This method makes sure that the min stack
           is also updated with appropriate minimum values */
        void push(int x)
        {
            if (isEmpty() == true) {
                super.push(x);
                min.push(x);
            }
            else {
                super.push(x);
                int y = min.pop();
                min.push(y);
                if (x < y)
                    min.push(x);
                else
                    min.push(y);
            }
        }

        /* SpecialStack's member method to insert an element to it. This method makes sure that the min stack
           is also updated with appropriate minimum values */
        public Integer pop()
        {
            int x = super.pop();
            min.pop();
            return x;
        }

        /* SpecialStack's member method to get minimum element from it. */
        int getMin()
        {
            int x = min.pop();
            min.push(x);
            return x;
        }

        /* Driver program to test SpecialStack methods */
        public static void main(String[] args)
        {
            SpecialStack s = new SpecialStack();
            s.push(10);
            s.push(20);
            s.push(30);
            System.out.println(s.getMin());
            s.push(5);
            System.out.println(s.getMin());
        }
    }

    /*  Complexity Analysis  :
           * Time Complexity :
                For insert operation  :  O(1)  (As insertion ‘push’ in a stack takes constant time)
                For delete operation  :  O(1)  (As deletion ‘pop’ in a stack takes constant time)
                For Get Min operation :  O(1)  (As we have used an auxiliary stack which has its top as the minimum element)

           * Auxiliary Space : O(n)    Use of auxiliary stack for storing values.

    * */



    //Approach 2 : Space Optimized Version.....
    /*  Space Optimized Version :
           The above approach can be optimized. We can limit the number of elements in the auxiliary stack.
           We can push only when the incoming element of the main stack is smaller than or equal to the top
           of the auxiliary stack.
           Similarly, during pop, if the pop-off element equal to the top of the auxiliary stack, remove the top element
           of the auxiliary stack. Following is the modified implementation of push() and pop().


    * */
    // Modified Functions....
    /*  //SpecialStack's member method to insert an element to it. This method makes sure
        //that the min stack is also updated with appropriate minimum values.

    void push(int x)
    {
        if (isEmpty() == true) {
            super.push(x);
            min.push(x);
        }
        else {
            super.push(x);
            int y = min.pop();
            min.push(y);

         //push only when the incoming element of main stack is smaller than or equal to top of auxiliary stack
            if (x <= y)
                min.push(x);
        }
    }

        //SpecialStack's member method to remove an element from it. This method removes top element from min stack also.
    public Integer pop()
    {
        int x = super.pop();
        int y = min.pop();

       //Push the popped element y back only if it is not equal to x
        if (y != x)
            min.push(y);
        return x;
    }
    */
    /*  Complexity Analysis :
           * Time Complexity :
                For Insert operation   :  O(1)  (As insertion ‘push’ in a stack takes constant time)
                For Delete operation   :  O(1)  (As deletion ‘pop’ in a stack takes constant time)
                For Get Min operation  :  O(1)  (As we have used an auxiliary which has its top as the minimum element)

           * Auxiliary Space : O(n)    The complexity in the worst case is the same as above but in other cases, it will take slightly less space than the above approach as repetition is neglected.

    * */




    //Approach 3 : Further Optimized Operation.....
    /* A special stack having peek() pop() and push() along with additional getMin() that returns
       minimum value in a stack without using extra space and all operations in O(1) time.. 🙂
     * */
    public static class SpecialStack_3 {
        int min = -1;                             // sentinel value for min
        static int demoVal = 9999;               // DEMO_VALUE
        Stack<Integer> st = new Stack<Integer>();
        void getMin() {
            System.out.println("min is: " + min);
        }

        void push(int val)
        {
            // if stack is empty OR current element is less than min, update min..
            if (st.isEmpty() || val < min) {
                min = val;
            }

            st.push(val * demoVal + min);                        // encode the current value with demoVal,
                                                                      // combine with min and insert into stack
            System.out.println("pushed: " + val);
        }

        int pop()
        {
            // if stack is empty return -1;
            if (st.isEmpty() ) {
                System.out.println("stack underflow");
                return -1;
            }

            int val = st.pop();

            if (!st.isEmpty())                                // if stack is empty, there would be no min value present,
                                                              // so make min as -1
                min = st.peek() % demoVal;
            else
                min = -1;
            System.out.println("popped: " + val / demoVal);

            return val / demoVal;                            // decode actual value from encoded value
        }

        int peek()
        {
            return st.peek() / demoVal;                     // decode actual value from encoded value
        }

        // Driver Code
        public static void main_3(String[] args)
        {
            SpecialStack_3 s = new SpecialStack_3();

            int[] arr = { 3, 2, 6, 1, 8, 5, 5, 5, 5 };

            for (int i = 0; i < arr.length; i++) {
                s.push(arr[i]);
                s.getMin();
            }
            System.out.println();
            for (int i = 0; i < arr.length; i++) {
                s.pop();
                s.getMin();
            }
        }
    }

    /*  Complexity Analysis :
           - For push() operation  :  O(1)  (As insertion ‘push’ in a stack takes constant time)
           - For pop() operation   :  O(1)  (As pop operation in a stack takes constant time)
           - For Get Min operation :  O(1)  (As we have maintained min variable throughout the code)

        Auxiliary Space   :  O(1)  No extra space is used.

    * */




    public static void main(String[] args) {

        /*Ques : Question: Design a Data Structure SpecialStack that supports all the stack operations
                 like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should
                 return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1).
                 To implement SpecialStack, you should only use standard Stack data structure and no other data structure
                 like arrays, list, . etc.


            Example : 1
            Consider the following SpecialStack
            16  --> TOP
            15
            29
            19
            18

            When getMin() is called it should return 15, which is the minimum element in the current stack.

            If we do pop two times on stack, the stack becomes
            29  --> TOP
            19
            18

            When getMin() is called, it should return 18 which is the minimum in the current stack.

        * */
    }



}
