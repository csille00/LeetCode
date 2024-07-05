package array_string

import kotlin.math.max
import kotlin.math.min

fun main(){
    println(intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)))
}

//fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
//    var nums1Pointer: Int = 0
//    var nums2Pointer: Int = 0
//    val maxLen = max(nums1.size, nums2.size)
//    val result = mutableListOf<Int>()
//    for(i in 0 until maxLen){
//        if(nums1[nums1Pointer] == nums2[nums2Pointer]) result.add(i)
//    }
//    return result.toIntArray()
//}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val nums1map = hashMapOf<Int, Int>()
    nums1.forEach{ num -> nums1map[num] = nums1map.getOrDefault(num, 0) +1 }
    val result = mutableListOf<Int>()
    for(num in nums2){
        if(nums1map.containsKey(num) && nums1map[num]!! > 0){
            result.add(num)
            nums1map[num] = nums1map[num]!! - 1
        }
    }

    return result.toIntArray()
}