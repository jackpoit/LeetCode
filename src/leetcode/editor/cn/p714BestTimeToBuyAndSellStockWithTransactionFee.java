//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划 
// 👍 489 👎 0


package leetcode.editor.cn;
//Java：买卖股票的最佳时机含手续费
public class p714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new p714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int max_profit=0;
       int buy=prices[0]+fee;//买入状态时 之前的最低价
       for (int i=1;i<prices.length;i++){
           if (prices[i]+fee<buy){
               buy=prices[i]+fee;
               //先看买不买
               //如果第i天 price+fee<之前的最低价 那我为什么不在第i天再买
               // 所以 buy=prices[i]+fee
           }else if (prices[i]>buy){
                max_profit+=prices[i]-buy;
                buy=prices[i];
                //如果不买 我就看要不要卖
               //如果price[i]>buy 那我就买了  获得利润
               //但是要是后一天涨了 提供一个反悔的操作
               //因为我买了 手里就没股票 但是如果第二天我后悔了
               //那我希望今天最后手里还有股票，那就假装自己没卖；但是利润还是要
               //就相当我卖出的时候 不用fee买入了一个今天价格的股票
           }
       }
       return max_profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
/*
 *@jackpoit
 *@date 2021-06-02 09:13:32
 */