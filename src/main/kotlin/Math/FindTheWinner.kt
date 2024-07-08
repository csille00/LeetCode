package Math

fun main(){
    //should be 3
    println(findTheWinner(6, 5))
}

fun findTheWinner(n: Int, k: Int): Int {
    //initialize a list with positions
    var i = 1
    val arr = List (n) {i++}.toMutableList()

    fun turn(arr: IntArray, startingPosition: Int): Int {
        //this probably isnt the best way to do this, but it works.
        //k-1 because k is 1 based and the array is 0 based
        //mod by array size to get the position it would be from 0,
        //then add the starting position and mod again to make sure it doesnt go more than arr size
        return ((k-1) % (arr.size) + startingPosition) % arr.size
    }
    var startingPosition = 0
    while(arr.size > 1){
        startingPosition = turn(arr.toIntArray(), startingPosition)
        arr.removeAt(startingPosition)

    }
    return arr[0]
}