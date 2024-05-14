package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;


public class Ques_Q_3 {

    //Ques : Minimum sum of squares of character counts in a given string after removing k characters
    //                                                                                  (GFG Ques.)


    //Approach 1 :                                                                      T.C. = O(k * log(n)),  S.C. = O(1)
    /*  A Simple solution is to use sorting technique through all current highest frequency reduce up to k times.
        For After every reduce again sort frequency array.

        * A Better Solution used to Priority Queue which has to the highest element on top.
            1. Initialize empty priority queue.
            2. Count frequency of each character and Store into temp array.
            3. Remove K characters which have highest frequency from queue.
            4. Finally, Count Sum of square of each element and return it.

    * */
    // Java program to find min sum of squares of characters after k removals
    public class GFG {

        static final int MAX_CHAR = 26;

        // Main Function to calculate min sum of squares of characters after k removals
        static int minStringValue(String str, int k)
        {
            int l = str.length();                               // find length of string

            // if K is greater than length of string so reduced string will become 0
            if (k >= l)
                return 0;

            // Else find Frequency of each character and store in an array
            int[] frequency = new int[MAX_CHAR];
            for (int i = 0; i < l; i++)
                frequency[str.charAt(i) - 'a']++;

            // creating a priority queue with comparator such that elements in the queue are in descending order.
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

            // Push each char frequency into a priority_queue
            for (int i = 0; i < MAX_CHAR; i++) {
                if (frequency[i] != 0)
                    q.add(frequency[i]);
            }

            // Removal of K characters
            while (k != 0) {
                // Get top element in priority_queue, remove it. Decrement by 1 and again push into priority_queue
                q.add(q.poll() - 1);
                k--;
            }

            // After removal of K characters find sum of squares of string Value
            int result = 0;                                               // Initialize result
            while (!q.isEmpty())
            {
                result += q.peek() * q.poll();
            }

            return result;
        }

        // Driver Code
        public static void main_1(String args[])
        {
            String str = "abbccc";                                       // Input 1
            int k = 2;
            System.out.println(minStringValue(str, k));

            str = "aaab";                                               // Input 2
            k = 2;
            System.out.println(minStringValue(str, k));
        }
    }




    //Approach 2 :                                                                     T.C. = O(n),  S.C. = O(n)
    /*  Efficient Approach :
            We can solve it in O(N) time complexity as we need to be greedy and always
            remove the characters of alphabets which are higher in frequency.

            Example : Let str=”abbccc” and k=2
                      now, alphabetCount[1]=1;               //for ‘a’
                           alphabetCount[2]=2;               //for ‘b’
                           alphabetCount[3]=3;               //for ‘c’

                           maximum=3
                           m[1] = 1           (only a occur 1 times)
                           m[2] = 1           (only b occur 2 times)
                           m[3] = 1           (only c occur 3 times)

                     //k = 2    maximum = 3   so k = k-m[maximum]
                     k = k-1; so now one c got removes so frequencies are a=1,b=2,c=2;
                              so as c’s frequency got decreased by one m[maximum] will be zero and
                              m[maximum-1] will be increased by m[maximum]
                     so update
                     m[2] += m[3], m[3] = 0; also maximum gets decreased by one as it is guaranteed to
                                             exist frequency one less than maximum from above.
                    m[1] = 1 , m[2] = 2 , m[3] = 0 and k = 1;
                    now m[maximum](i.e m[2]=2>k) so we should partially remove one character of either b or c
                    so m[1]=2 0,m[2]=1 ,m[3]=0 and k=0; so, (1*1)*2 + (2*2)*1 + (3*3)*0 = 6//ans


    * */
    // Java program to find min sum of squares of characters after k removals
    public class GFG_2 {
        static final int MAX_CHAR = 26;

        // Main Function to calculate min sum of squares of characters after k removals
        static int minStringValue(String str, int k)
        {
            int[] alphabetCount = new int[MAX_CHAR];

            // Here the array stored frequency the number of occurrences in string
            // m[frequency] = number of alphabets with frequency
            // i.e, in our example : abbccc m[1] = 1(1 a's occur),
            //                              m[2] = 1(2 b's occur),
            //                              m[3] = 1(3 c's occur).

            int[] m = new int[str.length()];

            for (int i = 0; i < str.length(); i++) {
                alphabetCount[str.charAt(i) - 'a']++;
            }
            // Store the maximum
            int maximum = 0;

            for (int i = 0; i < MAX_CHAR; i++) {
                m[alphabetCount[i]]++;
                maximum = Math.max(maximum, alphabetCount[i]);
            }

            while (k > 0) {
                int z = m[maximum];
                if (z <= k) {
                    /*
                     Remove one occurrence of alphabet from each with frequency as maximum.
                     So we will have k-z more remove operations to perform as z is number of characters,
                     and we perform one removal from each of the alphabet with that frequency.
                    */

                    k = k - z;

                    // As we removed one occurrence from each the alphabets will no longer have
                    // the frequency of maximum their frequency will be decreased by one
                    // so add these number of alphabets to group with frequency one less than maximum.
                    // Remove them from maximum count.

                    m[maximum] = 0;

                    // Add those to frequency one less.
                    m[maximum - 1] += z;

                    // new maximum will be one less.
                    maximum--;
                }
                else {
                    // if all the elements of that frequency cannot be removed
                    // we should partially remove them.
                    m[maximum] -= k;
                    maximum--;
                    m[maximum] += k;
                    k = 0;
                }
            }

            int ans = 0;
            for (int i = 0; i < str.length(); i++) {
                //(square of frequency) * (number of characters corresponding to that frequency)
                ans += (i * i) * m[i];
            }

            return ans;
        }

        // Driver Code
        public static void main_2(String args[])
        {
            String str = "abbccc";                                          // Input 1
            int k = 2;
            System.out.println(minStringValue(str, k));

            str = "aaab";                                                  // Input 2
            k = 2;
            System.out.println(minStringValue(str, k));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a string of lowercase alphabets and a number k, the task is to print the minimum value of
                 the string after removal of ‘k’ characters. The value of a string is defined as the sum of squares
                 of the count of each distinct character.

            For example : Consider the string “saideep”, here frequencies of characters are
                          s-1, a-1, i-1, e-2, d-1, p-1 and value of the string is 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9.

            Expected Time Complexity : O(k * log(n))


            Example : 1
            Input   : str = abccc, K = 1
            Output  : 6
            Explanation : We remove c to get the value as 12 + 12 + 22

            Example : 2
            Input   : str = aaab, K = 2
            Output  : 2


        *
        *
        *
        * */

    }




}
