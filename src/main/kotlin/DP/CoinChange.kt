package DP

import kotlin.math.min

fun main(){
    println(coinChange(intArrayOf(2,5,10,1), 27))
}

fun coinChange(coins: IntArray, amount: Int): Int {
        //initialize every item except 0 in the list to an impossible amount of coins (amount+1 coins)
        //this is so that you can know if it is possible to make this number (or the number before it
        val dp = List(amount+1) {amount+1}.toMutableList()
        //there are 0 ways to make the number 0
        dp[0] = 0
        //the idea of the dp array is basically a memoization thing so that you can make each number from 0 to amount as you go
        // with the bigger amounts being easy to compute because they are just smaller sub problems
        for(i in 1..amount){
            //while filling each number in the dp array, try every available coin to make this number
            for(coin in coins){
                //if the coin is greater than the amount we are making, skip
                if(coin <= i){
                    // Once at this point, there are two options: either we can do better than impossible (or a previous
                    // inner loop iteration's attempt), or we cannot, so we either leave it as is, or we "add" this coin
                    // (the "+1" in the dp[i-coin] + 1) and see how many coins it was to create the amount we are looking
                    // at minus the coin value we are currently considering
                    dp[i] = min(dp[i], dp[i - coin] + 1)
                }
            }
        }
        return if(dp[amount] == amount+1) -1 else dp[amount]
}