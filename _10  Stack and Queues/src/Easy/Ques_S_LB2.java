package Easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ques_S_LB2 {

    //Ques : Parenthesis Checker.........                                              (GFG Ques.)


    //Approach 1 :                                                                     T.C. = O(n),  S.C. = O(n)
    /*  Approach :
            The idea is to put all the opening brackets in the stack and whenever you hit a closing bracket.
            Search if the top of the stack is the opening bracket of the same nature. If this holds then pop
            the stack and continue the iteration , in the end if the stack is empty, it means all brackets are
            well-formed and return  Balanced , else return Not Balanced.

            Illustration:
            Below is the illustration of above approach.
            //Follow the link for visual representation......
            //Link : https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1


        Follow the steps mentioned below to implement the idea :

          * Declare a character stack temp.
          * Now traverse the string exp.
                - If the current character is a starting bracket ( ( or {  or [ ) then push it to stack.
                - If the current character is a closing bracket ( ) or  }  or ] ) then pop from stack and
                    if the popped character is the matching starting bracket then fine else brackets are Not Balanced.
          * After complete traversal, if there is some starting bracket left in stack then Not balanced , else Balanced.

    * */
    // Java program for checking balanced brackets
    public class BalancedBrackets {

        // function to check if brackets are balanced
        static boolean areBracketsBalanced(String expr)
        {
            // Using ArrayDeque is faster than using Stack class
            Deque<Character> stack = new ArrayDeque<Character>();

            // Traversing the Expression
            for (int i = 0; i < expr.length(); i++) {
                char x = expr.charAt(i);

                if (x == '(' || x == '[' || x == '{') {
                    // Push the element in the stack
                    stack.push(x);
                    continue;
                }

                // If current character is not opening
                // bracket, then it must be closing. So stack
                // cannot be empty at this point.
                if (stack.isEmpty())
                    return false;
                char check;
                switch (x) {
                    case ')' :  check = stack.pop();
                                if (check == '{' || check == '[')
                                    return false;
                                    break;

                    case '}' :  check = stack.pop();
                                if (check == '(' || check == '[')
                                    return false;
                                    break;

                    case ']' :  check = stack.pop();
                                if (check == '(' || check == '{')
                                    return false;
                                    break;
                }
            }

            // Check Empty Stack
            return (stack.isEmpty());
        }

        // Driver code
        public static void main_1(String[] args)
        {
            String expr = "([{}])";

            // Function call
            if (areBracketsBalanced(expr))
                System.out.println("Balanced ");
            else
                System.out.println("Not Balanced ");
        }
    }






    public static void main(String[] args) {

        /*Ques : Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]”
                 are correct in exp.
                 For example : the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.

            Example : 1
            Input   : {([])}
            Output  : true
            Explanation :  { ( [ ] ) }. Same colored brackets can form balanced pairs,
                           with 0 number of unbalanced bracket.

            Example : 2
            Input   : ()
            Output  : true
            Explanation :  (). Same bracket can form balanced pairs, and here only 1 type
                           of bracket is present and in balanced way.

            Example : 3
            Input   : ([]
            Output  : false
            Explanation :  ([]. Here square bracket is balanced but the small bracket is not balanced and
                           Hence , the output will be unbalanced.

            Your Task :
            This is a function problem. You only need to complete the function ispar() that takes a string
            as a parameter and returns a boolean value true if brackets are balanced else returns false.
            The printing is done automatically by the driver code.


            Expected Time Complexity    : O(|x|)
            Expected Auxiliary Space  : O(|x|)



        * */
    }



}
