package org.example.SlidingWindow

//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
//
//For example, "ACGAATTCCG" is a DNA sequence.
//When studying DNA, it is useful to identify repeated sequences within the DNA.
//
//Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

fun main(){
    println(findRepeatedDnaSequences("AAAAAAAAAAAAA"))
}

fun findRepeatedDnaSequences(s: String): List<String> {
    var left = 0
    var right = 10
    val seenDNA = mutableSetOf<String>()
    val ans = mutableSetOf<String>()
    while(right < s.length){
        val curWin = s.subSequence(left, right)
        seenDNA.add(curWin.toString())
        right++
        left++
        val newWin = s.subSequence(left, right)
        if(seenDNA.contains(newWin.toString())){
           ans.add(newWin.toString())
        }
    }
    return ans.toList()
}
