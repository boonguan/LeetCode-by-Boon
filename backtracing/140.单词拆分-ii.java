import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 *
 * https://leetcode-cn.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (37.26%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    11.1K
 * Total Submissions: 29.4K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典
 * wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 
 * 说明：
 * 
 * 
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 
 * 示例 1：
 * 
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i = 0; i < n; i++){
            if(wordDict.contains(s.substring(0, i))){
                dp[i] = true;
                continue;
            }
            for(int l = 0; l < i; l++){
                if(dp[l] && wordDict.contains(s.substring(l + 1, i + 1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[n - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, n - 1, wordDict, res, queue, dp);
            return res;
        }
        return res;
    }
    private void dfs(String s, int end, List<String> wordDict, List<String> res, LinkedList<String> queue, boolean[] dp){
        if(wordDict.contains(s.substring(0, end + 1))){
            queue.addFirst(s.substring(0, end + 1));
            StringBuilder stringBuilder = new StringBuilder();
            for(String str : queue){
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());
            queue.removeFirst();
        }
        for (int i = 0; i < end; i++) {

            if (dp[i]) {
                String suffix = s.substring(i + 1, end + 1);
                if (wordDict.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordDict, res, queue, dp);
                    queue.removeFirst();
                }
            }

        }
    }
}
// @lc code=end

