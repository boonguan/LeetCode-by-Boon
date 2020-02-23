/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (38.41%)
 * Likes:    280
 * Dislikes: 0
 * Total Accepted:    21.3K
 * Total Submissions: 55.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * 输出: 42
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
        对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
        1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
        **/
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSumWithRoot(root);
        return res;
    }
    private int maxSumWithRoot(TreeNode root){
        if(root == null) return 0;
        int left = maxSumWithRoot(root.left);
        int right = maxSumWithRoot(root.right);
        int curSum = Math.max(0, Math.max(left, right)) + root.val;
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        res = Math.max(res, Math.max(0, left) + Math.max(0, right) + root.val);
        return curSum;
    }
}
// @lc code=end

