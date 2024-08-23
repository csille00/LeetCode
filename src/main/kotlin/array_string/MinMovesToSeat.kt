package array_string

import kotlin.math.abs

fun main(){
    println(minMovesToSeat(intArrayOf(3,1,5), intArrayOf(2,7,4)))
}

fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    seats.sort()
    students.sort()
    var sum = 0
    for(i in seats.indices){
        sum += abs(seats[i] - students[i])
    }
    return sum
}