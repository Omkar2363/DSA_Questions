package Medium;

import java.util.Stack;

public class Ques_S_5 {

    //Ques : Find if an expression has duplicate parenthesis or not.......             (GFG Ques.)


    //Approach 1 :                                                                     T.C. = O(n),  S.C. = O(n)
    // Java program to find duplicate parenthesis in a balanced expression
    public class GFG {
        // Function to find duplicate parenthesis in a balanced expression
        static boolean findDuplicateparenthesis(String s) {
            // create a stack of characters
            Stack<Character> Stack = new Stack<>();

            // Iterate through the given expression
            char[] str = s.toCharArray();

            for (char ch : str) {
                // if current character is close parenthesis ')'
                if (ch == ')') {
                    // pop character from the stack
                    char top = Stack.peek();
                    Stack.pop();

                    // stores the number of characters between a closing and opening parenthesis
                    // if this count is less than or equal to 1 then the brackets are redundant else not
                    int elementsInside = 0;
                    while (top != '(') {
                        elementsInside++;
                        top = Stack.peek();
                        Stack.pop();
                    }
                    if (elementsInside < 1) {
                        return true;
                    }
                }  // push open parenthesis '(', operators and operands to stack
                else {
                    Stack.push(ch);
                }
            }

            // No duplicates found
            return false;
        }

        // Driver code
        public static void main(String[] args) {

            // input balanced expression
            String str = "(((a+(b))+(c+d)))";

            if (findDuplicateparenthesis(str)) {
                System.out.println("Duplicate Found ");
            } else {
                System.out.println("No Duplicates Found ");
            }
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a balanced expression, find if it contains duplicate parenthesis or not. A set of
                 parenthesis are duplicate if the same subexpression is surrounded by multiple parenthesis.


            Examples :
            * Below expressions have duplicate parenthesis -
                1. ((a+b)+((c+d)))
                   The subexpression "c+d" is surrounded by two pairs of brackets.

                2. (((a+(b)))+(c+d))
                   The subexpression "a+(b)" is surrounded by two pairs of brackets.

                3. (((a+(b))+c+d))
                   The whole expression is surrounded by two pairs of brackets.

                4. ((a+(b))+(c+d))
                   (b) and ((a+(b)) is surrounded by two pairs of brackets.

           * Below expressions don't have any duplicate parenthesis -
                5. ((a+b)+(c+d))
                    No subexpression is surrounded by duplicate brackets.


        */

    }



}
