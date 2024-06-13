package org.example.SlidingWindow

import kotlin.math.min

fun main(){
    println(minSubArray3(7, intArrayOf(2,3,1,2,4,3)))
}

fun minSubArray(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE
    var start = 0
    var end = 0
    var sum = nums[0]
    for(i in nums.indices){
        sum += nums[start++]
        while(sum >= target && end < start){
            result = minOf(result, start - end)
            sum -= nums[end++]
        }
    }
    return start - end
}

fun minSubArray3(target: Int, nums: IntArray): Int {
    var left = 0
    var sum = 0
    var ans = Int.MAX_VALUE
    for(right in nums.indices){
        sum += nums[right]
        while(sum >= target){
            ans = min(ans, right - left + 1)
            sum -= nums[left]
            left ++
        }

    }
    return ans
}
