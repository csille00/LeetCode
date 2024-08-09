package TwoPointers

fun main(){
    println(twoSum(intArrayOf(3,2,4), 6))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1
    while(left < right){
        val sum = nums[left] + nums[right]
        val leftSmaller = nums[left] < nums[right]
        if(sum > target) {
            if(leftSmaller) right -- else left ++
        }
        else if(sum < target){
            if(leftSmaller) left ++ else right --
        }
        else break
    }
    return intArrayOf(left, right)
}