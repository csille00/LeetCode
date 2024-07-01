package BinarySearch

fun main(){
    println(searchInsert(intArrayOf(1,3,5,6), 7))
}

fun searchInsert(nums: IntArray, target: Int): Int{
    var left = 0
    var right = nums.size
    while(left < right){
        val mid = left + (right - left) / 2
        if(nums[mid] == target){
            return mid
        } else if(nums[mid] > target){
            right = mid
        } else if (nums[mid] < target){
            left = mid + 1
        }
    }
    return left
}