//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 354 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // 排序方法
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        String s1=new String(sChars);
        String s2=new String(tChars);
        if(s1.equals(s2)){
            return true;
        }
        return false;

    }

        // 数组当作hash表
        public boolean isAnagram2(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }
        int[] table=new int[26];
        for(int i=0;i<s.length();++i){
            table[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();++i){
            table[t.charAt(i)-'a']--;
            if(table[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
        }
        // hash表
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> table = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                Integer count = table.getOrDefault(s.charAt(i), 0);
                ++count;
                table.put(s.charAt(i), count);
            }
            for (int i=0;i<t.length();++i){
                Integer count = table.getOrDefault(t.charAt(i), 0);
                --count;
                if(count<0){
                    return false;
                }
                table.put(t.charAt(i),count);
            }
                return true;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}