package leetcode_algorithm.Valid_Sudoku;

import java.util.HashSet;


/**
 *
 * 验证数独的合法性
 * 
 *  Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 */
public class Solution {

    public static void main(String[] args) {
        char[][] tmp = new char[][]{
                {'.','.','.','.','.','.','.','.','2',},
                {'.','.','.','.','.','.','.','.','6',},
                {'.','.','1','4','.','.','8','.','.',},
                {'.','.','.','.','.','.','.','.','.',},
                {'.','.','.','.','.','.','.','.','.',},
                {'.','.','.','.','3','.','.','.','.',},
                {'5','.','8','6','.','.','.','.','.',},
                {'.','9','.','.','.','.','4','.','.',},
                {'.','.','.','.','5','.','.','.','.',},
        };
        System.out.println(new Solution().isValidSudoku(tmp));
    }


    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
