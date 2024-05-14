package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class Ques_6 {

    //Ques : Next Greater Element (NGE) for every element in given Array..........              (GFG Ques.)

    //Approach 1 : By using Nested Loops..........                                              T.C. = O(n^2),  S.C. = O(1)
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

        public static void main(String args[])
        {
            int arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNGE(arr, n);
        }
    }



    //Approach 2 : By using Stack.........                                                     T.C. = O(n),   S.C. = O(n)
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

        /* prints element and NGE pair for
           all elements of arr[] of size n */
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

                    /* If the popped element is smaller than next, then
                        a). print the pair
                        b). keep popping while elements are smaller and stack is not empty
                    */
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
               the next greater element, so print -1 for them
            */
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





    //Approach 3 : By using Map...........                                                    T.C. = O(n),   S.C. = O(n)
    // Java code to implement the approach
    class GFG_3 {
        static void nextLargerElement(int[] arr, int n)
        {
            ArrayList<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer> >();

            // iterating over the array
            for (int i = 0; i < n; i++)
            {
                while (list.size() > 0  &&  list.get(list.size() - 1).get("value")  <  arr[i])
                {
                    // updating the array as per the stack top
                    HashMap<String, Integer> array_map = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                    arr[array_map.get("ind")] = arr[i];
                }

                // pushing values to stack
                HashMap<String, Integer> stack_map = new HashMap<String, Integer>();

                stack_map.put("value", arr[i]);
                stack_map.put("ind", i);
                list.add(stack_map);
            }

            // updating the array as per the stack top
            while (list.size() > 0)
            {
                HashMap<String, Integer> d = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                arr[d.get("ind")] = -1;
            }
        }

        // Driver Code

        public static void main_3(String[] args)
        {
            int[] arr = { 6, 8, 0, 1, 3 };
            int n = 5;

            // Function call
            nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an array, print the Next Greater Element (NGE) for every element.

                    The Next greater Element for an element x is the first greater element on the right side
                    of x in the array. Elements for which no greater element exist, consider the next greater
                    element as -1.


                Example : 1
                Input   : arr[] = [ 4 , 5 , 2 , 25 ]
                Output  : 4      –>   5
                          5      –>   25
                          2      –>   25
                          25     –>   -1

                Explanation : except 25 every element has an element greater than them present on the right side


                Example : 2
                Input   : arr[] = [ 13 , 7, 6 , 12 ]
                Output  : 13      –>     -1
                          7       –>     12
                          6       –>     12
                          12      –>     -1

                Explanation : 13 and 12 don’t have any element greater than them present on the right side


        *
        * */
    }




}
