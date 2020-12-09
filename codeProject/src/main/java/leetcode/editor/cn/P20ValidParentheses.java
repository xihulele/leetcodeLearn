//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2026 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 使用栈来操作，左括号入栈，右括号出栈
         * @param s
         * @return
         */
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Stack<Character> stack=new Stack();
        int len=s.length();
        int i=0;
        while(i<len){
           if(pairs.containsKey(s.charAt(i))){
               stack.push(s.charAt(i));
           }else{
               if(stack.isEmpty()){
                   return false;
               }
               Character pop = stack.pop();
               if(pairs.get(pop)!=s.charAt(i)){
                   return false;
               }
           }
           ++i;
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isPush(char c){
        if(c=='('||c=='{'||c=='['){
            return true;
        }else {
            return false;
        }
    }

        private boolean canCancel(char left, char right) {
            if (left == '(') {
                return right == ')';
            } else if (left == '{') {
                return right == '}';
            } else {
                return right == ']';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}