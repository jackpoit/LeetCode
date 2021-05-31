//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你能不使用循环或者递归来完成本题吗？ 
// 
// Related Topics 位运算 
// 👍 236 👎 0


package leetcode.editor.cn;
//Java：4的幂
public class p342PowerOfFour{
    public static void main(String[] args) {
        Solution solution = new p342PowerOfFour().new Solution();
        // TO TEST
        System.out.println(solution.isPowerOfFour(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfFour(int n) {
       return n>0&&((n&(n-1))==0)&&(n%3==1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-05-31 20:03:47
 */