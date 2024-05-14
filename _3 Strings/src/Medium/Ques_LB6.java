package Medium;

import java.util.Stack;

public class Ques_LB6 {

    //Ques : Count the Reversals.......                                                       (GFG Ques.)
    //       (Minimum number of bracket reversals needed to make an expression balanced...)


    //Approach 1 : Naive Approach.....
    /*  Approach : A Naive Solution is to consider every bracket and recursively count
                   number of reversals by taking two cases (i) keeping the bracket  as
                   it is (ii) reversing the bracket. If we get a balanced  expression,
                   we update result if number of steps followed for reaching here is smaller
                   than the minimum so far. Time complexity of this solution is O(2n).
     * */


    //Approach 2 : Efficient Approach.....Using Stack.....                                   T.C. = O(n),  S.C. = O(n)
    /*  An Efficient Solution can solve this problem in O(n) time.
        The idea is to first remove all balanced part of expression.
        For example, convert “}{{}}{{{” to “}{{{” by removing highlighted part.
                     If we take a closer look, we can notice that, after removing balanced part,
                     we always end up with an expression of the form }}…}{{…{,  an  expression
                     that contains 0 or more number of closing brackets followed by 0 or more
                     numbers of opening brackets.

        How many minimum reversals are required for an expression of the form “}}..}{{..{” ?.
        Let m be the total number of closing brackets and n be the number of opening brackets.
        We need ⌈m/2⌉ + ⌈n/2⌉ reversals. For example }}}}{{ requires 2+1 reversals.
    *
    * */
    public class GFG_2 {

        /*
         Method count minimum reversal for making an expression balanced.
         Returns -1 if expression cannot be balanced
        */
        static int countMinReversals(String expr)
        {
            int len = expr.length();

            // length of expression must be even to make it balanced by using reversals.
            if (len % 2 != 0)
                return -1;

            /*
             After this loop, stack contains unbalanced part of expression,
             i.e., expression of the form "}}..}{{..{"
            */
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < len; i++) {
                char c = expr.charAt(i);
                if (c == '}' && !s.empty()) {
                    if (s.peek() == '{')
                        s.pop();
                    else
                        s.push(c);
                }
                else
                    s.push(c);
            }

            // Length of the reduced expression red_len = (m+n)
            int red_len = s.size();

            // count opening brackets at the end of stack
            int n = 0;
            while (!s.empty() && s.peek() == '{') {
                s.pop();
                n++;
            }

            // return ceil(m/2) + ceil(n/2) which is actually equal to (m+n)/2 + n%2
            // when m+n is even.
            return (red_len / 2 + n % 2);
        }

        // Driver method
        public static void main_1(String[] args)
        {
            String expr = "}}{{";

            System.out.println(countMinReversals(expr));
        }
    }


    //Approach 3 : Another  efficient approach......                                        T.C. = O(n),  S.C. = O(n)
    /*  Another Intuitive Solution can solve this problem with same complexity.

        The idea is to follow the algorithm used in Check if the parentheses is balanced or not.
        We follow this algorithm with a new condition when we find that the parentheses is not balanced.
        This case arises when the stack is empty and we encounter a ‘ } ‘. In Check if the parentheses
        is balanced or not program we break the loop when we find that parentheses is not balanced but here
        we will reverse it to ‘ { ‘ and push it to the stack. While doing this, answer is incremented by 1.

        Here, since we found a case of unbalanced expression the ‘ { ‘ must be changed in order to get a
        balanced expression. Also, changing this would be the most minimal way to get a balanced expression
        as it is a must condition to change it.

        For example,  string = “}{{}}{}}” will be converted to “{{{}}{}}” and we get a balanced expression.

        There may arise a case where after doing this to the string we have some ‘{‘ left in the stack.
        For example,  string = “{}{{{{” will be converted to “{}{{{{” and there will be 4 ‘{‘ present in the stack
        which are not popped and are not balanced.

        We can simply make it balanced by reversing the right half of the stack to ‘}’.
        Example: if stack has ‘ {{{{ ‘ left, we make it ‘ {{}} ‘ forming a balanced expression.
        Hence, answer gets updated by (stack size / 2). The case where the size of stack is odd,
        it is not possible to transform it to a balanced string.
    * */
    class GFG_3 {
        static int countMinReversals(String str){

            // Step 1: Initialize a stack of char type and ans as 0.
            Stack<Character> st = new Stack<Character>();
            int ans = 0;

            // Step 2: Run a loop for each character of the string
            for (int i = 0 ; i < str.length() ; i++) {

                // Step 2.1: If ' { ' encountered push it to the
                // stack
                if (str.charAt(i) == '{')
                    st.add(str.charAt(i));

                    // Step 2.2: If ' } ' is encountered
                else {
                    // Step 2.2.1: If stack has a '{' present for '}' encountered, pop from the stack.
                    if (!st.isEmpty())
                        st.pop();

                        // Step 2.2.2: If stack is empty, change '}' to '{' and push it to stack and increment ans by 1
                    else {
                        st.add('{');
                        ans++;
                    }
                }
            }
            // Step 3: if stack size is odd return -1.
            if (st.size() % 2 != 0)
                return -1;

            // Step 4: Increment ans by ( stackSize/2 ).
            ans += st.size() / 2;

            return ans;
        }

        // Driver code
        public static void main(String args[])
        {
            String expr = "{{{{}}";
            System.out.println(countMinReversals(expr));
        }
    }



    //Approach 4 : Space Efficient approach.......                                          T.C. = O(n),  S.C. = O(1)
    public class GFG_4 {

        // Method count minimum reversal for making an expression balanced.
        // Returns -1 if expression cannot be balanced
        static int countMinReversals(String expr){
            int len = expr.length();
            int ans;

            // Expressions of odd lengths cannot be balanced
            if (len % 2 != 0) {
                return -1;
            }
            int left_brace = 0, right_brace = 0;
            for (int i = 0; i < len; i++) {
                char ch = expr.charAt(i);

                // If we find a left bracket then we simply increment the left bracket
                if (ch == '{') {
                    left_brace++;
                }

                // Else if left bracket is 0 then we find unbalanced right bracket and increment
                // right bracket or if the expression is balanced then we decrement left
                else {
                    if (left_brace == 0) {
                        right_brace++;
                    }
                    else {
                        left_brace--;
                    }
                }
            }
            ans = (int)(Math.ceil((0.0 + left_brace) / 2) + Math.ceil((0.0 + right_brace) / 2));
            return ans;
        }

        // Driver method
        public static void main(String[] args)
        {
            String expr = "}}{{";

            System.out.println(countMinReversals(expr));
        }
    }



    //Approach 5 : Another space efficient approach........                                 T.C. = O(n),  S.C. = O(1)
    class GFG_5 {

        /*
         Returns count of minimum reversals for making expr balanced.
         Returns -1 if expr cannot be balanced.
        */
        static int countMinReversals(String s) {

            int temp = 0, res = 0, n = s.length();
            if (n % 2 != 0)
                return -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '{')
                    temp++;
                else {
                    if (temp == 0) {
                        res++;
                        temp++;
                    }
                    else
                        temp--;
                }
            }
            if (temp > 0)
                res += temp / 2;
            return res;
        }

        // Driver program to test above function
        public static void main(String[] args)
        {
            String expr = "}}{{";
            System.out.print(countMinReversals(expr));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a string S consisting of only opening and closing curly brackets '{' and '}',
                 find out the minimum number of reversals required to convert the string into a balanced expression.
                 A reversal means changing '{' to '}' or vice-versa.


            Example : 1
            Input   : S = "}{{}}{{{"
            Output  : 3
            Explanation : One way to balance is: "{{{}}{}}".
                          There is no balanced sequence that can be formed in lesser reversals.


            Example : 2
            Input   : S = "{{}{{{}{{}}{{"
            Output  : -1
            Explanation : There's no way we can balance this sequence of braces.

            Your Task :
            You don't need to read input or print anything. Your task is to complete the function countRev()
            which takes the string S as input parameter and returns the minimum number of reversals required
            to balance the bracket sequence. If balancing is not possible, return -1.

            Expected Time Complexity : O(|S|).
            Expected Auxiliary Space : O(1).
        *
        *
        * */
    }



}
