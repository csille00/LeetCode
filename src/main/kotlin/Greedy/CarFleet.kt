package Greedy

import java.util.*

fun main(){
    println(carFleet(12, intArrayOf(10,8,0,5,3), intArrayOf(2,4,1,1,3)))
}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val stack = Stack<Double>()
    //zip the position and speed together as pairs, and then sort them descending to go through them from the car closest
    //to the target first.
    val ps = position.zip(speed).sortedByDescending { item -> item.first }
    for(pair in ps){
        //calculate the time that the car is going to reach the target at
        val time = (target - pair.first) / pair.second.toDouble()
        //add this car to the stack
        stack.add(time)
        //if the stack is multiple car fleets, and the time that the new car will reach the target is BEFORE the time that
        //the car in front will hit, then pop
        if(stack.size >= 2 && time <= stack[stack.size - 2]) stack.pop()
    }

    return stack.size
}

/*
1
1

 */