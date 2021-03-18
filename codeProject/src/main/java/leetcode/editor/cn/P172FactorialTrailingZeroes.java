//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 427 👎 0

package leetcode.editor.cn;
public class P172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172FactorialTrailingZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {

        // 出现2*5的次数决定了 0 的个数 每隔5个数至少一个5   每隔两个2个数至少一个2 所以2比5多。只需要计算 5个个数就可以了。
        // 每五个数一个五 每隔25多一个5 每隔125 又多一个5
        // n/5 +n/25 +n/125 +++n/5*5...  直到n/5...=0
        int count=0;
        while(n>0){
            count+=n/5;
            n=n/5;
        }
        return  count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}