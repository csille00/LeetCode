package DP

import kotlin.math.min

fun main(){
    println(minimumTotal(listOf(listOf(2), listOf(3,4), listOf(6,5,7), listOf(4,1,8,3))))
}

fun minimumTotal(triangle: List<List<Int>>): Int{
        //This just worked in my brain pretty well when I did it reversed (since I was doing a bottom up approach)
        val triangleCopy = triangle.reversed()
        val dp = mutableListOf<MutableList<Int>>()
        //Since we are doing a minimum target, initialize everything in dp to Int.MAX_VALUE
        for(layer in triangleCopy) dp.add(MutableList(layer.size) {Int.MAX_VALUE})
        //initialize the bottom row of dp to the same as the bottom row, since that cannot change (you have to take the bottom row to get to the bottom)
        for(i in triangleCopy[0].indices) dp[0][i] = triangleCopy[0][i]

        //iterate through each number in the triangle
        for(i in triangleCopy.indices){
            for(j in triangleCopy[i].indices){
                //you can do triangle[i+1][j], and you can do triangle[i+1][j-1]. each one has a conditional.
                //if j = 0, then the upper layer will not have a -1
                //if j = triangle[i].size-1, then the upper layer will not have a [j] (only a j-1)
                val straightUp = if(j != triangleCopy[i].size-1) dp[i][j] + triangleCopy[i+1][j] else Int.MAX_VALUE
                val upLeft = if(j != 0) dp[i][j] + triangleCopy[i+1][j-1] else Int.MAX_VALUE
                if(j != triangleCopy[i].size-1) dp[i+1][j] = min(dp[i+1][j], straightUp)
                if(j != 0) dp[i+1][j-1] = min(dp[i+1][j-1], upLeft)
            }
        }

        //return the tip of the reversed triangle
        return dp[dp.size-1][0]
}