package leetcode.editor.summary.BinarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找变形2
 *假如集合中的元素有重复，要找到key首次出现的位置。
 */
public class BinarySearch3 {

    public static void main(String[] args){



        int[] nums=new int[]{1,2,2,3,3,4,9,9,10,12};
        Solution solution =new Solution();
        int i = solution.binarySearch(nums, 2);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int binarySearch(int[] nums,int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target<nums[mid]){
                    high=mid-1;
                }else if(target>nums[mid]){
                    low=mid+1;
                }else{
                    if(mid==0) return mid;
                    if(mid>=1&& nums[mid-1]!=nums[mid]) return mid;
                    high=mid;
                }
            }
            return -1;
        }
    }
}
