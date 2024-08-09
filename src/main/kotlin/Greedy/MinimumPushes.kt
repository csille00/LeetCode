package Greedy

fun main(){
    println(minimumPushes("aabbccddeeffgghhiiiiii"))
}

fun minimumPushes(word: String): Int {
        val freqMap = mutableMapOf<Char, Int>()
        for(ch in word){
            freqMap[ch] = freqMap.getOrPut(ch) {0} + 1
        }

        val sortedMap = freqMap.toList().sortedByDescending { (_, freq) -> freq }.toMap()

        var result = 0
        var i = 0
        for(pair in sortedMap){
            val multiplier = i/8 + 1
            repeat(pair.value){ result += 1*multiplier }
            i++
        }

        return result
}