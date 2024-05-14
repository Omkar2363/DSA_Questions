package Medium;

import java.util.Stack;

public class Ques_S_9 {

    //Ques : The Celebrity Problem........                                             (GFG Ques.)


    //Approach 1 : By using loops......                                                T.C. = O(n^2),  S.C. = O(n)
    /*  Method 1 : This uses Graph to arrive at the particular solution.

        Approach :
        Model the solution using graphs. Initialize indegree and outdegree of every vertex as 0. If A knows B, draw
        a directed edge from A to B, increase indegree of B and outdegree of A by 1. Construct all possible edges of
        the graph for every possible pair [i, j]. There are NC2 pairs. If a celebrity is present in the party, there
        will be one sink node in the graph with outdegree of zero and indegree of N-1.


        Algorithm :
          1. Create two arrays indegree and outdegree, to store the indegree and outdegree
          2. Run a nested loop, the outer loop from 0 to n and inner loop from 0 to n.
          3. For every pair i, j check if i knows j then increase the outdegree of i and indegree of j
          4. For every pair i, j check if j knows i then increase the outdegree of j and indegree of i
          5. Run a loop from 0 to n and find the id where the indegree is n-1 and outdegree is 0

    * */
    // Java program to find celebrity
    class GFG {

        // Max # of persons in the party
        static final int N = 8;

        // Person with 2 is celebrity
        static int MATRIX[][] = { { 0, 0, 1, 0 },
                                  { 0, 0, 1, 0 },
                                  { 0, 0, 0, 0 },
                                  { 0, 0, 1, 0 } };

        static int knows(int a, int b) { return MATRIX[a][b]; }

        // Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1).
        static int findCelebrity(int n)
        {

            // the graph needs not be constructed as the edges can be found by using knows function

            // degree array;
            int[] indegree = new int[n];
            int[] outdegree = new int[n];

            // query for all edges
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int x = knows(i, j);

                    // set the degrees
                    outdegree[i] += x;
                    indegree[j] += x;
                }
            }

            // find a person with indegree n-1 and out degree 0
            for (int i = 0; i < n; i++)
                if (indegree[i] == n - 1 && outdegree[i] == 0)
                    return i;

            return -1;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            int n = 4;
            int id = findCelebrity(n);
            if (id == -1)
                System.out.print("No celebrity");
            else
                System.out.print("Celebrity ID " + id);
        }
    }



    //Approach 2 : By using Recursion......                                           T.C. = O(n),  S.C. = O(1)
    /* Method 2 : Uses recursion

        * Approach :
        The problem can be solved using recursion. Say, if the 'potential celebrity' of N-1 persons is known,
        can the solution to N be found from it? A potential celebrity is one who is the only one  left  after
        eliminating n-1 people. n-1 people are eliminated with the following strategy :

            - If A knows B, then A cannot be a celebrity. But B could be.
            - Else If B knows A, then B cannot be a celebrity. But A could be.

        The above-mentioned approach use Recursion to find the potential celebrity among n persons, recursively calls
        n-1 persons, till the base case of 0 persons is reached. For 0 persons -1 is returned indicating that there are
        no possible celebrities since there are 0 people. In the ith stage of recursion, the ith person and (i-1)th person
        are compared to check if anyone of them knows the other. And using the above logic (in the bullet points) the
        potential celebrity is returned to the (i+1)th stage.

        Once the recursive function returns an id. We check if this id does not know anybody else, but all others know
        this id. If this is true, then this id will be the celebrity.


        * Algorithm :
          1. Create a recursive function that takes an integer n.
          2. Check the base case, if the value of n is 0 then return -1.
          3. Call the recursive function and get the ID of the potential celebrity from the first n-1 elements.
          4. If the id is -1 then assign n as the potential celebrity and return the value.
          5. If the potential  celebrity of first n-1 elements knows n-1 then return n-1, (0 based indexing)
          6. If the celebrity of first n-1 elements does not know n-1 then return id of celebrity of n-1 elements,
             (0 based indexing)
          7. Else return -1
          8. Create a wrapper function and check whether the id returned by the function is really the celebrity or not.

    *
    * */
    // Java program for the above approach
    class GFG_2 {

        // Max # of persons in the party
        static int N = 8;

        // Person with 2 is celebrity
        static int MATRIX[][] = {   { 0, 0, 1, 0 },
                                    { 0, 0, 1, 0 },
                                    { 0, 0, 0, 0 },
                                    { 0, 0, 1, 0 }  };

        static int knows(int a, int b) { return MATRIX[a][b]; }

        // Returns -1 if a 'potential celebrity' is not present.
        // If present, returns id (value from 0 to n-1).
        static int findPotentialCelebrity(int n)
        {
            // Base case : when n reaches 0 , returns -1
            //             since n represents the number of people,
            //             0 people implies no celebrity(= -1)
            if (n == 0)
                return -1;

            // find the celebrity with n-1 persons
            int id = findPotentialCelebrity(n - 1);

            // if there are no celebrities
            if (id == -1)
                return n - 1;

                // if the id knows the nth person then the id cannot be a celebrity,
                // but nth person could be one
            else if (knows(id, n - 1) == 1) {
                return n - 1;
            }
            // if the nth person knows the id, then the nth person cannot be a celebrity
            // and the id could be one
            else if (knows(n - 1, id) == 1) {
                return id;
            }

            // if there is no celebrity
            return -1;
        }

        // Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1).
        // a wrapper over findCelebrity
        static int Celebrity(int n)
        {
            // find the celebrity
            int id = findPotentialCelebrity(n);

            // check if the celebrity found is really the celebrity
            if (id == -1)
                return id;
            else {
                int c1 = 0, c2 = 0;

                // check the id is really the celebrity
                for (int i = 0; i < n; i++)
                    if (i != id) {
                        c1 += knows(id, i);
                        c2 += knows(i, id);
                    }

                // if the person is known to everyone.
                if (c1 == 0 && c2 == n - 1)
                    return id;

                return -1;
            }
        }

        // Driver code
        public static void main_2(String[] args)
        {
            int n = 4;
            int id = Celebrity(n);
            if (id == -1) {
                System.out.println("No celebrity");
            }
            else {
                System.out.println("Celebrity ID " + id);
            }
        }
    }




    //Approach 3 : By using eliminating technique........                            T.C. = O(n),  S.C. = O(n)
    /*  Method 3 : Uses elimination technique

        * Approach :
        There are some observations based on elimination technique (Refer Polya's How to Solve It book).
          - If A knows B, then A can't be a celebrity. Discard A, and B may be celebrity.
          - If A doesn't know B, then B can't be a celebrity. Discard B, and A may be celebrity.
        Repeat above two steps till there is only one person.
        Ensure the remained person is a celebrity. (What is the need of this step?)


        * Algorithm :
           1. Create a stack and push all the id's in the stack.
           2. Run a loop while there are more than 1 element in the stack.
           3. Pop top two element from the stack (represent them as A and B)
           4. If A knows B, then A can't be a celebrity and push B in stack. Else if A doesn't know B, then B can't
              be a celebrity push A in stack.
           5. Assign the remaining element in the stack as the celebrity.
           6. Run a loop from 0 to n-1 and find the count of persons who knows the celebrity and the number of people
              whom the celebrity knows. if the count of persons who knows the celebrity is n-1 and the count of people
              whom the celebrity knows is 0 then return the id of celebrity else return -1.

    * */
    // Java program to find celebrity using stack data structure
    class GFG_3 {
        // Person with 2 is celebrity
        static int MATRIX[][] = {  { 0, 0, 1, 0 },
                                   { 0, 0, 1, 0 },
                                   { 0, 0, 0, 0 },
                                   { 0, 0, 1, 0 }  };


        // Returns true if a knows b, false otherwise
        static boolean knows(int a, int b)
        {
            boolean res = (MATRIX[a][b] == 1) ? true : false;
                return res;
        }

        // Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1).
        static int findCelebrity(int n)
        {
            Stack<Integer> st = new Stack<>();
            int c;

            // Step 1 : Push everybody onto stack
            for (int i = 0; i < n; i++)
            {
                st.push(i);
            }

            while (st.size() > 1)
            {
                // Step 2 : Pop off top two persons from the stack,
                //          discard one person based on return status of knows(A, B).
                int a = st.pop();
                int b = st.pop();

                // Step 3 : Push the remained person onto stack.
                if (knows(a, b))
                {
                    st.push(b);
                }
                else
                    st.push(a);
            }

            // If there are only two people and there is no potential candidate
            if(st.empty())
                return -1;

            c = st.pop();

            // Step 5 : Check if the last person is celebrity or not
            for (int i = 0; i < n; i++)
            {
                // If any person doesn't know 'c' or 'a' doesn't know any person, return -1
                if (i != c && (knows(c, i) || !knows(i, c)))
                    return -1;
            }
            return c;
        }

        // Driver Code
        public static void main_3(String[] args)
        {
            int n = 4;
            int result = findCelebrity(n);
            if (result == -1)
            {
                System.out.println("No Celebrity");
            }
            else
                System.out.println("Celebrity ID " +
                        result);
        }
    }




    //Approach 4 : Two Pointer Approach..........(Optimized Approach....)           T.C. = O(n),  S.C. = O(1)
    /*  Method 4 : Uses two-pointer approach......

        * Optimal Approach :
            The idea is to use two pointers, one from start and one from the end. Assume the start person is A,
            and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity.
            At the end of the loop, only one index will be left as a celebrity. Go through each person again and check
            whether this is the celebrity.

          The Two Pointer approach can be used where two pointers can be assigned, one at the start and the other
          at the end, and the elements can be compared and the search space can be reduced.


        * Algorithm :
           1. Create two indices i and j, where i = 0 and j = n-1
           2. Run a loop until i is less than j.
           3. Check if i knows j, then i can't be a celebrity. so increment i, i.e. i++
           4. Else j cannot be a celebrity, so decrement j, i.e. j--
           5. Assign i as the celebrity candidate
           6. Now at last check that whether the candidate is actually a celebrity by re-running a loop from 0 to n-1
              and constantly checking that if the candidate knows a person or if there is a candidate who does not know
              the candidate, then we should return -1. else at the end of the loop, we can be sure that the candidate is
              actually a celebrity.

    * */
    // Java program to find celebrity in the given Matrix of people
    class GFG_4 {
        public static void main(String[] args)
        {
            int[][] M = {  { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 }  };

            int celebIdx = celebrity(M, 4);

            if (celebIdx == -1)
                System.out.println("No celebrity found!");
            else {
                System.out.println("0-based celebrity index is : " + celebIdx);
            }
        }
        public static int celebrity(int M[][], int n)
        {
            // This function returns the celebrity index 0-based (if any)

            int i = 0, j = n - 1;
            while (i < j) {
                if (M[j][i] == 1)                            // j knows i
                    j--;
                else                                         // j does not know i so i cant be celebrity
                    i++;
            }
            // i, points to our celebrity candidate
            int candidate = i;

            // Now, all that is left is to check that whether the candidate is actually a celebrity
            // i.e. : he is known by everyone, but he knows no one
            for (i = 0; i < n; i++) {
                if (i != candidate) {
                    if (M[i][candidate] == 0 || M[candidate][i] == 1)
                        return -1;
                }
            }

            // if we reach here this means that the candidate is really a celebrity
            return candidate;
        }
    }






    public static void main(String[] args) {

        /*Ques : A celebrity is a person who is known to all but does not know anyone at a party. If you go to a
                 party of N people, find if there is a celebrity in the party or not.
                 A square NxN matrix M[][] is used to represent people at the party such that if an element of
                 row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.

            Note : Follow 0 based indexing.
            Follow Up: Can you optimize it to O(N)


            Example : 1
            Input   : N = 3
                      M[][] = { {0 1 0},
                                {0 0 0},
                                {0 1 0} }
            Output  : 1
            Explanation : 0th and 2nd person both know 1. Therefore, 1 is the celebrity.


            Example : 2
            Input   : N = 2
                      M[][] = { {0 1},
                                {1 0} }
            Output  : -1
            Explanation : The two people at the party both know each other. None of them is a celebrity.


            Your Task :
            You don't need to read input or print anything. Complete the function celebrity() which takes
            the matrix M and its size N as input parameters and returns the index of the celebrity.
            If no such celebrity is present, return -1.


            Expected Time Complexity  : O(N^2)
            Expected Auxiliary Space  : O(1)

        * */
    }




}
