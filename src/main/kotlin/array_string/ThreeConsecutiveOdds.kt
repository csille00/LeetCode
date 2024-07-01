package array_string

fun main(){
    println(threeConsecutiveOdds(intArrayOf(1,2,3,4,5,7,9,)))
}

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    for(i in 0 until arr.size - 2){
        //cool use of Kotlin's all function. I did not really know that you could do that in kotlin.
        if(arr.sliceArray(i..i+2).all {it % 2 == 1}){
            return true
        }
    }
    return false
}