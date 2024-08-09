package array_string

fun main(){
    val result = intersection2(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))
    result.forEach { print("$it, ") }
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray = nums2.intersect(nums1.toSet()).toIntArray()

fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {

    fun merge(left: IntArray, right: IntArray): IntArray {
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()
        while(i < left.size && j < right.size){
            if(left[i] < right[j]){
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }
        }
        while(i < left.size){
            result.add(left[i])
            i++
        }
        while(j < right.size){
            result.add(right[j])
            j++
        }
        return result.toIntArray()
    }

    fun mergeSort(nums: IntArray): IntArray {
        if(nums.size > 1){
            val mid = (nums.size)/2
            val left = mergeSort(nums.sliceArray(IntRange(0, mid)))
            val right = mergeSort(nums.sliceArray(IntRange(mid+1, nums.size)))
            return merge(left, right)
        }
        return nums
    }

    val nums1Sorted = mergeSort(nums1)
    val nums2Sorted = mergeSort(nums2)

    return nums2Sorted

}