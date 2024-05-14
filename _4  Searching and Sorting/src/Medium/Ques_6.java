package Medium;

public class Ques_6 {

    //Ques : Find duplicates in O(n) time and O(1) extra space.......                     (GFG Ques.)

    /*  The above problem is an extended version of the following problem.....
        Follow the link for the ques and its various approaches.....

        Ques : Find the two repeating elements in a given array.......
        Sol  : This ques has 6 approaches for its solution...
        Link : https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
    */
    /*  Method 1 and Method 2 of the above link are not applicable as the question
        says O(n) time complexity and O(1) constant space.
        Also, Method 3 and Method 4 cannot be applied here because there can be more
        than 2 repeating elements in this problem. Method 5 can be extended to  work
        for this problem. Below is the solution that is similar to Method 5.

    * */

    //Approach 1 : Efficient Approach...                                                  T.C. = O(n), S.C. = O(1)
    // JAVA code to find duplicates in O(n) time
    class Leet442 {

        public static void main(String args[])
        {
            int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };

            for (int i = 0; i < numRay.length; i++) {
                numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
            }
            System.out.println("The repeating elements are : ");
            for (int i = 0; i < numRay.length; i++) {
                if (numRay[i] >= numRay.length * 2) {
                    System.out.println(i + " ");
                }
            }
        }
    }


    //Approach 2 : Another efficient approach...                                         T.C. = O(n), S.C. = O(1)
    //C++ Code :
    /*  #include <bits/stdc++.h>
        using namespace std;

        vector<int> duplicates(int arr[], int n)
        {
            // Increment array elements by 1
            for (int i = 0; i < n; i++) {
                arr[i] += 1;
            }

            // result vector
            vector<int> res;

            // count variable for count of largest element
            int count = 0;

            for (int i = 0; i < n; i++) {

                // Calculate index value
                int index = abs(arr[i]) > n ? abs(arr[i]) / (n + 1) : abs(arr[i]);

                // Check if index equal to the largest element value
                if (index == n) {
                    count++;
                    continue;
                }

                // Get element value at index
                int val = arr[index];

                // Check if element value is negative, positive or greater than n
                if (val < 0) {
                    res.push_back(index - 1);
                    arr[index] = abs(arr[index]) * (n + 1);
                }
                else if (val > n)
                    continue;
                else
                    arr[index] = -arr[index];
            }

            // If largest element occurs more than once
            if (count > 1)
                res.push_back(n - 1);

            if (res.size() == 0)
                res.push_back(-1);
            else
                sort(res.begin(), res.end());

            return res;
        }

        // Driver Code
        int main()
        {
            int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
            int n = sizeof(numRay) / sizeof(numRay[0]);

            vector<int> ans = duplicates(numRay, n);
            for (int i : ans)
                cout << i << ' ' << endl;
            return 0;
        }
    *
    * */





    public static void main(String[] args) {

        /*Ques : Given an array of n elements that contains elements from 0 to n-1, with any of
                 these numbers appearing any number of times. Find these repeating numbers in O(n)
                 and using only constant memory space.


            Example : 1
            Input   : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
            Output  : 1, 3, 6
            Explanation : The numbers 1 , 3 and 6 appears more than once in the array.


            Example : 2
            Input   : n = 5 and array[] = {1, 2, 3, 4 ,3}
            Output  : 3
            Explanation : The number 3 appears more than once in the array.
        *


        *
        * */
    }


}


