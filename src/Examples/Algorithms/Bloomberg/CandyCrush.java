package Examples.Algorithms.Bloomberg;

// Mark crush blocks with negative value
public class CandyCrush {
    // 三消游戏
    public int[][] candyCrush(int[][] board) {
        boolean recursive = false;
        // 把所有三个连在一起的block都赋予negative值
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int value = Math.abs(board[i][j]);
                if (i >= 2 && value == Math.abs(board[i-1][j]) && value == Math.abs(board[i-2][j]))
                    board[i][j] = board[i-1][j] = board[i-2][j] = value * -1;
                if (j >= 2 && value == Math.abs(board[i][j-1]) && value == Math.abs(board[i][j-2]))
                    board[i][j] = board[i][j-1] = board[i][j-2] = value * -1;
            }
        }

        // Start from bottom right, if value是negative值，则需要crush and drop， 如果value是positive value， 则跳过。
        for (int i = board.length-1; i >= 0; i--){
            for (int j = board[0].length-1; j >= 0; j--){
                if (board[i][j] >= 0)
                    continue;
                crush(board, i, j);
                recursive = true;
            }
        }
        return recursive ? candyCrush(board) : board;
    }

    // Logic of crush and drop of all blocks over the blockl with negative values.
    private void crush(int[][] board, int i, int j){
        int upper = i-1;
        // 找到第一个crushed block上方的不被crush的block， 准备drop it
        while (upper >= 0){
            if (board[upper][j] > 0)
                break;
            upper--;
        }
        // crush and drop
        while (upper >= 0){
            board[i][j] = board[upper][j];
            upper--;
            i--;
        }
        // fill with above blocks with value 0
        while (i >= 0){
            board[i][j] = 0;
            i--;
        }
    }
}
