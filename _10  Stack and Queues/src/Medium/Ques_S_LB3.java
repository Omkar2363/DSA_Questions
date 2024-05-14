package Medium;

import java.util.Stack;

public class Ques_S_LB3 {

    //Ques : How to Reverse a Stack using Recursion........                                 (GFG Ques.)


    //Approach 1 : By using Recursion.......                                                T.C. = O(n^2),  S.C. = O(n)
    /*  Reverse a stack using Recursion :
            The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty.
            When the stack becomes empty, insert all held items one by one at the bottom of the stack.


        * Illustration :
          - Below is the illustration of the above approach

            Let given stack be :
                   1
                   2
                   3
                   4

            After all calls of reverse,  4 will be passed to function insert at bottom, after that 4 will be pushed
            to the stack when stack is empty


                    4
            Then 3 will be passed to function insert at bottom , it will check if the stack is empty or not if not
            then pop all the elements back and insert 3 and then push other elements back.

                   4
                   3
            Then 2 will be passed to function insert at bottom , it will check if the stack is empty or not if not
            then pop all the elements back and insert 2 and then push other elements back.
                  4
                  3
                  2
            Then 1 will be passed to function insert at bottom , it will check if the stack is empty or not if not then pop all the elements back and insert 1 and then push other elements back.

                  4
                  3
                  2
                  1


        * Follow the steps mentioned below to implement the idea :
           1. Create a stack and push all the elements in it.
           2. Call reverse(), which will pop all the elements from the stack and pass the popped element
              to function insert_at_bottom()
           3. Whenever insert_at_bottom() is called it will insert the passed element at the bottom of the stack.
           4. Print the stack
    *
    */
    // Java code to reverse a stack using recursion
    class Test {

        // using Stack class for stack implementation
        static Stack<Character> st = new Stack<>();

        // Below is a recursive function that inserts an element at the bottom of a stack.
        static void insert_at_bottom(char x)
        {
            if (st.isEmpty())
                st.push(x);
            else {
                // All items are held in Function Call Stack until we reach end of the stack.
                // When the stack becomes empty, the st.size() becomes 0, the above if part is executed and
                // the item is inserted at the bottom
                char a = st.peek();
                st.pop();
                insert_at_bottom(x);

                // push all the items held in Function Call Stack
                // once the item is inserted at the bottom
                st.push(a);
            }
        }

        // Below is the function that reverses the given stack using insert_at_bottom()
        static void reverse()
        {
            if (st.size() > 0) {

                // Hold all items in Function Call Stack until we reach end of the stack
                char x = st.peek();
                st.pop();
                reverse();

                // Insert all the items held in Function Call Stack one by one from the bottom
                // to top. Every item is inserted at the bottom
                insert_at_bottom(x);
            }
        }

        // Driver Code
        public static void main_1(String[] args)
        {

            // push elements into the stack
            st.push('1');
            st.push('2');
            st.push('3');
            st.push('4');

            System.out.println("Original Stack");

            System.out.println(st);

            // function to reverse the stack
            reverse();

            System.out.println("Reversed Stack");

            System.out.println(st);
        }
    }





    public static void main(String[] args) {

        /*Ques : Write a program to reverse a stack using recursion, without using any loop.


            Example : 1
            Input   : elements present in stack from top to bottom 1 2 3 4
            Output  : 4 3 2 1

            Example : 2
            Input   : elements present in stack from top to bottom 1 2 3
            Output  : 3 2 1
        * */
    }


}
