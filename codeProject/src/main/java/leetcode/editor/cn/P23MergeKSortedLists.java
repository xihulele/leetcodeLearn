//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1033 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.domain.ListNode;

import java.util.PriorityQueue;

public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
    /**
     * 方法1.顺序两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        ListNode res= null;
        for(ListNode listNode : lists){
            res=mergeTow2(res,listNode);
        }
        return res;
    }



    /**
     * 方法2 使用优选队列（本质是个大顶堆或者小顶堆）
     * 将所有元素放入优先队列，然后出队
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Status> priorityQueue=new PriorityQueue();
        //放入队列中去
        for(ListNode listNode:lists){
            if(listNode!=null){
                priorityQueue.add(new Status(listNode.val,listNode));
            }
        }
        ListNode head=new ListNode(0);
        ListNode tail=head;
        //出队列 每次出队列的是最小值
        while(!priorityQueue.isEmpty()){
            ListNode min= priorityQueue.poll().node;
            tail.next=min;
            tail=tail.next;
            if(min.next!=null){
                priorityQueue.add(new Status(min.next.val,min.next));
            }
        }
        return head.next;
    }


    /**
     * 方法3.分之合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    public ListNode  merge(ListNode[] list ,int l,int r){
        if(l==r){
            return list[l];
        }
        if(l>r){
            return null;
        }
        int mid=(l+r)>>1;
        return mergeTow2(merge(list,l,mid),merge(list,mid+1,r));
    }



    /**
     * 合并两个列表递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode  mergeTow1(ListNode list1,ListNode list2){
        if(list1==null){
            return  list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<list2.val){
            list1.next=mergeTow1(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTow1(list1,list2.next);
            return list2;
        }
    }



    /**
     * 合并两个列表递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode  mergeTow2(ListNode list1,ListNode list2){
        ListNode head=new ListNode(1);
        ListNode tail=head,p1=list1,p2=list2;
        while (p1!=null&&p2!=null){
            if(p1.val<p2.val){
                tail.next=p1;
                p1=p1.next;
            }else {
                tail.next=p2;
                p2=p2.next;
            }
            tail=tail.next;
        }
        if(p1==null){
            tail.next=p2;
        }
        if(p2==null){
            tail.next=p1;
        }
        return head.next;
    }

    public class Status implements Comparable<Status>{
        public int val;
        public ListNode node;


        public Status(int val, ListNode node ){
            this.val=val;
            this.node=node;
        }
        public int compareTo(Status status) {
            return this.val-status.val;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)




}