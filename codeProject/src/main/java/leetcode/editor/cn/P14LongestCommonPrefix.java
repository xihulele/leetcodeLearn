//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1369 👎 0

package leetcode.editor.cn;


public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs=new String[]{"flower","flow","flight"};
        String commonPrefix = solution.longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix2(String[] strs) {

        if(strs==null||strs.length==0){
            return "";
        }
        int len=strs.length;
        if(len==1){
            return strs[0];
        }
        String comPre = this.comPre(strs[0], strs[1]);
        if(len==2){
            return comPre;
        }
        for(int i=2;i< strs.length;++i){
            comPre= this.comPre(comPre, strs[i]);
            if("".equals(comPre)){
                return "";
            }
        }
        return comPre;
    }

    public String comPre(String s1,String s2){
        String comPre="";
        if(s1.equals(comPre)||s2.equals(comPre)){
            return comPre;
        }
        int len1=s1.length();
        int len2=s2.length();
        int i=0;
        int len=len1<len2?len1:len2;

        while(i<len){
            if(s1.charAt(i)==s2.charAt(i)){
                ++i;
            }else {
                break;
            }
        }
        comPre=s1.substring(0,i);
        return  comPre;
    }


        public String longestCommonPrefix(String[] strs) {

            if(strs==null||strs.length==0){
                return "";
            }
            int len=strs.length;
            if(len==1){
                return strs[0];
            }
            int len2=strs[0].length();
            int i=0;
            for(i=0;i<len2;++i){
                char c=strs[0].charAt(i);
                for(int j=1;j<len;++j){
                    if(i==strs[j].length()||c!=strs[j].charAt(i)){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return  strs[0];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}