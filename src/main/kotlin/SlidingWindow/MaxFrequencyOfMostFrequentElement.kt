package org.example.SlidingWindow

import kotlin.math.max

fun main(){
    println(maxFrequency(intArrayOf(1,2,4), 5))
}

fun maxFrequency(nums: IntArray, k: Int): Int {
    var right = 0
    var left = 0
    var ans = 1
    var sum = 0
    while(right < nums.size){
        sum += nums[right]
        while((right - left + 1) * nums[right] - sum > k) sum-=nums[left++]
        ans = max(right - left + 1, ans)
        right++
    }
    return ans
}