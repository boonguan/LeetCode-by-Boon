/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (64.70%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    22.3K
 * Total Submissions: 34K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    int n = 0;

    public List<List<String>> partition(String s) {
         n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1) && (len < 3 || dp[i + 1][i + len - 2]);
            }
        }

        dfs(s, new ArrayList<String>(), dp, 0);
        return res;

    }

    private void dfs(String s, List<String> temp, boolean[][] dp, int start){
        if(start == n){
            res.add(new ArrayList<String>(temp));
        }
        for(int i = start; i < n; i++){
            if(dp[start][i]){
                temp.add(s.substring(start, i + 1));
                dfs(s, temp, dp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
// @lc code=end

