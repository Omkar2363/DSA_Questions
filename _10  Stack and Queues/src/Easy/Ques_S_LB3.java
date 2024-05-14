package Easy;

public class Ques_S_LB3 {

    //Ques : Reverse a string using Stack.........                                       (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(n),  S.C. = O(n)
    /*  Approach :
            The idea is to create an empty stack and push all the characters from the string into it.
            Then pop each character one by one from the stack and put them back into the input string
            starting from the 0’th index. As we all know, stacks work on the principle of first in, last out.
            After popping all the elements and placing them back to string, the formed string would be reversed.


        Follow the steps given below to reverse a string using stack.
          *  Create an empty stack.
          *  One by one push all characters of string to stack.
          *  One by one pop all characters from stack and put them back to string.

    * */
    /* Java program to reverse String using Stack  */
    static class Stack {
        int size;
        int top;
        char[] a;

        // function to check if stack is empty
        boolean isEmpty() { return (top < 0); }

        Stack(int n)
        {
            top = -1;
            size = n;
            a = new char[size];
        }

        // function to push element in Stack
        boolean push(char x)
        {
            if (top >= size) {
                System.out.println("Stack Overflow");
                return false;
            }
            else {
                a[++top] = x;
                return true;
            }
        }

        // function to pop element from stack
        char pop()
        {
            if (top < 0) {
                System.out.println("Stack Underflow");
                return 0;
            }
            else {
                char x = a[top--];
                return x;
            }
        }
    }
    // Driver code
    class Main {
        // function to reverse the string
        public static void reverse(StringBuffer str)
        {
            // Create a stack of capacity equal to length of string
            int n = str.length();
            Stack obj = new Stack(n);

            // Push all characters of string to stack
            int i;
            for (i = 0; i < n; i++)
                obj.push(str.charAt(i));

            // Pop all characters of string and put them back to str
            for (i = 0; i < n; i++) {
                char ch = obj.pop();
                str.setCharAt(i, ch);
            }
        }

        // driver function
        public static void main_1(String args[])
        {
            // create a new string
            StringBuffer s = new StringBuffer("GeeksQuiz");

            // call reverse method
            reverse(s);

            // print the reversed string
            System.out.println("Reversed string is " + s);
        }
    }






    public static void main(String[] args) {

        /*Ques : You are given a string S, the task is to reverse the string using stack.


            Example : 1
            Input   : S="GeeksforGeeks"
            Output  : skeeGrofskeeG


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function reverse()
            which takes the string S as an input parameter and returns the reversed string.


            Expected Time Complexity  : O(N)
            Expected Auxiliary Space  : O(N)

        * */
    }



}
