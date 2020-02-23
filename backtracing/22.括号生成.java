/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.56%)
 * Likes:    761
 * Dislikes: 0
 * Total Accepted:    76.2K
 * Total Submissions: 103.9K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }
    private void dfs(List<String> res, String part, int left, int right, int n){
        if(left == n && right == n){
            res.add(part);
        }
        if(left < right){
            return;
        }
        if(left < n){
            dfs(res, part + "(", left + 1, right, n);
        }
        if(right < n){
            dfs(res, part + ")", left, right + 1, n);
        }
        
    }
}
// @lc code=end

