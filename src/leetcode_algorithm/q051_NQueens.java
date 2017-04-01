package leetcode_algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**

    The n-queens puzzle is the problem of placing n queens on an
 n×n chessboard such that no two queens attack each other.

        Given an integer n, return all distinct solutions to the n-queens puzzle.

        Each solution contains a distinct board configuration of the n-queens' placement,
        where 'Q' and '.' both indicate a queen and an empty space respectively.

        For example,
        There exist two distinct solutions to the 4-queens puzzle:
             [
 [".Q..",  // q001_TwoSum 1
                 "...Q",
                 "Q...",
                 "..Q."],

 ["..Q.",  // q001_TwoSum 2
                 "Q...",
                 "...Q",
                 ".Q.."]
             ]
*/


public class q051_NQueens {

    public static void main(String[] args) {
        System.out.println(new q051_NQueens().solveNQeens(4));
        System.out.println(new q051_NQueens().solveNQeens(8));
        System.out.println(new q051_NQueens().solveNQeens(9));
    }

    /**
     *解法1(推荐解法)
     * @param n
     * @return
     */
    public List<List<String>> solveNQeens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i< n ;i++)
            for(int j = 0; j< n;j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        dfs(board , 0 , res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        for(int i = 0; i<board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }


    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i< board.length;i++) {
            for(int j = 0; j< y ;j++) {
                if(board[i][j] == 'Q' && (x + j == y+i || x+y == i+j || x==i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for(int i = 0; i< board.length;i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


}
