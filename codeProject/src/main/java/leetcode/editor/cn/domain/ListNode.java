package leetcode.editor.cn.domain;

  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public void set(int val){
          this.val=val;
      }

      public int  get(){
          return this.val;
      }

  }
