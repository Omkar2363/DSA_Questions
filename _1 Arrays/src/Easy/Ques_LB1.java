package Easy;

public class Ques_LB1 {

    //Ques : Sort an array of 0s, 1s and 2s                      (GFG Question)


    //Approach : 1
    public static void sort012_1(int a[], int n) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int i=0 ; i<n ; i++){
            if(a[i] == 0)
                zeroCount++;
            else if(a[i] == 1)
                oneCount++;
            else
                twoCount++;
        }

        for(int i=0 ; i<zeroCount ; i++)
            a[i] = 0;

        for(int i=zeroCount ; i<zeroCount+oneCount ; i++)
            a[i] = 1;

        for(int i=zeroCount+oneCount ; i<n ; i++)
            a[i] = 2;
    }

    //Approach : 2
    public static void sort012_2(int a[], int n) {
        //See the editorial of GFG for different approach.
    }

    public static void main(String[] args)
    {

        /*Ques :  Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


            Example : 1
            Input   : N = 5
                      arr[]= {0 2 1 2 0}
            Output  :  0 0 1 2 2
            Explanation  : 0s 1s and 2s are segregated into ascending order.


            Example : 2
            Input   : N = 3
                      arr[] = {0 1 0}
            Output  :  0 0 1
            Explanation : 0s 1s and 2s are segregated into ascending order.
        */
    }
}
