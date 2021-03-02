//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1260 👎 0

package leetcode.editor.cn;
public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       return isCheck(root.left,root.right);
    }


    public boolean isCheck(TreeNode p,TreeNode q){

        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return  p.val==q.val&isCheck(p.left,q.right)&&isCheck(p.right,q.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}