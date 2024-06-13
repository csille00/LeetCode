package org.example.SlidingWindow

fun main() {
    println(longestSubstring("ababacb", 3))
}

fun longestSubstring(s: String, k: Int): Int {
    var left = 0
    val map = mutableMapOf<Char, Int>()
    var ans = 0

    for(i in s.indices) map[s[i]] = map.getOrPut(s[i]) { 0 } + 1
    var uniqueChars = map.size
    var uniqueSeen = 0
    
    for(right in s.indices){
       if(s.substring(left, right).contains(s[right])){

       }
    }

//    for(right in s.indices){
//        if(map[s[right]]!! >= k){
//            ans = max(ans, right - left + 1)
//        } else {
//            left = right
//        }
//    }
    return 0
}