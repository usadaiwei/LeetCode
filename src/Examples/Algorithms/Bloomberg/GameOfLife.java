package Examples.Algorithms.Bloomberg;
/*
289. Game of Life
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {
    // 衍化下次变化, 重点是用int[][] temp来暂时储存变化, 不影响其他board格子
    public void gameOfLife(int[][] board) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int num = count(board, dirs, i, j);
                if (board[i][j] == 1){// live
                    if (num < 2 || num > 3)
                        temp[i][j] = 0;
                    else
                        temp[i][j] = 1;
                } else if (board[i][j] == 0 && num == 3)
                    temp[i][j] = 1;
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = temp[i][j];
            }
        }
    }

    // count num of neibhours
    private int count(int[][] board, int[][] dirs, int i, int j){
        int counter = 0;

        for (int[] dir : dirs){
            int ii = i + dir[0];
            int jj = j + dir[1];

            if (ii >= 0 && jj >= 0 && ii < board.length && jj < board[0].length && board[ii][jj] == 1)
                counter++;
        }
        return counter;
    }
}
