package array_string

fun main(){
    var arr = intArrayOf(5,2,7,9,4,2,5,6,5,6000,7,8,9,3,6,7,3,2,1)
    var sortedArr = sortArrayB(arr)
    sortedArr.forEach { print(it) }
}

fun sortArray(nums: IntArray): IntArray {

    fun merge(l: Int, mid: Int, h: Int) {
        //the idea here is to look at each piece of both the left and the right, and add them iteratively to our result list
        val left = nums.sliceArray(l..mid)
        val right = nums.sliceArray(mid+1..h)

        //i is for the left, j is for the right, and k is for our result list
        var i = 0
        var j = 0
        var k = l

        //quit iterating when one of our pointers reaches the end of its list
        while(i < left.size && j < right.size){
            //insert the smaller of the two numbers being looked at (nums[i] or nums [j] and then iterate the respective pointer as well as k (which represents the current result index
            if(left[i] <= right[j]){
                nums[k] = left[i]
                i++
            } else {
                nums[k] = right[j]
                j++
            }
            k++
        }

        //copy the remaining elements into the thing
        while(i < left.size){
            nums[k] = left[i]
            i++
            k++
        }
        while(j < right.size){
            nums[k] = right[j]
            j++
            k++
        }

    }

    //while l and right are not equal, divide the list until they both equal one
    //then merge each individual piece until its all back together
    fun mergeSort(l: Int, h: Int){
        if(l < h){
            val mid = (l+h) /2
            mergeSort(l, mid)
            mergeSort(mid+1, h)
            merge(l, mid, h)
        }
    }

    mergeSort(0, nums.size - 1)
    return nums
}

fun sortArrayB(nums: IntArray): IntArray{

    fun merge(l: Int, mid: Int, h: Int){
        val left = nums.sliceArray(l..mid)
        val right = nums.sliceArray(mid+1..h)
        var i = 0
        var j = 0
        var k = l

        while (i < left.size && j < right.size){
            if(left[i] <= right[j]){
                nums[k] = left[i]
                i++
            } else{
                nums[k] = right[j]
                j++
            }
            k++
        }
        while(i<left.size){
            nums[k] = left[i]
            i++
            k++
        }
        while(j<right.size){
            nums[k] = right[j]
            j++
            k++
        }
    }

    fun mergeSort(l: Int, h: Int){
        if(l<h){
            val mid = (l+h)/2
            mergeSort(l, mid)
            mergeSort(mid+1, h)
            merge(l, mid, h)
        }
    }
    mergeSort(0, nums.size - 1)

    return nums
}