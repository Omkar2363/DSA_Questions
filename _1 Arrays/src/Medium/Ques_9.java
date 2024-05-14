package Medium;

public class Ques_9 {

    //Ques : Container With Most Water..........                                    (Leet code Ques no. - 11)

    //Approach 1 : Two pointer approach......                                      T.C. = O(n),  S.C. = O(1)
    public int maxArea_1(int[] height) {
        int left = 0;
        int right =  height.length-1;
        int maxWater = 0;
        while(left < right){
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right-left));
                                    /*This can also be done as follows :
                                      int min2Lines = Math.min(height[left], height[right]);
                                      maxWater   =  Math.max(maxWater , min2Lines * (right - left));
                                    * */

            if(height[left]>height[right])
                right--;
            else
                right++;
        }
        return maxWater;
    }


    //Approach 2 : Two pointer approach......                                     T.C. = O(log(n)),  S.C. = O(1)
    public int maxArea_2(int[] height){
        int left  = 0;
        int right = height.length-1;
        int temp  = 0;
        int ans  = Integer.MIN_VALUE;

        while(left < right){

            if(height[left] <= height[right]){
                temp = height[left]*(right - left);
                ans = Math.max(ans,temp);
                left++;
            }
            else{
                temp = height[right]*(right - left);
                ans = Math.max(ans,temp);
                right--;
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        /*Ques : You are given an integer array height of length n. There are n vertical lines drawn such that
                 the two endpoints of the ith line are (i, 0) and (i, height[i]).

                 Find two lines that together with the x-axis form a container, such that the container contains
                 the most water.

                 Return the maximum amount of water a container can store.

                 Notice that you may not slant the container.


                Example : 1
                Input   : height = [1,8,6,2,5,4,8,3,7]
                Output  : 49
                Explanation : The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
                              In this case, the max area of water (blue section) the container can contain is 49.

                Example : 2
                Input   : height = [1,1]
                Output  : 1

        * */
    }
}
