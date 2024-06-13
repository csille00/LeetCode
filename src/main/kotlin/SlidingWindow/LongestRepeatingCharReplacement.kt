package org.example.SlidingWindow

import kotlin.math.max

fun main(){
	println(characterReplacement("ABAB", 2))
}

fun characterReplacement(s: String, k: Int): Int{
		var left = 0
		var ans = 0
		var frequencies = mutableMapOf<Char, Int>()
		var maxFreq = 0

		for(right in s.indices){
			frequencies[s[right]] = frequencies.getOrPut(s[right]) { 0 } + 1
			maxFreq = max(maxFreq, frequencies[s[right]]!!)
			while((right - left+1) - maxFreq > k){
				frequencies[s[left]] = frequencies[s[left]]?.minus(1) ?: 0
				left++
			}
			ans = max(ans, right - left+1)
		}
		return ans
}
