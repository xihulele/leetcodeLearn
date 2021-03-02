//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 467 👎 0

package leetcode.editor.cn;
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-2147483648,	2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int divide(int dividend, int divisor) {
//
//        boolean resFlag=true;
//        if((dividend<0&&divisor<0)||(dividend>0&&divisor>0)){
//            resFlag=true;
//        }else {
//            resFlag=false;
//        }
//        if(dividend==Integer.MIN_VALUE){
//            if(divisor==1){
//                return Integer.MIN_VALUE;
//            }
//            if(divisor==-1){
//                return Integer.MAX_VALUE;
//            }
//
//        }
//        if(dividend<0){
//            dividend=0-dividend;
//        }
//        if(divisor<0){
//            divisor=0-divisor;
//        }
//        int div = div(dividend, divisor);
//        if(!resFlag){
//            div=0-div;
//        }
//        return div;
//    }
//
//    public int  div(int  dividend,int divisor){
//
//        if(dividend<divisor){
//            return 0;
//        }
//        if(divisor==1){
//            return dividend;
//        }
//        int count=1;
//        int tempDivisor=divisor;
//        while(tempDivisor+tempDivisor<dividend){
//            count=count+count;
//            tempDivisor=tempDivisor+tempDivisor;
//        }
//        dividend= (dividend-tempDivisor);
//        return count+div(dividend,divisor);
//    }


        public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            if(dividend>Integer.MIN_VALUE){
                return -dividend;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        long a=dividend;
        long b=divisor;
        int flag=1;
        if((a<0&&b>0)||(a>0&&b<0)){
            flag=-1;
        }
        a=a<0?-a:a;
        b=b<0?-b:b;
        int res=div(a,b);
        if(flag==-1){
            return -res;
        }
        return res;
        }

        public int div (long a,long b){
            if (a < b) {
                return 0;
            }
            long tb=b;
            int count=1;
            while(tb+tb<=a){
                count=count+count;
                tb=tb+tb;
            }
            return count +div(a-tb,b);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}