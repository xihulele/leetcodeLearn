package leetcode.editor.summary.sort;





/**
 * 6.快速排序
 * （1）通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */
public class Sort6Quick {

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
            quickSort(nums,0,nums.length-1);
        }

        public  void  quickSort(int nums[],int left,int right){
            if(left<right){
                int index = partition(nums, left, right);
                quickSort(nums,left,index-1);
                quickSort(nums,index+1,right);
            }
        }

        /**
         * 分区函数，以第一个数组第一个元素为基准,将小于基准的数放在基准前边，将大于基准的数据放在基准后边。
         * @param nums
         * @param left
         * @param right
         */
        public  int  partition(int  nums[],int left,int right){

            int i=left;
            int j=right;
            int temp=nums[left];
            while(i<j){
                while(i<j&& nums[j]>temp){
                    --j;
                }
                if(i<j){
                    nums[i]=nums[j];
                    ++i;
                }
                while(i<j&&nums[i]<temp){
                    ++i;
                }
                if(i<j){
                    nums[j]=nums[i];
                    --j;
                }
            }
            nums[i]=temp;
            return i;
        }
    }
}
