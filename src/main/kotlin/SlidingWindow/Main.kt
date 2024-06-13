package org.example.SlidingWindow


fun main(){
    print(minSubArray2(7, intArrayOf(2,3,1,2,4,3)));
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    if(nums[nums.size - 1] >= target) return 1
    var windowStart = 0
    var windowEnd = 0
    var minSize = Int.MAX_VALUE
    var sum = nums[0]
    while (!(windowEnd == nums.count() - 1 && windowStart == nums.count() - 1)) {
        if (sum >= target) {
            if (windowEnd - windowStart + 1 < minSize){
                minSize = windowEnd - windowStart + 1
            }
            sum -= nums[windowStart]
            windowStart++

        } else if (sum < target) {
            windowEnd++
            if (windowEnd < nums.size){
                sum += nums[windowEnd]
            } else {
                break
            }
        }
    }
    return if(minSize == Int.MAX_VALUE) 0 else minSize
}

fun minSubArray2(target: Int, nums: IntArray): Int{
    var left = 0
    var right = 0
    var sum = 0
    var result = Int.MAX_VALUE
    while (right in nums.indices) {
        sum += nums[right++]

        while (left < right && sum >= target) {
            result = minOf(result, right - left)
            sum -= nums[left++]
        }
    }

    return if (result == Int.MAX_VALUE) 0 else result

}



//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

