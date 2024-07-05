package DP

import java.lang.StringBuilder

fun main(){
    println(generateParenthesis(3))
}

fun generateParenthesis(n: Int): List<String> {
    var numOpenParensPlaced = 1
    val str = StringBuilder()
    val result = mutableListOf<String>()

    fun backtrack(str: StringBuilder, numOpenParens: Int, closingParensNeeded: Int){
        if(str.length == n*2 && closingParensNeeded == 0) {
            result.add(str.toString())
            return
        } else if(str.length > n*2){
            return
        }
        //while the num openParens is less than n, you can either close the current paren, or open a new one. do both
        while(numOpenParens <= n){
            if(closingParensNeeded == 0) backtrack(str.append('('), numOpenParens + 1, closingParensNeeded + 1)
            str.deleteCharAt(str.length-1)
            if(closingParensNeeded > 0) {
                backtrack(str.append('('), numOpenParens + 1, closingParensNeeded + 1)
                str.deleteCharAt(str.length - 1)
                backtrack(str.append(')'), numOpenParens, closingParensNeeded - 1)
                str.deleteCharAt(str.length-1)
            }
        }
    }

    backtrack(str, 0, 0)

    return result
}