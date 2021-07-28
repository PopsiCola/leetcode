//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 316 👎 0

package com.cute.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        // String word = "ABCCED";
        // char[][] boards = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        /*String word = "FRANCE";
        char[][] boards = {
         {'F','Y', 'C', 'E', 'N', 'R', 'D'}
        ,{'K','L', 'N', 'F', 'I', 'N', 'U'}
        ,{'R','A', 'A', 'R', 'A', 'H', 'R'}
        ,{'N','D', 'K', 'L', 'P', 'N', 'E'}
        ,{'A','L', 'A', 'N', 'S', 'A', 'P'}
        ,{'O','O', 'G', 'O', 'T', 'P', 'N'}
        ,{'H','P', 'O', 'L', 'A', 'N', 'O'}};*/
        String word = "AAB";
        char[][] boards = {
         {'C','A', 'A'}
        ,{'A','A', 'A'}
        ,{'B','C', 'D'}};
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(boards, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[] chars = {};
        char[][] boards = {};
        int rows = 0;
        int columns = 0;
        // 是否走过该路径
        boolean[][] bool = null;

        public boolean exist(char[][] board, String word) {
            chars = word.toCharArray();
            boards = board;

            rows = board.length;
            columns = board[0].length;
            bool = new boolean[rows][columns];


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (chars[0] == board[i][j]) {
                        // 判断四周是否存在与
                        int index = 0;

                        if (dfs(++index, i, j)) {
                            return true;
                        } else {
                            bool[i][j] = false;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(int index, int i, int j) {
            bool[i][j] = true;

            if (index == chars.length) {
                return true;
            }
            int row = i + 1;
            if (row >= 0 && row < rows && (chars[index] == boards[row][j]) && !bool[row][j]) {
                if (dfs(++index, row, j)) {
                    return true;
                } else {
                    --index;
                    bool[row][j] = false;
                }
            }
            row = i - 1;
            if (row >= 0 && row < rows && (chars[index] == boards[row][j]) && !bool[row][j]) {
                if (dfs(++index, row, j)) {
                    return true;
                } else {
                    --index;
                    bool[row][j] = false;
                }
            }
            int column = j + 1;
            if (column >= 0 && column < columns && (chars[index] == boards[i][column]) && !bool[i][column]) {
                if (dfs(++index, i, column)) {
                    return true;
                } else {
                    --index;
                    bool[i][column] = false;
                }
            }
            column = j - 1;
            if (column >= 0 && column < columns && (chars[index] == boards[i][column]) && !bool[i][column]) {
                if (dfs(++index, i, column)) {
                    return true;
                } else {
                    --index;
                    bool[i][column] = false;
                }
            }
            return false;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}