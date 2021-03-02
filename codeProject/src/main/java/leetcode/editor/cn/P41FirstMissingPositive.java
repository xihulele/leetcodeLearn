//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 955 👎 0

package leetcode.editor.cn;
public class P41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {

        //1.先将数组都转换成正数
        int n=nums.length;
        for(int i=0;i<n;++i){
            if(nums[i]<=0){
                nums[i]=n+1;
            }
        }
        //2.如果|x| 在(1,n) 则将nums[|x|-1] 标志成负数，以此表示 x出现过。如果nums[|x|-1]为负数 则不用标记了

        for(int i=0;i<n;++i){
            int temp=Math.abs(nums[i]);
            if(temp<=n){
                if(nums[temp-1]>0){
                    nums[temp-1]=-nums[temp-1];
                }
            }
        }
        //3.找到第一个正数 返回
        for(int i=0;i<n;++i){
            if(nums[i]>0){
                return i+1;
            }
        }
        //都为负数 返回n+1;
        return n+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}