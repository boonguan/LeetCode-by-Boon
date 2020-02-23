/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (39.61%)
 * Likes:    322
 * Dislikes: 0
 * Total Accepted:    38.5K
 * Total Submissions: 94.5K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y){
        if(index == word.length()){
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)){
            return false;
        }
        
        char origin = board[x][y];
        board[x][y] = '1';
        boolean res = dfs(board, word, index + 1, x + 1, y) ||
        dfs(board, word, index + 1, x , y + 1) ||
        dfs(board, word, index + 1, x , y - 1) ||
        dfs(board, word, index + 1, x - 1 , y);
        board[x][y] = origin;

        return res;   
    }
}
// @lc code=end

