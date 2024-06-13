package org.example.SlidingWindow

import kotlin.math.max

fun main(){
    println(lengthOfLongestSubstring2("aab"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var left = 0
    var right = 0
    var maxLen = 0
    val charSet = mutableSetOf<Char>()
    while(right < s.length){
        if(!charSet.contains(s[right])){
            charSet.add(s[right])
            right++
            maxLen = max(charSet.size, maxLen)
        } else {
            charSet.remove(s[left])
            left++
        }
    }
    return maxLen
}

fun lengthOfLongestSubstring2(s: String): Int {
    var left = 0
    var maxLen = 0
    for(right in s.indices){
       //update state
        while(s.substring(left, right+1).count{ it == s[right] }  > 1){
            left ++
        }
        maxLen = max(maxLen, right - left + 1)
    }
    return maxLen
}
