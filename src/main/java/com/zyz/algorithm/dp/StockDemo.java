package com.zyz.algorithm.dp;

/**
 * This is Description
 *
 *  股票问题
 *
 *      设置dp[i][n][k]变量,i为第几天，n是交易次数（买入的时候交易k次），k是否持有股票
 *
 *
 *    dp转换方程：
 *      如果没有持有股票：
 *          dp[i][n][k] = Math.max(dp[i-1][n-1][1] + price[i],dp[i-1][n-1][0])
 *      如果持有股票：
 *          dp[i][n][k] = Math.max(dp[i-1][n-1][0] - price[i],dp[i-1][n-1][k])
 *
 *
 *
 *
 * @author yunzhen.zhang
 * @date 2022/04/30
 */
public class StockDemo {

    /**
     * 买卖股票的最佳时机
     *     解法1：
     *      贪心算法：股票收益最大 = 股票最高点-股票最低点
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // 定义一个历史最低值min和最大利润变量，遍历数组
        int min = Integer.MAX_VALUE;
        int diff = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            diff = Math.max(diff, prices[i] - min);
        }

        return diff;
    }

    /**
     * 买卖股票的最佳时机
     *  解法2：
     *      状态定义：
     *          dp[i][k]: 代表最大收益。 i代表第几个交易日，k：0代表不持有股票，k:1表示持有股票
     *      状态方程：
     *          持有股票：(今天买入 or 今天之前买入)
     *              dp[i][1] = max(dp[i-1][1], - price[i])
     *          不持有股票：(今天之前卖出 or 今天卖出)
     *              dp[i][0] = max(dp[i-1][1]+price[i],dp[i-1][0])
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];

        // 初始化
        dp[0][1] = -prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);  //注意这里持有股票是的收益
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        }

        return dp[dp.length - 1][0];
    }


    /**
     * 股票的最大利润（连续买连续卖）
     *
     *  状态方程：
     *      dp[i] = dp[i-1] + Math.max(0,price[i]-price[i-1])
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diffPrice = prices[i] - prices[i - 1];
            if (diffPrice > 0) profit += diffPrice;
        }
        return profit;
    }


    /**
     * 买卖股票的最佳时机II  (可以连续买连续卖)
     *  解法2：
     *      状态定义：
     *          dp[i][k]: 代表最大收益。 i代表第几个交易日，k：0代表不持有股票，k:1表示持有股票
     *      状态方程：
     *          持有股票：(今天买入 or 今天之前买入)
     *              dp[i][1] = max(dp[i-1][1], dp[i-1][0]- price[i])
     *          不持有股票：(今天之前卖出 or 今天卖出)
     *              dp[i][0] = max(dp[i-1][1]+price[i],dp[i-1][0])
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];

        // 初始化
        dp[0][1] = -prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            //注意这里和上一题的区别
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        }

        return dp[dp.length - 1][0];
    }

    /**
     * 买卖股票的最佳时机III(最多可以进行两笔交易)
     *
     *      状态定义：
     *          dp[i][s] 代表第i天s状态下的最大收益
     *          s状态：0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
     *      状态方程：
     *           dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
     *           dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
     *           dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
     *           dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
     *
     * @return
     */
    public int maxProfit5(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;


        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];


        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[len - 1][4];
    }


    /**
     * 188. 买卖股票的最佳时机 IV（可以交易k次）
     *      状态变量：
     *          dp[i][n][k] :代表第i天的最大收益
     *          i代表第几天，n代表第几次交易，k代表是否持有股票
     *      状态方程：
     *          不持有股票：
     *              dp[i][n][k] = max(dp[i-1][n][0],dp[i-1][n-1][0] + prices[i])
     *
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit6(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][交易次数][是否持有股票]
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }


        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有/买入
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    /**
     * 309.最佳买卖股票时机含冷冻期（卖出股票后隔一天才能买入股票）
     *
     * @param prices
     * @return
     */
    public int maxProfit7(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     *  状态变量：
     *      dp[i][k]:代表第i天的股票最大收益
     *      i代表第几天，k代表是否持有股票.0:不持有，1：持有
     *  状态方程：
     *      dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]-2)
     *      dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     *
     *  初始变量：
     *      dp[0][0] = 0;
     *      dp[0][1] = -prices[0];
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {


        if (prices == null || prices.length == 0) return -1;

        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 注意返回值的判断（因为有手续费的作用，所以两者之间是可能有差异的)
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }




}
