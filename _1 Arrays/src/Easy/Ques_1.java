package Easy;

public class Ques_1 {

    //Ques : Find maximum and minimum no. in an array :                                (GFG Ques)

    static class MinMax{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    public static void min_max(int[] arr){

        MinMax mm = new MinMax();

        //Case 1 : Empty array
        if(arr.length == 0){
            mm.min = 0;
            mm.max = 0;
        }
        //Case 2 : Only One element in the array
        if(arr.length == 1){
            mm.min = arr[0];
            mm.max = arr[0];
        }
        //Case 3 : More than one element in the array
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] > mm.max){
                mm.max = arr[i];
            }
            if(arr[i] < mm.min){
                mm.min = arr[i];
            }
        }

        System.out.println("Minimum element of the array is : " + mm.min);
        System.out.println("Maximum element of the array is : " + mm.max);
    }

    public static void main(String[] args) {

        int[] arr = {5,7,8,4,9,10,11,14,17,19};
        int[] arr2 = {};
        int[] arr3 = {1};

        min_max(arr);
        min_max(arr2);
        min_max(arr3);
    }

}
