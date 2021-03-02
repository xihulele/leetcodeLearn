//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 804 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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

        //1.深度优先遍历
    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return  Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //2.广度优先遍历
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        int level=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                --size;
            }
            ++level;
        }
        return  level;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}