package Medium;

public class Ques_LB8 {

    //Ques : Find the string in grid........                                              (GFG Ques.)
    //       (Search a word in a 2D grid of characters)


    //Approach 1 :                                                                       T.C. = /**/
    /*  Approach: The idea used here is simple, we check every cell.
                  If cell has first character, then we one by one try all 8 directions
                  from that cell for a match. Implementation is interesting though.
                  We use two arrays x[] and y[] to find next move in all 8 directions.

     */
    class GFG_1{

        // Rows and columns in the given grid
        static int R, C;

        // For searching in all 8 direction
        static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // This function searches in all 8-direction from point
        // (row, col) in grid[][]
        static boolean search2D(char[][] grid, int row,int col, String word)
        {
            /*
             If first character of word doesn't match with
             given starting point in grid.
            */
            if (grid[row][col] != word.charAt(0))
                return false;

            int len = word.length();

            /*
             Search word in all 8 directions
             starting from (row, col)
            */
            for (int dir = 0; dir < 8; dir++) {

                // Initialize starting point for current direction
                int k;
                int rd = row + x[dir];
                int cd = col + y[dir];

                // First character is already checked, match remaining characters
                for (k = 1; k < len; k++) {

                    // If out of bound break
                    if (rd >= R || rd < 0 || cd >= C || cd < 0)
                        break;

                    // If not matched, break
                    if (grid[rd][cd] != word.charAt(k))
                        break;

                    // Moving in particular direction
                    rd += x[dir];
                    cd += y[dir];
                }

                // If all character matched, then value of must be equal to length of word
                if (k == len)
                    return true;
            }
            return false;
        }

        // Searches given word in a given matrix in all 8 directions
        static void patternSearch(char[][] grid, String word)
        {
            // Consider every point as starting point and search given word
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {

                    if ((grid[row][col] == word.charAt(0))  && (search2D(grid, row, col, word)))
                        System.out.println("pattern found at " + row + ", " + col);
                }
            }
        }

        /* Driver code
        public static void main(String args[])
        {
            R = 3;
            C = 13;
            char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                              { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                              { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
            patternSearch(grid, "GEEKS");
            System.out.println();
            patternSearch(grid, "EEE");
        }*/
    }

    // Complexity Analysis:
    /*  Time complexity: O(R*C*8*len(str)).
        All the cells will be visited and traversed in all 8 directions, where R and C is side of matrix so time complexity is O(R*C).
        Auxiliary Space: O(1).
        As no extra space is needed.
    */




    public static void main(String[] args) {

        /*Ques : Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid.
                 A word can be matched in all 8 directions at any point. Word is said be found in a direction
                 if all characters match in this direction (not in zig-zag form). The 8 directions are,
                 horizontally left, horizontally right, vertically up, vertically down and 4 diagonal directions.


            Example : 1

            Input   : grid = {  {a,b,c},
                                {d,r,f},
                                {g,h,i} },
                      word = "abc"
            Output  : {{0,0}}
            Explanation : From (0,0) one can find "abc" in horizontally right direction.


            Example : 2
            Input   : grid = {  {a,b,a,b},
                                {a,b,e,b},
                                {e,b,e,b}   },
                      word = "abe"
            Output  : {{0,0},{0,2},{1,0}}
            Explanation : From (0,0) one can find "abe" in right-down diagonal.
                          From (0,2) one can find "abe" in left-down diagonal.
                          From (1,0) one can find "abe" in Horizontally right direction.


            Your Task :
            You don't need to read or print anything, Your task is to complete the function searchWord() which
            takes grid and word as input parameters and returns a list containing the positions from
            where the word originates in any direction. If there is no such position then returns an empty list.

            Note : The returning list should be lexicographically smallest. If the word can be found in
                   multiple directions strating from the same coordinates,
                   the list should contain the coordinates only once.


            Expected Time Complexity   : O(n*m*k) where k is constant
            Expected Space Complexity  : O(1)


        * */

    }

}
