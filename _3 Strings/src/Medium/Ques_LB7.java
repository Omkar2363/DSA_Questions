package Medium;

public class Ques_LB7 {

    //Ques : Count of number of given string in 2D character array                               (GFG Ques.)


    //Approach 1 :                                                                               T.C. = O(m*n),  S.C. = O(m*n)
    /*  Approach:

        1. To count all occurrences, we follow simple brute force approach.
        2. Traverse through each character of the matrix and taking each character as a start of the string to be found.
        3. Try to search in all the possible directions.
        4. Whenever, a word is found, increase the count.
        5. After traversing the matrix what ever will be the value of count will be number of times string exists in
           character matrix.


        Algorithm :
        * Step 1– Traverse matrix character by character and take one character as string start
        * Step 2– For each character find the string in all the four directions recursively
        * Step 3– If a string found, we increase the count
        * Step 4– When we are done with one character as start, we repeat the same process for the next character
        * Step 5– Calculate the sum of count for each character
        * Step 6– Final count will be the answer

    *
    * */
    // Utility function to search complete string from any given index of 2d char array
    static int internalSearch(String needle, int row, int col, String hay[], int row_max, int col_max, int xx)
    {
        int found = 0;

        if ((row >= 0 && row <= row_max) && (col >= 0 && col <= col_max) &&
                                            (xx < needle.length() && needle.charAt(xx) == hay[row].charAt(col)))
        {
            char match = needle.charAt(xx);
            xx += 1;

            hay[row] = hay[row].substring(0, col) + "0" + hay[row].substring(col + 1);

            if (xx == needle.length())
            {
                found = 1;
            }
            else
            {

                // Through Backtrack searching in every direction
                found += internalSearch(needle, row,col + 1, hay, row_max, col_max,xx);
                found += internalSearch(needle, row,col - 1, hay, row_max, col_max,xx);
                found += internalSearch(needle,row + 1, col, hay, row_max, col_max,xx);
                found += internalSearch(needle,row - 1, col, hay, row_max, col_max,xx);
            }

            hay[row] = hay[row].substring(0, col)  +  match  +  hay[row].substring(col + 1);
        }
        return found;
    }

    // Function to search the string in 2d array
    static int searchString(String needle, int row, int col, String str[], int row_count, int col_count) {

        int found = 0;
        int r, c;

        for (r = 0; r < row_count; ++r) {
            for (c = 0; c < col_count; ++c) {
                found += internalSearch(needle, r, c, str,row_count - 1,col_count - 1, 0);
            }
        }
        return found;


    /* Driver code
    public static void main(String args[])
    {
        String needle = "MAGIC";
        String input[] = { "BBABBM" ,
                           "CBMBBA" ,
                           "IBABBG" ,
                           "GOZBBI" ,
                           "ABBBBC" ,
                           "MCIGAM"  };
        String str[] = new String[input.length];
        int i;
        for(i = 0; i < input.length; ++i)
        {
            str[i] = input[i];
        }

        System.out.println("count: " + searchString(needle, 0, 0, str, str.length, str[0].length()));
    }*/
    }




    public static void main(String[] args) {

        /*Ques : Given a 2-Dimensional character array and a string, we need to find the
                 given string in 2-dimensional character array, such that individual characters
                 can be present left to right, right to left, top to down or down to top.


            Example  : 1
            Input    : a = {
                           {D,D,D,G,D,D},
                           {B,B,D,E,B,S},
                           {B,S,K,E,B,K},
                           {D,D,D,D,D,E},
                           {D,D,D,D,D,E},
                           {D,D,D,D,D,G}
                           }
                       str = "GEEKS"
            Output   : 2


            Example  : 2
            Input    : a = {
                           {B,B,M,B,B,B},
                           {C,B,A,B,B,B},
                           {I,B,G,B,B,B},
                           {G,B,I,B,B,B},
                           {A,B,C,B,B,B},
                           {M,C,I,G,A,M}
                           }
                       str = "MAGIC
            Output   : 3
        *
        * */
    }

}
