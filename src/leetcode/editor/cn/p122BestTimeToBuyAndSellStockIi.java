//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics 贪心算法 数组 
// 👍 1231 👎 0


package leetcode.editor.cn;
//Java：买卖股票的最佳时机 II
public class p122BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new p122BestTimeToBuyAndSellStockIi().new Solution();
        int[] prices={7,6,5,4,3,2};
        System.out.println(solution.maxProfit(prices));
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int[][] dp=new int[n][2];
       dp[0][0]=0;  //表示利润最大值
       dp[0][1]=-prices[0];// 持有股票 买了当天的 自己的钱肯定少了（初始自己0元）
        for (int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第i天不持有股票 有2个来源：
            // 1：前一天也不持有 今天不动 2：前一天持有 今天卖了（卖了 就+prices[i])
            dp[i][1]=Math.max(dp[i-1][1],dp[i][0]-prices[i]);
            //第i天持有股票 同样：
            // 1：前一天持有 今天不动  2:前一天不持有 今天买了
        }
        return dp[n-1][0];
        //最后一天 不持有股票肯定比持有钱多
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    //对于每一天，如果后一天价格高于前一天：不卖  买
    // 如果后一天价格低于前一天 卖  不买

    //状态转移
    //dp[][0] dp[][1]  0表示卖出状态（不持有股票） 1表示买入状态（持有股票）


}
/*
 *@jackpoit
 *@date 2021-05-31 17:30:23
 */