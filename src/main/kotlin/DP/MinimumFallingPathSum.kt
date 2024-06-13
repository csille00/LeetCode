package DP

import kotlin.math.min

fun main(){
    println(minFallingPathSum(arrayOf(intArrayOf(2,1,3),intArrayOf(6,5,4),intArrayOf(7,8,9))))
}

fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val dp = Array(matrix.size) { IntArray(matrix[0].size) {Int.MAX_VALUE} }
        //init first row of dp to first row of matrix, since that you can never go up anyway
        for(i in matrix.indices)dp[0][i] = matrix[0][i]

        //loop through each element in the 2d array and find min sum to get to that point
        for(i in matrix.indices){
            for(j in matrix[0].indices){
                var diagonalLeft = Int.MAX_VALUE
                var down = Int.MAX_VALUE
                var diagonalRight = Int.MAX_VALUE
                if(j != 0 && i != matrix.size-1) diagonalLeft = matrix[i+1][j-1] + dp[i][j]
                if(i != matrix.size-1) down = matrix[i+1][j] + dp[i][j]
                if(j != matrix.size - 1 && i != matrix.size - 1) diagonalRight = matrix[i+1][j+1] + dp[i][j]
                //now that the three move costs are set, place them in the dp array
                if(j != 0 && i != matrix.size - 1) dp[i+1][j-1] = min(dp[i+1][j-1], diagonalLeft)
                if(i != matrix.size - 1) dp[i+1][j] = min(dp[i+1][j], down)
                if(j != matrix.size - 1 && i != matrix.size - 1) dp[i+1][j+1] = min(dp[i+1][j+1], diagonalRight)
            }
        }

        return dp[dp.size-1].min()
}