class Solution {
    public boolean isWinner(char[][] board, int row, int col, char ch) {
        // entire row
        if (board[row][0] == ch && board[row][1] == ch && board[row][2] == ch) {
            return true;
        }
        
        // entire column
        if (board[0][col] == ch && board[1][col] == ch && board[2][col] == ch) {
            return true;
        }
        
        // left diagonal
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            return true;
        }
        
        // right diagonal
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
            return true;
        }
        
        return false;
    }

    public String tictactoe(int[][] moves) {
        char ch = 'X';
        char[][] board = new char[3][3];
        
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            board[row][col] = ch;
            
            if (isWinner(board, row, col, ch)) {
                if (ch == 'X') {
                    return "A";
                } else {
                    return "B";
                }
            }
            
            if (ch == 'X') {
                ch = 'O';
            } else {
                ch = 'X';
            }
        }
        
        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}

