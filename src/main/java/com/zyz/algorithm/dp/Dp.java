package com.zyz.algorithm.dp;


/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/08/02
 */
public class Dp {


    /**
     * 走台阶（一次能走一个台阶或者两个台阶）
     * <p>
     * 转换方程：dp[i] = dp[i-1] + dp[i-2]
     *
     * @param n
     * @return
     */
    public int numWays(int n) {

        if (n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }


    /**
     * 剑指 Offer 14- I. 剪绳子  (剪成一段段，算乘积)
     * 动态规划
     * 思路：一个个从前往后算
     *  核心思想是长度为n的最大乘积为：max(dp[n],i*j,i*dp[j])
     *   https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-14-i-jian-sheng-zi-huan-s-xopj/
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[2] = 1;

        // 一个个的算
        for (int i = 3; i < dp.length; i++) {
            for (int j = 2; j < i; j++) {
                // 剪j段，剩下i-j段可剪
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


    /**
     * 剑指 Offer 10- I. 斐波那契数列
     *
     *  dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    /**
     * 剑指 Offer 60. n个骰子的点数
     * 转换变量： dp[n][j]   n代表几个骰子，j代表每个出现的点数，dp[n][j]代表每个点数出现的次数
     * 转换方程：
     * for(int i=1;i++;i<=6){
     * dp[n][j] += dp[n-1][j-i]
     * }
     * <p>
     * 边界：
     * 点数总个数：n*6
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur <= 0) {
                        continue;
                    }
                    dp[i][j] += dp[i - 1][j - cur];
                }
            }

        }

        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
        }
        return ans;
    }


    /**
     * 剑指 Offer 49. 丑数
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 定义状态变量：dp[n] n是第几个丑数，dp[n]代表第n个丑数对应的值
     * 状态方程：dp[n] = min(dp[a]*2,dp[b]*3,dp[c]*5)   a,b,c代表3个丑数
     * <p>
     * <p>
     * 丑数递推性质： 丑数只包含因子 2, 3, 5 ，因此有 ！！！！！！！“丑数 == 某一个较小丑数 × 某因子”！！！！！！！
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;

        // 定义三个指针
        int a = 1, b = 1, c = 1;

        for (int i = 2; i <= n; i++) {
            int select = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
            dp[i] = select;

            if (select == dp[a] * 2) ++a;
            if (select == dp[b] * 3) ++b;
            if (select == dp[c] * 5) ++c;
        }

        return dp[n];
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值 or 棋盘最短路径
     * <p>
     * 状态变量：dp[i][j] i代表行，j代表列,dp[i][j]代表第i行第j列最大价值
     * 状态转换方程：dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+dp[i][j]
     * <p>
     * 解法：
     * 画网格
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        // 初始化第一行和第一列
        for (int i = 1; i < n; i++) grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];

        // 依次遍历网格，赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 96.不同的二叉搜索树
     *
     *  状态变量定义：
     *      dp[i] ： 1到i为节点组成的二叉搜索树的个数为dp[i]。
     *  状态方程：
     *      dp[i] += dp[j - 1] * dp[i - j]; ，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
     *
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 剑指 Offer 63. 股票的最大利润（数组中的最大差值）
     * <p>
     * 状态定义：dp[i] i 代表数组长度，dp[i] 代表数组长度为i时的股票最大利润
     * 状态方程：dp[i] = Math.max(dp[i-1],i-min(0..i-1))
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }


    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 连续子数组的最大和
     *     定义两个变量，sum是记录前一个连续子数组的最大和，max是 连续子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 比较一下前面sum的和
            sum = Math.max(sum, 0);
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }


    /**
     * 把数字翻译成字符串
     *
     *      状态定义：dp[i]:就等于长度为i的数字转换成字符串的最大数量
     *      转换方程：
     *          如果当前数字和前一个数字不能组成一个字符，则：
     *                  dp[i] = dp[i-1]
     *          如果当前数字和前一个数字可以组成一个字符，则
     *                  dp[i] = dp[i-1] +dp[i-2]
     *      初始值：
     *          dp[0]=1;  //这个要找case想一想
     *          dp[1]=1;
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);

        // 定义初始变量
        int[] dp = new int[str.length() + 1];
        // dp[0]为无数字,注意dp[0]的取值
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= str.length(); i++) {
            // 注意怎么获取元素
            Integer integer = Integer.valueOf(str.substring(i - 2, i));
            if (integer > 25 || integer < 10) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[dp.length - 1];
    }


    public static void main(String[] args) {

        String aa = "yunzhenzhang";
        System.out.println(aa.substring(1, 2));
    }
}
