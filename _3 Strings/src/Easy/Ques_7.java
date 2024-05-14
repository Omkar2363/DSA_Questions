package Easy;

import java.util.HashMap;
import java.util.Map;

public class Ques_7 {

    //Ques : Print all the duplicates in the input string.....                            (GFG Ques.)

    //Approach 1 : By using Hashing.....                                                  T.C. = O(n), S.C. = O(NO_OF_CHARS)
    /*Note: Hashing involves the use of an array of fixed size each time
            no matter whatever the string is.

            For example, str = “aaaaaaaaaa”.

            An array of size 256 is used for str, only 1 block out of total size (256) will be
            utilized to store the number of occurrences of ‘a’ in str (i.e count[‘a’] = 10).

            Rest 256 – 1 = 255 blocks remain unused.

            Thus, Space Complexity is potentially high for such cases. So, to avoid any discrepancies
            and to improve Space Complexity, maps are generally preferred over long-sized arrays. */
    static final int NO_OF_CHARS = 256;
    /* Fills count array with frequency of characters */
    static void fillCharCounts(String str, int[] count) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }
    /* Print duplicates present in the passed string */
    static void printDups_1(String str) {

        // Create an array of size 256 and fill count of
        // every character in it
        int count[] = new int[NO_OF_CHARS];
        fillCharCounts(str, count);

        for (int i = 0; i < NO_OF_CHARS; i++)
            if (count[i] > 1)
                System.out.println((char) (i) + ", count = " + count[i]);


    /* Driver Method
    public static void main(String[] args)
    {
        String str = "test string";
        printDups(str);
    }*/
    }



    //Approach 2 : By using HashMap.....                                                  T.C. = O(n), S.C. = O(NO_OF_CHARS)
    /*The approach is the same as discussed in Method 1, but, using a map to store the count.

        Time Complexity  : O(N*log(N)), where N = length of the string passed and it generally takes
                                                  O(log(N)) time for an element insertion in a map.
        Space Complexity : O(K),        where K = size of the map (0<=K<=input_string_length).
     */
    static void printDups_2(String str) {
        HashMap<Character, Integer> count = new HashMap<>();

        /*Store duplicates present in the passed string */
        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), 1);

            else
                count.put(str.charAt(i),
                        count.get(str.charAt(i)) + 1);
        }

        /*Print duplicates in sorted order*/
        for (Map.Entry mapElement : count.entrySet()) {
            char key = (char) mapElement.getKey();
            int value = ((int) mapElement.getValue());

            if (value > 1)
                System.out.println(key + ", count = " + value);
        }

    /* Driver code
    public static void main(String[] args)
    {
        String str = "test string";
        printDups_2(str);
    }*/
    }



    //Approach 3 : By using Maps.....                                                    T.C. = O(n), S.C. = O(K)
    /*  Time Complexity  : O(N),  where N = length of the string passed and it takes
                                            O(1) time to insert and access any element in an unordered map
        Auxiliary Space  : O(K),  where K = size of the map (0<=K<=input_string_length).*/
    static void printDups(String str) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);

            else
                count.put(str.charAt(i), 1);
                //increase the count of characters by 1
        }

        for (Map.Entry<Character, Integer> mapElement : count.entrySet())
        {
            //iterating through the unordered map
            if (mapElement.getValue() > 1)                  //if the count of characters is greater than 1 then duplicate found
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
        }


    /* Driver program to test above function
    public static void main(String args[])
    {
        String str = "test string";
        printDups(str);
    }*/

    }




    public static void main(String[] args) {

        /*Ques : Write an efficient program to print all the duplicates and their
                 counts in the input string
         *
        * */
    }
}
