package SlidingWindow

import kotlin.math.max
import kotlin.math.min

fun main(){
    println(longestSubarray(intArrayOf(10,1,2,4,7,2), 5))
}

fun longestSubarray(nums: IntArray, limit: Int): Int {
        var left = 0
        var maxSize = 0
        var maxInWindow = nums[0]
        var minInWindow = nums[0]
        for(right in nums.indices){
            maxInWindow = max(maxInWindow, nums[right])
            minInWindow = min(minInWindow, nums[right])
            var diff = maxInWindow - minInWindow
            while(diff > limit && left < right){
                if(nums[left] == maxInWindow){
                    maxInWindow = 0
                    for(i in left+1..right) maxInWindow = max(maxInWindow, nums[i])
                }
                if(nums[left] == minInWindow) {
                    minInWindow = Int.MAX_VALUE
                    for(i in left+1..right) minInWindow = min(minInWindow, nums[i])
                }
                diff = maxInWindow - minInWindow
                left++
            }
            maxSize = max(maxSize, right - left+1)
        }
        return maxSize
}

internal class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var best = 1

        for (i in nums.indices) {
            var high = nums[i]
            var low = nums[i]
            var r = i

            while (high - low <= limit) {
                r++
                if (r - i > best) best = r - i
                if (r >= nums.size) break
                if (nums[r] > high) high = nums[r]
                if (nums[r] < low) low = nums[r]
            }
        }
        return best
    }
}