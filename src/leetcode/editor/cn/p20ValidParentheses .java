//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2426 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

//有效的括号
class p20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new p20ValidParentheses().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()) {
        if (c=='{'||c=='['||c=='('){
            stack.push(c);
        }else {
            if (stack.isEmpty()){
                return false;
            }
            //"]" 如果只有右括号 会报错 取出栈顶元素时要判断栈是否为空
            char topChar=stack.pop();
            if (c=='}'&&topChar!='{'){
                return false;
            }
            if (c==']'&&topChar!='['){
                return false;
            }
            if (c==')'&&topChar!='('){
                return false;
            }
        }
        }
        return stack.isEmpty(); //"["

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-05-29 00:18:53	
 */