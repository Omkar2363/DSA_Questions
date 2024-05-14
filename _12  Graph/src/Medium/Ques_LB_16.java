package Medium;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_16 {

    //Ques : Snakes and Ladders.............                                              (Leet Code Ques no.- 909)


    //Approach 1 : By using BFS.........(Efficient Solution).....                         T.C. = (n^2),  S.C. = O(n^2)
    class Solution {
        public int snakesAndLadders(int[][] board)
        {
            int target = board.length * board.length;

            Queue<Integer> q = new LinkedList<>();
            boolean[] visit = new boolean[target + 1];

            q.add(1);
            visit[1] = true;
            int steps = 0;
            while(!q.isEmpty())
            {
                int options = q.size();
                steps++;

                for(int i = 0; i < options; i++)
                {
                    int currCell = q.remove();
                    for(int j = 1; j < 7; j++)
                    {
                        int nextCell = getNextIndex(board, currCell + j);

                        if(nextCell == target)
                            return steps;

                        if(!visit[nextCell]){
                            q.add(nextCell);
                            visit[nextCell] = true;
                        }

                    }
                }
            }

            return -1;
        }

        private int getNextIndex(int[][] board, int index)
        {
            int n = board.length;
            int row = n - 1 - (index - 1)/n;
            int col = ((index - 1)/n % 2) == 0   ?  (index - 1)%n  :  n-1-(index - 1)% n;

            return board[row][col] == -1 ? index : board[row][col];
        }
    }



    //Approach 2 : By using HashMap + BFS.........
    class Solution_2 {
        public int snakesAndLadders(int[][] board)
        {
            //Step1: Convert board to hashmap to map the board cell number to cell value for easier calculation
            int n = board.length;
            HashMap<Integer, Integer> h_map = new HashMap<Integer, Integer>();
            int start = n * n;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                {
                    if ((n-i) % 2 == 0) {
                        h_map.put(start, board[i][j]);
                    }
                    else {
                        h_map.put(start, board[i][n-j-1]);
                    }
                    start--;
                }
            }

            // breadth-first-search
            Queue<Integer> queue = new LinkedList<Integer>();
            HashSet<Integer> h_set = new HashSet<Integer>();
            queue.add(1);
            h_set.add(1);                                        // For visited  cells
            int step = 0;

            while(!queue.isEmpty())
            {
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int current = queue.poll();
                    if (current == n * n)                       // Reached the top! winner winner chicken dinner
                    {
                        return step;
                    }
                    for(int j = 1; j <= 6; j++)
                    {
                        int newPoint = current + j;
                        if (newPoint > n * n){
                            continue;                           // We are outside the board now with this choice
                        }
                        if(h_map.get(newPoint) != -1){
                            newPoint = h_map.get(newPoint);        // Either snake or ladder (doesn't matter)
                        }
                        if(!h_set.contains(newPoint)){
                            queue.add(newPoint);
                            h_set.add(newPoint);
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }





    public static void main(String[] args) {

        /*Ques : You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon
                 style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

            * You start on square 1 of the board. In each move, starting from square curr, do the following :
                1. Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
                        * This choice simulates the result of a standard 6-sided die roll :
                            i.e., there are always at most 6 destinations, regardless of the size of the board.
                2. If next has a snake or ladder, you must move to the destination of that snake or ladder.
                   Otherwise, you move to next.
                3. The game ends when you reach the square n2.

            A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that
            snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

            Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is
            the start of another snake or ladder, you do not follow the subsequent snake or ladder.
                * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
                  You follow the ladder to square 3, but do not follow the subsequent ladder to 4.

        Return the least number of moves required to reach the square n2. If it is not possible to reach the square,
        return -1.


        Example : 1
        Input   : board = [ [-1,-1,-1,-1,-1,-1],
                            [-1,-1,-1,-1,-1,-1],
                            [-1,-1,-1,-1,-1,-1],
                            [-1,35,-1,-1,13,-1],
                            [-1,-1,-1,-1,-1,-1],
                            [-1,15,-1,-1,-1,-1] ]
        Output  : 4
        Explanation : In the beginning, you start at square 1 (at row 5, column 0).
                        You decide to move to square 2 and must take the ladder to square 15.
                        You then decide to move to square 17 and must take the snake to square 13.
                        You then decide to move to square 14 and must take the ladder to square 35.
                        You then decide to move to square 36, ending the game.
                    This is the lowest possible number of moves to reach the last square, so return 4.


        Example : 2
        Input   : board = [ [-1,-1],
                            [-1,3] ]
        Output  : 1



        *
        * */
    }




}

