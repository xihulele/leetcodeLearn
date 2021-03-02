package leetcode.editor.summary.BinarySearch;



/**
 * 经典二分查找
 * 在有序数组里面查找是否存在某个元素，如果存在，则返回相应元素所在索引号
 */
public class BinarySearch1 {

    public static void main(String[] args){

        int[] nums=new int[]{1,2,2,3,3,4,9,10,12};
        Solution solution =new Solution();
        int i = solution.binarySearch(nums, 3);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int binarySearch(int[] nums,int target) {
            int n=nums.length;
            if(n==0){
                return -1;
            }
            int l=0;
            int r=nums.length-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            return -1;
        }
    }
}
