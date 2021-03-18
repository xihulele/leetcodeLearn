package leetcode.editor.summary.sort;





/**
 * 1.插入排序
 * （1）第一个元素看成有序序列，第二及以后的元素是待排序序列（2）一次扫描待排序序列，将待排序序列插入在有序序列的合适位置。
 * 插入排序在对几乎已经排好序的数据操作时， 效率高， 即可以达到线性排序的效率
 */
public class Sort1Insert {

    public static void main(String[] args){

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public void  insertSort(int[] nums) {
            for(int i=1;i<nums.length;++i){
                int temp=nums[i];
                int j=i;
                while(j>0&&temp<nums[j-1]){
                    nums[j]=nums[j-1];
                    --j;
                }
                nums[j]=temp;
            }
        }
    }
}
