package Examples.Algorithms.Bloomberg;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (check(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int a, int b, int wordIndex){
        // return 条件
        if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || wordIndex >= word.length() || board[a][b] != word.charAt(wordIndex))
            return false;

        // return 条件
        if (wordIndex == word.length()-1)
            return board[a][b] == word.charAt(wordIndex);

        // 防止当前格子被重复搜到
        char temp = board[a][b];
        board[a][b] = '1';

        // recursive calls
        boolean up = check(board, word, a-1, b, wordIndex+1);
        boolean down = check(board, word, a+1, b, wordIndex+1);
        boolean right = check(board, word, a, b+1, wordIndex+1);
        boolean left = check(board, word, a, b-1, wordIndex+1);

        // 回溯
        board[a][b] = temp;
        // return 条件
        return (up || down || left || right);


    }
}
