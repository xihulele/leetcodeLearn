//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 340 👎 0

package leetcode.editor.cn;
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome2(String s) {
        if(s==null){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        int len=s.length();
        int p1=0;
        int p2=len-1;
        while(p1<p2){
            while(p1<p2&&!Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while(p1<p2&&!Character.isLetterOrDigit(s.charAt(p2))){
                --p2;
            }
            if(p1<p2){
                if(Character.toLowerCase(s.charAt(p1))!=Character.toLowerCase(s.charAt(p2))){
                    return false;
                }
                ++p1;
                --p2;
            }
        }
        return true;
    }
        public boolean isPalindrome(String s) {
            if(s==null){
                return false;
            }
            if("".equals(s)){
                return true;
            }
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<s.length();++i){
                if(Character.isLetterOrDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                }
            }
            String sNew = sb.toString();
            int p1=0;
            int p2=sNew.length()-1;
            while(p1<p2){
                if(Character.toLowerCase(sNew.charAt(p1))!=Character.toLowerCase(sNew.charAt(p2))){
                    return false;
                }
                ++p1;
                --p2;
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}