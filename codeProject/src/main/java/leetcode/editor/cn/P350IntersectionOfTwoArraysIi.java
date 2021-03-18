//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 460 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){

            return intersect(nums2,nums1);
        }

        int size=nums1.length;
        int[] res=new int[size];
        Map<Integer,Integer> table=new HashMap();
        for(int i:nums1){
            int count=table.getOrDefault(i,0);
            ++count;
            table.put(i,count);

        }
        int index=0;
        for(int i:nums2){
            int count=table.getOrDefault(i,0);
            if(count>0){
               res[index]=i;
               ++index;
               --count;
               table.put(i,count);
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

        public int[] intersect2(int[] nums1, int[] nums2) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int len1=nums1.length;
            int len2=nums2.length;
            int  resSize=Math.min(len1,len2);
            int res[]=new int[resSize];
            int index=0,index1=0,index2=0;
            while (index1<len1&&index2<len2){
                if(nums1[index1]<nums2[index2]){
                    //
                    ++index1;
                }else if(nums1[index1]>nums2[index2]){
                    ++index2;
                }else {
                    res[index]=nums1[index1];
                    ++index1;
                    ++index2;
                    ++index;
                }

            }

            return Arrays.copyOfRange(res,0,index1);

        }




}
//leetcode submit region end(Prohibit modification and deletion)

}