package leetcode.editor.summary.sort;





/**
 * 3.选择排序
 * （1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * （2）在剩余待排序中的元素中找到最小（大）的元素，存放已排序序列最后一个元素后面。
 * （3）重复二直到排序结束。
 */
public class Sort3Select {

    public static void main(String[] args){
        int nums[]={9,7,12,9,5,67,3,3,1,999};
        Solution solution=new Solution();
        solution.solution(nums);
        StringBuffer stringBuffer=new StringBuffer();
        for(int num:nums){
            stringBuffer.append(num).append(",");
        }
        System.out.println(stringBuffer.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public void  solution(int[] nums) {
            for(int i=0;i<nums.length;++i){
                int min=i;
                for(int  j=i;j<nums.length;++j){
                    if(nums[min]>nums[j]){
                        min=j;
                    }
                }
                if(i!=min){
                    int temp=nums[i];
                    nums[i]=nums[min];
                    nums[min]=temp;
                }
            }
        }
    }
}
