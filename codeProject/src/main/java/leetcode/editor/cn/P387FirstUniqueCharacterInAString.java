//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 359 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class P387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {


        HashMap<Character,Integer>  table=new HashMap();
        for(int i=0;i<s.length();++i){
            int count=table.getOrDefault(s.charAt(i),0);
            count++;
            table.put(s.charAt(i),count);
        }

        for(int i=0;i<s.length();++i){
            int count=table.getOrDefault(s.charAt(i),0);
            if(count==1){
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}