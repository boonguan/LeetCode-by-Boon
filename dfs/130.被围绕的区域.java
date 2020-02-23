/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (38.58%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    21.5K
 * Total Submissions: 54.8K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
     
        if(board.length <= 0) return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[row-1][i] == 'O'){
                dfs(board, row - 1, i);
            }
        }
        for(int j = 0; j < row; j++){
            if(board[j][0] == 'O'){
                dfs(board, j, 0);
            }
            if(board[j][col-1] == 'O'){
                dfs(board, j, col - 1);
            }
        }


        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row , int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#'){
            return;
        }
        if(board[row][col] == 'O'){
            board[row][col] = '#';
            dfs(board, row + 1, col);
            dfs(board, row - 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }

    }

}
// @lc code=end

