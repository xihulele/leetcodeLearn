//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1716 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class P136SingleNumber {
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,1};
        Solution solution = new P136SingleNumber().new Solution();
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(nums[i])){
                Integer count = map.get(nums[i]);
                count=count+1;
                map.put(nums[i],count);
            }else {
                map.put(nums[i],1);
            }
        }

        for(int i=0;i<nums.length;++i){
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}