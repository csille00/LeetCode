package Math

import array_string.threeConsecutiveOdds
//[[5,2],[5,4],[10,3],[20,1]]
//(2 + 6 + 4 + 1

//[[2,3],[6,3],[7,5],[11,3],[15,2],[18,1]]
//sum + 25
//4.16667
fun main(){
    println(averageWaitingTime(arrayOf(intArrayOf(2, 3), intArrayOf(6,3), intArrayOf(7, 5), intArrayOf(11,3), intArrayOf(15,2), intArrayOf(18,1))))
}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var sumWaitingTime: Double = 0.0//customers[0][1]
    var curTime = customers[0][0]
    for(i in customers.indices){
        var waitTime = if(customers[i][0] <= curTime) curTime - customers[i][0] + customers[i][1] else customers[i][1]
        sumWaitingTime += waitTime
        if(customers[i][0] > curTime){
            curTime = customers[i][0] + customers[i][1]
        } else{
            curTime += customers[i][1]
        }
    }
    return sumWaitingTime/customers.size
}
