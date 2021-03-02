//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1138 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private boolean[] flags;
        private List<List<Integer>> res;
        private List<Integer> path;
    public List<List<Integer>> permute(int[] nums) {

        int n=nums.length;
        res=new ArrayList<>();
        if(n==0){
            return res;
        }
        flags=new boolean[n];
        int level=0;
        path=new ArrayList<>();
        dfs(level,n,nums,path);
        return res;
    }

    public void dfs(int level,int n,int[] nums,List<Integer> path){
        if(level==n){
            res.add(new ArrayList<>(path));
        }
        for(int i=0;i<n;++i){
            if(!flags[i]){
                flags[i]=true;
                path.add(nums[i]);
                dfs(level+1,n,nums,path);
                flags[i]=false;
                path.remove(path.size()-1);
            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}