package DP

import kotlin.math.min

fun main(){
    println(minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
}

fun minCostClimbingStairs(cost: IntArray): Int {
    // initialize base cases (0,1)
    val dp = mutableListOf(cost[0])
    if(cost.size == 1) return dp[0]
    dp.add(cost[1])
    // loop through stairs from 2 til size (since base cases are 0, 1)
    for(i in 2 until cost.size+1){
        val cost1 = dp[i-1]
        val cost2 = dp[i-2]
        //cost of next taken stair is the cheaper of the two stairs before it, plus the cost of the stair you are on (unless its the top)
       dp.add(min(cost1, cost2) + if(i == cost.size) 0 else cost[i])
    }
    return dp[dp.size - 1]
}