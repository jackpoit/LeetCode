//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 1960 👎 0


package leetcode.editor.cn;
//Java：只出现一次的数字
public class p136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new p136SingleNumber().new Solution();
        //Test
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        //异或
        // 任何数和 0 做异或运算，结果仍然是原来的数
        //任何数和其自身做异或运算，结果是 0，
        //异或运算满足交换律和结合律
        int single=0;
        for (int num : nums) {
            single^=num;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-08-10 20:13:55
 */