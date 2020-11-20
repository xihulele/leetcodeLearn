//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5273 👎 0

package leetcode.editor.cn;



//java:两数相加
public class P2AddTwoNumbers{
    public static void main(String[] args){
        Solution solution = new P2AddTwoNumbers().new Solution();
//        ListNode l1=new ListNode(2);
//        l1.next=new ListNode(4);
//        l1.next.next=(new ListNode(3));
//        ListNode l2=new ListNode(5);
//        l2.next=(new ListNode(6));
//        l2.next.next=(new ListNode(4));
//        ListNode l3 = solution.addTwoNumbers(l1, l2);
//        while (l3!=null){
//            System.out.print(l3.val+",");
//            l3=l3.next;
//        }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3=new ListNode(-1);
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode p3=l3;
        int flag=0;
        while(p1!=null||p2!=null){
            int temp=flag;
            flag=0;
            if(p1!=null){
                temp=temp+p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                temp=temp+p2.val;
                p2=p2.next;
            }
            if(temp>9){
                temp=temp%10;
                flag=1;
            }
            p3.next=new ListNode(temp);
            p3=p3.next;
        }
        if(flag==1){
            p3.next=new ListNode(1);
        }
        return l3.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



    public  class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}