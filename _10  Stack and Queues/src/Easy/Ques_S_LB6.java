package Easy;

import java.util.Stack;

public class Ques_S_LB6 {

    //Ques : Program to insert an element at the Bottom of a Stack..........                (GFG Ques.)


    //Approach 1 : Naive approach........                                                   T.C. = O(n),  S.C. = O(n)
    /*  Naive Approach : The simplest approach would be to create another stack.

           * Follow the steps below to solve the problem  :

                1. Initialize a stack, say temp.
                2. Keep popping from the given stack S and pushing the popped elements into temp,
                   until the stack S becomes empty.
                3. Push N into the stack S.
                4. Now, keep popping from the stacktemp and push the popped elements into the stack S,
                   until the stack temp becomes empty.
    *
    * */
    // Java program for the above approach
    class GFG {

        // Function to insert an element at the bottom of a given stack
        static void insertToBottom(Stack<Integer> S, int N)
        {
            // Temporary stack
            Stack<Integer> temp = new Stack<>();

            // Iterate until S becomes empty
            while (!S.empty())
            {

                // Push the top element of S into the stack temp
                temp.push(S.peek());

                // Pop the top element of S
                S.pop();
            }

            // Push N into the stack S
            S.push(N);

            // Iterate until temp becomes empty
            while (!temp.empty())
            {

                // Push the top element of temp into the stack S
                S.push(temp.peek());

                // Pop the top element of temp
                temp.pop();
            }

            // Print the elements of S
            while (!S.empty())
            {
                System.out.print(S.peek() + " ");
                S.pop();
            }
        }

        // Driver code
        public static void main_1(String[] args)
        {

            // Given Binary Tree
            Stack<Integer> S = new Stack<>();
            S.push(5);
            S.push(4);
            S.push(3);
            S.push(2);
            S.push(1);

            int N = 7;

            insertToBottom(S, N);
        }
    }



    //Approach 2 : Efficient approach......                                                T.C. = O(n),  S.C. = O(n)
    /*  Efficient Approach : Instead of using a temporary stack, the implicit stack can be used through recursion.

          *  Follow the steps below to solve the problem :
                1. Define a recursion function that accepts the stack S and an integer as parameters and returns a stack.
                2. Base case to be considered is if the stack is empty. For this scenario, push N into the stack and
                   return it.
                3. Otherwise, remove the top element of S and store it in a variable, say X.
                4. Recurse again using the new stack
                5. Push X into S.

    * */
    // Java program for the above approach
    public class Main
    {
        // Recursive function to use implicit stack
        // to insert an element at the bottom of stack
        static Stack<Integer> recur(Stack<Integer> S, int N)
        {
            // If stack is empty
            if (S.size() == 0)
                S.push(N);

            else {

                // Stores the top element
                int X = S.peek();

                // Pop the top element
                S.pop();

                // Recurse with remaining elements
                S = recur(S, N);

                // Push the previous top element again
                S.push(X);
            }
            return S;
        }

        // Function to insert an elementn at the bottom of stack
        static void insertToBottom(Stack<Integer> S, int N)
        {

            // Recursively insert N at the bottom of S
            S = recur(S, N);

            // Print the stack S
            while (S.size() > 0) {
                System.out.print(S.peek() + " ");
                S.pop();
            }
        }

        public static void main_2(String[] args) {
            // Input
            Stack<Integer> S = new Stack<Integer>();
            S.push(5);
            S.push(4);
            S.push(3);
            S.push(2);
            S.push(1);

            int N = 7;

            insertToBottom(S, N);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a stack S and an integer N, the task is to insert N at the bottom of the stack.


            Example : 1
            Input   : N = 7
                      S = 1 <- (Top)
                          2
                          3
                          4
                          5
            Output  : 1 2 3 4 5 7


            Example : 2
            Input   : N = 17
                      S = 1 <- (Top)
                          12
                          34
                          47
                          15
            Output  : 1 12 34 47 15 17


        *
        * */
    }



}
