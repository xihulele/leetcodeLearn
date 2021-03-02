package leetcode.editor.summary.BinarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找变形4
 *在一个有序的数组里，数据里面元素可能有重复的，查找指定key所在的索引范围。
 * 例如：int arr[] = {1,2,2,2,2,3,3,3,3,3,6,6,7,9,11,12}; 查找3的话，应该返回（5,9）
 *
 * 分析一下： 一个思路是，先随意找到一个key所在的索引i，然后从i的左右两侧查找，直到左右两侧遇到不等于key的值为止，然后返回两边的索引号。
 * 但是，这样存在一个问题，考虑一下如果一个数组是{1,2,3,3,3,3,3,3,3,4}，这样按照上面的想法就很扯淡了，因为与key相等的值太多了，比较代价太大。
 * 于是可以考虑，用两次二分查找，找两个边界，这里我们可以使用变形3中所写好的find函数，我们去找比key+1大的最小的索引right，以及比key大的最小值得索引left。
 * 返回结果，即为<left,right-1>
 */
public class BinarySearch5 {

    public static void main(String[] args){



//        int[] nums=new int[]{1,2,2,3,3,4,9,9,10,12};
        int[] nums=new int[]{1,2,2,3,3,4,9,9,10,12,12,12};
        Solution solution =new Solution();
//        int i = solution.binarySearch(nums, 2);
//        System.out.println(i);
        for(int i=0;i<15;++i){
            List<Integer> range = solution.findRange(nums, 12, i);
            System.out.println("key:"+i+",begin:"+range.get(0)+",end:"+range.get(1));
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

        public List<Integer> findRange(int[] nums, int length, int key){
            List<Integer> res=new ArrayList<>();
            res.add(-1);
            res.add(-1);
            int l = binarySearch(nums, 0,length-1, key);
            if(l<0 || nums[l] != key) return res;
            res.set(0,l);
            int r = binarySearch(nums, 0, length-1, key+1);
            if(r==-1){
                r=length;
            }
            if(r-1<0 || nums[r-1] != key) return res;
            res.set(1, r-1);
            return res;
        }
    }
}
