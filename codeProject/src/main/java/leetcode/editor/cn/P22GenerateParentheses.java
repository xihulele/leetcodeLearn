//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1459 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        /**
         * 使用深度优先算法  dfs
         * @param n
         * @return
         */
    public List<String> generateParenthesis(int n) {
        //
        List<String> res=new ArrayList();
        StringBuffer cur=new StringBuffer();
        dfs(res,cur,n,n);
        return res;
    }

        /**
         *
         * @param res 结果集合
         * @param cur 当前生成序列
         * @param left 左括号剩余个数
         * @param right 右括号剩余个数
         */
    public void dfs(List<String> res,StringBuffer cur,int left,int right){
        // 左括号剩余0 右括号剩余0 说明到达回溯节点
        if(left==0&&right==0){
            res.add(cur.toString());
            return;
        }
        // 左边剩余大于右边剩余 这种情况下的生成的序列都不符合条件 直接返回
        if(left>right){
            return;
        }
        // 如果左括号还有剩余那么当前序加上“（” 继续深度遍历 left-1的情况
        if(left>0){
            cur.append('(');
            dfs(res,cur,left-1,right);
            cur.deleteCharAt(cur.length()-1);
        }
        // 如果右括号还有剩余那么当前序加上“）” 继续深度遍历 right-1的情况
        if(right>0){
            cur.append(')');
            dfs(res,cur,left,right-1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}