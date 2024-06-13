package org.example.SlidingWindow

fun main(){
    println(isSubsequence("abc", "ahbgdc"))
}


    fun isSubsequence(s: String, t: String): Boolean {
        var tCounter = 0
        var sCounter = 0
        while(sCounter < s.length && tCounter < t.length){
            if(s[sCounter] == t[tCounter]){
                println("if")
                sCounter++
                tCounter++
            } else {
                println("else")
                tCounter++
            }
        }
        if(sCounter == s.length - 1){
            return true
        }
        return false
    }
