//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1454 👎 0

package leetcode.editor.cn;
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // dp[i] 表示 以i结尾的数组的最大利润，及前i日最大利润
        //前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
        //dp[i]= max(dp[i-1],price[i]-min[1:n])  min[1-n] 为前n日最低价格
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i =0;i<n;++i){
             minPrice=Math.min(prices[i],minPrice);
             profit=Math.max(profit,prices[i]-minPrice);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}