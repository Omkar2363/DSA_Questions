package Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Ques_LB12 {

    //Ques : First non-repeating character in a stream.........                               (GFG Ques.)


    //Approach 1 :                                                                            T.C. = O(n),   S.C. = O(1)
    // A Java program to find first non-repeating character from a stream of characters
    public class NonReapeatingC {
        final static int MAX_CHAR = 256;
        static void findFirstNonRepeating()
        {
            // inDLL[x] contains pointer to a DLL node if x is present in DLL.
            // If x is not present, then inDLL[x] is NULL
            List<Character> inDLL = new ArrayList<Character>();

            // repeated[x] is true if x is repeated two or more times.
            // If x is not seen so far or x is seen only once, then repeated[x] is false
            boolean[] repeated = new boolean[MAX_CHAR];

            // Let us consider following stream and see the process
            String stream = "geeksforgeeksandgeeksquizfor";
            for (int i = 0; i < stream.length(); i++) {
                char x = stream.charAt(i);
                System.out.println("Reading " + x  + " from stream \n");

                // We process this character only if it has not occurred or occurred only once.
                // repeated[x] is true if x is repeated twice or more
                if (!repeated[x]) {

                    // If the character is not in DLL, then add this at the end of DLL.
                    if (!(inDLL.contains(x))) {
                        inDLL.add(x);
                    }
                    else                                      // Otherwise remove this character from DLL
                    {
                        inDLL.remove((Character)x);
                        repeated[x] = true;                   // Also mark it as repeated
                    }
                }

                // Print the current first non-repeating character from stream
                if (inDLL.size() != 0) {
                    System.out.print( "First non-repeating character so far is ");
                    System.out.println(inDLL.get(0));
                }
            }
        }

        /* Driver code */
        public static void main_1(String[] args)
        {
            findFirstNonRepeating();
        }
    }



    //Approach 2 : Queue based approach......                                                 T.C. = O(n),   S.C. = O(1)
    // Java Program for a Queue based approach to find first non-repeating character
    public class NonReapatingCQueue {
        final static int MAX_CHAR = 26;

        // function to find first non repeating character of stream
        static void firstNonRepeating(String str)
        {
            // count array of size 26(assuming only lower case characters are present)
            int[] charCount = new int[MAX_CHAR];

            // Queue to store Characters
            Queue<Character> q = new LinkedList<Character>();

            // traverse whole stream
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                // push each character in queue
                q.add(ch);

                // increment the frequency count
                charCount[ch - 'a']++;

                // check for the non repeating character
                while (!q.isEmpty()) {
                    if (charCount[q.peek() - 'a'] > 1)
                        q.remove();
                    else {
                        System.out.print(q.peek() + " ");
                        break;
                    }
                }
                if (q.isEmpty())
                    System.out.print(-1 + " ");
            }
            System.out.println();
        }

        // Driver function
        public static void main_2(String[] args)
        {
            String str = "aabc";
            firstNonRepeating(str);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an input stream of A of n characters consisting only of lower case alphabets.
                 The task is to find the first non repeating character, each time a character is
                 inserted to the stream. If there is no such character then append '#' to the answer.


            Example : 1
            Input   : A = "aabc"
            Output  : "a#bb"
            Explanation : For every character first non-repeating character is as following-----
                            "a"    - first non-repeating character is 'a'
                            "aa"   - no non-repeating character so '#'
                            "aab"  - first non-repeating character is 'b'
                            "aabc" - first non-repeating character is 'b'

            Example : 2
            Input   : A = "zz"
            Output  : "z#"
            Explanation : For every character first non-repeating character is as following------
                            "z"   - first non-repeating character is 'z'
                            "zz"  - no non-repeating character so '#'


            Your Task  :
            You don't need to read or print anything. Your task is to complete the function FirstNonRepeating()
            which takes A as input parameter and returns a string after processing the input stream.


            Expected Time Complexity   : O(26 * n)
            Expected Space Complexity  : O(26)

        *
        * */
    }


}
