package Easy;

import java.util.Collections;
import java.util.ArrayList;

public class Ques_5 {

    //Ques : Chocolate Distribution problem ...............                                      (GFG Ques)

    //Approach :    T.C. = O(nlog(n)) ,  S.C. = O(1)
    public long findMinDiff (ArrayList<Integer> a, int n, int m){
        if(m==0 || n==0){
            return 0;
        }
        if(n < m){
            return -1;
        }

        Collections.sort(a);

        long min_Diff = Integer.MAX_VALUE;

        for(int i=0 ; i < (a.size()-m+1) ; i++)
        {
            int diff = a.get(i+m-1) - a.get(i);

            if(diff < min_Diff)
                min_Diff = diff;

        }
        return min_Diff;
    }

    public static void main(String[] args) {
        /*
        Ques : Given an array of N integers where each value represents the number of chocolates in a packet.
               Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:

        Each student gets one packet.
        The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
        Examples:

        Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
        Output: Minimum Difference is 2
        Explanation:
        We have seven packets of Chocolates, and we need to pick three packets for 3 students
        If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.

        Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5
        Output: Minimum Difference is 6
        */
    }
}
