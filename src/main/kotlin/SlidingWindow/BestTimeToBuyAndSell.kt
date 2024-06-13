package org.example.SlidingWindow

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
}

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

fun maxProfit(prices: IntArray): Int {
    // initialize minPrice and maxProfit. Since it is a maximization problem, maxProfit starts at 0
    var minPrice = prices[0]
    var maxProfit = 0
    // loop through each price from i to size (skip 0 since it was already initialized
    for(i in 1 until prices.size){
        var curPrice = prices[i]
        //if the price we are currently looking at is smaller than the smallest price we've seen, then we want to start looking at that one
        if(curPrice < minPrice){
            minPrice = curPrice
        } else {
            // essentially, we take the smallest price that we have seen so far, and take the profit based on the
            // curPrice. Then calculate the max profit as we go.
            var profit = curPrice - minPrice
            if(profit > maxProfit){
                maxProfit = profit
            }
        }
    }
    return maxProfit
}
