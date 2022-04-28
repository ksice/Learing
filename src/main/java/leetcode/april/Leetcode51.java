package leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/4/10 下午2:28
 * @Author : ksice_xt
 */
public class Leetcode51 {

    List<List<String>> lists = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘".代表空"，"Q代表皇后"
        char[][] board = new char[n][n];

        //初始化棋盘
        for (char[] item : board) {
            Arrays.fill(item, '.');
        }
        //从第0行开始进行排列
        backtrack(board, 0);
        return lists;
    }

    public void backtrack(char[][] board, int row) {
        //当row的行数的描绘board行数说明排列到最后一行了，说明这是一种可以用的排列方式，于是进行存储
        if (row == board.length) {
            lists.add(charToList(board));
            return;
        }

        int n = board[row].length;

        //当前行的列放置的可能情况
        for (int col = 0; col < n; col++) {

            if (!isValid(board, row, col)) {
                continue;
            }
            //找到可放置的位置
            board[row][col] = 'Q';

            //然后开始放置下一行
            backtrack(board, row + 1);

            //找到一种排列方式后开始找下一个排列方式,假如刚开始第一行第一列，然后在放置第一行第二列，把每个位置都放一遍，找到排列的种类
            //还原当前节点，找下一列排列情况
            //这个还原节点的操作真的很厉害，这样就可以考虑多种情况了
            board[row][col] = '.';
        }
    }


    /**
     * 不考虑左下方和右下方是因为下面的行都还没放置，丛上往下放，所以只需要管上面的排列方式是否有冲突
     *
     * @param board 棋盘
     * @param row   行
     * @param col   列
     * @return
     */
    public boolean isValid(char[][] board, int row, int col) {

        int length = board.length;
        //判断这一列是否有皇后冲突
        for (int i = 0; i < length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //检查右上方是否有冲突,row-1代表是上面，因为往下是+1
        //col+1往右边走
        for (int i = row - 1, j = col + 1; i >= 0 && j < length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //检查左上方是否有冲突，col-1 j--往左走,同时j-- j>0
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //将一种排列方式存入到list集合中
    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

}
