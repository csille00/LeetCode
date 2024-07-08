package LinkedList

import TwoPointers.ListNode
import kotlin.math.abs
import kotlin.math.min

//5,3,1,2,5,1,2

fun main(){
//    0,3,1,0,4,5,2,0
    val head = ListNode(5)
    head.next = ListNode(3)
    head.next?.next = ListNode(1)
    head.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(1)
    head.next?.next?.next?.next?.next?.next = ListNode(2)
//    head.next?.next?.next?.next?.next?.next?.next = ListNode(0)

    println(nodesBetweenCriticalPoints(head)[0])
    return
}

fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {

        fun isNextNodeCritial(node: ListNode): Boolean {
            if(node.next == null || node.next?.next == null) return false
            if((node.`val` < node.next!!.`val` && node.next!!.next!!.`val` < node.next!!.`val`)
                || (node.`val` > node.next!!.`val` && node.next!!.next!!.`val` > node.next!!.`val`)){
                return true
            }
            return false
        }

        var cur = head

        val indexMap = mutableMapOf<ListNode, Int>()
        var i = 0
        while(cur?.next != null){
            i++
            if(isNextNodeCritial(cur)) indexMap[cur.next!!] = i
            cur = cur.next
        }

        if(indexMap.size < 2) return intArrayOf(-1,-1)

        indexMap.toList().sortedByDescending { (_, value) -> value}

        var min = Int.MAX_VALUE
        val indexList = indexMap.toList()
        for(i in 0 until indexMap.size - 1){
            min = min(min, abs(indexList[i].second - indexList[i+1].second))
        }

        return intArrayOf(min, abs(indexMap[indexMap.keys.first()]?.minus(indexMap[indexMap.keys.last()]!!) ?: -1))
}