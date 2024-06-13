package DP

import java.util.Collections.min
import kotlin.math.min

fun main(){
    println(mincostTickets(intArrayOf(1,4,6,7,8), intArrayOf(2,7,15)))
}

fun mincostTickets(days: IntArray, costs: IntArray): Int{

    data class TicketCosts(
        var oneDay: Int,
        var sevenDay: Int,
        var thirtyDay: Int,
        var optimal: Int = Int.MAX_VALUE
    )


    var dp = Array(days[days.size-1]+1) {TicketCosts(Int.MAX_VALUE-30, Int.MAX_VALUE-30, Int.MAX_VALUE-30)}
    dp[0] = TicketCosts(0,0,0, 0)
    for(i in 1..dp.size){ dp[i].oneDay = dp[i-1].oneDay + costs[0] }
    for(i in 1..dp.size){
                
    }
    for(i in 1..dp.size){

    }
    return dp[days.size-1].optimal
}