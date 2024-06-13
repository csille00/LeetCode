package DP

import kotlin.math.max

fun main(){
    val sol = Solution()
    println(sol.findMaxForm(arrayOf("10","0001","111001","1","0"), 5, 3))
}

// i = 0
// j = 1

class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        // the dp array will contain every subproblem from 0,0 to m,n. Initialize all to 0 since it is a max problem
        val dp = Array(m+1) { Array(n+1) {0} }
        //iterate through each string
        for(str in strs){
            // get the count of ones and zeros in the string we are currently looking at
            val count0 = str.count { c: Char -> c == '0' }
            val count1 = str.count { c: Char -> c == '1' }
            // since we are using data from the immediately previous state, we need to start at the top (m, n)
            // and work our way down, so that when we update a number, we won't need the previous data.
            // this essentially helps us to enusre that we are only counting each substring once.
            for(i in m downTo count0){
                for(j in n downTo count1){
                    // get the max of what is already there from a previous iteration,
                    // or, consider if we took the string we are currently looking at into the subset (the +1). We would need to
                    // essentially see how many 1's and 0's we have left, and see how many are in THAT subset; hence i - count0 and j - count1.
                    dp[i][j] = max(dp[i][j], dp[i - count0][j - count1] + 1)
                }
            }
        }
        return dp[m][n]
    }
}