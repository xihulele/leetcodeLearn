package leetcode.editor.summary.sort;





/**
 * 3.选择排序
 * （1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * （2）在剩余待排序中的元素中找到最小（大）的元素，存放已排序序列最后一个元素后面。
 * （3）重复二直到排序结束。
 */
public class Sort4Bubble {

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
            boolean exchange=false;
            for(int i=0;i<nums.length-1;++i){
                for(int j=0;j<nums.length-1-i;++j){
                    if(nums[j]>nums[j+1]){
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                        exchange=true;
                    }
                    if(!exchange){
                        return;
                    }
                }
            }
        }
    }
}
