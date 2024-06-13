package DP

import kotlin.math.min

fun main(){
    println(minPathSum(arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6)/*,intArrayOf(4,2,1)*/)))
}

fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[0].size) }
        dp[0][0] = grid[0][0]

        for(i in 1 until grid.size){
            dp[i][0] = dp[i-1][0] + grid[i][0]
        }
        for(j in 1 until grid[0].size){
            dp[0][j] = dp[0][j-1] + grid[0][j]
        }

        val m = grid.size
        val n = grid[0].size
        for(i in 1 until m){
            for(j in 1 until n){
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
            }
        }
        return dp[m-1][n-1]

}