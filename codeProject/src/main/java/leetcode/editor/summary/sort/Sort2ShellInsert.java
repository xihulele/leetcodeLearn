package leetcode.editor.summary.sort;





/**
 * 2.希尔排序
 * （1）确定增量k= n/2 , 将数组划分为m个子序列，增量就是每个子序列中，每个元素的空隙。给每个子序列插入排序
 * （2）缩小增量  k=k/2 ,对各个子序列继续进行插入排序
 * （3）当k==1 是，给整个序列进行排序 ，然后结束排序。
 */
public class Sort2ShellInsert {

    public static void main(String[] args){

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public void  solution(int[] nums) {
            shellSort(nums,nums.length);
        }

        //dk 缩小增量，如果是直接插入排序，dk=1
        void ShellInsertSort(int a[], int n, int dk)
        {
            for(int i= dk; i<n; ++i){
                if(a[i] < a[i-dk]){          //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                    int j = i-dk;
                    int x = a[i];           //复制为哨兵，即存储待排序元素
                    a[i] = a[i-dk];         //首先后移一个元素
                    while(x < a[j]){     //查找在有序表的插入位置
                        a[j+dk] = a[j];
                        j -= dk;             //元素后移
                    }
                    a[j+dk] = x;            //插入到正确位置
                }
            }

        }

        /**
         * 先按增量d（n/2,n为要排序数的个数进行希尔排序
         *
         */
        void shellSort(int a[], int n){

            int dk = n/2;
            while( dk >= 1  ){
                ShellInsertSort(a, n, dk);
                dk = dk/2;
            }
        }
    }


}
