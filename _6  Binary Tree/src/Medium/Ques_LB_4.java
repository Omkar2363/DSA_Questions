package Medium;

import java.util.*;

public class Ques_LB_4 {

    //Ques : Check mirror in n-ary tree............                                  (GFG Ques.)


    //Approach 1 : By using Hashing.......                                           T.C. = O(n),  S.C. = O(n)
    // Java program to check if two n-ary trees are mirror.
    public class Main {
        // Function to check given two trees are mirror of each other or not
        static boolean checkMirrorTree(int M, int N, int[] u1, int[] v1, int[] u2, int[] v2)
        {
            // Map to store nodes of the tree
            HashMap<Integer, Stack<Integer>> map = new HashMap<>();

            // Traverse first tree nodes
            for (int i = 0 ; i < N ; i++ )
            {
                if(!map.containsKey(u1[i]))
                {
                    map.put(u1[i], new Stack<Integer>());
                }
                else{
                    map.get(u1[i]).push(v1[i]);
                }
            }

            // Traverse second tree nodes
            for (int i = 0 ; i < N ; i++)
            {
                if(map.containsKey(u2[i])  &&  map.get(u2[i]).size() > 0)
                {
                    if(map.get(u2[i]).peek() != v2[i])
                        return false;
                    map.get(u2[i]).pop();
                }
            }

            return true;
        }

        // Driver code
        public static void main_1(String[] args) {
            int M = 7, N = 6;

            // Tree 1
            int[] u1 = { 1, 1, 1, 10, 10, 10 };
            int[] v1 = { 10, 7, 3, 4, 5, 6 };

            // Tree 2
            int[] u2 = { 1, 1, 1, 10, 10, 10 };
            int[] v2 = { 3, 7, 10, 6, 5, 4 };

            if(checkMirrorTree(M, N, u1, v1, u2, v2))
                System.out.print("Yes");
            else
                System.out.print("No");
        }
    }





    //Approach 2 : By using Linked List                                             T.C. = O(n),  S.C. = O(n)
    // Java program to check two n-ary trees are mirror.
    class GFG {

        // Function to check given two trees are mirror of each other or not
        static int checkMirrorTree(int n, int e, int[] A, int[] B) {

            //Lists to store nodes of the tree
            List<Stack<Integer>> s = new ArrayList<>();
            List<Queue<Integer>> q = new ArrayList<>();

            // initializing both list with empty stack and queue
            for (int i = 0; i <= n; i++) {
                s.add(new Stack<>());
                Queue<Integer> queue = new LinkedList<>();
                q.add(queue);
            }

            // add all nodes of tree 1 to list of stack and tree 2 to list of queue
            for (int i = 0; i < 2 * e; i += 2) {
                s.get(A[i]).push(A[i + 1]);
                q.get(B[i]).add(B[i + 1]);
            }

            // now take out the stack and queues for each of the nodes
            // and compare them one by one
            for (int i = 1; i <= n; i++) {
                while (!s.get(i).isEmpty() && !q.get(i).isEmpty()) {
                    int a = s.get(i).pop();
                    int b = q.get(i).poll();

                    if (a != b) {
                        return 0;
                    }
                }
            }

            return 1;
        }

        public static void main_2 (String[] args) {
            int n = 3;
            int e = 2;
            int A[] = { 1, 2, 1, 3 };
            int B[] = { 1, 3, 1, 2 };

            if (checkMirrorTree(n, e, A, B) == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }






    public static void main(String[] args) {

        /*Ques : Given two n-ary trees, the task is to check if they are the mirror of each other or not.
                 Print “Yes” if they are the mirror of each other else “No”.


            Example : 1
            Input   : Node = 3, Edges = 2
                      Edge 1 of first N-ary: 1 2
                      Edge 2 of first N-ary: 1 3
                      Edge 1 of second N-ary: 1 3
                      Edge 2 of second N-ary: 1 2
            Output  : Yes


            Example : 2
            Input   : Node = 3, Edges = 2
                      Edge 1 of first N-ary: 1 2
                      Edge 2 of first N-ary: 1 3
                      Edge 1 of second N-ary: 1 2
                      Edge 2 of second N-ary: 1 3
            Output  : No



            //Follow the link for Visual Representation of the Example   :
            //Link : https://www.geeksforgeeks.org/check-mirror-n-ary-tree/
        *
        *
        * */
    }




}
