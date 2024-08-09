package array_string

fun main(){
    removeDuplicates(intArrayOf(1,1,1,2,2,3))
}

fun removeDuplicates(nums: IntArray): Int {
    var left = 0
    var counter = 1
    for(right in 1 until nums.size){
        if(nums[right] == nums[right - 1]) counter ++
        if(counter > 2){
            val temp = nums[right]
            val test = nums.filterIndexed { i, _ -> i != right }.toIntArray()
            println("hi")
        }
    }
    return nums.size
}