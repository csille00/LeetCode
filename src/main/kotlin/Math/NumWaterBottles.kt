package Math

fun main(){
    println(numWaterBottles(15, 8))
}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var numDrunk = numBottles
    var emptyBottles = numBottles
    //loop while there are still enough empty bottles to get a full one
    while (emptyBottles >= numExchange) {
        //you can get emptyBottles/numExchange number of new full bottles
        val newBottles = emptyBottles / numExchange
        numDrunk += newBottles
        //add the new bottles you just exchanged for to the emptybottles list + the leftover bottles that didn't get exchanged
        emptyBottles = newBottles + (emptyBottles % numExchange)
    }
    return numDrunk
}

