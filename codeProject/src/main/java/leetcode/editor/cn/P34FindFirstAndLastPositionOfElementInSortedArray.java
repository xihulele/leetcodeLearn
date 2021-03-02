//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 771 👎 0

package leetcode.editor.cn;
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums=new int[]{1,2,3};
        int[] result= solution.searchRange(nums,1);
        System.out.println(result[0]+","+result[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n=nums.length;
        if(n==0){
            return new int[]{-1,-1};
        }
        if(n==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }else{
                return new int[]{-1,-1};
            }
        }
        int l=0,r=n-1;
        int mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                break;
            }
            if(nums[l]<=target&&target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        if(l>r){
            return new int[]{-1,-1};
        }
        int p1=mid,p2=mid;
        while(p1>=0&&nums[p1]==nums[mid]){
            --p1;
        }
        while(p2<=n-1&&nums[p2]==nums[mid]){
            ++p2;
        }
        return new int[]{p1+1,p2-1};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}