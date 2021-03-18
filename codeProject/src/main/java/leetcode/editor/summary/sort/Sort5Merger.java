package leetcode.editor.summary.sort;





/**
 * 3.归并排序
 * （1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 */
public class Sort5Merger {

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
            mergerSort(nums,0,nums.length-1);
            return;
        }
        // 分治算法 要给整个数据归并排序 ，先给两个小数组归并，然后将两个小数组进行合并
        public void  mergerSort(int[] nums,int left,int right) {

            if(left<right){
                int mid=left+(right-left)/2;
                mergerSort(nums,left,mid);
                mergerSort(nums,mid+1,right);
                mergerTow(nums,left,mid,right);
            }
            return;
        }

        // 两个有序数组和并

        public void mergerTow(int[] nums,int left,int mid ,int right){
            int[] temp=new int[right-left+1];
            int i=left;
            int j=mid+1;
            int k=0;
            while(i<=mid&&j<=right){
                if(nums[i]<nums[j]){
                    temp[k]=nums[i];
                    ++i;
                }else{
                    temp[k]=nums[j];
                    ++j;
                }
                ++k;
            }
            while(i<=mid){
                temp[k]=nums[i];
                ++i;
                ++k;
            }
            while (j<=right){
                temp[k]=nums[j];
                ++j;
                ++k;
            }
//            k=0;
//            for(int m =left;m<=right;++m){
//                nums[m]=temp[k];
//                ++k;
//        }
            for(int m =0;m<temp.length;++m){
                nums[m+left]=temp[m];
            }
        }
//public static int[] sort(int[] a,int low,int high){
//    int mid = (low+high)/2;
//    if(low<high){
//        sort(a,low,mid);
//        sort(a,mid+1,high);
//        //左右归并
//        merge(a,low,mid,high);
//    }
//    return a;
//}
//
//        public static void merge(int[] a, int low, int mid, int high) {
//            int[] temp = new int[high-low+1];
//            int i= low;
//            int j = mid+1;
//            int k=0;
//            // 把较小的数先移到新数组中
//            while(i<=mid && j<=high){
//                if(a[i]<a[j]){
//                    temp[k++] = a[i++];
//                }else{
//                    temp[k++] = a[j++];
//                }
//            }
//            // 把左边剩余的数移入数组
//            while(i<=mid){
//                temp[k++] = a[i++];
//            }
//            // 把右边边剩余的数移入数组
//            while(j<=high){
//                temp[k++] = a[j++];
//            }
//            // 把新数组中的数覆盖nums数组
//            for(int x=0;x<temp.length;x++){
//                a[x+low] = temp[x];
//            }
//        }
    }




}
