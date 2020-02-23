/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.74%)
 * Likes:    588
 * Dislikes: 0
 * Total Accepted:    79.6K
 * Total Submissions: 151.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == "" || digits.length() == 0) return new ArrayList<String>();
        
        dfs(digits, "", 0);
        return res;
    }
    private void dfs(String digits, String temp, int index){
        if(index == digits.length()){
            res.add(temp);
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';
        String mapString = map[pos];

        for(int i = 0; i < mapString.length(); i++){
            dfs(digits, temp + mapString.charAt(i), index + 1);
        }


    }
}
// @lc code=end

