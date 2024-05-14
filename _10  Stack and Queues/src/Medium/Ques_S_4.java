package Medium;

import java.util.Stack;

public class Ques_S_4 {

    //Ques : Length of the longest valid substring........                                   (GFG Ques.)


    //Approach 1 : Simple Approach........
    /*  A Simple Approach is to find all the substrings of given string.
        For every string, check if it is a valid string or not. If valid and length is more than
        maximum length so far, then update maximum length. We can check whether a substring is valid
        or not in linear time using a stack (See this for details). Time complexity of this solution is O(n^2).


     * */



    //Approach 2 : Efficient Approach.......
    /*  An Efficient Solution can solve this problem in O(n) time. The idea is to store indexes
        of previous starting brackets in a stack. The first element of the stack is a special element
        that provides index before the beginning of valid substring (base for next valid string).

            1) Create an empty stack and push -1 to it.
               The first element of the stack is used
               to provide a base for the next valid string.

            2) Initialize result as 0.

            3) If the character is '(' i.e. str[i] == '('),
               push index 'i' to the stack.

            2) Else (if the character is ')')
               a) Pop an item from the stack (Most of the
                  time an opening bracket)
               b) If the stack is not empty, then find the
                  length of current valid substring by taking
                  the difference between the current index and
                  top of the stack. If current length is more
                  than the result, then update the result.
               c) If the stack is empty, push the current index
                  as a base for the next valid substring.

            3) Return result
    * */
    // Java program to find length of the longest valid substring
    class Test_2 {
        // method to get length of the longest valid
        static int findMaxLen(String str)
        {
            int n = str.length();

            // Create a stack and push -1 as initial index to it.
            Stack<Integer> stk = new Stack<>();
            stk.push(-1);

            // Initialize result
            int result = 0;

            // Traverse all characters of given string
            for (int i = 0; i < n; i++)
            {
                // If opening bracket, push index of it
                if (str.charAt(i) == '(')
                    stk.push(i);

                    // If closing bracket, i.e.,str[i] = ')'
                else
                {
                    // Pop the previous opening bracket's index
                    if(!stk.empty())
                        stk.pop();

                    // Check if this length formed with base of current valid substring
                    // is more than max so far
                    if (!stk.empty())
                        result = Math.max(result, i - stk.peek());

                        // If stack is empty. push current index as base for next valid substring (if any)
                    else
                        stk.push(i);
                }
            }

            return result;
        }

        // Driver code
        public static void main_2(String[] args)
        {
            String str = "((()()";

            // Function call
            System.out.println(findMaxLen(str));

            str = "()(()))))";

            // Function call
            System.out.println(findMaxLen(str));
        }
    }



    //Approach 3 : Another Efficient Approach.......
    /*  Another Efficient Approach can solve the problem in O(n) time. The idea is to maintain an array
        that stores the length of the longest valid substring ending at that index. We iterate through
        the array and return the maximum value.

            1) Create an array longest of length n (size of the input
               string) initialized to zero.
               The array will store the length of the longest valid
               substring ending at that index.

            2) Initialize result as 0.

            3) Iterate through the string from second character
               a) If the character is '(' set longest[i]=0 as no
                  valid sub-string will end with '('.
               b) Else
                  i) if s[i-1] = '('
                        set longest[i] = longest[i-2] + 2
                  ii) else
                        set longest[i] = longest[i-1] + 2 +
                        longest[i-longest[i-1]-2]

            4) In each iteration update result as the maximum of
               result and longest[i]

            5) Return result.

    * */
    // Java program to find length of the longest valid subString
    class GFG_3 {
        static int findMaxLen(String s)
        {
            if (s.length() <= 1)
                return 0;

            // Initialize curMax to zero
            int curMax = 0;
            int[] longest = new int[s.length()];

            // Iterate over the String starting from second index
            for (int i = 1; i < s.length(); i++)
            {
                if (s.charAt(i) == ')'  &&  i - longest[i - 1] - 1 >= 0  &&  s.charAt(i - longest[i - 1] - 1) == '(')
                {
                    longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0)
                                                                            ? longest[i - longest[i - 1] - 2]
                                                                            : 0);
                    curMax = Math.max(longest[i], curMax);
                }
            }
            return curMax;
        }

        // Driver code
        public static void main_3(String[] args)
        {
            String str = "((()()";

            // Function call
            System.out.print(findMaxLen(str) +"\n");

            str = "()(()))))";

            // Function call
            System.out.print(findMaxLen(str) +"\n");

        }
    }




    //Approach 4 : Another approach........
    /*  Another approach in O(1) auxiliary space and O(N) Time complexity :
           1). The idea to solve this problem is to traverse the string on and keep track of the count of
               open parentheses and close parentheses with the help of two counters left and right respectively.
           2). First, the string is traversed from the left towards the right and for every “(” encountered,
               the left counter is incremented by 1 and for every “)” the right counter is incremented by 1.
           3). Whenever the left becomes equal to right, the length of the current valid string is calculated
               and if it greater than the current longest substring, then value of required the longest substring
               is updated with current string length.
           4). If the right counter becomes greater than the left counter, then the set of parentheses has become
               invalid and hence the left and right counters are set to 0.
           5). After the above process, the string is similarly traversed from right to left and similar procedure
               is applied.
    * */
    // Java program to implement the above approach
    class GFG_4 {

        // Function to return the length of the longest valid substring
        public static int solve(String s, int n)
        {

            // Variables for left and right counter maxlength to store the maximum length found so far
            int left = 0, right = 0;
            int maxlength = 0;

            // Iterating the string from left to right
            for (int i = 0; i < n; i++) {

                // If "(" is encountered, then left counter is incremented else right counter is incremented
                if (s.charAt(i) == '(')
                    left++;
                else
                    right++;

                // Whenever left is equal to right, it signifies that the subsequence is valid and
                if (left == right)
                    maxlength = Math.max(maxlength, 2 * right);

                    // Resetting the counters when the subsequence becomes invalid
                else if (right > left)
                    left = right = 0;
            }

            left = right = 0;

            // Iterating the string from right to left
            for (int i = n - 1; i >= 0; i--) {

                // If "(" is encountered, then left counter is incremented else right counter is incremented
                if (s.charAt(i) == '(')
                    left++;
                else
                    right++;

                // Whenever left is equal to right, it signifies that the subsequence is valid and
                if (left == right)
                    maxlength = Math.max(maxlength, 2 * left);

                    // Resetting the counters when the subsequence becomes invalid
                else if (left > right)
                    left = right = 0;
            }
            return maxlength;
        }

        // Driver code
        public static void main(String args[])
        {
            // Function call
            System.out.print(solve("((()()()()(((())", 16));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a string consisting of opening and closing parenthesis, find the length of the
                 longest valid parenthesis substring.


            Example : 1
            Input   : ((()
            Output  : 2
            Explanation : ()

            Example : 2
            Input   : )()())
            Output  : 4
            Explanation : ()()

            Example : 3
            Input   : ()(()))))
            Output  : 6
            Explanation :  ()(())

        * */
    }


}
