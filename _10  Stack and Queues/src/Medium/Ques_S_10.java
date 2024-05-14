package Medium;

public class Ques_S_10 {

    //Ques : Next Greater Element.......                                                  (GFG Ques.)


    //Approach 1 : By using Nested Loop.....                                              T.C. = O(n^2), S.C. = O(1)
    // Simple Java program to print next greater elements in a given array
    class Main {

        /* prints element and NGE pair for all elements of arr[] of size n */
        static void printNGE(int arr[], int n)
        {
            int next, i, j;
            for (i = 0; i < n; i++) {
                next = -1;
                for (j = i + 1; j < n; j++) {
                    if (arr[i] < arr[j]) {
                        next = arr[j];
                        break;
                    }
                }
                System.out.println(arr[i] + " -- " + next);
            }
        }
        public static void main_1(String args[])
        {
            int arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNGE(arr, n);
        }
    }



    //Approach 2 : By using Stack.......                                                  T.C. = O(n),  S.C. = O(n)
    // Java program to print next greater element using stack
    public class NGE {
        static class stack {
            int top;
            int items[] = new int[100];

            // Stack functions to be used by printNGE
            void push(int x)
            {
                if (top == 99) {
                    System.out.println("Stack full");
                }
                else {
                    items[++top] = x;
                }
            }
            int pop()
            {
                if (top == -1) {
                    System.out.println("Underflow error");
                    return -1;
                }
                else {
                    int element = items[top];
                    top--;
                    return element;
                }
            }
            boolean isEmpty()
            {
                return (top == -1) ? true : false;
            }
        }

        /* prints element and NGE pair for all elements of arr[] of size n */
        static void printNGE(int arr[], int n)
        {
            int i = 0;
            stack s = new stack();
            s.top = -1;
            int element, next;

            /* push the first element to stack */
            s.push(arr[0]);

            // iterate for rest of the elements
            for (i = 1; i < n; i++) {
                next = arr[i];

                if (s.isEmpty() == false) {

                    // if stack is not empty, then pop an element from stack
                    element = s.pop();

                /* If the popped element is smaller than next,
                   then (a). print the pair
                        (b). keep popping while elements are smaller and  stack is not empty */
                    while (element < next) {
                        System.out.println(element + " --> " + next);
                        if (s.isEmpty() == true)
                            break;
                        element = s.pop();
                    }

                /* If element is greater than next, then push the element back */
                    if (element > next)
                        s.push(element);
                }

            /* push next to stack so that we can find next greater for it */
                s.push(next);
            }

            /* After iterating over the loop, the remaining elements in stack do not have
               the next greater element, so print -1 for them */
            while (s.isEmpty() == false) {
                element = s.pop();
                next = -1;
                System.out.println(element + " -- " + next);
            }
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNGE(arr, n);
        }
    }



    //Approach 3 : By using Map..........                                                T.C. = O(n),  S.C. = O(n)
    //C++ Code
    /*   C++ code to implement the approach
            #include <bits/stdc++.h>

            using namespace std;

            void nextLargerElement(int arr[], int n)
            {
                vector<unordered_map<string, int> > s;

                // iterating over the array
                for (int i = 0; i < n; i++) {
                    while (s.size() > 0
                           && s[s.size() - 1]["value"] < arr[i]) {
                        // updating the array as per the stack top
                        unordered_map<string, int> d = s[s.size() - 1];
                        s.pop_back();
                        arr[d["ind"]] = arr[i];
                    }
                    // pushing values to stack
                    unordered_map<string, int> e;

                    e["value"] = arr[i];
                    e["ind"] = i;
                    s.push_back(e);
                }

                // updating the array as per the stack top
                while (s.size() > 0) {
                    unordered_map<string, int> d = s[s.size() - 1];
                    s.pop_back();
                    arr[d["ind"]] = -1;
                }
            }

            // Driver Code

            int main()
            {
                int arr[] = { 6, 8, 0, 1, 3 };
                int n = 5;

                // Function call
                nextLargerElement(arr, n);
                for (int i = 0; i < n; i++)
                    cout << arr[i] << " ";
            }
    * */




    public static void main(String[] args) {

        /*Ques : Given an array arr[ ] of size N having elements, the task is to find the next greater element for
                 each element of the array in order of their appearance in the array.

                 Next greater element of an element in the array is the nearest element on the right which is greater
                 than the current element.
                 If there does not exist next greater of current element, then next greater element for current element
                 is -1. For example, next greater of the last element is always -1.


            Example : 1
            Input   : N = 4, arr[] = [1 3 2 4]
            Output  : 3 4 4 -1
            Explanation :  In the array, the next larger element to
                           1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
                           since it doesn't exist, it is -1.

            Example : 2
            Input   : N = 5, arr[] [6 8 0 1 3]
            Output  : 8 -1 1 3 -1
            Explanation : In the array, the next larger element to
                          6 is 8, for 8 there is no larger elements
                          hence it is -1, for 0 it is 1 , for 1 it
                          is 3 and then for 3 there is no larger
                          element on right and hence -1.

            Your Task :
            This is a function problem. You only need to complete the function nextLargerElement() that takes
            list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting
            the next greater elements for all the corresponding elements in the input array.

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(N)

        * */
    }



}
