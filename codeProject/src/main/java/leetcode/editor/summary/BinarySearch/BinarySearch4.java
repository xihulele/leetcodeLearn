package leetcode.editor.summary.BinarySearch;


/**
 * 二分查找变形3
 *在一个有序的数组里，查找不小于key的最小的数的索引，如果key值存在，则返回key第一次出现的位置，如果不存在则返回-1。（类似的查找比key小的最大的数）
 */
public class BinarySearch4 {

    public static void main(String[] args){



        int[] nums=new int[]{1,2,2,3,3,4,9,9,10,12};
        Solution solution =new Solution();
//        int i = solution.binarySearch(nums, 2);
//        System.out.println(i);

        for(int i=0;i<15;++i){
            int r = solution.binarySearch(nums, 0,9,i);
            System.out.println("key:"+i+",index:"+r);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int binarySearch(int[] nums,int low,int high,int key) {
            if (low > high) {
                return -1;
            }
            if (nums[low] >= key) {
                return low;
            }
            int mid=(low+high)/2;
            if(nums[mid]<key){
                return binarySearch(nums,mid+1,high,key);
            }else{
                if(mid>low&&nums[mid-1]>=key){
                   return binarySearch(nums,low,mid-1,key);
                }
                return mid;
            }
        }
    }
}
