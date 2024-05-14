package Easy;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;


public class Ques_LB7 {

    //Ques : Second most repeated string in a sequence......                            (GFG Ques.)


    //Approach 1 :                                                                      T.C. = O(n), S.C. = O(n)
    // Method to find the word
    static String secMostRepeated(Vector<String> seq) {
        // Store all the words with its occurrence
        HashMap<String, Integer> occ = new HashMap<String, Integer>(seq.size()) {
            @Override
            public Integer get(Object key) {
                return containsKey(key) ? super.get(key) : 0;
            }
        };

        for (int i = 0; i < seq.size(); i++)
            occ.put(seq.get(i), occ.get(seq.get(i)) + 1);

        // find the second largest occurrence
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;

        Iterator<Map.Entry<String, Integer>> itr = occ.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v > first_max) {
                sec_max = first_max;
                first_max = v;
            } else if (v > sec_max &&
                    v != first_max)
                sec_max = v;
        }

        // Return string with occurrence equals
        // to sec_max
        itr = occ.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v == sec_max)
                return entry.getKey();
        }

        return null;

    /* Driver method
    public static void main(String[] args)
    {
        String arr[] = { "ccc", "aaa", "ccc",
                "ddd", "aaa", "aaa" };
        List<String> seq =  Arrays.asList(arr);

        System.out.println(secMostRepeated(new Vector<>(seq)));
    }*/

    }


    public static void main(String[] args) {

        /*Ques : Given a sequence of strings, the task is to find out the second most repeated (or frequent)
                 string in the given sequence.

                 Note : No two strings are the second most repeated, there will be always a single string.


            Example : 1
            Input   : N = 6
                      arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
            Output  : bbb
            Explanation : "bbb" is the second most occurring string with frequency 2.

            Example : 2
            Input   : N = 6
                      arr[] = {geek, for, geek, for, geek, aaa}
            Output  : for
            Explanation : "for" is the second most occurring string with frequency 2.

            Your Task:
            You don't need to read input or print anything. Your task is to complete the function secFrequent()
            which takes the string array arr[] and its size N as inputs and returns the second  most  frequent
            string in the array.


            Expected Time Complexity: O(N*max(|Si|).
            Expected Auxiliary Space: O(N*max(|Si|).
        *
        * */
    }

}
