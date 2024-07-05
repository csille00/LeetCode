package array_string

fun main(){
    println(minDifference(intArrayOf(6,6,0,1,1,4,6)))
}

//The minimum difference possible is obtained by removing three elements between the three smallest and three largest values in the array.
//0,1,1,4,6,6,6

fun minDifference(nums: IntArray): Int {
    if(nums.size <= 4) return 0
    var movesRemaining = 3
    nums.sort()
    return 0

}