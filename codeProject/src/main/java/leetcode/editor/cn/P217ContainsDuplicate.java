//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 371 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i:nums){
            if(set.contains(i)){
                return true;
            }else {
                set.add(i);
            }
        }
        return false;
    }

        public boolean containsDuplicate(int[] nums) {

            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;++i){
                if(nums[i]==nums[i+1]){
                    return true;
                }
            }
            return false;
        }



}
//leetcode submit region end(Prohibit modification and deletion)

}