package leetcode_algorithm;

import java.util.Arrays;

/**

Write a program to solve a Sudoku puzzle by filling the empty cells.

        Empty cells are indicated by the character '.'.

        You may assume that there will be only one unique solution.


*/

public class q037_SudokuSolver {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5' , '3' , '.' , '.' , '7' , '.', '.', '.', '.',},
                {'6' , '.' , '.' , '1' , '9' , '5', '.', '.', '.',},
                {'.' ,  '9' , '8' , '.' , '.' , '.', '.', '6', '.',},
                {'8' , '.' , '.' , '.' , '6' , '.', '.', '.', '3',},
                {'4' , '.' , '.' , '8' , '.' , '3', '.', '.', '1',},
                {'7' , '.' , '.' , '.' , '2' , '.', '.', '.', '6',},
                {'.' , '6' , '.' , '.' , '.' , '.', '2', '8', '.',},
                {'.' , '.' , '.' , '4' , '1' , '9', '.', '.', '5',},
                {'.' , '.' , '.' , '.' , '8' , '.', '.', '7', '9',}
        };
        new q037_SudokuSolver().solveSudoku(board);
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }


    /**
     *½â·¨1
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0;i < board.length; i++) {
            for(int j = 0; j<board[0].length;j++) {
                if (board[i][j] == '.') {
                    for(char c = '1'; c<='9' ;c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i< 9;i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3* (row / 3) + i/3][3 * (col / 3) + i % 3] != '.'
                    && board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
