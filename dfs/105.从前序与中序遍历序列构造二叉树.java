import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (63.20%)
 * Likes:    296
 * Dislikes: 0
 * Total Accepted:    35.5K
 * Total Submissions: 56.2K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
        

    
    public TreeNode buildCore(int[] preorder, int pl, int pr, int[] inorder, int il, int ir, HashMap<Integer, Integer> map){
        if(pl > pr) return null;
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftLen = rootIndex - il;

        root.left = buildCore(preorder, pl + 1, pl + leftLen, inorder, il, rootIndex - 1, map);
        root.right = buildCore(preorder, pl + leftLen + 1, pr, inorder, rootIndex + 1, ir, map);
        return root;
    }
}
// @lc code=end

