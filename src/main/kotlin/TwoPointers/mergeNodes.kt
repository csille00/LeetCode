package TwoPointers

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
// */

class ListNode(var `val`: Int){
    var next: ListNode? = null
}

fun main(){
//    0,3,1,0,4,5,2,0
    val head = ListNode(0)
    head.next = ListNode(3)
    head.next?.next = ListNode(1)
    head.next?.next?.next = ListNode(0)
    head.next?.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next?.next = ListNode(0)

    println(mergeNodes(head))
}

    fun mergeNodes(head: ListNode?): ListNode? {
        var cur = head?.next
        var prev = head
        while(cur?.next != null){
            if(cur.`val` == 0){
                prev?.next = cur
                prev = cur
            } else {
                prev?.`val` = prev?.`val`?.plus(cur.`val`)!!
            }
           cur = cur.next
        }
        prev?.next = null
        return head
    }