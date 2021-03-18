//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 886 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(1);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode preNode;
    // 1.使用额外的数组
    public boolean isPalindrome1(ListNode head) {
        //todo
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int start=0;
        int end=list.size()-1;
        while(start<=end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    //2.递归的方法
    public boolean isPalindrome2(ListNode head) {
        preNode=head;
        return reverseAndCheck(head);
    }
    public boolean  reverseAndCheck(ListNode  currentNode){
        if(currentNode==null){
            return true;
        }
        if(!reverseAndCheck(currentNode.next)){
            return false;
        }
        if(currentNode.val!=preNode.val){
            return false;
        }
        preNode=preNode.next;
        return true;
    }
    //3.开慢指针
    //(1) 找到中间节点（2）翻转后半段 （3） 前后比较（4）将后半段再翻转回来（5）返回结果
    public boolean isPalindrome(ListNode head) {

        ListNode halfEnd=firstHalfEnd(head);
        ListNode secondHead = reverseListNode(halfEnd.next);
        ListNode p1=head;
        ListNode p2=secondHead;
        boolean  flag=true;
        while(p2!=null){
            if(p1.val!=p2.val){
                 flag=false;
                 break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        ListNode listNode = reverseListNode(secondHead);
        halfEnd.next=listNode;
        return flag;
    }

    /**
     * 返回链表的前半段尾部节点（寄数时 中间节点算作前半段）
     * @param head
     * @return
     */
    ListNode firstHalfEnd(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
           fast= fast.next.next;
           slow=slow.next;
        }
        return slow;
    }

    ListNode reverseListNode(ListNode head){
        ListNode newHead=new ListNode(-1);
        ListNode p=head;
        while(p!=null){
            ListNode node =newHead.next;
            newHead.next=p;
            p=p.next;
            newHead.next.next=node;

        }
        return newHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}