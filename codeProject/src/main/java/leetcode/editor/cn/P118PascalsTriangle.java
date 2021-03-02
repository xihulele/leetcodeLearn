//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 457 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>  last=new ArrayList<>();
        last.add(1);
        res.add(last);
        if(numRows==1){
            return res;
        }
        for(int i=2;i<=numRows;++i){
            List<Integer> curList=new ArrayList<>();
            curList.add(1);
            for(int j=1;j<i-1;++j){
                curList.add(last.get(j-1)+last.get(j));
            }
            curList.add(1);
            res.add(curList);
            last=curList;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}