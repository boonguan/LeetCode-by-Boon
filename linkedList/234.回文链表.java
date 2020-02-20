package linkedList;/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (39.51%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    63.5K
 * Total Submissions: 157.1K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 输入: 1->2->1->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode pre = head, slow = head, fast = head, prepre = null;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;//反转前半段
            prepre = pre;
        }
        if(fast != null){
            slow = slow.next;
        }
        
        while(slow != null && pre != null){
            if(pre.val != slow.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return slow == pre;

    }
}
// @lc code=end

