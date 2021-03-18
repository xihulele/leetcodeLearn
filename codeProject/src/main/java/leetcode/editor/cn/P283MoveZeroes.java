//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 981 👎 0

package leetcode.editor.cn;
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //1.双指针 左边指针指向处理的序列的尾部，右边指针指向待处理序列的头部，右边指针碰到0 就跳过，非零就和左边指针的数交换，
        // 左右指针之间的数都是0
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        int len=nums.length;
        while (right<len){
            if(nums[right]!=0){
                swap(left,right,nums);
                ++left;
            }
            ++right;
        }

    }

    public void swap(int left,int right,int[] nums){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}