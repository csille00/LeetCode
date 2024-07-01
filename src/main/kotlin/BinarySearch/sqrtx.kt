package BinarySearch

fun main(){
    println(mySqrt(2147395599))
}

fun mySqrt(x: Int): Int {
    var left: Long = 0
    var right: Long = x.toLong()+1
    while(left < right){
        val mid: Long = left + (right - left) / 2
        if(mid * mid > x){
            right = mid
        } else {
            left = mid + 1
        }
    }
    return (left - 1).toInt()
}