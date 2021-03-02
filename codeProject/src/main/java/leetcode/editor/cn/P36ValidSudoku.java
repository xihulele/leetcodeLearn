//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 456 👎 0

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;

public class P36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku2(char[][] board) {
        HashSet<Character> set1=new HashSet<Character>();
        HashSet<Character> set2=new HashSet<Character>();
        HashSet<Character> set3=new HashSet<Character>();
        int size=board.length;
        for(int i=0;i<size;++i){
            for(int j=0;j<size;++j){
                if(board[i][j]!='.'){
                    if(set1.contains(board[i][j])){
                        return false;
                    }else {
                        set1.add(board[i][j]);
                    }
                }
                if(board[j][i]!='.'){
                    if(set2.contains(board[j][i])){
                        return false;
                    }else {
                        set2.add(board[j][i]);
                    }
                }
            }
            set1.clear();
            set2.clear();
        }
        for(int i=0;i< size;i=i+3){
            for(int j=0;j<size;j=j+3){
                for(int m=0;m<3;++m){
                    for(int n=0;n<3;++n){
                        if(board[i+m][j+n]!='.'){
                            if(set3.contains(board[i+m][j+n])){
                                return false;
                            }else {
                                set3.add(board[i+m][j+n]);
                            }
                        }
                    }
                }
                set3.clear();
            }
        }
        return true;
    }

        public boolean isValidSudoku(char[][] board) {

            int size = board.length;
            HashMap<Integer, Integer>[] rows = new HashMap[size];
            HashMap<Integer, Integer>[] columns = new HashMap[size];
            HashMap<Integer, Integer>[] boxes = new HashMap[size];

            for(int i=0;i<size;++i){
                rows[i]=new HashMap<Integer, Integer>();
                columns[i]=new HashMap<Integer, Integer>();
                boxes[i]=new HashMap<Integer, Integer>();
            }

            for(int i=0;i<size;++i){
                for(int j=0;j<size;++j){
                    int  num=board[i][j];
                    if(num!='.'){
                        //9个盒子坐标确定
                        int boxIndex=(i/3)*3+j/3;
                        rows[i].put(num, rows[i].getOrDefault(num,0)+1);
                        columns[j].put(num, columns[j].getOrDefault(num,0)+1);
                        boxes[boxIndex].put(num,boxes[boxIndex].getOrDefault(num,0)+1);
                        if(rows[i].get(num)>1||columns[j].get(num)>1||boxes[boxIndex].get(num)>1){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}