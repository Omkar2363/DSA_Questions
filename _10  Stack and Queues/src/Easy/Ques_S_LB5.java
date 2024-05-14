package Easy;

import java.util.Stack;

public class Ques_S_LB5 {

    //Ques : Evaluation of Postfix Expression..........                                     (GFG Ques.)


    //Approach 1 : By using Stack........                                                   T.C. = O(n),  S.C. = O(n)
    /*  Evaluation of Postfix Expression Using Stack :

        Follow the steps mentioned below to evaluate postfix expression using stack:
          *  Create a stack to store operands (or values).
          *  Scan the given expression from left to right and do the following for every scanned element.
                - If the element is a number, push it into the stack
                - If the element is an operator, pop operands for the operator from the stack.
                  Evaluate the operator and push the result back to the stack
          *  When the expression is ended, the number in the stack is the final answer
    * */
    // Java program to evaluate value of a postfix expression
    public class Test {
        // Method to evaluate value of a postfix expression
        static int evaluatePostfix(String exp)
        {
            //create a stack
            Stack<Integer> stack = new Stack<>();

            // Scan all characters one by one
            for(int i=0; i<exp.length(); i++)
            {
                char c =  exp.charAt(i);

                // If the scanned character is an operand (number here), push it to the stack.
                if(Character.isDigit(c))
                    stack.push(c - '0');

                    //  If the scanned character is an operator, pop two
                    // elements from stack apply the operator
                else
                {
                    int val1 = stack.pop();
                    int val2 = stack.pop();

                    switch(c)
                    {
                        case '+' :  stack.push(val2+val1);
                                        break;

                        case '-' :  stack.push(val2- val1);
                                        break;

                        case '/' : stack.push(val2/val1);
                                        break;

                        case '*' : stack.push(val2*val1);
                                        break;
                    }
                }
            }
            return stack.pop();
        }

        // Driver program to test above functions
        public static void main_1(String[] args)
        {
            String exp="231*+9-";
            System.out.println("postfix evaluation: "+evaluatePostfix(exp));
        }
    }



    //Approach 2 :                                                                         T.C. = O(n),  S.C. = O(n)
    /*  There are the following limitations of the above implementation :
           *  It supports only 4 binary operators '+', '*', '-' and '/'. It can be extended for more
              operators by adding more switch cases.
           *  The allowed operands are only single-digit operands. The program can be extended for multiple
              digits by adding a separator-like space between all elements (operators and operands) of the given expression.
    * */
    // Below given is the extended program which allows operands to have multiple digits.
    // Java program to evaluate value of a postfix expression having multiple digit operands
    class Test1 {

        // Method to evaluate value of a postfix expression
        static int evaluatePostfix(String exp)
        {
            //create a stack
            Stack<Integer> stack = new Stack<>();

            // Scan all characters one by one
            for(int i = 0; i < exp.length(); i++)
            {
                char c = exp.charAt(i);

                if(c == ' ')
                    continue;

                    // If the scanned character is an operand (number here),extract the number
                    // Push it to the stack.
                else if(Character.isDigit(c))
                {
                    int n = 0;

                    //extract the characters and store it in num
                    while(Character.isDigit(c))
                    {
                        n = n*10 + (int)(c-'0');
                        i++;
                        c = exp.charAt(i);
                    }
                    i--;

                    //push the number in stack
                    stack.push(n);
                }

                // If the scanned character is an operator, pop two elements from stack apply the operator
                else
                {
                    int val1 = stack.pop();
                    int val2 = stack.pop();

                    switch(c)
                    {
                        case '+' :  stack.push(val2+val1);
                                        break;

                        case '-' :  stack.push(val2- val1);
                                        break;

                        case '/' :  stack.push(val2/val1);
                                        break;

                        case '*' :  stack.push(val2*val1);
                                        break;
                    }
                }
            }
            return stack.pop();
        }

        // Driver program to test above functions
        public static void main_2(String[] args)
        {
            String exp = "100 200 + 2 / 5 * 7 +";
            System.out.println(evaluatePostfix(exp));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given string S representing a postfix expression, the task is to evaluate the expression and
                 find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.


            Example : 1
            Input   : S = "231*+9-"
            Output  : -4
            Explanation : After solving the given expression, we have -4 as result.


            Example : 2
            Input   : S = "123+*8-"
            Output  : -3
            Explanation : After solving the given postfix expression, we have -3 as result.


            Your Task :
            You do not need to read input or print anything. Complete the function evaluatePostfixExpression()
            that takes the string S denoting the expression as input parameter and returns the evaluated value.


            Expected Time Complexity  : O(|S|)
            Expected Auxiliary Space  : O(|S|)

        *
        * */

    }




}
