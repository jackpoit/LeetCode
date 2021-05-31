 //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1647 👎 0


package leetcode.editor.cn;
//Java：买卖股票的最佳时机
public class p121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new p121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max_profit=0;
        for (int i=0;i<prices.length;i++){
            if (prices[i] < min) {
                min=prices[i];
            }else if (prices[i]-min>max_profit){
                max_profit=prices[i]-min;
            }
        }
        return max_profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    // 之所以用else if 是因为如果当前的数小于之前所有的最小值
    // 他这天就不可能卖出股票，因为价格比之前所有都低
    //只需要遍历一次，
    // 每次比较，先求出之前的最小值，只需当前值与最小值比较
    // 在把当前数与前面最小值的差值与最大利润比较 若大于最大利润则变成最大值
}
/*
 *@jackpoit
 *@date 2021-05-31 11:08:16
 */