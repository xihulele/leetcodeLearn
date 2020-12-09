//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1026 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *   回溯法思路的简单描述是：把问题的解空间转化成了图或者树的结构表示，
     *   然后使用深度优先搜索策略进行遍历，遍历的过程中记录和寻找所有可行解或者最优解。
     *
     *   回溯法类似于图的深度搜索
     */
    class Solution {
    public List<String> letterCombinations(String digits) {


        if(digits==null||digits.length()==0){
            return new ArrayList<String>();
        }

        Map<Character,String> phoneMap=new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        int index=0;
        StringBuffer stringBuffer=new StringBuffer();
        List<String> res=new ArrayList<String>();
        this.subLetterCombinations(phoneMap,digits,index,stringBuffer,res);
        return res;

    }


    public void subLetterCombinations(Map<Character,String> phoneMap,String digits,int index,StringBuffer stringBuffer,List<String> result){
        if(index==digits.length()){
            result.add(stringBuffer.toString());
            return;
        }
        String phoneStr = phoneMap.get(digits.charAt(index));
        int len = phoneStr.length();
        for(int i=0;i<len;++i){
            stringBuffer.append(phoneStr.charAt(i));
            subLetterCombinations(phoneMap,digits,index+1,stringBuffer,result);
            stringBuffer.deleteCharAt(index);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}