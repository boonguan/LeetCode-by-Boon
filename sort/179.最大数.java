/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (34.71%)
 * Likes:    197
 * Dislikes: 0
 * Total Accepted:    18.8K
 * Total Submissions: 53.8K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strArr[i] = nums[i] + "";
        }
        Arrays.sort(strArr, (o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));

        StringBuilder res = new StringBuilder();
        for(String str : strArr){
            res.append(str);
        }
        if(res.charAt(0) == '0') return "0";
        return res.toString();
    }
}
// @lc code=end

