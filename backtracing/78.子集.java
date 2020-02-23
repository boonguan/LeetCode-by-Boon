
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.71%)
 * Likes:    478
 * Dislikes: 0
 * Total Accepted:    62.2K
 * Total Submissions: 81.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    

    public List<List<Integer>> subsets(int[] nums) {
        
        // backtracing(nums, list, 0);
        //迭代解法 枚举
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(Integer num : nums){
            for(int j = 0; j < res.size(); j++){
                List<Integer> newList = res.get(j);
                newList.add(num);
                res.add(newList);
            }
        }
        return res;
    }
    // private void backtracing(int[] nums, List<Integer> list, int start){
    //     res.add(new ArrayList<>(list));
    //     for(int i = start; i < nums.length; i++){
    //         list.add(nums[i]);
    //         backtracing(nums, list, i + 1);
    //         list.remove(list.size() - 1);
    //     }
    // }
}
// @lc code=end

