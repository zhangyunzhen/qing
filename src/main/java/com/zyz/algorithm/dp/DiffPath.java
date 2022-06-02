package com.zyz.algorithm.dp;

/**
 * This is Description
 *      不同路径
 *
 *         关键点在于状态变量初始化时，别写漏了
 *
 * @author yunzhen.zhang
 * @date 2022/05/01
 */
public class DiffPath {


    /**
     *
     *  二维数组从左上角到达右下角有多少条不同的路径？（只可以向下或者向右移动）
     *
     *  状态变量：
     *      dp[i][j] 代表到达坐标i行j列的路径和
     *
     *  状态方程：
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     *  初始变量：
     *      dp[0][1] = 1
     *      dp[1][0] = 1;
     *
     * @return
     */
    public int diffPath(int m, int n) {

        if (m < 0 || n < 0) return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    /**
     * 二维数组中有障碍（只可以向下或者向右移动）
     *
     *  解法：和上一个解法一样，只是当[i][j]为障碍物时，dp[i][j]为0，注意数组初始化的值
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            //一旦遇到障碍，后续都到不了
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            //一旦遇到障碍，后续都到不了
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

}
