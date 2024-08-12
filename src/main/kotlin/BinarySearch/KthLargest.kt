package BinarySearch

import java.util.*


fun main(){
    val obj = KthLargest(3, intArrayOf(4,5,8,2))
    println(obj.add(3))
    println(obj.add(5))
    println(obj.add(10))
    println(obj.add(9))
    println(obj.add(4))
}

//class KthLargest(private val k: Int, private var nums: IntArray) {
//
//    fun add(`val`: Int): Int {
//        nums.sort()
//
//        fun findIndex(num: Int, start: Int, end: Int): Int {
//            if(start >= end) return start
//            val mid = (start + end) / 2
//            return when {
//                num <= nums[mid] -> findIndex(num, start, mid)
//                else -> findIndex(num, mid + 1, end)
//            }
//        }
//
//        val tempNums = nums.toMutableList()
//        val foo = findIndex(`val`, 0, nums.size)
//        tempNums.add(foo, `val`)
//        nums = tempNums.toIntArray()
//        return nums[nums.size - k]
//    }
//
//}

internal class KthLargest(private val k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>(k)

    init {
        for (num in nums) {
            if (minHeap.size < k) {
                minHeap.offer(num)
            } else if (num > minHeap.peek()) {
                minHeap.offer(num)
                if (minHeap.size > k) {
                    minHeap.poll()
                }
            }
        }
    }

    fun add(`val`: Int): Int {
        if (minHeap.size < k) {
            minHeap.offer(`val`)
        } else if (`val` > minHeap.peek()) {
            minHeap.offer(`val`)
            minHeap.poll()
        }
        return minHeap.peek()
    }
}