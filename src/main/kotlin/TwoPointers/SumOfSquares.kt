package TwoPointers

//Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

fun main(){
    println(judgeSquareSum(5))
}

fun judgeSquareSum(c: Int): Boolean {
    return true
}
/*
so, I am thinking that I would want to see if c - 1 is a perfect square.
How can I use binary search/ two pointers on this?

binary search involves taking the whole search area, and halving it with each iteration.
what is the search area?
 */