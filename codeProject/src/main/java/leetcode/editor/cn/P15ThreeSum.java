//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2797 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList();
        Arrays.sort(nums);
        int n=nums.length;
        for(int first =0;first<n;++first){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third=n-1;
            int target=-nums[first];
            for(int second=first+1;second<n;++second){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third]>target){
                    --third;

                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List list=new ArrayList();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}