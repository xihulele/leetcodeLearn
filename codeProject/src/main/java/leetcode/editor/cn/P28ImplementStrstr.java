//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 642 👎 0

package leetcode.editor.cn;
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();

        System.out.println(solution.strStr("",""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int strStr1(String haystack, String needle) {

        for(int i=0;i<haystack.length()-needle.length()+1;++i){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

        public int strStr(String haystack, String needle) {



            int len1=haystack.length();
            int len2=needle.length();
            if(len2==0){
                return 0;
            }
            for(int i=0;i<len1-len2+1;++i){
                int p1=i;
                if(haystack.charAt(p1)==needle.charAt(0)){
                    ++p1;
                    int p2=1;
                    while(p2<needle.length()&&haystack.charAt(p1)==needle.charAt(p2)){
                        ++p1;
                        ++p2;
                    }
                    if(p2==needle.length()){
                        return i;
                    }
                }
            }

            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}