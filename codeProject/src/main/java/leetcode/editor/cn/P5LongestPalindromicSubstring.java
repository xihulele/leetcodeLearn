//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2945 👎 0
/**
 * 求一个字符串s(n)的最长回文串的状态转移方程是
 * p(i,j)=p(i+i,j-1)^s[i]==s[j] n>=2
 * p(i,i)=true  n=1
 * p(i,i+1)=s[i]==s[i+1] n=2
 */
package leetcode.editor.cn;
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        String ans="";
        for(int l=0;l<n;++l){
            for(int i=0;i+l<n;++i){
                int j=i+l;
                if(l==0){
                    dp[i][j]=true;
                }else if (l==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
                if(dp[i][j]&&l+1>ans.length()){
                    ans=s.substring(i,j+1);
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}