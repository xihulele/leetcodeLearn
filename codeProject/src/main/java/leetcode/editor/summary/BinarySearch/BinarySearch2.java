package leetcode.editor.summary.BinarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找变形1
 * 在循环有序数组（或者叫做旋转数组）中查找指定元素，也就是说在类似这样的{12,16,18,20,41,100,1,4,6,9}数组中查找指定的元素。
 */
public class BinarySearch2 {

    public static void main(String[] args){

        List<String> a=new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");


//        int[] nums=new int[]{1,2,2,3,3,4,9,10,12};
//        Solution solution =new Solution();
//        int i = solution.binarySearch(nums, 3);
        System.out.println(a.toString());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int binarySearch(int[] nums,int target) {
            int n =nums.length;
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
