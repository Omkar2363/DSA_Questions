package Medium;

import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

public class Ques_13 {

    //Ques : Arrange given numbers to form the biggest number                           (GFG Ques)

    //Approach 1 : Via making a comparator                                              T.C. = O(n)  , S.C. = O()
    // The main function that prints the arrangement with the largest value. The function accepts a vector of strings
    static void printLargest_1(Vector<String> arr) {

        Collections.sort(arr, new Comparator<String>(){
            // A comparison function which is used by sort() in printLargest()
            @Override public int compare(String X, String Y)
            {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two formed numbers is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }

    /* Driver code
    public static void main(String[] args)
    {

        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
    // Output  :  6054854654
    */



    //Approach 2 : Via using sort function                                              T.C. = O(n*log(n))  , S.C. = O(1)
    // The main function that prints the arrangement with the largest value. The function accepts a vector of strings
    static void printLargest_2(ArrayList<Integer> arr) {

        // Sort the numbers using library sort function. The function uses our comparison function myCompare()
        // to compare two strings.
        Collections.sort(arr, new Comparator<Integer>(){

            // A comparison function which is used by sort() in printLargest_2()
            @Override
            public int compare(Integer x, Integer y)
            {
                int xy = x;
                int yx = y;

                // Count length of x and y
                int countx = 0;
                int county = 0;

                // Count length of X
                while (x > 0) {
                    countx++;
                    x /= 10;
                }

                // Count length of Y
                while (y > 0) {
                    county++;
                    y /= 10;
                }

                x = xy;
                y = yx;

                while (countx > 0)
                {
                    countx--;
                    yx *= 10;
                }

                while (county > 0)
                {
                    county--;
                    xy *= 10;
                }

                // Append x to y
                yx += x;

                // Append y to x
                xy += y;

                return -xy + yx;
            }
        });

        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i));
    }

    /* Driver code
    public static void main(String[] args)
    {
        // Output should be 6054854654
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(54);
        arr.add(546);
        arr.add(548);
        arr.add(60);

        printLargest(arr);

    }

    Output :  6054854654
    Time Complexity :  O(n*logn) , sorting is considered to have a running time complexity of O(n logn),
                       and the for loop runs in O(n) time.
    Auxiliary Space : O(1)
    */


    public static void main(String[] args) {


        /*Ques : Given an array of numbers, arrange them in a way that yields the largest value.
                 For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
                              And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives
                              the largest value.


                 NOTE : A simple solution that comes to our mind is to sort all numbers in descending order,
                        but simply sorting does not work. For example, 548 is greater than 60, but in output 60 comes before 548.
                        As a second example, 98 is greater than 9, but 9 comes before 98 in output.
        *
        * */
    }


}
