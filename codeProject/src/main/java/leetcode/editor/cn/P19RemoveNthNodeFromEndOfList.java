//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1137 👎 0

package leetcode.editor.cn;
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *快慢指针
     * p1 先走n个节点
     * p2 不走
     * p1 p2 同时走 p1 走到结尾处 p2下个节点正好是要删除的节点
     */
    class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode listNode=new ListNode(0,head);
        ListNode p1=head;
        ListNode p2=listNode ;
        int i=0;
        while(i<n&&p1!=null){
            p1=p1.next;
            ++i;
        }
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        ListNode temp=p2.next;
        p2.next=temp.next;
        return listNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}