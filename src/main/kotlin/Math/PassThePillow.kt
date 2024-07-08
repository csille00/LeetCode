package Math

fun main(){
    println(passThePillow(4, 5))
}

fun passThePillow(n: Int, time: Int): Int {
    val div = time/(n-1)
    val foo = time % (n - 1)
    return if(div % 2 == 1) n - foo else foo + 1
}