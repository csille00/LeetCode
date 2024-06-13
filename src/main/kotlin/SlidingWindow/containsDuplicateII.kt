package org.example.SlidingWindow

fun main(){
   println(containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 3))
}

//Given an integer array nums and an integer k, return true if there are two distinct
//indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    // can't have a duplicate if there is only one item
    if(nums.size <= 1) return false
    var left = 0
    // since we are looking for duplicates, we should use a set.
    var numsInWindow = mutableSetOf<Int>()
    for(right in nums.indices){
        // if we have already seen the soon to be added number, then it fits the criteria. return true.
        if(numsInWindow.contains(nums[right])) return true
        // else, add the number to the window
        numsInWindow.add(nums[right])
        // if the window is now too big, remove from the left side.
        if(right - left >= k){
            numsInWindow.remove(nums[left])
            left++
        }
    }
    return false
}