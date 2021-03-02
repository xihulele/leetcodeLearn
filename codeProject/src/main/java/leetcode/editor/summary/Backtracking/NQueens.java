package leetcode.editor.summary.Backtracking;


import java.util.*;

/**
 * 回溯法解决n个皇后问题
 * 从第一行到N行，不断尝试皇后的列的位置，如果该行都不能摆放,则回溯到上行，更换上行皇后的列的位置。
 * https://leetcode-cn.com/problems/n-queens/solution/
 */
public class NQueens {

    public static void main(String[] args){
        Solution solution=new Solution();

        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists.toString());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
     public static class Solution {


        private Set<Integer> col;
        private Set<Integer> main;
        private Set<Integer> sub;

        public List<List<String>> solveNQueens(int n) {

            Deque<Integer> path = new ArrayDeque<>();
            List<List<String>> res =new ArrayList<>();
            if(n==0){
                return res;
            }
            col=new HashSet<>();
            main=new HashSet<>();
            sub=new HashSet<>();
            int row=0;
            dfs(row,n,path,res);
            return res;
        }

        public void dfs(int row ,int n, Deque<Integer> path,List<List<String>> res){
            if(row==n){
                res.add(convert2board(path,n));
                return;
            }
            for(int j=0;j<n;++j){
                if(!col.contains(j)&&!main.contains(row-j)&&!sub.contains(j+row)){
                    path.addLast(j);
                    col.add(j);
                    main.add(row-j);
                    sub.add(j+row);

                    dfs(row+1,n,path,res);

                    col.remove(j);
                    main.remove(row-j);
                    sub.remove(j+row);

                    path.removeLast();
                }
            }
        }

        private List<String> convert2board(Deque<Integer> path,int n) {
            List<String> board = new ArrayList<>();
            for (Integer num : path) {
                StringBuilder row = new StringBuilder();
                for(int i=0;i<n;++i){
                    row.append(".");
                }
                row.replace(num, num + 1, "Q");
                board.add(row.toString());
            }
            return board;
        }

    }
}
