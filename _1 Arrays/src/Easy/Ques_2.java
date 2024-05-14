package Easy;

public class  Ques_2 {

    //Ques : Reverse the Array ..............
    //       In-place reversal (two pointer approach)            T.C. = O(n/2).... S.C. = O(1)

    public static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]   = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr){

        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        printArray(arr);

        System.out.println("After reversing the array  : ");
        reverse(arr);

        printArray(arr);
    }
}
