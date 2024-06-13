package array_string

fun main(){
    println(relativeSortArray(intArrayOf(2,3,1,3,2,4,6,7,9,2,19), intArrayOf(2,1,4,3,9,6)))
}
//use hashmap
fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    var arr1Cpy = arr1.copyOf().toMutableList()
    for(i in 0 until arr1Cpy.size){
        //find where in arr2 each element of arr1 is found. place it at that index
        var element = arr2.indexOfFirst { j -> j == arr1Cpy[i] }
        if(element == -1) {
            for (j in arr2.size until arr1Cpy.size) {
                var temp = arr1Cpy[i]
                arr1Cpy.removeAt(i)
                arr1Cpy.addLast(temp)
            }
        } else {

        }
    }
    return intArrayOf(0)
}