//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 638 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        System.out.println(solution.countPrimes(100));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        //
        public int countPrimes(int n) {

            int[] primes=new int[n];
            Arrays.fill(primes,1);
            for(int i=2;i<n;++i){
                if(primes[i]==1){
                    if((long) i*i<n){
                        for(int j=i*i;j<n;j=j+i){
                            primes[j]=0;
                        }
                    }

                }
            }
            int res=0;
            for(int i=2;i<n;++i){
                if(primes[i]==1){
                    ++res;
                }
            }
            return res;
        }


//    public int countPrimes(int n) {
//
//        int res=0;
//        for(int i=2;i<n;++i){
//            if(isPrime(i)){
//                ++res;
//            }
//        }
//        return res;
//    }
//
//
//    boolean isPrime(int n){
//
//        for(int i=2;i*i<=n;++i){
//            if(n%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}