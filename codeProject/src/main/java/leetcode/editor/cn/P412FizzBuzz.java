//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 87 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.domain.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new P412FizzBuzz().new Solution();
        ListNode  node =new ListNode(){
            {set(123);}
            {setIn(456);
                System.out.println("内部类："+getIn());}
            public int in ;
            public void setIn(int  in){
                this.in=in;
            }
            public int  getIn(){
                return this.in;
            }
        };
//        System.out.println(node.get());
        System.out.println(node.get());

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz2(int n) {

        List<String> res=new ArrayList<>();


        for(int i=1;i<=n;++i){
            if(i%3==0&&i%5==0){
                res.add("FizzBuzz");
            }else if(i%3==0){
                res.add("Fizz");
            }else if(i%5==0){
                res.add("Buzz");
            }else {
                res.add(i+"");
            }
        }

        return res;
    }

    //2.活动映射表解法（规则容易变的情况下）

        public List<String> fizzBuzz(int n) {

        //通过匿名内部类初始化 map 最外层｛｝ 是匿名内部类的表达式，里面的｛｝是静态代码块
            Map<Integer,String> map=new HashMap<Integer,String>(){{
                put(3,"Fizz");
                put(5,"Buzz");
            }
            };
            List<String> list=new ArrayList<>();
            for(int i=1;i<=n;++i){
                String temp="";
                for(Map.Entry<Integer,String> entry:map.entrySet()){
                    if(i%(entry.getKey())==0){
                        temp=temp+entry.getValue();
                    }
                }
                if(temp==""){
                    temp=i+"";
                }
                list.add(temp);
            }
            return list;
        }



}
//leetcode submit region end(Prohibit modification and deletion)

}