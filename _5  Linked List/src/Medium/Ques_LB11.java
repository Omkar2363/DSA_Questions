package Medium;

import java.util.HashMap;
import java.util.Map;

public class Ques_LB11 {

    //Ques : Given a string, find its first non-repeating character.........                   (GFG Ques.)


    //Approach 1 : By using HashMap and two string traversal......                             T.C. = O(n), S.C. = O(1)
    /*  Method #1 :  HashMap and Two-string method traversals.

        A character is said to be non-repeating if its frequency in the string is unit. Now for finding
        such characters, one needs to find the frequency of all characters in the string and check which
        character has unit frequency. This task could be done efficiently using a hash_map which will map
        the character to their respective frequencies and in which we can simultaneously update the frequency
        of any character we come across in constant time. The maximum distinct characters in the ASCII system are 256.
        So hash_map has a maximum size of 256. Now read the string again and the first character which
        we find has a frequency as unity is the answer.


        Algorithm :

          1. Make a hash_map which will map the character to their respective frequencies.
          2. Traverse the given string using a pointer.
          3. Increase the count of current character in the hash_map.
          4. Now traverse the string again and check whether the current character has frequency = 1.
          5. If the frequency>1 continue the traversal.
          6. Else break the loop and print the current character as the answer.


        Pseudo Code :
        for ( i=0 to str.length())
            hash_map[str[i]]++;
        for(i=0 to str.length())
            if(hash_map[str[i]] == 1)
              return str[i]
    *
    */
    // Java program to find first non-repeating character
    class GFG_1 {
        static final int NO_OF_CHARS = 256;
        static char count[] = new char[NO_OF_CHARS];

        /* calculate count of characters in the passed string */
        static void getCharCountArray(String str)
        {
            for (int i = 0; i < str.length(); i++)
                count[str.charAt(i)]++;
        }

        /* The method returns index of first non-repeating character in a string.
           If all characters are repeating then returns -1 */
        static int firstNonRepeating(String str)
        {
            getCharCountArray(str);
            int index = -1, i;

            for (i = 0; i < str.length(); i++) {
                if (count[str.charAt(i)] == 1) {
                    index = i;
                    break;
                }
            }

            return index;
        }

        // Driver method
        public static void main(String[] args)
        {
            String str = "geeksforgeeks";
            int index = firstNonRepeating(str);

            System.out.println( index == -1  ? "Either all characters are repeating or string " + "is empty"
                                                          : "First non-repeating character is " + str.charAt(index));
        }
    }



    //Approach 2 :  HashMap and single string traversal....                                   T.C. = O(n), S.C. = O(1)
    /*Method #2: HashMap and single string traversal

        Make a count array instead of hash_map of maximum number of characters(256). We can augment
        the count array by storing not just counts but also the index of the first time you encountered
        the character e.g. (3, 26) for ‘a’ meaning that ‘a’ got counted 3 times and the first time it was
        seen is at position 26. So when it comes to finding the first non-repeater, we just have to scan
        the count array, instead of the string. Thanks to Ben for suggesting this approach.


        Algorithm :
           1. Make a count_array which will have two fields namely frequency, first occurrence of a character.
           2. The size of count_array is ‘256’.
           3. Traverse the given string using a pointer.
           4. Increase the count of current character and update the occurrence.
           5. Now here’s a catch, the array will contain valid first occurrence of the character which has frequency has unity otherwise the first occurrence keeps updating.
           6. Now traverse the count_array and find the character which has least value of first occurrence and frequency value as unity.
           7. Return the character


        Pseudo Code :

        for ( i=0 to str.length())
            count_arr[str[i]].first++;
            count_arr[str[i]].second=i;

        int res=INT_MAX;
        for(i=0 to count_arr.size())
            if(count_arr[str[i]].first==1)
                res=min(min, count_arr[str[i]].second)

        return res
    * */
    // Java program to find first non-repeating character
    // Note : hashmap is used
    static class CountIndex {
        int count, index;

        // constructor for first occurrence
        public CountIndex(int index)
        {
            this.count = 1;
            this.index = index;
        }

        // method for updating count
        public void incCount()
        {
            this.count++;
        }
    }
    class GFG {
        static final int NO_OF_CHARS = 256;

        static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);

        /* calculate count of characters in the passed string */
        static void getCharCountArray(String str)
        {
            for (int i = 0; i < str.length(); i++) {
                // If character already occurred,
                if (hm.containsKey(str.charAt(i))) {
                    // updating count
                    hm.get(str.charAt(i)).incCount();
                }

                // If it's first occurrence, then store the index and count = 1
                else {
                    hm.put(str.charAt(i), new CountIndex(i));
                }
            }
        }

        /* The method returns index of first non-repeating character in a string.
           If all characters are repeating then returns -1 */
        static int firstNonRepeating(String str)
        {
            getCharCountArray(str);
            int result = Integer.MAX_VALUE, i;
            for (Map.Entry<Character, CountIndex> entry : hm.entrySet())
            {
                int   c = entry.getValue().count;
                int ind = entry.getValue().index;
                if(c == 1  &&  ind < result)
                {
                    result = ind;
                }
            }
            return result;
        }

        // Driver method
        public static void main_2(String[] args)
        {
            String str = "geeksforgeeks";
            int index = firstNonRepeating(str);

            System.out.println( index == Integer.MAX_VALUE  ?  "Either all characters are repeating " + " or string is empty"
                                                            : "First non-repeating character is " + str.charAt(index));
        }
    }



    //Approach 3 :                                                                           T.C. = O(n), S.C. = O(1)
    /*  Method #3 : Count array and single string traversal :

        Approach :
        Make a count array of maximum number of characters(256). We can initialize all the elements
        in this array to -1. And then loop through our string character by character and check if the
        array element with this character as index is -1 or not. If it is -1 then change it to i and
        if it not -1 then this means that this character already appeared before, so change it to -2.

        In the end all the repeating characters will be changed to -2 and all non-repeating characters
        will contain the index where they occur. Now we can just loop through all the non-repeating
        characters and find the minimum index or the first index.
    * */
    // JAVA program to find first non-repeating character
    public class GFG_3 {

        // this function return the index of first non-repeating  character if found, or else it returns -1
        public static int firstNonRepeating(String str) {
            int[] fi = new int [256];                                  // array to store First Index

            // initializing all elements to -1
            for(int i = 0; i<256; i++)
                fi[i] = -1;

            // sets all repeating characters to -2 and non-repeating characters contain the index where they occur
            for(int i = 0; i<str.length(); i++) {
                if(fi[str.charAt(i)] == -1) {
                    fi[str.charAt(i)] = i;
                }else {
                    fi[str.charAt(i)] = -2;
                }
            }

            int res =  Integer.MAX_VALUE;

            for(int i = 0; i<256; i++) {

                // If this character is not -1 or -2 then it means that this character occurred only once
                // so find the min index of all characters that occur only once, that's our first index
                if(fi[i] >= 0)
                    res = Math.min(res, fi[i]);
            }

            // if res remains  Integer.MAX_VALUE, it means there are no
            // characters that repeat only once or the string is empty
            if(res ==  Integer.MAX_VALUE) return -1;
            else return res;
        }

        public static void main_3(String args[]){
            String str;
            str = "geeksforgeeks";
            int firstIndex = firstNonRepeating(str);
            if (firstIndex == -1)
                System.out.println("Either all characters are repeating or string is empty");
            else
                System.out.println("First non-repeating character is "+ str.charAt(firstIndex));
        }
    }






    public static void main(String[] args) {

        /*Ques : Given a string, find the first non-repeating character in it.
                 For example : if the input string is “GeeksforGeeks”, then the output should be ‘f’ and
                               if the input string is “GeeksQuiz”, then the output should be ‘G’.

            Example : 1
            Input   : "geeksforgeeks"
            Explanation :
                 Step 1 : Construct a character count array from the input string.
                  ....
                  count['e'] = 4
                  count['f'] = 1
                  count['g'] = 2
                  count['k'] = 2
                  ....

                Step 2 : Get the first character whose count is 1 ('f').
        *
        *
        * */

    }



}
