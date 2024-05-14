package Easy;

public class Ques_LB4 {

    //Ques : Cyclically rotate an array by one                                            (GFG Ques)

    //Approach 1 :  Simple problem                                                        T.C. = O(n), S.C. = O(1)
    public void rotate(int arr[], int n){
        int temp = arr[arr.length-1];
        for(int i=(arr.length-1)  ; i>0 ; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }


    public static void main(String[] args) {

        /*Ques : Given an array, rotate the array by one position in clock-wise direction.

                Example : 1
                Input   : N = 5
                          A[] = {1, 2, 3, 4, 5}
                Output  : 5 1 2 3 4


                Example : 2
                Input   : N = 8
                          A[] = {9, 8, 7, 6, 4, 2, 1, 3}
                Output  : 3 9 8 7 6 4 2 1

        * */
    }
}
