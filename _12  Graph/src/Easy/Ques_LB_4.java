package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_4 {

    //Ques : Flood Fill.........                                                             (Leet Code Ques no.- 733)


    //Approach 1 : By DFS using Recursion.....(Efficient Solution)
    class Solution_1 {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
        {
            int color = image[sr][sc];
            if(color != newColor)
                dfschange(image, sr, sc, newColor, color);

            return image;
        }
        public void dfschange(int[][] image, int sr, int sc, int newColor, int orignal)
        {
            if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != orignal)
                return;

            image[sr][sc] = newColor;

            dfschange(image, sr + 1, sc, newColor, orignal);
            dfschange(image, sr - 1, sc, newColor, orignal);
            dfschange(image, sr, sc + 1, newColor, orignal);
            dfschange(image, sr, sc - 1, newColor, orignal);
        }

    }




    //Approach 2 : By DFS using Queue......
    class Solution_2 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
        {
            int target = image[sr][sc];
            image[sr][sc] = newColor;

            if(target == newColor){
                return image;
            }

            final int[][] directions = { {1,0},{0,1},{-1,0},{0,-1} };
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sr,sc});

            while(!queue.isEmpty())
            {
                int[] cur = queue.poll();
                for(int[] dir : directions)
                {
                    int row = cur[0] + dir[1];
                    int col = cur[1] + dir[0];

                    if(isVaild(row, col, image, target))
                    {
                        image[row][col] = newColor;
                        queue.add(new int[]{row,col});
                    }
                }
            }
            return image;
        }
        private boolean isVaild(int row, int col, int[][] image, int target)
        {
            if(row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != target)
            {
                return false;
            }
            return true;
        }

    }








    public static void main(String[] args) {

        /*  An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

            You are also given three integers sr, sc, and color. You should perform a flood fill on the image
            starting from the pixel image[sr][sc].

            To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to
            the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally
            to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned
            pixels with color.

            Return the modified image after performing the flood fill.


        Example : 1
        Input   : image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        Output  : [[2,2,2],[2,2,0],[2,0,1]]
        Explanation : From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
                      all pixels connected by a path of the same color as the starting pixel
                      (i.e., the blue pixels) are colored with the new color.

            Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.


        Example : 2
        Input   : image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
        Output  : [[0,0,0],[0,0,0]]
        Explanation : The starting pixel is already colored 0, so no changes are made to the image.


        // Follow the link for Visual Representation of the Example :
        // Link : https://leetcode.com/problems/flood-fill/
        *
        *
        * */
    }



}
